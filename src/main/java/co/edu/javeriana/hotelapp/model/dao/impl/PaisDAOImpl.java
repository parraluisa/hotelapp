package co.edu.javeriana.hotelapp.model.dao.impl;

import co.edu.javeriana.hotelapp.model.dao.PaisDAO;
import co.edu.javeriana.hotelapp.model.dto.PaisDTO;
import co.edu.javeriana.hotelapp.util.Oracle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaisDAOImpl implements PaisDAO {

    public final Oracle oracle;

    public PaisDAOImpl(){
        this.oracle= new Oracle();
    }
    @Override
    public PaisDTO create(PaisDTO pais) {
        try {
            this.oracle.conectar();
            String query="Insert into pais_p2(nombre, imptur, iva, impcons) values("
                    +"'"+pais.getNombre()+"',"
                    +pais.getImpNacTur()+","
                    + pais.getIva()+","
                    + pais.getImpCons()+")";
            Statement stmt = this.oracle.getConnection().createStatement();
            int code= stmt.executeUpdate(query);
            stmt.close();
            this.oracle.desconectar();
            switch (code) {
                case 1:
                    System.out.println("Se creo el pais");
                    return findByName(pais.getNombre());
                default:
                    return null;
        }
        }
        catch (SQLException ex) {
            Logger.getLogger(PaisDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }
    }

    @Override
    public PaisDTO edit(String nombre, PaisDTO pais) {
        try {
            this.oracle.conectar();
            String query = "update pais_p2 set "
                    +"nombre ='"+ pais.getNombre()+"',"
                    +" imptur ="+ "'" + pais.getImpNacTur() + "',"
                    +"iva ="+ "'" + pais.getIva() + "',"
                    +"impcons ="+ "'" + pais.getImpCons() + "' where nombre ='"+nombre+"'";
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement();
            int code = stmt.executeUpdate(query);
            stmt.close();
            this.oracle.desconectar();
            switch (code) {
                case 1:
                    System.out.println("Se actualizo el pais");
                    return findByName(pais.getNombre());
                default:
                    return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaisDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Boolean delete(String nombre) {
        try {
            this.oracle.conectar();
            String query = "DELETE FROM pais_p2 WHERE nombre='"
                    + nombre + "'";
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement();
            int code = stmt.executeUpdate(query);
            stmt.close();
            this.oracle.desconectar();
            switch (code) {
                case 1:
                    System.out.println("Se eliminó el pais");
                    return true;
                default:
                    return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaisDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public PaisDTO findByName(String nombre) {
        try {
            this.oracle.conectar();
            String query = "SELECT * FROM pais_p2 WHERE nombre = '" + nombre + "'";
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()) {
                PaisDTO pais = new PaisDTO(
                        rs.getString("nombre"),
                        rs.getInt("imptur"),
                        rs.getInt("iva"),
                        rs.getShort("impcons"));
                rs.close();
                stmt.close();
                return pais;
            } else {
                rs.close();
                stmt.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaisDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<PaisDTO> findAll() {
        List<PaisDTO> paisesList=new ArrayList<PaisDTO>();
        try {
            this.oracle.conectar();
            String query = "SELECT * FROM pais_p2";
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()){
                while (rs.next()) {
                    PaisDTO pais = new PaisDTO(
                            rs.getString("nombre"),
                            rs.getInt("imptur"),
                            rs.getInt("iva"),
                            rs.getInt("impcons"));
                    paisesList.add(pais);
                }
                rs.close();
                stmt.close();
                return paisesList;
            }
            else {
                rs.close();
                stmt.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaisDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Integer count() {
        try {
            this.oracle.conectar();
            String query = "SELECT COUNT(*) FROM pais_p2";
            System.out.println(query);
            Statement stmt = this.oracle.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            int num=rs.getInt("count(*)");
            rs.close();
            stmt.close();
            return num;

        } catch (SQLException ex) {
            Logger.getLogger(PaisDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
