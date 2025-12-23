package com.example.BulsAndCows;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayController {


    Number number = new Number();

    public double getRandom(int max, int min){
        return Math.random()*(max-min)+min;
    }

    @PostMapping("start")
    public ResponseEntity<Void> start(){
        number.setFirst((int) getRandom(9,0));
        number.setSecond((int) getRandom(9,0));
        number.setThird((int) getRandom(9,0));
        number.setForth((int) getRandom(9,0));
        return ResponseEntity.accepted().build();
    }

    @GetMapping("play/{yourNumber}")
    public ResponseEntity<String> play(@PathVariable ("yourNumber") String yourNumber){
        if(!(yourNumber.length()==4)){
            return ResponseEntity.ok("Число должно быть четырехзначным");
        }
        int first = Integer.parseInt(""+yourNumber.charAt(0));
        int second = Integer.parseInt(""+yourNumber.charAt(1));
        int third = Integer.parseInt(""+yourNumber.charAt(2));
        int forth = Integer.parseInt(""+yourNumber.charAt(3));
        int bulls = number.getBulls(first, 1)+number.getBulls(second, 2)+number.getBulls(third, 3)+number.getBulls(forth, 4);
    }
}
