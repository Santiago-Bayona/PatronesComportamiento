//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.poo.patronescomportamiento.Modelo;

public class FiltroBloqueado extends NotificacionFiltro {
    public FiltroBloqueado() {
    }

    protected String filtrar(Mensaje mensaje) {
        return mensaje.getUsuario().getBloquedao() ? "El usuario esta bloqueado" : null;
    }
}
