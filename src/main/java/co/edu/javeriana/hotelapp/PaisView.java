package co.edu.javeriana.hotelapp;

import co.edu.javeriana.hotelapp.model.dao.PaisDAO;
import co.edu.javeriana.hotelapp.model.dao.impl.PaisDAOImpl;
import co.edu.javeriana.hotelapp.model.dto.PaisDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PaisView {
    private String nombre;
    private int percent;
    private int IVA;
    private int imp;
    private boolean insert=true;
    private boolean edit=false;


    @FXML
    private TextField name;

    @FXML
    private Button delete;
    @FXML
    private TextField iva;
    @FXML
    private TextField impuesto;
    @FXML
    private TextField percentage;
    @FXML
    private Label controller;
    @FXML
    private Label im;
    @FXML
    private Label i;
    @FXML
    private Label p;
    @FXML
    private RadioButton Porcentaje;
    @FXML
    private RadioButton impuesto1;
    @FXML
    private RadioButton impuesto2;
    @FXML
    private Button Submit;
    @FXML
    private Button confirmar;

    @FXML
    private Button submit2;



    protected void vis1(boolean bool)
    {
        tagname.setVisible(bool);
        name.setVisible(bool);
        im.setVisible(bool);
        i.setVisible(bool);
        p.setVisible(bool);
        iva.setVisible(bool);
        impuesto.setVisible(bool);
        percentage.setVisible(bool);
        Submit.setVisible(bool);
    }
    protected void vis2(boolean bool)
    {
        tagname.setVisible(bool);
        name.setVisible(bool);
        confirmar.setVisible(bool);
        Porcentaje.setVisible(bool);
        impuesto1.setVisible(bool);
        impuesto2.setVisible(bool);
        submit2.setVisible(bool);
    }

    protected void viseliminar(boolean b)
    {
        tagname.setVisible(b);
        name.setVisible(b);
        delete.setVisible(b);
    }

    protected void vissearch(boolean b)
    {
        tagname.setVisible(b);
        name.setVisible(b);
        fuck.setVisible(b);
    }

    protected void viscount(boolean b)
    {
        searchtag.setVisible(b);
    }

    private boolean select1=false;
    private boolean select2=false;
    private boolean select3=false;

    @FXML
    protected void confirmar()
    {
        vis2(false);
        vis1(false);
        viseliminar(false);
        name.setVisible(true);
        tagname.setVisible(true);
        if(Porcentaje.isSelected()==true)
        {
            this.select1=true;
            percentage.setVisible(true);
            p.setVisible(true);
            confirmar.setVisible(false);
            submit2.setVisible(true);
            i.setText("IVA");
        }
        if(impuesto1.isSelected()==true)
        {

            this.select2=true;
            i.setVisible(true);
            iva.setVisible(true);
            confirmar.setVisible(false);
            submit2.setVisible(true);
            i.setText("IVA");
        }
        if(impuesto2.isSelected()==true)
        {
            this.select3=true;
            im.setVisible(true);
            impuesto.setVisible(true);
            confirmar.setVisible(false);
            submit2.setVisible(true);
            i.setText("IVA");
        }
        if(select1==false && select2==false && select3==false)
        {
            vis2(true);
            i.setVisible(true);
            i.setText("Fatal error! please select a search filter");
        }
    }

    @FXML
    protected void pushedit()
    {
        String auxIVA;
        String auxImptur;
        String auxImpcons;
        this.nombre=name.getText();
        try
        {
            if(name.getText().equals(""))
            {

                throw new Exception("Please enter the name of the country");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        if(select1==true)
        {
            this.percent=Integer.parseInt(percentage.getText());
            auxImptur=percentage.getText();
        } else
        {
            auxImptur=null;
        }
        if(select2==true)
        {
            this.IVA=Integer.parseInt(iva.getText());
            auxIVA=iva.getText();
        } else
        {
            auxIVA=null;
        }
        if(select3==true)
        {
            this.imp=Integer.parseInt(impuesto.getText());
            auxImpcons=impuesto.getText();
        }
        else
        {
            auxImpcons=null;
        }

        PaisDAO pdao=new PaisDAOImpl();
        PaisDTO pdto= new PaisDTO(nombre,auxImptur,auxIVA,auxImpcons);
        PaisDTO p1= pdao.edit(nombre,pdto);
        System.out.println(nombre);
        System.out.println(percent);
        System.out.println(IVA);
        System.out.println(imp);

    }

    @FXML
    protected void eliminar()
    {
        vis1(false);
        vis2(false);
        vis3(false);
        vissearch(false);
        viseliminar(true);
        viscount(false);
    }

    @FXML
    protected void DELETE()
    {
        this.nombre=name.getText();
        PaisDAO pdao = new PaisDAOImpl();
        Boolean p1= pdao.delete(nombre);
        if(p1==true){
            System.out.println("se pudo eliminar el pais");
        }
        else {
            System.out.println("algo paso y no se pudo");
        }
        System.out.println("Success");
    }
    @FXML
    protected void buscar()
    {
        vis1(false);
        vis2(false);
        viseliminar(false);
        vissearch(true);
        viscount(false);

    }
    @FXML
    private Button fuck;
    @FXML
    private Label result;

    @FXML
    private Label tag;
    @FXML
    private Label tag1;
    @FXML
    private Label tag2;
    @FXML
    private Label tag3;
    @FXML
    private Label result1;
    @FXML
    private Label result2;
    @FXML
    private Label result3;
    @FXML
    private Label result4;

    protected void vis3(boolean b)
    {
        tag.setVisible(b);
        tag1.setVisible(b);
        tag2.setVisible(b);
        tag3.setVisible(b);
        result1.setVisible(b);
        result2.setVisible(b);
        result3.setVisible(b);
        result4.setVisible(b);
    }

    @FXML
    protected void search()
    {
        vis3(false);
        vis1(false);
        viseliminar(false);
        vis2(false);
        this.nombre=name.getText();
        PaisDAO pdao=new PaisDAOImpl();
        PaisDTO p1=pdao.findByName(nombre);
        vis3(true);
        tag.setText("Pais: ");
        tag1.setText("Impuesto NAC.turismo: ");
        tag2.setText("IVA: ");
        tag3.setText("Impuesto consumidor: ");
        result1.setText(p1.getNombre());
        result2.setText(String.valueOf((p1.getImpNacTur())));
        result3.setText(String.valueOf(p1.getIva()));
        result4.setText(String.valueOf(p1.getImpCons()));

    }

    @FXML
    private Label tagname;

    @FXML
    private Label searchtag;

    @FXML
    protected void Count()
    {
        vis1(false);
        vis2(false);
        vis3(false);
        viseliminar(false);
        vissearch(false);
        viscount(true);
        PaisDAO pdao= new PaisDAOImpl();
        int cant=pdao.count();
        searchtag.setText("La cantidad de paises son: " + cant);
        tagname.setVisible(false);
        name.setVisible(false);

    }

    @FXML
    protected void edit()
    {
        viseliminar(false);
        vissearch(false);
        vis3(false);
        viscount(false);
        vis1(false);
        vis2(true);
        submit2.setVisible(false);
        confirmar.setVisible(true);
        Porcentaje.setVisible(true);
        impuesto1.setVisible(true);
        impuesto2.setVisible(true);
        this.nombre=name.getText();
        PaisDAO pdao= new PaisDAOImpl();
        PaisDTO p1=pdao.findByName(nombre);
        controller.setText("Porfavor filtre sus resultados para modificar un valor en la base de datos");
    }


    @FXML
    protected void insertar()
    {
        viseliminar(false);
        vis2(false);
        vissearch(false);
        vis3(false);
        vis1(true);
        confirmar.setVisible(false);
        Porcentaje.setVisible(false);
        impuesto1.setVisible(false);
        impuesto2.setVisible(false);
        controller.setText("Porfavor insertar los datos para agregar el país a la base de datos");

    }

    @FXML
    private Label confirmation;

    @FXML
    protected void getinsert() throws Exception {
        this.nombre=name.getText();
        try
        {
            if(nombre.equals(""))
            {
                confirmation.setVisible(true);
                confirmation.setText("Cannot leave Name in blank");
                throw new Exception("Cannot leave name in blank");
            }
            if(iva.getText().equals(""))
            {
                confirmation.setVisible(true);
                confirmation.setText("Cannot leave IVA in blank");
                throw new Exception("Cannot leave IVA in blank");
            }
            if(impuesto.getText().equals(""))
            {
                confirmation.setVisible(true);
                confirmation.setText("Cannot leave tax in blank");
                throw new Exception("Cannot leave tax in blank");
            }
            if(percentage.getText().equals(""))
            {
                confirmation.setVisible(true);
                confirmation.setText("Cannot leave Percentage in blank");
                throw new Exception("Cannot leave Percentage in blank");
            }
            this.IVA=Integer.parseInt(iva.getText());
            this.imp=Integer.parseInt(impuesto.getText());
            this.percent=Integer.parseInt(percentage.getText());
            PaisDTO pais=new PaisDTO(nombre,imp,IVA,percent);
            PaisDAO pdao =new PaisDAOImpl();
            PaisDTO pa=pdao.create(pais);
            confirmation.setVisible(true);
            confirmation.setText("La adición fue un exito!");
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println("This is nombre: "+nombre);
        System.out.println("This is IVA: "+IVA);
        System.out.println("This is impuesto: "+imp);
        System.out.println("This is percentage: "+percent);
    }



    @FXML
    protected void exit()
    {
        System.exit(0);
    }
}
