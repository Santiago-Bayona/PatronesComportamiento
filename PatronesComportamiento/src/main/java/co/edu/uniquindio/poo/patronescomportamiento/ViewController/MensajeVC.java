//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.poo.patronescomportamiento.ViewController;

import co.edu.uniquindio.poo.patronescomportamiento.App;
import co.edu.uniquindio.poo.patronescomportamiento.Controller.MensajeController;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.FiltroBloqueado;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.Mensaje;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.NotificacionFiltro;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.User;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.VacioFiltro;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MensajeVC {
    private App app;
    private ObservableList<Mensaje> listaMensaje = FXCollections.observableArrayList();
    private ObservableList<User> listaUsuario = FXCollections.observableArrayList();
    private Mensaje selectedMensaje;
    private User selectedUser;
    MensajeController mensajeController;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button btt_Enviar;
    @FXML
    private Button btt_Eliminar;
    @FXML
    private TableColumn<User, String> tbc_TipoUser;
    @FXML
    private TableColumn<User, String> tbc_NombreUser;
    @FXML
    private TableColumn<Mensaje, String> tbc_Usuario;
    @FXML
    private TableColumn<User, String> tbc_CanalUser;
    @FXML
    private Button btt_Regresar;
    @FXML
    private TableView<Mensaje> tb_Mensaje;
    @FXML
    private TableView<User> tb_User;
    @FXML
    private TextArea txt_Mensaje;
    @FXML
    private TableColumn<Mensaje, String> tbc_Codigo;
    @FXML
    private TextArea txt_Final;
    @FXML
    private TextField txt_Codigo;

    public MensajeVC() {
    }

    @FXML
    void Enviar(ActionEvent event) {
        this.agregarMensaje();
        this.mostrarMensaje();
    }

    @FXML
    void Eliminar(ActionEvent event) {
        this.eliminarMensaje();
    }

    @FXML
    void Regresar(ActionEvent event) {
        try {
            this.app.openViewPrincipal();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al abrir la vista principal");
        }

    }

    @FXML
    void initialize() {
        assert this.btt_Enviar != null : "fx:id=\"btt_Enviar\" was not injected: check your FXML file 'Mensaje.fxml'.";

        assert this.btt_Eliminar != null : "fx:id=\"btt_Eliminar\" was not injected: check your FXML file 'Mensaje.fxml'.";

        assert this.tbc_TipoUser != null : "fx:id=\"tbc_TipoUser\" was not injected: check your FXML file 'Mensaje.fxml'.";

        assert this.tbc_NombreUser != null : "fx:id=\"tbc_NombreUser\" was not injected: check your FXML file 'Mensaje.fxml'.";

        assert this.tbc_Usuario != null : "fx:id=\"tbc_Usuario\" was not injected: check your FXML file 'Mensaje.fxml'.";

        assert this.tbc_CanalUser != null : "fx:id=\"tbc_CanalUser\" was not injected: check your FXML file 'Mensaje.fxml'.";

        assert this.btt_Regresar != null : "fx:id=\"btt_Regresar\" was not injected: check your FXML file 'Mensaje.fxml'.";

        assert this.tb_Mensaje != null : "fx:id=\"tb_Mensaje\" was not injected: check your FXML file 'Mensaje.fxml'.";

        assert this.tb_User != null : "fx:id=\"tb_User\" was not injected: check your FXML file 'Mensaje.fxml'.";

        assert this.txt_Codigo != null : "fx:id=\"txt_Mensaje\" was not injected: check your FXML file 'Mensaje.fxml'.";

        assert this.txt_Mensaje != null : "fx:id=\"txt_Mensaje\" was not injected: check your FXML file 'Mensaje.fxml'.";

        assert this.tbc_Codigo != null : "fx:id=\"tbc_Codigo\" was not injected: check your FXML file 'Mensaje.fxml'.";

        assert this.txt_Final != null : "fx:id=\"txt_Final\" was not injected: check your FXML file 'Mensaje.fxml'.";

        this.mensajeController = new MensajeController(App.sistema);
        this.obtenerMensaje();
        this.obtenerUser();
        this.initView();
    }

    private void obtenerUser() {
        if (this.listaUsuario == null) {
            this.listaUsuario = FXCollections.observableArrayList();
        }

        Collection<User> usuarios = this.mensajeController.obtenerListaUsuarios();
        if (usuarios != null) {
            this.listaUsuario.setAll(usuarios);
        } else {
            System.out.println("No se encontraron Usuarios.");
        }

    }

    private void obtenerMensaje() {
        if (this.mensajeController != null) {
            this.listaMensaje.addAll(this.mensajeController.obtenerListaMensaje());
        } else {
            System.err.println("PartidoController no está inicializado.");
        }

    }

    private void initView() {
        this.initDataBinding();
        this.tb_Mensaje.getItems().clear();
        this.tb_Mensaje.setItems(this.listaMensaje);
        this.tb_User.setItems(this.listaUsuario);
        this.listenerSelectionMensaje();
        this.listenerSelectionUser();
    }

    private void initDataBinding() {
        this.tbc_Codigo.setCellValueFactory((cellData) -> new SimpleStringProperty(((Mensaje)cellData.getValue()).getCodigo()));
        this.tbc_Usuario.setCellValueFactory((cellData) -> new SimpleStringProperty(((Mensaje)cellData.getValue()).getUsuario().getNombre()));
        this.tbc_CanalUser.setCellValueFactory((cellData) -> new SimpleStringProperty(((User)cellData.getValue()).getPreferido().getNombreCanal()));
        this.tbc_TipoUser.setCellValueFactory((celldata) -> {
            User.Tipo tipo = ((User)celldata.getValue()).getTipo();
            String TamanioString = tipo != null ? tipo.toString() : "Sin Tipo";
            return new SimpleStringProperty(TamanioString);
        });
        this.tbc_NombreUser.setCellValueFactory((cellData) -> new SimpleStringProperty(((User)cellData.getValue()).getNombre()));
    }

    private void listenerSelectionMensaje() {
        this.tb_Mensaje.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.selectedMensaje = newSelection;
            this.mostrarInformacionMensaje(this.selectedMensaje);
        });
    }

    private void listenerSelectionUser() {
        this.tb_User.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> this.selectedUser = newSelection);
    }

    private void mostrarInformacionMensaje(Mensaje mensaje) {
        if (mensaje != null) {
            this.txt_Mensaje.setText(mensaje.getInformacion());
            this.txt_Codigo.setText(mensaje.getCodigo());
            String resultado = this.mensajeController.generarMensaje(mensaje, mensaje.getInformacion());
            this.txt_Final.setText(resultado);
        }

    }

    private void agregarMensaje() {
        Mensaje mensaje = this.buildMensaje();
        String resultadoFiltro = this.aplicarFiltros(mensaje);
        if (resultadoFiltro != null) {
            Alert alerta = new Alert(AlertType.WARNING);
            alerta.setTitle("Advertencia");
            alerta.setHeaderText((String)null);
            alerta.setContentText(resultadoFiltro);
            alerta.showAndWait();
            this.txt_Final.setText(resultadoFiltro);
        } else {
            if (this.mensajeController.AgregarMensaje(mensaje)) {
                this.listaMensaje.add(mensaje);
                this.limpiarCampos();
            }

        }
    }

    private Mensaje buildMensaje() {
        Mensaje mensaje = new Mensaje(this.txt_Codigo.getText(), this.txt_Mensaje.getText(), this.selectedUser);
        return mensaje;
    }

    private void eliminarMensaje() {
        if (this.mensajeController.EliminarMensaje(this.selectedMensaje)) {
            this.listaMensaje.remove(this.selectedMensaje);
            this.limpiarCampos();
            this.limpiarSeleccion();
        }

    }

    private void mostrarMensaje() {
        if (this.listaMensaje != null && !this.listaMensaje.isEmpty()) {
            Mensaje ultimoMensaje = (Mensaje)this.listaMensaje.get(this.listaMensaje.size() - 1);
            String texto = ultimoMensaje.getInformacion();
            String resultado = this.mensajeController.generarMensaje(ultimoMensaje, texto);
            if (resultado.equals("El mensaje no puede ser vacio") || resultado.equals("El usuario esta bloqueado")) {
                Alert alerta = new Alert(AlertType.WARNING);
                alerta.setTitle("Advertencia");
                alerta.setHeaderText((String)null);
                alerta.setContentText(resultado);
                alerta.showAndWait();
            }

            this.txt_Final.setText(resultado);
        } else {
            this.txt_Final.setText("No hay mensajes para mostrar.");
        }

    }

    private String aplicarFiltros(Mensaje mensaje) {
        NotificacionFiltro filtro1 = new VacioFiltro();
        NotificacionFiltro filtro2 = new FiltroBloqueado();
        filtro1.setNext(filtro2);
        return filtro1.manejar(mensaje);
    }

    private void limpiarSeleccion() {
        this.tb_User.getSelectionModel().clearSelection();
        this.limpiarCampos();
    }

    private void limpiarCampos() {
        this.txt_Mensaje.clear();
        this.txt_Codigo.clear();
        this.txt_Final.clear();
        this.tb_User.getSelectionModel().clearSelection();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
