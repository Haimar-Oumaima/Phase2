package com.example.phase2_ressources_groupe9.reservation;

import com.example.phase2_ressources_groupe9.horaire.Horaire;
import com.example.phase2_ressources_groupe9.personne.Personne;
import com.example.phase2_ressources_groupe9.salle.Salle;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String personneId;
    private String salleId;
    private String horaireId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonneId() {
        return personneId;
    }

    public void setPersonneId(String personneId) {
        this.personneId = personneId;
    }

    public String getSalleId() {
        return salleId;
    }

    public void setSalleId(String salleId) {
        this.salleId = salleId;
    }

    public String getHoraireId() {
        return horaireId;
    }

    public void setHoraireId(String horaireId) {
        this.horaireId = horaireId;
    }
}
