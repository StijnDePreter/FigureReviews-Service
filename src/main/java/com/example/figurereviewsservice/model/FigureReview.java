package com.example.figurereviewsservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "figureReviews")
public class FigureReview {

    @Id
    private String id;
    private String Name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDate = new Date();
    private String textReview;
    private Integer stars;
}