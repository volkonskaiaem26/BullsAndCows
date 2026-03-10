package com.example.BulsAndCows.Controller;

import com.example.BulsAndCows.Configs.NumberRepository;
import com.example.BulsAndCows.Entity.Number;
import com.example.BulsAndCows.Entity.NumberInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayController {


    private final NumberRepository numberRepository;
    public PlayController(NumberRepository numberRepository){
        this.numberRepository = numberRepository;
    }
    Number answer = new Number();
    public double getRandom(int max, int min){
        return Math.random()*(max-min)+min;
    }

    @GetMapping("/numbers")
    public ResponseEntity<List<NumberInfo>> getUsers() {
        List<NumberInfo> numbers = numberRepository.findAll();
        return ResponseEntity.ok(numbers);
    }

    @PostMapping("start")
    public ResponseEntity<Void> start(){
        answer.setFirst((int) getRandom(9,0));
        answer.setSecond((int) getRandom(9,0));
        answer.setThird((int) getRandom(9,0));
        answer.setForth((int) getRandom(9,0));
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/play")
    public ResponseEntity<NumberInfo> play(@RequestBody Number number){
        NumberInfo num = new NumberInfo(number);
        int cows = num.getNumber().getCows(answer.getFirst())+
                num.getNumber().getCows(answer.getSecond())+
                num.getNumber().getCows(answer.getThird())+
                num.getNumber().getCows(answer.getForth());
        num.setCows(cows);
        int bulls = num.getNumber().getBulls(answer.getFirst(), 1)+
                num.getNumber().getBulls(answer.getSecond(), 2)+
                num.getNumber().getBulls(answer.getThird(), 3)+
                num.getNumber().getBulls(answer.getForth(), 4);
        num.setBulls(bulls);
        numberRepository.save(num);
        return ResponseEntity.ok(num);
    }
}
