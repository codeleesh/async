package com.lovethefeel.async.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Spring uses the Jackson JSON library to convert GitHub’s JSON response into a User object.
 * The @JsonIgnoreProperties annotation tells Spring to ignore any attributes not listed in the class.
 * This makes it easy to make REST calls and produce domain objects.
 *
 * In this guide, we grab only the name and the blog URL for demonstration purposes.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class User {
    private String name;
    private String blog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", blog=" + blog + "]";
    }
}
