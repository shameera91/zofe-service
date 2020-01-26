package com.app.zofeservice.service.impl;

import com.app.zofeservice.dto.CandidateOutputDTO;
import com.app.zofeservice.modal.Employee;
import com.app.zofeservice.repository.EmployerRepository;
import com.app.zofeservice.repository.QuestionnaireAnswerRepository;
import com.app.zofeservice.service.QuestionService;
import com.app.zofeservice.service.QuestionnaireService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created By Shameera.A on 1/25/2020
 */

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private static final int MINIMAL_RESULTS_SIZE = 10;
    private static final int FACTOR_REDUCTION_ON_MORE = 2;
    private static final double FACTOR_MULTIPICATION_ON_LESS = 0.8;
    private final QuestionnaireAnswerRepository questionnaireAnswerRepository;
    private final QuestionService questionService;
    private final EmployerRepository employerRepository;

    public QuestionnaireServiceImpl(QuestionnaireAnswerRepository questionnaireAnswerRepository, QuestionService questionService, EmployerRepository employerRepository) {
        this.questionnaireAnswerRepository = questionnaireAnswerRepository;
        this.questionService = questionService;
        this.employerRepository = employerRepository;
    }

    @Override
    public List<CandidateOutputDTO> getMatchingCandidatesByAnswerIndex(String searchQuery) {

        /*   example searchQuery*/
        String searchQuery1 = "1:1,2:3";


        /* what I m thinking is , from from end we are passing , question id and answer which
         * the employer is picking .
         *
         * in here we have to separate into parts ,  by using java String class functions
         *
         * after that , we have to do the filtering part.
         *
         * which is I m still thinking
         *
         * */

        //repository get all candidates

        Map<Integer, Integer> questionList = getQuestionsBySearchString(searchQuery1);
        List<Employee> fittingEmployees = getAllFittingCandidates(questionList);

        if (fittingEmployees.size() >= MINIMAL_RESULTS_SIZE) {
            return getCandidateOutputDTOs(fittingEmployees);
        }

        List<CandidateOutputDTO> dtos = getCandidateOutputDTOs(fittingEmployees);

        dtos.addAll(getNonFittingEmployeesByRank(questionList));

        return dtos;
    }

    private Collection<? extends CandidateOutputDTO> getNonFittingEmployeesByRank(Map<Integer, Integer> questionList) {
        List<Employee> allEmployees = employerRepository.findAll();
        for (Employee employee : allEmployees) {
            int level = 100;
            for (Integer questionIdx : questionList.keySet()) {

                int userAns = questionnaireAnswerRepository.getQuestionAnswer(employee, questionIdx);
                if (userAns > questionList.get(questionIdx)) {
                    level -= FACTOR_REDUCTION_ON_MORE;
                } else {
                    if (userAns < questionList.get(questionIdx)) {
                        level = (int) (level * FACTOR_MULTIPICATION_ON_LESS);
                    }
                }
            }
            CandidateOutputDTO dto = new CandidateOutputDTO(level, null, employee);
        }
        return null;
    }

    private List<CandidateOutputDTO> getCandidateOutputDTOs(List<Employee> fittingEmployees) {
        //TODO: implement
        return null;
    }

    private List<Employee> getAllFittingCandidates(Map<Integer, Integer> questionList) {
        StringBuilder query = new StringBuilder("select distinct employee from QuestionnaireAnswers where 1=1 ");
        for (Integer question : questionList.keySet()) {
            query.append(" AND question = ").append(question).append(" AND employeeAnswer >= ").append(questionList.get(question));
        }
        List<Employee> employeesFit = null; //todo:implement repository.runQuery(query);
        return employeesFit;
    }

    private List<Employee> getAllEmployees() {
        return new LinkedList<>();
    }

    private Map<Integer, Integer> getQuestionsBySearchString(String searchQuery1) {

        Map<Integer, Integer> questionAnswerMap = new HashMap<>();
        String[] pairs = searchQuery1.split(",");
        for (String pair : pairs) {
            String[] spllitted = pair.split(":");
            Integer questionIdx = Integer.parseInt(spllitted[0]);
            Integer answerIdx = Integer.parseInt(spllitted[1]);
            questionAnswerMap.put(questionIdx, answerIdx);
        }
        return questionAnswerMap;
    }
}
