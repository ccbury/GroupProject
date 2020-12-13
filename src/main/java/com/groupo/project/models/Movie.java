
package com.groupo.project.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {
    private String title;
    private Boolean watched;
    private Boolean recommended;
    private String summary;
    
    public Movie(String title, Boolean watched, Boolean recommended, String summary){
        this.title=title;
        this.recommended=recommended;
        this.watched=watched;
        this.summary=summary;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getWatched() {
        return watched;
    }

    public Boolean getRecommended() {
        return recommended;
    }

    public String getSummary() {
        return summary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWatched(Boolean watched) {
        this.watched = watched;
    }

    public void setRecommended(Boolean recommended) {
        this.recommended = recommended;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    
}
