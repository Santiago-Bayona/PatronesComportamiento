//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.poo.patronescomportamiento.Modelo;

public class Mensaje {
    private String codigo;
    private String Informacion;
    public User usuario;
    public TemplateUser templateUser;
    private NotificacionFiltro filtro;

    public Mensaje(String codigo, String informacion, User usuario) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.Informacion = informacion;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public User getUsuario() {
        return this.usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getInformacion() {
        return this.Informacion;
    }

    public void setInformacion(String Informacion) {
        this.Informacion = Informacion;
    }

    public NotificacionFiltro getFiltro() {
        return this.filtro;
    }

    public void setFiltro(NotificacionFiltro filtro) {
        this.filtro = filtro;
    }

    public String EnviarMensaje(String mensaje) {
        switch (this.usuario.getTipo()) {
            case Cliente -> this.templateUser = new ClienteFormato();
            case Administrador -> this.templateUser = new AdminFormato();
            case Invitado -> this.templateUser = new InvitadoFormato();
        }

        return this.templateUser.Formato(this.usuario.getPreferido().EnviarMensaje(mensaje));
    }
}
