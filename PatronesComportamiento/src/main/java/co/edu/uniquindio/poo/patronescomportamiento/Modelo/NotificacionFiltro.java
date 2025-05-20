//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.poo.patronescomportamiento.Modelo;

public abstract class NotificacionFiltro {
    protected NotificacionFiltro next;

    public NotificacionFiltro() {
    }

    public NotificacionFiltro getNext() {
        return this.next;
    }

    public void setNext(NotificacionFiltro next) {
        this.next = next;
    }

    public String manejar(Mensaje mensaje) {
        String resultado = this.filtrar(mensaje);
        return resultado == null && this.next != null ? this.next.manejar(mensaje) : resultado;
    }

    protected abstract String filtrar(Mensaje var1);
}
