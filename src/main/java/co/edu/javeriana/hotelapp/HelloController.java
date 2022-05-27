package co.edu.javeriana.hotelapp;

import co.edu.javeriana.hotelapp.model.dao.LogInDAO;
import co.edu.javeriana.hotelapp.model.dao.impl.LogInDAOImpl;
import co.edu.javeriana.hotelapp.model.dto.LogInDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {
    private String username;
    private String password;
    private String username_reg;
    private String password_reg;
    private String re_password_reg;
    private boolean log_in=true;
    private boolean register=false;

    @FXML
    private TextField textField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label pass_log;
    @FXML
    private Label user_log;
    @FXML
    private Label pass_reg;
    @FXML
    private Label user_reg;
    @FXML
    private Button login;
    @FXML
    private PasswordField re_passwordField;
    @FXML
    private TextField textField_reg;
    @FXML
    private PasswordField passwordField_reg;
    @FXML
    private Label pass_re_reg;
    @FXML
    private Button reg;
    @FXML
    private Label error_log;
    @FXML
    private Label error_reg;



    @FXML
    protected void gettext_log() throws Exception {
        try
        {
            this.username=textField.getText();
            this.password=passwordField.getText();
            if(username=="")
            {
                throw new Exception("Cannot leave blank space in username");
            }
            if(password=="")
            {
                throw new Exception("Cannot leave blank space in password");
            }
            LogInDTO p1= new LogInDTO(username,password);
            LogInDAO ldao= new LogInDAOImpl();
            boolean p2= ldao.encontrarUsuario(username, p1);
            if(p2==true)
            {
                System.out.println("Success");
                dir();
            }
            else
            {
                System.out.println("Failed");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
            error_log.setVisible(true);
            error_log.setText(e.getLocalizedMessage());
        }

            System.out.println(username);
            System.out.println(password);
    }
    @FXML
    protected void gettext_reg()
    {
       try
       {
           this.username_reg=textField_reg.getText();
           this.password_reg=passwordField_reg.getText();
           this.re_password_reg=re_passwordField.getText();
           if(username_reg=="")
           {
               throw new Exception("Cannot leave blank space in username");
           }
           if(password_reg=="")
           {
               throw new Exception("Cannot leave blank space in password");
           }
           if(password_reg.equals(re_password_reg))
           {

               try
               {
                   LogInDTO logdto= new LogInDTO(username_reg.toString(),password_reg.toString());
                   LogInDAO logdao= new LogInDAOImpl();
                   LogInDTO p2= logdao.create(logdto);
                   LogInDAOImpl l2 = new LogInDAOImpl();

                   error_reg.setVisible(true);
                   error_reg.setBackground(new Background(new BackgroundFill(Color.WHITE,null, Insets.EMPTY)));
                   error_reg.setText("Thanks for your registration, you're all set");
               }
               catch (Exception e)
               {
                   System.out.println(e.getLocalizedMessage());
               }
           }
           else
           {
               throw new Exception("Lookout! the passwords doesn't match");
           }
       }
       catch (Exception e)
       {
           System.out.println(e.getLocalizedMessage());
           error_reg.setVisible(true);
           error_reg.setText(e.getLocalizedMessage());
       }
        System.out.println(username_reg);
        System.out.println(password_reg);
        System.out.println(re_password_reg);
    }

    @FXML
    protected void exit()
    {
        System.exit(0);
    }
    @FXML
    protected void vis_log()
    {
        this.register=false;
        if(register==false)
        {
            this.log_in=true;
            try
            {
                user_reg.setVisible(register);
                pass_reg.setVisible(register);
                textField_reg.setVisible(register);
                pass_re_reg.setVisible(register);
                passwordField_reg.setVisible(register);
                re_passwordField.setVisible(register);
                reg.setVisible(register);
                error_reg.setVisible(register);
            }
            catch (Exception e)
            {
                System.out.println(e.getLocalizedMessage());
            }
        }
        if(log_in==true)
        {
            try
            {
                textField.setVisible(log_in);
                passwordField.setVisible(log_in);
                user_log.setVisible(log_in);
                pass_log.setVisible(log_in);
                login.setVisible(log_in);
            }
            catch (Exception e)
            {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }

    @FXML
    private void vis_reg()
    {
        this.log_in=false;
        if(log_in==false)
        {
            this.register=true;
            try
            {
                textField.setVisible(log_in);
                passwordField.setVisible(log_in);
                user_log.setVisible(log_in);
                pass_log.setVisible(log_in);
                login.setVisible(log_in);
                error_log.setVisible(log_in);
            }
            catch (Exception e)
            {
                System.out.println(e.getLocalizedMessage());
            }
        }
        if(register==true)
        {
            try
            {
                user_reg.setVisible(register);
                pass_reg.setVisible(register);
                pass_re_reg.setVisible(register);
                textField_reg.setVisible(register);
                passwordField_reg.setVisible(register);
                re_passwordField.setVisible(register);
                reg.setVisible(register);
            }
            catch (Exception e)
            {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }


    protected void dir() throws IOException {
        try
        {
            Parent root = FXMLLoader.load(HelloApplication.class.getResource("dir.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("dir.css").toExternalForm());
            Stage stage= new Stage();
            stage.setTitle("DIR");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }

}