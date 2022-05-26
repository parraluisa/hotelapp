package co.edu.javeriana.hotelapp.model.dao.impl;

import co.edu.javeriana.hotelapp.model.dto.CategoriaDTO;
import co.edu.javeriana.hotelapp.model.dto.PaisDTO;

import java.util.List;

public interface CategoriaDAO {

    public CategoriaDTO edit(Integer numEstrellas, String descripcion, Double sobrecosto, CategoriaDTO categoria);

    public List<CategoriaDTO> findAll();
}
