package co.edu.javeriana.hotelapp;

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

    private boolean por;
    private boolean imp1;
    private boolean imp2;

    @FXML
    private TextField name;
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
        Porcentaje.setVisible(bool);
        impuesto1.setVisible(bool);
        impuesto2.setVisible(bool);
    }
    @FXML
    protected void confirmar()
    {
        vis2(false);
        if(Porcentaje.isSelected()==true)
        {
            this.por=true;
            percentage.setVisible(true);
            p.setVisible(true);
        }
        if(impuesto1.isSelected()==true)
        {
            this.imp1=true;
            i.setVisible(true);
            iva.setVisible(true);
        }
        if(impuesto2.isSelected()==true)
        {
            this.imp2=true;
            im.setVisible(true);
            impuesto.setVisible(true);
        }
        confirmar.setVisible(false);
        submit2.setVisible(true);
    }

    @FXML
    protected void pushedit()
    {
        this.nombre=name.getText();
        if(por==true)
        {
            this.percent=Integer.parseInt(percentage.getText());
        }
        if(por==false)
        {
            this.percent=0;
        }
        if(imp1==true)
        {
            this.IVA=Integer.parseInt(iva.getText());
        }
        if(imp1==false)
        {
            this.IVA=0;
        }
        if(imp2==true)
        {
            this.imp=Integer.parseInt(impuesto.getText());
        }
        if(imp2==false)
        {
            this.imp=0;
        }
        System.out.println(nombre);
        System.out.println(percent);
        System.out.println(IVA);
        System.out.println(imp);
    }

    @FXML
    protected void edit()
    {
        vis1(false);
        confirmar.setVisible(true);
        Porcentaje.setVisible(true);
        impuesto1.setVisible(true);
        impuesto2.setVisible(true);
        this.nombre=name.getText();
        controller.setText("Porfavor filtre sus resultados para modificar un valor en la base de datos");
    }

    @FXML
    protected void insertar()
    {
        vis1(true);
        confirmar.setVisible(false);
        Porcentaje.setVisible(false);
        impuesto1.setVisible(false);
        impuesto2.setVisible(false);
        controller.setText("Porfavor insertar los datos para agregar el país a la base de datos");

    }

    @FXML
    protected void getinsert()
    {
        try
        {
            this.nombre=name.getText();
            if(nombre.equals(""))
            {
                throw new Exception("Cannot leave name in blank");
            }
            this.IVA=Integer.parseInt(iva.getText());
            this.imp=Integer.parseInt(impuesto.getText());
            this.percent=Integer.parseInt(percentage.getText());

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
