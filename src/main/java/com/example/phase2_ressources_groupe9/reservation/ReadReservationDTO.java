package com.example.phase2_ressources_groupe9.reservation;

import com.example.phase2_ressources_groupe9.horaire.Horaire;

public class ReadReservationDTO {
    private Long id;
    private String personne;
    private String salle;
    private Horaire horaire;
//    private String horaire;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonne() {
        return personne;
    }

    public void setPersonne(String personne) {
        this.personne = personne;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public Horaire getHoraire() {
        return horaire;
    }

    public void setHoraire(Horaire horaire) {
        this.horaire = horaire;
    }
//    public String getHoraire() {
//        return horaire;
//    }
//
//    public void setHoraire(String horaire) {
//        this.horaire = horaire;
//    }
}
