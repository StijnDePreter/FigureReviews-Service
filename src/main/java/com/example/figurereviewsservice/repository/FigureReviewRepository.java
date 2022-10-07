package com.example.figurereviewsservice.repository;

import com.example.figurereviewsservice.model.FigureReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FigureReviewRepository extends MongoRepository<FigureReview, String> {

    List<FigureReview> findFigureReviewsByName(String name);
    List<FigureReview> findFigureReviewByStars(Integer stars);
    List<FigureReview> findAll();
    FigureReview findFigureReviewByNameAndDate(String name, Date date);



}