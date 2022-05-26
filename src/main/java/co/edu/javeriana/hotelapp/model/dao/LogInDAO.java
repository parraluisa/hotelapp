package co.edu.javeriana.hotelapp.model.dao;

import co.edu.javeriana.hotelapp.model.dto.LogInDTO;

public interface LogInDAO {

    public LogInDTO create (LogInDTO login);

    public Boolean encontrarUsuario(String user, LogInDTO login);

}
