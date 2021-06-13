package com.cosaproyectosistemas.LukkyFrost.cosa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Paca")
public class Paismodelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = false, nullable = false)
    private String pais;


    @Column(unique = false, nullable = false)
    private String capital;

    public String getPais() {
        return pais;
    }

    public void setpais(String pais) {
        this.pais = pais;
    }

    public String getcapital() {
        return capital;
    }

    public void setcapital(String capital) {
        this.capital = capital;
    }


    @Override
    public String toString() {
        return "Paismodelo [Pais=" + pais + ", Capital=" + capital + "]";
    }

}