package com.app.zofeservice.modal;

import com.app.zofeservice.common.audit.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Map;

/**
 * Created By Shameera.A on 1/24/2020
 */

@Entity
@Table(name = "question_answers")
@Audited
@Getter
@SuperBuilder
@NoArgsConstructor
public class QuestionnaireAnswers extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Answer employeeAnswer;

    @ManyToOne
    private Employee employee;

}
