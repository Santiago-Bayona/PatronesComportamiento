//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.poo.patronescomportamiento.Modelo;

public class InvitadoFormato extends TemplateUser {
    public InvitadoFormato() {
    }

    public String encabezado() {
        return "Buenas querido Invitado \n";
    }

    public String Cuerpo(String mensaje) {
        return mensaje + "\n";
    }

    public String Final() {
        return "Gracias por usar nuestro sistema";
    }
}
