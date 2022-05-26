package co.edu.javeriana.hotelapp.model.dao;

import co.edu.javeriana.hotelapp.model.dto.CategoriaDTO;

import java.util.List;

public interface CategoriaDAO {

    public CategoriaDTO create (CategoriaDTO categoria);

    public CategoriaDTO edit(Integer numEstrellas, CategoriaDTO categoria);

    public Boolean delete(Integer numEstrellas);

    public CategoriaDTO findByNum(Integer numEstrellas);

    public List<CategoriaDTO> findAll();

    public Integer count();

}
