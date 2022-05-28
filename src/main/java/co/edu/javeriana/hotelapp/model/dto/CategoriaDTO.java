package co.edu.javeriana.hotelapp.model.dto;

public class CategoriaDTO {
    Integer numEstrellas;
    String descripcion;
    float sobrecosto;

    public CategoriaDTO(Integer numEstrellas, String descripcion, float sobrecosto) {
        this.numEstrellas = numEstrellas;
        this.descripcion = descripcion;
        this.sobrecosto = sobrecosto;
    }
    public CategoriaDTO(Integer numEstrellas, String descripcion, String sobrecosto) {
        this.numEstrellas = numEstrellas;
        this.descripcion = descripcion;
        if(sobrecosto!=null){
            this.sobrecosto = Float.parseFloat(sobrecosto);
        }
        else {
            this.sobrecosto=-1;
        }
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

    public float getSobrecosto() {
        return sobrecosto;
    }

    public void setSobrecosto(float sobrecosto) {
        this.sobrecosto = sobrecosto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriaDTO)) return false;

        CategoriaDTO that = (CategoriaDTO) o;

        if (Float.compare(that.getSobrecosto(), getSobrecosto()) != 0) return false;
        if (!getNumEstrellas().equals(that.getNumEstrellas())) return false;
        return getDescripcion().equals(that.getDescripcion());
    }

    @Override
    public int hashCode() {
        int result = getNumEstrellas().hashCode();
        result = 31 * result + getDescripcion().hashCode();
        result = 31 * result + (getSobrecosto() != +0.0f ? Float.floatToIntBits(getSobrecosto()) : 0);
        return result;
    }
}
