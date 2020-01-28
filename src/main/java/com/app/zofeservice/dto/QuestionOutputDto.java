package com.app.zofeservice.dto;

import com.app.zofeservice.modal.Answer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created By Shameera.A on 1/28/2020
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionOutputDto {

    private long id;
    private String question;
    private List<Answer> answers;
}
