package godev.com.trainingrooms.controller;

import godev.com.trainingrooms.model.CoffeeRoom;
import godev.com.trainingrooms.repository.CoffeeRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/coffee_room")
public class CoffeeRoomController {

    @Autowired
    private CoffeeRoomRepository coffeeRoomRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    CoffeeRoom addCoffeeRoom(@RequestBody CoffeeRoom c) {
        return coffeeRoomRepository.save(c);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<CoffeeRoom> getAllCoffeeRooms() {
        return coffeeRoomRepository.findAll();
    }
}