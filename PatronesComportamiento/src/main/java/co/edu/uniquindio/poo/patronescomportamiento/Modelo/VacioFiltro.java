//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.poo.patronescomportamiento.Modelo;

public class VacioFiltro extends NotificacionFiltro {
    public VacioFiltro() {
    }

    public String filtrar(Mensaje mensaje) {
        return mensaje.getInformacion() != null && !mensaje.getInformacion().isEmpty() ? null : "El mensaje no puede ser vacio";
    }
}
