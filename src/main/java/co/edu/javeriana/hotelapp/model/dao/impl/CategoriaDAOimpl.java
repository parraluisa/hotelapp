package co.edu.javeriana.hotelapp.model.dao.impl;

import co.edu.javeriana.hotelapp.model.dao.CategoriaDAO;
import co.edu.javeriana.hotelapp.model.dto.CategoriaDTO;
import co.edu.javeriana.hotelapp.util.Oracle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDAOimpl implements CategoriaDAO {

    public final Oracle oracle;

    public CategoriaDAOimpl(){
        this.oracle= new Oracle();
    }

    @Override
    public CategoriaDTO create(CategoriaDTO categoria) {
        try {
            this.oracle.conectar();
            String query="Insert into categoria_p2 values("
                    +categoria.getNumEstrellas()+","
                    +"'"+categoria.getDescripcion()+"',"
                    +categoria.getSobrecosto()+")";
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement();
            int code= stmt.executeUpdate(query);
            stmt.close();
            this.oracle.desconectar();
            switch (code) {
                case 1:
                    System.out.println("Se creo la categoria");
                    return findByNum(categoria.getNumEstrellas());
                default:
                    return null;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(CategoriaDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }
    }

    @Override
    public CategoriaDTO edit(Integer numEstrellas, CategoriaDTO categoria) {
        try {
            this.oracle.conectar();
            String query = "update categoria_p2 set "
                    +"estrellas ="+ categoria.getNumEstrellas()+","
                    +" descripcion ="+ "'" + categoria.getDescripcion() + "',"
                    +"sobrecosto ="+ "'" + categoria.getSobrecosto() + "' where estrellas ="+numEstrellas;
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement();
            int code = stmt.executeUpdate(query);
            stmt.close();
            this.oracle.desconectar();
            switch (code) {
                case 1:
                    System.out.println("Se actualizo la categoria");
                    return findByNum(categoria.getNumEstrellas());
                default:
                    return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public Boolean delete(Integer numEstrellas) {
        try {
            this.oracle.conectar();
            String query = "DELETE FROM categoria_p2 WHERE estrellas="
                    + numEstrellas + "";
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement();
            int code = stmt.executeUpdate(query);
            stmt.close();
            this.oracle.desconectar();
            switch (code) {
                case 1:
                    System.out.println("Se eliminó la categoria");
                    return true;
                default:
                    return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public CategoriaDTO findByNum(Integer numEstrellas) {
        try {
            this.oracle.conectar();
            String query = "SELECT * FROM categoria_p2 WHERE estrellas = " + numEstrellas + "";
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()) {
                CategoriaDTO categoria = new CategoriaDTO(
                        rs.getInt("estrellas"),
                        rs.getString("descripción"),
                        rs.getInt("sobrecosto"));
                rs.close();
                stmt.close();
                return categoria;
            } else {
                rs.close();
                stmt.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<CategoriaDTO> findAll() {
        List<CategoriaDTO> categoriasList=new ArrayList<CategoriaDTO>();
        try {
            this.oracle.conectar();
            String query = "SELECT * FROM categoria_p2";
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()){
                while (rs.next()) {
                    CategoriaDTO categoria = new CategoriaDTO(
                            rs.getInt("estrellas"),
                            rs.getString("descripcion"),
                            rs.getInt("sobrecosto"));
                    categoriasList.add(categoria);
                }
                rs.close();
                stmt.close();
                return categoriasList;
            }
            else {
                rs.close();
                stmt.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Integer count() {
        try {
            this.oracle.conectar();
            String query = "SELECT COUNT(*) FROM categoria_p2";
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            int num=rs.getInt("count(*)");
            rs.close();
            stmt.close();
            return num;

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
