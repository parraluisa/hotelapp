package co.edu.javeriana.hotelapp.model.dao.impl;

import co.edu.javeriana.hotelapp.model.dto.CategoriaDTO;
import co.edu.javeriana.hotelapp.model.dto.LogInDTO;

import java.util.List;

public interface LogInDAO {

    public LogInDTO create (LogInDTO login);

    public Boolean encontrarUsuario(String user, LogInDTO login);
}
