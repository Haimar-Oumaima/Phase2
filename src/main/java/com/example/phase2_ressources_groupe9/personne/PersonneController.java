package com.example.phase2_ressources_groupe9.personne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personnes")
public class PersonneController {

    @Autowired
    private PersonneRepository personneRepository;

    @PostMapping
    public Personne creerPersonne(@RequestBody Personne nouvellePersonne) {
        return personneRepository.save(nouvellePersonne);
    }

    @GetMapping
    public List<Personne> lirePersonnes() {
        return personneRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personne> lirePersonneParId(@PathVariable Long id) {
        return personneRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerPersonne(@PathVariable Long id) {
        return personneRepository.findById(id)
                .map(personne -> {
                    personneRepository.delete(personne);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}