//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.poo.patronescomportamiento.Modelo;

public class ClienteFormato extends TemplateUser {
    public ClienteFormato() {
    }

    public String encabezado() {
        return "Buenas querido Cliente \n";
    }

    public String Cuerpo(String mensaje) {
        return mensaje + "\n";
    }

    public String Final() {
        return "Gracias por usar nuestro sistema";
    }
}
