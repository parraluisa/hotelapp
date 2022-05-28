package co.edu.javeriana.hotelapp.model.dto;

import java.util.Objects;

public class PaisDTO {
    String nombre;
    int impNacTur;
    int iva;
    int impCons;

    public PaisDTO(String nombre, int impNacTur, int iva, int impCons) {
        this.nombre = nombre;
        this.impNacTur = impNacTur;
        this.iva = iva;
        this.impCons = impCons;
    }
    public PaisDTO(String nombre, String impNacTur, String iva, String impCons) {
        this.nombre = nombre;
        if (impNacTur!=null){
            this.impNacTur = Integer.parseInt(impNacTur);
        }
        else{
            this.impNacTur=-1;
        }
        if (iva!= null){
            this.iva = Integer.parseInt(iva);
        }
        else {
            this.iva=-1;
        }
        if(impCons!=null){
            this.impCons = Integer.parseInt(impCons);
        }
        else {
            this.impCons=-1;
        }
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImpNacTur() {
        return impNacTur;
    }

    public void setImpNacTur(int impNacTur) {
        this.impNacTur = impNacTur;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getImpCons() {
        return impCons;
    }

    public void setImpCons(int impCons) {
        this.impCons = impCons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaisDTO)) return false;
        PaisDTO paisDTO = (PaisDTO) o;
        return impNacTur == paisDTO.impNacTur && iva == paisDTO.iva && impCons == paisDTO.impCons && nombre.equals(paisDTO.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, impNacTur, iva, impCons);
    }

    @Override
    public String toString() {
        return "PaisDTO{" +
                "nombre='" + nombre + '\'' +
                ", impNacTur=" + impNacTur +
                ", iva=" + iva +
                ", impCons=" + impCons +
                '}';
    }
}
