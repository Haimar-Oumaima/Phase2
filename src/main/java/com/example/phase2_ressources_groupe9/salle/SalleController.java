package com.example.phase2_ressources_groupe9.salle;

import com.example.phase2_ressources_groupe9.salle.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salles")
public class SalleController {
    @Autowired
    private SalleRepository salleRepository;

    @PostMapping
    public Salle creerSalle(@RequestBody Salle nouvelleSalle) {
        return salleRepository.save(nouvelleSalle);
    }

    @GetMapping
    public List<Salle> lireSalles() {
        return salleRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerSalle(@PathVariable Long id) {
        return salleRepository.findById(id)
                .map(salle -> {
                    salleRepository.delete(salle);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
