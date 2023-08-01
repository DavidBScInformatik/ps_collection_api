package de.davidjahnbscinformatik.prototype;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private String description;

    @OneToMany
    @JoinColumn(name = "platformId")
    private Set<Game> gamelist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Game> getGamelist() {
        return gamelist;
    }

    public void setGamelist(Set<Game> gamelist) {
        this.gamelist = gamelist;
    }
}
