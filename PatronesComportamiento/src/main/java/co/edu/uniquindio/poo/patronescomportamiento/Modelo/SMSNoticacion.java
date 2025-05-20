//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.poo.patronescomportamiento.Modelo;

public class SMSNoticacion implements NotificacionStrategy {
    public SMSNoticacion() {
    }

    public String Enviar(String mensaje) {
        String Final = "Sms con el mensaje: " + mensaje;
        return Final;
    }
}
