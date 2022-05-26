package co.edu.javeriana.hotelapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class categoria {
    private int num_estrellas;
    private String desc;
    private int cost;


    @FXML
    private TextField estrella;
    @FXML
    private TextField descripcion;
    @FXML
    private TextField costo;

    @FXML
    protected void getinsert()
    {
        try
        {
            this.num_estrellas=Integer.parseInt(estrella.getText());
            this.desc=descripcion.getText();
            this.cost=Integer.parseInt(costo.getText());
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
    protected void exit()
    {
        System.exit(0);
    }
}
