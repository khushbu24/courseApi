package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Course {

    @Id
    public String id;

    public  String name;
    public String description;

    //one topic will have many courses
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String d) {
        this.description = d;
    }

    public Topic getTopic3() {
        return topic3;
    }

    public void setTopic3(Topic topic) {
        this.topic3 = topic;
    }
}
