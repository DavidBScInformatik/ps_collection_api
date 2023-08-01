package de.davidjahnbscinformatik.prototype;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface GameRepository extends CrudRepository<Game, Integer> {
    Set<Game> findByPlatformId(Integer platformId);
}
