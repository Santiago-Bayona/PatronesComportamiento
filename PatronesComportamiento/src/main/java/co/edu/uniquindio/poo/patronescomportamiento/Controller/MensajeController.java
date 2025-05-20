//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.poo.patronescomportamiento.Controller;

import co.edu.uniquindio.poo.patronescomportamiento.Modelo.Mensaje;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.Sistema;
import co.edu.uniquindio.poo.patronescomportamiento.Modelo.User;
import java.util.Collection;

public class MensajeController {
    public Sistema sistema;

    public MensajeController(Sistema sistema) {
        this.sistema = sistema;
    }

    public boolean AgregarMensaje(Mensaje mensaje) {
        if (this.sistema == null) {
            System.err.println("Error: El sistema no ha sido inicializada.");
            return false;
        } else {
            return this.sistema.AgregarMensaje(mensaje);
        }
    }

    public Collection<Mensaje> obtenerListaMensaje() {
        if (this.sistema == null) {
            System.err.println("Error: No se puede obtener la lista de usuarios porque el sistema es null.");
            return null;
        } else {
            return this.sistema.getMensajes();
        }
    }

    public boolean EliminarMensaje(Mensaje mensaje) {
        if (this.sistema == null) {
            System.err.println("Error: No se puede eliminar Partido ya que la comptencia es null.");
            return false;
        } else {
            return this.sistema.EliminarMensaje(mensaje);
        }
    }

    public String generarMensaje(Mensaje mensaje, String texto) {
        return mensaje.EnviarMensaje(texto);
    }

    public Collection<User> obtenerListaUsuarios() {
        if (this.sistema == null) {
        }

        return this.sistema.getUsuarios();
    }
}
