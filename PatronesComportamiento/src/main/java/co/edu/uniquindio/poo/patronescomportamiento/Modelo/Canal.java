//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.poo.patronescomportamiento.Modelo;

public class Canal {
    public NotificacionStrategy notificaion;

    public Canal(NotificacionStrategy notificaion) {
        this.notificaion = notificaion;
    }

    public String EnviarMensaje(String mensaje) {
        String ms = this.notificaion.Enviar(mensaje);
        return ms;
    }

    public void setNotificacion(String notificacion) {
        if (notificacion.equals("SMS")) {
            this.notificaion = new SMSNoticacion();
        } else if (notificacion.equals("Push")) {
            this.notificaion = new PushNotification();
        } else {
            System.out.println("No existe esta notificacion");
        }

    }

    public String getNombreCanal() {
        if (this.notificaion instanceof SMSNoticacion) {
            return "SMS";
        } else if (this.notificaion instanceof PushNotification) {
            return "Push";
        } else {
            return this.notificaion instanceof EmailNoticacion ? "Email" : "Desconocido";
        }
    }

    public NotificacionStrategy getNotificaion() {
        return this.notificaion;
    }
}
