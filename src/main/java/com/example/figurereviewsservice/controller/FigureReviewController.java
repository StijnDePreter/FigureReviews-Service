package com.example.figurereviewsservice.controller;

import com.example.figurereviewsservice.model.FigureReview;
import com.example.figurereviewsservice.repository.FigureReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@RestController
public class FigureReviewController {

    @Autowired
    private FigureReviewRepository figureReviewRepository;

    @PostConstruct
    public void fillDB(){
        if(figureReviewRepository.count()==0){
            figureReviewRepository.save(new FigureReview("Duck" ,"Stukken passen niet goed", 2));
            figureReviewRepository.save(new FigureReview("Duck" ,"Moeilijke stap", 5));
            figureReviewRepository.save(new FigureReview("Car" ,"eenvoudige stap", 4));
            figureReviewRepository.save(new FigureReview("Chicken" ,"eenvoudige stap", 2));
        }
    };


    @GetMapping("/figureReviews")
    public List<FigureReview> getFigureReviewByName(){
        return figureReviewRepository.findAll();
    }

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
        FigureReview retrievedFigureReview = figureReviewRepository.findFigureReviewByNameAndDate(updateFigureReview.getName(), updateFigureReview.getDate() );

        retrievedFigureReview.setName(updateFigureReview.getName());
        retrievedFigureReview.setDate(updateFigureReview.getDate());

        figureReviewRepository.save(retrievedFigureReview);

        return retrievedFigureReview;
    }

    @DeleteMapping("figureReviews/name/{name}/date/{date}")
    public ResponseEntity deleteFigureReview(@PathVariable String name, @PathVariable Date date){
        FigureReview figureReview = figureReviewRepository.findFigureReviewByNameAndDate(name, date);
        if(figureReview!=null){
            figureReviewRepository.delete(figureReview);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    };

}

