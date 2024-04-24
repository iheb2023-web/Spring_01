package com.iheb.sport.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSport;
    private String nomSport;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date dateFondation;


    public sport( String nomSport, String description, Date dateFondation) {
        super();
        this.nomSport = nomSport;
        this.description = description;
        this.dateFondation = dateFondation;

    }

    public sport() {
        super();
    }


    public Long getIdSport() {
        return idSport;
    }
    public void setIdSport(Long idSport) {
        this.idSport = idSport;
    }

    public String getNomSport() {
        return nomSport;
    }
    public void setNomSport(String nomSport) {
        this.nomSport = nomSport;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateFondation() {
        return dateFondation;
    }
    public void setDateFondation(Date dateFondation) {
        this.dateFondation = dateFondation;
    }

	@Override
	public String toString() {
		return "sport [idSport=" + idSport + ", nomSport=" + nomSport + ", description=" + description
				+ ", dateFondation=" + dateFondation + "]";
	}

    




}

