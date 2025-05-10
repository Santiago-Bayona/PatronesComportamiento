module co.edu.uniquindio.poo.patronescomportamiento {
    requires javafx.controls;
    requires javafx.fxml;

    requires atlantafx.base;
    requires java.desktop;
    requires java.management;


    opens co.edu.uniquindio.poo.patronescomportamiento to javafx.fxml;
    exports co.edu.uniquindio.poo.patronescomportamiento;
    exports co.edu.uniquindio.poo.patronescomportamiento.Controller;
    opens co.edu.uniquindio.poo.patronescomportamiento.Controller to javafx.fxml;
    exports co.edu.uniquindio.poo.patronescomportamiento.ViewController;
    opens co.edu.uniquindio.poo.patronescomportamiento.ViewController to javafx.fxml;
    exports co.edu.uniquindio.poo.patronescomportamiento.Modelo;
    opens co.edu.uniquindio.poo.patronescomportamiento.Modelo to javafx.fxml;

}