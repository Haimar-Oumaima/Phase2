package com.example.phase2_ressources_groupe9.reservation;

public class CreateReservationDTO {
    private Long id;
    private Long personneId;
    private Long salleId;
    private Long horaireId;

    // Constructeurs, getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Long personneId) {
        this.personneId = personneId;
    }

    public Long getSalleId() {
        return salleId;
    }

    public void setSalleId(Long salleId) {
        this.salleId = salleId;
    }

    public Long getHoraireId() {
        return horaireId;
    }

    public void setHoraireId(Long horaireId) {
        this.horaireId = horaireId;
    }
}
