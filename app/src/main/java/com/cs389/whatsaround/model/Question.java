package com.cs389.whatsaround.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Question implements Serializable {

    private String image;
    private String answer;


    public Question(String image, String answer) {
        this.image = image;
        this.answer = answer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public static List<Question> getQuestionsSample(){

        List<Question> questions = new ArrayList<Question>();

        questions.add(new Question("Computer","computer"));
        questions.add(new Question("Table","table"));
        questions.add(new Question("Child","child"));
        questions.add(new Question("Chair","chair"));

        return questions;

    }
}
