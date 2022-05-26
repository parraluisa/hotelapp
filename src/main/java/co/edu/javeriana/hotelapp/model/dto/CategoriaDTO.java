package co.edu.javeriana.hotelapp.model.dto;

import java.util.Objects;

public class CategoriaDTO {
    Integer numEstrellas;
    String descripcion;
    Double sobrecosto;

    public CategoriaDTO(Integer numEstrellas, String descripcion, Double sobrecosto) {
        this.numEstrellas = numEstrellas;
        this.descripcion = descripcion;
        this.sobrecosto = sobrecosto;
    }

    public Integer getNumEstrellas() {
        return numEstrellas;
    }

    public void setNumEstrellas(Integer numEstrellas) {
        this.numEstrellas = numEstrellas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getSobrecosto() {
        return sobrecosto;
    }

    public void setSobrecosto(Double sobrecosto) {
        this.sobrecosto = sobrecosto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaDTO that = (CategoriaDTO) o;
        return numEstrellas.equals(that.numEstrellas) && descripcion.equals(that.descripcion) && sobrecosto.equals(that.sobrecosto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numEstrellas, descripcion, sobrecosto);
    }

    @Override
    public String toString() {
        return "CategoriaDTO{" +
                "numEstrellas=" + numEstrellas +
                ", descripcion='" + descripcion + '\'' +
                ", sobrecosto=" + sobrecosto +
                '}';
    }
}