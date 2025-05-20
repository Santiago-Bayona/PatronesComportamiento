//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.poo.patronescomportamiento.Modelo;

public class PushNotification implements NotificacionStrategy {
    public PushNotification() {
    }

    public String Enviar(String mensaje) {
        String Final = "Push Notification con el mensaje: " + mensaje;
        return Final;
    }
}
