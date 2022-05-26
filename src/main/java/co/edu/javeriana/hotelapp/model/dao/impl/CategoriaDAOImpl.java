package co.edu.javeriana.hotelapp.model.dao.impl;

import co.edu.javeriana.hotelapp.model.dao.PaisDAO;
import co.edu.javeriana.hotelapp.model.dto.CategoriaDTO;
import co.edu.javeriana.hotelapp.model.dto.PaisDTO;
import co.edu.javeriana.hotelapp.util.Oracle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDAOImpl implements CategoriaDAO {

    public final Oracle oracle;

    public CategoriaDAOImpl() {
        this.oracle = new Oracle();
    }

    @Override
    public CategoriaDTO edit(Integer numEstrellas, String descripcion, Double sobrecosto, CategoriaDTO categoria) {
        try {
            this.oracle.conectar();
            String query = "update categoria_p2 set " //Categoría está sujeto al nombre de la tabla
                    + "numEstrellas =" + categoria.getNumEstrellas() + ","
                    + "descripcion  =" + "'" + categoria.getDescripcion() + "',"
                    + "sobrecosto =" + "'" + categoria.getSobrecosto() + "'where numEstrellas ='" + numEstrellas + "';";
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement();
            int code = stmt.executeUpdate(query);
            stmt.close();
            this.oracle.desconectar();
            switch (code) {
                case 1:
                    System.out.println("Se actualizo la categoria");
                    // return findByName(categoria.getC());
                default:
                    return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogInDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<CategoriaDTO> findAll() {
        List<CategoriaDTO> categoriasList = new ArrayList<CategoriaDTO>();
        try {
            this.oracle.conectar();
            String query = "SELECT * FROM categoria;"; //Está sujeto al nombre de la tabla
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()) {
                while (rs.next()) {
                    CategoriaDTO categoria = new CategoriaDTO(
                            rs.getInt("numEstrellas"),
                            rs.getString("descripcion"),
                            rs.getDouble("sobrecosto"));
                    categoriasList.add(categoria);
                }
                rs.close();
                stmt.close();
                return categoriasList;
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
