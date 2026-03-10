package com.example.BulsAndCows.Controller;


import com.example.BulsAndCows.BullsCowsResult;
import com.example.BulsAndCows.Entity.NumberInfo;
import com.example.BulsAndCows.Entity.NumberInt;
import com.example.BulsAndCows.Entity.NumberRepository;
import com.example.BulsAndCows.GameService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayController {

    private final NumberRepository numberRepository;
    private final GameService gameService;

    public PlayController(NumberRepository numberRepository, GameService gameService) {
        this.numberRepository = numberRepository;
        this.gameService = gameService;
    }

    @GetMapping("/numbers")
    public ResponseEntity<List<NumberInfo>> getNumbers() {
        List<NumberInfo> numbers = numberRepository.findAll();
        return ResponseEntity.ok(numbers);
    }


    @PostMapping("/start")
    public ResponseEntity<Void> start(HttpSession session) {
        int[] secret = gameService.generateSecret();
        session.setAttribute("secret", secret);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/play")
    public ResponseEntity<NumberInfo> play(@RequestBody NumberInt guess, HttpSession session) {

        int[] secret = (int[]) session.getAttribute("secret");
        if (secret == null) {
            return ResponseEntity.badRequest().build();
        }

        int[] guessArray = new int[]{
                guess.getFirst(),
                guess.getSecond(),
                guess.getThird(),
                guess.getForth()
        };

        BullsCowsResult result = gameService.countBullsAndCows(secret, guessArray);


        NumberInfo numberInfo = new NumberInfo(guess);
        numberInfo.setBulls(result.getBulls());
        numberInfo.setCows(result.getCows());
        numberInfo.setResult(guess.getFirst()*1000 + guess.getSecond()*100 + guess.getThird()*10 + guess.getForth());
        numberRepository.save(numberInfo);

        return ResponseEntity.ok(numberInfo);
    }
}
