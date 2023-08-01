package de.davidjahnbscinformatik.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GameController {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlatformRepository platformRepository;

    @GetMapping("/game/all")
    public ResponseEntity<Iterable<Game>> getAll(){
        return new ResponseEntity<Iterable<Game>>(this.gameRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/game")
    public ResponseEntity<Game> create(@RequestBody Game newGame){
        this.gameRepository.save(newGame);
        return new ResponseEntity<Game>(newGame, HttpStatus.OK);
    }


}
