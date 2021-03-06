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
import javax.persistence.Table;

/**
 * Created By Shameera.A on 1/24/2020
 */
@Entity
@Table(name = "answer")
@Audited
@Getter
@SuperBuilder
@NoArgsConstructor
public class Answer extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int answerScore;

    private String answerText;

}
