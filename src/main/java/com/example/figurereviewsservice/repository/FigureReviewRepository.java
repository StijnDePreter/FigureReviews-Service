package com.example.figurereviewsservice.repository;

import com.example.figurereviewsservice.model.FigureReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FigureReviewRepository extends MongoRepository<FigureReview, String> {
    //Get /FigureReviews/{Name}
    //Get /FigureNamesbyStars/Stars/{stars}
    //Post /FigureReview
    //Put /FigureReview
    //Delete /FigureReview

    List<FigureReview> findFigureReviewsByName(String name);
    List<FigureReview> findFigureReviewByStars(Integer stars);

    FigureReview findFigureReviewByNameAndDate(String name, Date date);


}
