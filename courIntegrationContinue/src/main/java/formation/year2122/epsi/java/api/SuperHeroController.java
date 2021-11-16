package formation.year2122.epsi.java.api;

import formation.year2122.epsi.java.api.dto.SuperHeroDTO;
import formation.year2122.epsi.java.model.SuperHero;
import formation.year2122.epsi.java.repository.SuperHeroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(
        path = "/superHeroes",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class SuperHeroController {

    private final SuperHeroRepository superHeroRepository;

    SuperHeroController(
            SuperHeroRepository superHeroRepository
    ) {
        this.superHeroRepository = superHeroRepository;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<SuperHeroDTO> getById(@PathVariable Long id) {
//        Optional<SuperHero> optionalSuperHero = this.superHeroRepository.findById(id);
//        if (optionalSuperHero.isPresent()) {
//            SuperHero superHero = optionalSuperHero.get();
//            SuperHeroDTO superHeroDTO = mapToDTO(superHero);
//            return ResponseEntity.ok(superHeroDTO);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
        
        return this.superHeroRepository.findById(id)
                .map(superHero -> ResponseEntity.ok(mapToDTO(superHero)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<SuperHeroDTO>> getAll() {
//         List<SuperHero> superHeroes = this.superHeroRepository.findAll();
//         List<SuperHeroDTO> superHeroDTOS = new ArrayList<>();
//         superHeroes.forEach(superHero -> superHeroDTOS.add(mapToDTO(superHero)));
//
//        return ResponseEntity.ok(superHeroDTOS);
        return ResponseEntity.ok(
                this.superHeroRepository
                        .findAll()
                        .stream()
                        .map(this::mapToDTO)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<SuperHeroDTO> create(@RequestBody SuperHeroDTO superHeroDTO) {
        superHeroDTO.setId(0);
        SuperHero superHero = mapToEntity(superHeroDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapToDTO(this.superHeroRepository.save(superHero)));
    }

    private SuperHero mapToEntity(SuperHeroDTO superHeroDTO) {
        SuperHero superHero = new SuperHero();
        superHero.setId(superHeroDTO.getId());
        superHero.setSuperHeroName(superHeroDTO.getSuperHeroName());
        superHero.setSecretIdentity(superHeroDTO.getSecretIdentity());
        return superHero;
    }

    private SuperHeroDTO mapToDTO(SuperHero superHero) {
        return new SuperHeroDTO(
                superHero.getId(),
                superHero.getSuperHeroName(),
                superHero.getSecretIdentity()
        );
    }
}
