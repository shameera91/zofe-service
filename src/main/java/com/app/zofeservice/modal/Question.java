package com.app.zofeservice.modal;

import com.app.zofeservice.common.audit.Auditable;
import com.app.zofeservice.dto.QuestionOutputDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created By Shameera.A on 1/24/2020
 */
@Entity
@Table(name = "question")
@Audited
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Question extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String question;

    @OneToMany
    @JoinTable(name = "q_and_a",joinColumns = @JoinColumn(name = "question_id"),inverseJoinColumns = @JoinColumn(name = "answer_id"))
    private List<Answer> answers;

    public QuestionOutputDto viewQuestionDetails(){
        return new QuestionOutputDto(id,question,answers);
    }
}
