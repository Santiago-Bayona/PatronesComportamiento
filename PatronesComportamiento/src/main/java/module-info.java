//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

module co.edu.uniquindio.poo.patronescomportamiento {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;
    requires java.desktop;
    requires java.management;

    exports co.edu.uniquindio.poo.patronescomportamiento;
    exports co.edu.uniquindio.poo.patronescomportamiento.Controller;
    exports co.edu.uniquindio.poo.patronescomportamiento.ViewController;
    exports co.edu.uniquindio.poo.patronescomportamiento.Modelo;

    opens co.edu.uniquindio.poo.patronescomportamiento to
            javafx.fxml;
    opens co.edu.uniquindio.poo.patronescomportamiento.Controller to
            javafx.fxml;
    opens co.edu.uniquindio.poo.patronescomportamiento.ViewController to
            javafx.fxml;
    opens co.edu.uniquindio.poo.patronescomportamiento.Modelo to
            javafx.fxml;
}
