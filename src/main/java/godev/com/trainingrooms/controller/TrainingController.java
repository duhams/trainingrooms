package godev.com.trainingrooms.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import godev.com.trainingrooms.model.Training;
import godev.com.trainingrooms.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/training")
public class TrainingController {

    @Autowired
    private TrainingRepository trainingRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    Training addTraining(@RequestBody Training t) {
        return trainingRepository.save(t);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

}
