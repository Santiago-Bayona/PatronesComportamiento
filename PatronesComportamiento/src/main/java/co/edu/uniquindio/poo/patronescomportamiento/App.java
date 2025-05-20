
package co.edu.uniquindio.poo.patronescomportamiento;

import atlantafx.base.theme.NordDark;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.Canal;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.EmailNoticacion;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.Mensaje;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.PushNotification;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.SMSNoticacion;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.Sistema;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.User;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.User.Tipo;
import co.edu.uniquindio.poo.patronescomportamiento.ViewController.MensajeVC;
import co.edu.uniquindio.poo.patronescomportamiento.ViewController.UserVC;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {
    public static Sistema sistema = new Sistema("San Juan de Dios");
    private Stage primaryStage;
    private boolean datosInicializados = false;

    public App() {
    }

    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        Application.setUserAgentStylesheet((new NordDark()).getUserAgentStylesheet());
        this.primaryStage.setTitle("Bienvenido");
        this.openViewPrincipal();
    }

    public void openViewPrincipal() {
        if (!datosInicializados) {
            inicializarData();
            datosInicializados = true;
        }
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("User.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            UserVC primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }

    public void Mensaje() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Mensaje.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MensajeVC empaqueVC = loader.getController();
            empaqueVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void inicializarData() {
        Canal Sms = new Canal(new SMSNoticacion());
        Canal Push = new Canal(new PushNotification());
        Canal Email = new Canal(new EmailNoticacion());
        sistema.AgregarCanal(Sms);
        sistema.AgregarCanal(Push);
        sistema.AgregarCanal(Email);
        User usuario = new User("Jose", "Jose@gmail.com", Tipo.Cliente, Push, true);
        sistema.AgregarUsuario(usuario);
        Mensaje mensaje = new Mensaje("C1", "Hola", usuario);
        sistema.AgregarMensaje(mensaje);
    }
}
