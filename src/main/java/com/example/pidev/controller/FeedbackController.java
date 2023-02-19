package com.example.pidev.controller;


import com.example.pidev.entities.Feedback;

import com.example.pidev.repository.UserRepository;
import com.example.pidev.services.IrecruiterFeedbackService;
import com.example.pidev.services.candidatFeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/feedback/")
public class FeedbackController {

    IrecruiterFeedbackService iFeedbackService;
    candidatFeedbackService icandidatFeedback;


    @Transactional
    @PostMapping("addfeedbackCandidacy/{iduser}/{cin}/{idcandidacy}")
    public Feedback addFeedback(@RequestBody Feedback feedback,

                                                @PathVariable("iduser") int iduser,
                                                @PathVariable("cin") int cin,

                                                @PathVariable("idcandidacy") int idcandidacy
                                                ) {


        return iFeedbackService.addFeedback(feedback,iduser,cin,idcandidacy);

    }



    @PutMapping("/updatefeedback/{idfeedback}")
    public Feedback updatefeedback(@RequestBody Feedback feedback) {
        return iFeedbackService.updateFeedback(feedback);

    }

    @Transactional
    @DeleteMapping("/removefeedback/{idfeedback}")
    public void removefeedback(@PathVariable("idfeedback") int idfeedback) {


         icandidatFeedback.removecandidatFeedback(idfeedback);

    }

    @Transactional
    @PostMapping("addcandidateFeedback/{idoffer}/{iduser}/{cin}")
    public Feedback addcandidatFeedback(@RequestBody Feedback feedback,

                                @PathVariable("idoffer") int idoffer,
                                @PathVariable("cin") int cin,
                                        @PathVariable("iduser") int iduser
    ) {


        return icandidatFeedback.addcandidatFeedback(feedback,idoffer,iduser,cin);

    }

    @Transactional
    @GetMapping("/affichage")
    public List<Feedback> getBeneficairesAsC() {

        return iFeedbackService.retrieveAllFeedback();
    }


    @Transactional
    @GetMapping("/affichagereclamation")
    public double calculerMoyenneReclamationsParUtilisateur() {
         return icandidatFeedback.calculerMoyenneReclamationsParUtilisateur();
    }
















}