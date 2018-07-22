package com.ots.voteservice.dto;

public class OptionsDto {

    private String restApiLink;
    private String description;

    public OptionsDto() {
    }

    public String getRestApiLink() {
        return restApiLink;
    }

    public void setRestApiLink(String restApiLink) {
        this.restApiLink = restApiLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
