package com.example.spring_rest_sample.dao;

import java.util.Date;

public class Book {
    private Long id;
    private String description;
    private String path;
    private double price;
    private Date publishdate;
    private String title;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the publishdate
     */
    public Date getPublishdate() {
        return publishdate;
    }

    /**
     * @param publishdate the publishdate to set
     */
    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}