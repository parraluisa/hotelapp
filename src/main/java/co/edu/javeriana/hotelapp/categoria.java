package co.edu.javeriana.hotelapp;

import co.edu.javeriana.hotelapp.model.dao.CategoriaDAO;
import co.edu.javeriana.hotelapp.model.dao.impl.CategoriaDAOimpl;
import co.edu.javeriana.hotelapp.model.dto.CategoriaDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class categoria {
    private int num_estrellas;
    private String desc;
    private float cost;


    @FXML
    private TextField estrella;
    @FXML
    private TextField descripcion;
    @FXML
    private TextField costo;

    @FXML
    private RadioButton des;

    @FXML
    private RadioButton sobre;

    @FXML
    private Label lSobre;

    @FXML
    private Button sumb;

    @FXML Label lDes;

    @FXML
    protected  void edit(){
        vis(true);
        des.setVisible(true);
        sobre.setVisible(true);
        vis1(false);
        shit.setVisible(false);
        search.setVisible(true);
    }

    protected void vis(Boolean bool){
        des.setVisible(bool);
        sobre.setVisible(bool);
    }

    protected void vis1(Boolean bool){
        lSobre.setVisible(bool);
        sumb.setVisible(bool);
        costo.setVisible(bool);
        descripcion.setVisible(bool);
        lDes.setVisible(bool);
    }



@FXML
private Button shit;

    @FXML
    protected void delete()
    {
        vis(false);
        vis1(false);
        shit.setVisible(false);
        search.setVisible(true);
    }

    @FXML
    protected void errase()
    {
        this.num_estrellas=Integer.parseInt(estrella.getText());
        System.out.println(num_estrellas);
        CategoriaDAO cdao = new CategoriaDAOimpl();
        Boolean c1=cdao.delete(num_estrellas);
        if(c1==true){
            System.out.println("se pudo eliminar el pais");
        }
        else {
            System.out.println("algo paso y no se pudo");
        }
    }
    @FXML
    protected void insert()
    {
        vis(false);
        vis1(true);
        shit.setVisible(false);
        search.setVisible(true);
    }


    @FXML
    private Button search;

    @FXML
    private Label Fuckshit;

    @FXML
    private Label hola;
    @FXML
    protected void mrda()
    {
        this.num_estrellas=Integer.parseInt(estrella.getText());
        CategoriaDAO cdao=new CategoriaDAOimpl();
        CategoriaDTO c1=cdao.findByNum(num_estrellas);
        Fuckshit.setVisible(true);
        Fuckshit.setText(c1.getDescripcion());
        hola.setVisible(true);
        hola.setText(String.valueOf(c1.getSobrecosto()));
    }
    @FXML
    protected void look()
    {
        vis(false);
        vis1(false);
        shit.setVisible(false);
        search.setVisible(true);
    }
    @FXML
    protected void getinsert()
    {
        try
        {
            this.num_estrellas=Integer.parseInt(estrella.getText());
            this.desc=descripcion.getText();
            this.cost=Float.parseFloat(costo.getText());
            CategoriaDTO c1= new CategoriaDTO(num_estrellas, desc,cost);
            CategoriaDAO cdao= new CategoriaDAOimpl();
            CategoriaDTO c2= cdao.create(c1);
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println(num_estrellas);
        System.out.println(desc);
        System.out.println(cost);
    }

    @FXML
    private Label fuck;
    @FXML
    protected void count()
    {
        estrella.setVisible(false);
        vis(false);
        vis1(false);
        CategoriaDAO cdao= new CategoriaDAOimpl();
        int cant= cdao.count();
        fuck.setText("Las categorias existentes son: " + cant);
    }

    @FXML
    protected void confirmar()
    {
        /*vis(false);
        if(Porcentaje.isSelected()==true)
        {
            percentage.setVisible(true);
            p.setVisible(true);
        }
        if(impuesto1.isSelected()==true)
        {
            i.setVisible(true);
            iva.setVisible(true);
        }
        if(impuesto2.isSelected()==true)
        {
            im.setVisible(true);
            impuesto.setVisible(true);
        }

        confirmar.setVisible(false);
        Submit.setVisible(true);*/
    }




    @FXML
    protected void exit()
    {
        System.exit(0);
    }
}
