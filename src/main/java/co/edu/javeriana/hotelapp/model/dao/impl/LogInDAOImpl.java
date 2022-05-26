package co.edu.javeriana.hotelapp.model.dao.impl;

import co.edu.javeriana.hotelapp.model.dao.LogInDAO;
import co.edu.javeriana.hotelapp.model.dto.LogInDTO;
import co.edu.javeriana.hotelapp.util.Oracle;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogInDAOImpl implements LogInDAO {

    public final Oracle oracle;

    public LogInDAOImpl(){
        this.oracle= new Oracle();
    }
    @Override
    public LogInDTO create(LogInDTO login) {
        try {
            this.oracle.conectar();
            String query="Insert into login_p2(usuario,contrasenia) values("
                    +"'"+login.getUser()+"',"
                    +login.getPassword()+")";
            Statement stmt = this.oracle.getConnection().createStatement();
            int code= stmt.executeUpdate(query);
            stmt.close();
            this.oracle.desconectar();
            switch (code) {
                case 1:
                    System.out.println("Se creo el usuario");
                      return findByUser(login.getUser());
                default:
                    return null;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(LogInDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }
    }
    @Override
    public Boolean encontrarUsuario(String user, LogInDTO login) {
        Boolean res=false;
        try {
            this.oracle.conectar();
            String query = "SELECT * FROM login_p2 WHERE user = '" + user + "'";
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()) {
                LogInDTO Log = new LogInDTO(
                        rs.getString("usuario"),
                        rs.getString("contrasenia"));
                rs.close();
                stmt.close();
                if (login.equals(Log)) {
                    res=true;
                }
            } else {
                rs.close();
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogInDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return res;
    }

    @Override

    public LogInDTO findByUser(String user){
        try {
            this.oracle.conectar();
            String query = "SELECT * FROM login_p2 WHERE usuario = '" + user + "'";
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()) {
                LogInDTO log = new LogInDTO(
                        rs.getString("usuario"),
                        rs.getString("contrasenia"));
                rs.close();
                stmt.close();
                return log;
            } else {
                rs.close();
                stmt.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogInDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}