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
    private boolean insert=true;
    private boolean edit=false;

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
        Submit.setVisible(true);
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
