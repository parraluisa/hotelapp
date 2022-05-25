module co.edu.javeriana.hotelapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens co.edu.javeriana.hotelapp to javafx.fxml;
    exports co.edu.javeriana.hotelapp;
}