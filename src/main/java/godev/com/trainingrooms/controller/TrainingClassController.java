package godev.com.trainingrooms.controller;

import godev.com.trainingrooms.model.TrainingClass;
import godev.com.trainingrooms.model.TrainingClassPeople;
import godev.com.trainingrooms.repository.TrainingClassPeopleRepository;
import godev.com.trainingrooms.repository.TrainingClassRepository;
import godev.com.trainingrooms.repository.TrainingTrainingClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/training_class")
public class TrainingClassController {

    @Autowired
    private TrainingClassRepository trainingClassRepository;

    @Autowired
    private TrainingClassPeopleRepository trainingClassPeopleRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    TrainingClass addTrainingClass(@RequestBody TrainingClass t) {
        return trainingClassRepository.save(t);
    }

    @PostMapping(path = "/add_people", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    HashMap<String, Object> addPeopleToTrainingClass(@RequestBody TrainingClassPeople req) {
        HashMap<String, Object> res = new HashMap<>();

        // Verify if the training class exceeded the maximum peoples, or if they have a difference of 1 or more in the classes
        TrainingClass tc = trainingClassRepository.getTrainingClassById(req.getTraining_class_id());

        // verify the difference between all the training classes
        TrainingClass trainingClassNotExceeded = this.getIfExistsAnotherClassWithTheLimitDifference(tc);
        if (trainingClassNotExceeded != null) { // if is != null, then exists another training class with more the 1 people difference
            tc = trainingClassNotExceeded;
        }

        // Verify if training class exceeded the maximum peoples
        Map<String, Object> exceededMaximumPeoples = trainingClassRepository.getTrainingClassExceededMaximumPeoples(tc.getId());
        if (exceededMaximumPeoples != null) {
            if (((BigInteger) exceededMaximumPeoples.get("isExceeded")).intValue() != 0) {
                res.put("error", "Class exceeded the maximum peoples.");
                return res;
            }
        }

        // verify if people exists in this class
        TrainingClassPeople v = trainingClassPeopleRepository.getTrainingClassPeopleByPeopleId(req.getPeople_id(), tc.getId());
        if (v != null) {
            res.put("error", "User already added to this training class");
            return res;
        }

        TrainingClassPeople tcp = new TrainingClassPeople();
        tcp.setPeople_id(req.getPeople_id());
        tcp.setTraining_class_id(tc.getId());
        try {
            trainingClassPeopleRepository.save(tcp);
            res.put("sucess", true);
            return res;
        } catch (Exception e) {
            res.put("error", e.getMessage());
            return res;
        }
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<TrainingClass> getAllTrainingClass() {
        return trainingClassRepository.findAll();
    }

    /*
    ===============================
    Helpers
    ===============================
     */

    // verify if has another class with more then 1 people of difference in training class
    TrainingClass getIfExistsAnotherClassWithTheLimitDifference(TrainingClass trainingClass) {
        List<Map<String, Object>> trainingClassLimits = trainingClassRepository.getTrainingClassLimitsByTrainingId(trainingClass.getTraining_id());
        Map<String, Object> traingClassQtds = trainingClassRepository.getTrainingClassPeopleQtd(trainingClass.getId());
        for (Map<String, Object> l : trainingClassLimits) {
            if ((long)((BigInteger) l.get("training_id")).intValue() != trainingClass.getId()) {
                if (((BigInteger) l.get("qtd")).intValue() - ((BigInteger) traingClassQtds.get("qtd")).intValue() > 1) {
                    return trainingClassRepository.findById((long) l.get("training_class_id"));
                }
            }
        }
        return null;
    }

}
