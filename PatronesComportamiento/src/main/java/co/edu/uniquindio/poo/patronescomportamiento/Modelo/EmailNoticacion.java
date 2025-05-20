//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.poo.patronescomportamiento.Modelo;

public class EmailNoticacion implements NotificacionStrategy {
    public EmailNoticacion() {
    }

    public String Enviar(String Mensaje) {
        String Final = "";
        Final = "Email Mensaje: " + Mensaje;
        return Final;
    }
}
