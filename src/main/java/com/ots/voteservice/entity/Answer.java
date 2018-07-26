package com.ots.voteservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answer_id")
    private int answerId;

    @Column(name = "answer_name")
    private String answerName;

    @Column(name = "count")
    private int count;


    public Answer() {
    }

    public Answer(String answerName, int count) {
        this.answerName = answerName;
        this.count = count;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (answerId != answer.answerId) return false;
        if (count != answer.count) return false;
        return answerName != null ? answerName.equals(answer.answerName) : answer.answerName == null;
    }

    @Override
    public int hashCode() {
        int result = answerId;
        result = 31 * result + (answerName != null ? answerName.hashCode() : 0);
        result = 31 * result + count;
        return result;
    }
}
