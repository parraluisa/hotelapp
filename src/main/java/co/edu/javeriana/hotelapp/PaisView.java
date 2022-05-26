package co.edu.javeriana.hotelapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PaisView {
    private String nombre;
    private int percent;
    private int IVA;
    private int imp;

    @FXML
    private TextField name;
    @FXML
    private TextField iva;
    @FXML
    private TextField impuesto;
    @FXML
    private TextField percentage;

    @FXML
    protected void getinsert()
    {
        try
        {
            this.nombre=name.getText();
            this.IVA=Integer.parseInt(iva.getText());
            this.imp=Integer.parseInt(impuesto.getText());
            this.percent=Integer.parseInt(percentage.getText());

        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println(nombre);
        System.out.println(IVA);
        System.out.println(imp);
        System.out.println(percent);

    }



    @FXML
    protected void exit()
    {
        System.exit(0);
    }
}
