package com.devf.smolinaa.firstapp.projectfragmentssample.UI.Fragment;

/**
 * Created by Salvador on 01/07/2015.
 */
public class Pockemon {

    public String nombre;
    public Integer escudo;
    public Integer espada;
    public Integer rayo;
    public String src;

    public Pockemon(String nombre, Integer escudo, Integer espada, Integer rayo, String src) {
        this.nombre = nombre;
        this.escudo = escudo;
        this.espada = espada;
        this.rayo = rayo;
        this.src = src;
    }

    public Pockemon(String nombre){
        this.nombre = nombre;
        switch (nombre){
            case "Pikachu":
                this.escudo = 23;
                this.espada = 32;
                this.rayo = 95;
                this.src = "pockemon1";
                break;
            case "Raichu":
                this.escudo = 52;
                this.espada = 23;
                this.rayo = 70;
                this.src = "pockemon2";
                break;
            case "MagicKarp":
                this.escudo = 85;
                this.espada = 32;
                this.rayo = 23;
                this.src = "pockemon3";
                break;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEscudo() {
        return escudo;
    }

    public void setEscudo(Integer escudo) {
        this.escudo = escudo;
    }

    public Integer getEspada() {
        return espada;
    }

    public void setEspada(Integer espada) {
        this.espada = espada;
    }

    public Integer getRayo() {
        return rayo;
    }

    public void setRayo(Integer rayo) {
        this.rayo = rayo;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
