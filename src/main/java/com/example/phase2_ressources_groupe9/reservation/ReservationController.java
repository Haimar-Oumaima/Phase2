package com.example.phase2_ressources_groupe9.reservation;

import com.example.phase2_ressources_groupe9.horaire.Horaire;
import com.example.phase2_ressources_groupe9.horaire.HoraireRepository;
import com.example.phase2_ressources_groupe9.personne.Personne;
import com.example.phase2_ressources_groupe9.personne.PersonneRepository;
import com.example.phase2_ressources_groupe9.salle.Salle;
import com.example.phase2_ressources_groupe9.salle.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private HoraireRepository horaireRepository;

    @PostMapping
    public ResponseEntity<Reservation> creerReservation(@RequestBody CreateReservationDTO createReservationDTO) {
        Personne personne = personneRepository.findById(createReservationDTO.getPersonneId()).orElse(null);
        Salle salle = salleRepository.findById(createReservationDTO.getSalleId()).orElse(null);
        Horaire horaire = horaireRepository.findById(createReservationDTO.getHoraireId()).orElse(null);

        Reservation reservation = new Reservation();
        reservation.setPersonne(personne);
        reservation.setSalle(salle);
        reservation.setHoraire(horaire);
        return ResponseEntity.ok(reservationRepository.save(reservation));
    }

    @GetMapping
    public List<Reservation> lireReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> lireReservationParId(@PathVariable Long id) {
        return reservationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerReservation(@PathVariable Long id) {
        return reservationRepository.findById(id)
                .map(reservation -> {
                    reservationRepository.delete(reservation);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }


}
