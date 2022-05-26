package co.edu.javeriana.hotelapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Dir {

    @FXML
    protected void pais() throws IOException {
        try
        {
            Parent root = FXMLLoader.load(HelloApplication.class.getResource("pais-view.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("pais.css").toExternalForm());
            Stage stage= new Stage();
            stage.setTitle("Pais");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @FXML
    protected void categoria() throws IOException {
        try
        {
            Parent root = FXMLLoader.load(HelloApplication.class.getResource("categoria-view.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("categoria.css").toExternalForm());
            Stage stage= new Stage();
            stage.setTitle("Categoria");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
