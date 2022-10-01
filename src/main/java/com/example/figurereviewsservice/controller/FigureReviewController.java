package com.example.figurereviewsservice.controller;

import com.example.figurereviewsservice.model.FigureReview;
import com.example.figurereviewsservice.repository.FigureReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class FigureReviewController {

    @Autowired
    private FigureReviewRepository figureReviewRepository;

    @GetMapping("/figureReviews/{name}")
    public List<FigureReview> getFigureReviewByName(@PathVariable String name){
        return figureReviewRepository.findFigureReviewsByName(name);
    }

    @GetMapping("/figureNamesByStars/{stars}")
    public List<FigureReview> getFigureReviewByName(@PathVariable Integer stars){
        return figureReviewRepository.findFigureReviewByStars(stars);
    }

    @GetMapping("/figureReviewByNameAndDate/{name}/{date}")
    public FigureReview getFigureReviewByName(@PathVariable String name,@PathVariable Date date) {
        return figureReviewRepository.findFigureReviewByNameAndDate(name,date);
    }

    @PostMapping ("/figureReview")
    public FigureReview addFigureReview(@RequestBody FigureReview figureReview){
        figureReviewRepository.save(figureReview);
        return figureReview;
    }

    @PutMapping("/figureReview")
    public FigureReview updateFigureReview(@RequestBody FigureReview updateFigureReview){
        FigureReview retreivedFigureReview = figureReviewRepository.findFigureReviewByNameAndDate(updateFigureReview.getName(), updateFigureReview.getDate() );

        retreivedFigureReview.setName(updateFigureReview.getName());
        retreivedFigureReview.setDate(updateFigureReview.getDate());

        //Hier was ik gebleven!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        figureReviewRepository.save(retreivedFigureReview);

        return retreivedFigureReview

    }



}
