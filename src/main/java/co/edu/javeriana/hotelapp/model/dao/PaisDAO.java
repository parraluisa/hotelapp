package co.edu.javeriana.hotelapp.model.dao;

import co.edu.javeriana.hotelapp.model.dto.PaisDTO;

import java.util.List;

public interface PaisDAO {

    public PaisDTO create (PaisDTO pais);

    public PaisDTO edit(String nombre, PaisDTO pais);

    public Boolean delete(String nombre);

    public PaisDTO findByName(String nombre);

    public List<PaisDTO> findAll();

    public Integer count();
}
