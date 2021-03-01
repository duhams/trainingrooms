package godev.com.trainingrooms.controller;


import godev.com.trainingrooms.model.People;
import godev.com.trainingrooms.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/people")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @PostMapping(path="/add")
    public @ResponseBody
    People addPeople(@RequestBody People p) {
        return peopleRepository.save(p);
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<People> getAllPeoples() {
        return peopleRepository.findAll();
    }

}
