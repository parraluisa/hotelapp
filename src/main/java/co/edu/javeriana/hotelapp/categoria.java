package co.edu.javeriana.hotelapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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

        /*
                vis1(false);
        confirmar.setVisible(true);
        Porcentaje.setVisible(true);
        impuesto1.setVisible(true);
        impuesto2.setVisible(true);
        this.nombre=name.getText();
        controller.setText("Porfavor filtre sus resultados para modificar un valor en la base de datos");
*/
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
