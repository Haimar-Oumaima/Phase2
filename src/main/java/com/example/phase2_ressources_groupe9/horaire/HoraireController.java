package com.example.phase2_ressources_groupe9.horaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horaires")
public class HoraireController {
    @Autowired
    private HoraireRepository horaireRepository;

    @PostMapping
    public Horaire create(@RequestBody Horaire nouvelleHoraire){
        return horaireRepository.save(nouvelleHoraire);
    }

    @GetMapping
    public List<Horaire> lireHoraires() {
        return horaireRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horaire> lireHoraireParId(@PathVariable Long id) {
        return horaireRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerHoraire(@PathVariable Long id) {
        return horaireRepository.findById(id)
                .map(horaire -> {
                    horaireRepository.delete(horaire);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
