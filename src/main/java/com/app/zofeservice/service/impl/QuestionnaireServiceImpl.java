package com.app.zofeservice.service.impl;

import com.app.zofeservice.dto.CandidateOutputDTO;
import com.app.zofeservice.exception.ResourceNotFoundException;
import com.app.zofeservice.modal.Employee;
import com.app.zofeservice.repository.EmployerRepository;
import com.app.zofeservice.repository.QuestionnaireAnswerRepository;
import com.app.zofeservice.service.QuestionService;
import com.app.zofeservice.service.QuestionnaireService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created By Shameera.A on 1/25/2020
 */

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private static final int MINIMAL_RESULTS_SIZE = 10;
    private static final int FACTOR_REDUCTION_ON_MORE = 2;
    private static final double FACTOR_MULTIPLICATION_ON_LESS = 0.8;
    private final QuestionnaireAnswerRepository questionnaireAnswerRepository;
    private final QuestionService questionService;
    private final EmployerRepository employerRepository;

    public QuestionnaireServiceImpl(QuestionnaireAnswerRepository questionnaireAnswerRepository,
                                    QuestionService questionService, EmployerRepository employerRepository) {
        this.questionnaireAnswerRepository = questionnaireAnswerRepository;
        this.questionService = questionService;
        this.employerRepository = employerRepository;
    }

    @Override
    public List<CandidateOutputDTO> getMatchingCandidatesByAnswerIndex(String searchQuery) {

        Map<Long, Integer> questionList = getQuestionsBySearchString(searchQuery);
        List<Employee> fittingEmployees = getAllFittingCandidates(questionList);

        if (fittingEmployees.size() >= MINIMAL_RESULTS_SIZE) {  /* why do you need this kind of approach ??*/
            return getCandidateOutputDTOs(fittingEmployees);
        }

        List<CandidateOutputDTO> candidateOutput = getCandidateOutputDTOs(fittingEmployees);
        List<CandidateOutputDTO> nonFittingEmployeesByRank = getNonFittingEmployeesByRank(questionList);

        //List<CandidateOutputDTO> collect = candidateOutput.stream().filter(c -> !nonFittingEmployeesByRank.contains(c.getEmployee())).collect(Collectors.toList());
        /*for(CandidateOutputDTO i : candidateOutput) {
            for(CandidateOutputDTO k: nonFittingEmployeesByRank){

            }
        }*/

        return nonFittingEmployeesByRank;
    }

    private List<Employee> getAllFittingCandidates(Map<Long, Integer> questionList) {
        List<List<Employee>> matchPerQuestion = new ArrayList<>();
        for (Long questionId : questionList.keySet()) {
            List<Employee> result = questionnaireAnswerRepository
                    .getAllFittingCandidate(questionId, questionList.get(questionId));
            matchPerQuestion.add(result);
        }
        Set<Employee> commonElements = getCommonElements(matchPerQuestion);
        return Lists.newArrayList(commonElements);
    }

    private List<CandidateOutputDTO> getNonFittingEmployeesByRank(Map<Long, Integer> questionList) {
        List<CandidateOutputDTO> result = new ArrayList<>();
        List<Employee> allEmployees = employerRepository.findAll();
        for (Employee employee : allEmployees) {
            int level = 100;
            for (Long questionId : questionList.keySet()) {
                Integer userAns = questionnaireAnswerRepository
                        .getQuestionAnswer(questionId, employee.getId()).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
                if (userAns > questionList.get(questionId)) {
                    level -= FACTOR_REDUCTION_ON_MORE;
                } else {
                    if (userAns < questionList.get(questionId)) {
                        level = (int) (level * FACTOR_MULTIPLICATION_ON_LESS);
                    }
                }
            }
            CandidateOutputDTO outputDto = new CandidateOutputDTO(level, "000", employee.viewEmployeeDetails());
            result.add(outputDto);
        }
        return result;
    }

    private List<CandidateOutputDTO> getCandidateOutputDTOs(List<Employee> fittingEmployees) {
        List<CandidateOutputDTO> result = new ArrayList<>();
        for (Employee employee : fittingEmployees) {
            CandidateOutputDTO dto = new CandidateOutputDTO(100, "000", employee.viewEmployeeDetails());
            result.add(dto);
        }
        return result;
    }

    private Map<Long, Integer> getQuestionsBySearchString(String searchQuery) {

        Map<Long, Integer> questionAnswerMap = new HashMap<>();
        String[] pairs = searchQuery.split(",");
        for (String pair : pairs) {
            String[] spllitted = pair.split(":");
            Long questionIdx = Long.parseLong(spllitted[0]);
            Integer answerIdx = Integer.parseInt(spllitted[1]);
            questionAnswerMap.put(questionIdx, answerIdx);
        }
        return questionAnswerMap;
    }

    public static <T> Set<T> getCommonElements(Collection<? extends Collection<T>> collections) {
        Set<T> common = new LinkedHashSet<T>();
        if (!collections.isEmpty()) {
            Iterator<? extends Collection<T>> iterator = collections.iterator();
            common.addAll(iterator.next());
            while (iterator.hasNext()) {
                common.retainAll(iterator.next());
            }
        }
        return common;
    }
}
