package com.ots.voteservice.model;

import javax.persistence.*;

@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vote_id")
    private int voteId;


    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "link", unique = true)
    private String link;

    @Column(name = "is_open")
    private boolean isOpen;


    public Vote() {
    }

    public Vote(String name, String link, boolean isOpen) {
        this.name = name;
        this.link = link;
        this.isOpen = isOpen;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        Vote vote = (Vote) o;

        if (voteId != vote.voteId) return false;
        if (isOpen != vote.isOpen) return false;
        if (name != null ? !name.equals(vote.name) : vote.name != null) return false;
        return link != null ? link.equals(vote.link) : vote.link == null;
    }

    @Override
    public int hashCode() {
        int result = voteId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (isOpen ? 1 : 0);
        return result;
    }
}
