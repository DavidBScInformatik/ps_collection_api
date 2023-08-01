package de.davidjahnbscinformatik.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class PlatformController {
    @Autowired
    private PlatformRepository platformRepository;
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/platform/all")
    public ResponseEntity<Iterable<Platform>> getAll(){
        Iterable<Platform> allEntries = this.platformRepository.findAll();
        return new ResponseEntity<Iterable<Platform>>(allEntries, HttpStatus.OK);
    }

    /**
     * @author David Jahn
     *
     * @description: get all games from one platform by ID
     *
     * @param platformId - platform for search
     * @return allEntries - Alle games on this platform
     */
    @GetMapping("platform/getAllGames")
    public ResponseEntity<Set<Game>> getAllGames(@RequestParam(value = "platformId") int platformId){
        Optional<Platform> platform = platformRepository.findById(platformId);
        if(platform.isPresent()){
            Set<Game> allEntries = gameRepository.findByPlatformId(platformId);
            if(allEntries.isEmpty()){
                return new ResponseEntity("No games found", HttpStatus.NOT_FOUND);
            }else{
                return new ResponseEntity<Set<Game>>(allEntries, HttpStatus.OK);
            }
        }else{
            return new ResponseEntity("No platform with ID " + platformId + " found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/platform")
    public ResponseEntity<Platform> create(@RequestBody Platform newPlatform){
        this.platformRepository.save(newPlatform);
        return new ResponseEntity<Platform>(newPlatform, HttpStatus.OK);
    }
}
