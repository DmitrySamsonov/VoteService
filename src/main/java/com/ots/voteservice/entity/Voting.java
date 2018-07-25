package com.ots.voteservice.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "voting")
public class Voting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "voting_id")
    private int votingId;

    @Column(name = "voting_theme", nullable = false, unique = true)
    private String votingTheme;

    @Column(name = "question", nullable = false, unique = true)
    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "answers")
    private List<Answer> answers;

    @Column(name = "link", unique = true)
    private String link;

    @Column(name = "is_open")
    private boolean isOpen;


    public Voting() {
    }

    public Voting(String votingTheme, String link, boolean isOpen) {
        this.votingTheme = votingTheme;
        this.link = link;
        this.isOpen = isOpen;
    }

    public int getVotingId() {
        return votingId;
    }

    public void setVotingId(int votingId) {
        this.votingId = votingId;
    }

    public String getVotingTheme() {
        return votingTheme;
    }

    public void setVotingTheme(String votingTheme) {
        this.votingTheme = votingTheme;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voting voting = (Voting) o;

        if (votingId != voting.votingId) return false;
        if (isOpen != voting.isOpen) return false;
        if (votingTheme != null ? !votingTheme.equals(voting.votingTheme) : voting.votingTheme != null) return false;
        if (question != null ? !question.equals(voting.question) : voting.question != null) return false;
        if (answers != null ? !answers.equals(voting.answers) : voting.answers != null) return false;
        return link != null ? link.equals(voting.link) : voting.link == null;
    }

    @Override
    public int hashCode() {
        int result = votingId;
        result = 31 * result + (votingTheme != null ? votingTheme.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (isOpen ? 1 : 0);
        return result;
    }
}
