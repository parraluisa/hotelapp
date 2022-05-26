package co.edu.javeriana.hotelapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    protected void gettext_log()
    {
            this.username=textField.getText();
            this.password=passwordField.getText();
            if(username==null)
            {
                System.out.println("null");
            }
            System.out.println(username);
            System.out.println(password);
    }
    @FXML
    protected void gettext_reg()
    {
        this.username_reg=textField_reg.getText();
        this.password_reg=passwordField_reg.getText();
        this.re_password_reg=re_passwordField.getText();
        if(username_reg==null)
        {
            System.out.println("This is null");
        }
        if(password_reg.equals(re_password_reg))
        {
            System.out.println("The passwords matched you're registered");
        }
        else
        {
            System.out.println("The passwords doesn't match, please review the passwords");
        }
        System.out.println(username_reg);
        System.out.println(password_reg);
        System.out.println(re_password_reg);
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



}