package co.edu.uniquindio.poo.patronescomportamiento.Modelo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Sistema extends Observable {
    // Singleton: Instancia única
    private static Sistema instance;

    // Colecciones globales (parte del Singleton original)
    private Collection<User> usuarios;
    private Collection<Canal> canales;
    private Collection<Mensaje> mensajes;
    private String patente;

    // Singleton: Constructor privado
    public Sistema(String patente) {
        this.patente = patente;
        this.usuarios = new LinkedList<>();
        this.canales = new LinkedList<>();
        this.mensajes = new LinkedList<>();
    }

    // Singleton: Acceso controlado a la instancia
    public static Sistema getInstance(String patente) {
        if (instance == null) {
            instance = new Sistema(patente);
        }
        return instance;
    }

    public boolean VerificarUsuario(String correo) {
        for (User user : usuarios) {
            if (correo.equals(user.getCorreo())) {
                return false;
            }
        }
        return true;
    }

    public Boolean AgregarUsuario(User user) {
        boolean esUnico = VerificarUsuario(user.getCorreo());
        if (esUnico) {
            usuarios.add(user);
            notifyObservers("USER_ADDED", user); // Observer: Notificar
            return true;
        }
        return false;
    }

    public Boolean EliminarUsuario(User user) {
        boolean esUnico = !VerificarUsuario(user.getCorreo());
        if (esUnico) {
            usuarios.remove(user);
            notifyObservers("USER_REMOVED", user); // Observer: Notificar
            return true;
        }
        return false;
    }

    public boolean ActualizarUsuario(String correo, User actualizado) {
        for (User user : usuarios) {
            if (user.getCorreo().equals(correo)) {
                user.setNombre(actualizado.getNombre());
                user.setCorreo(actualizado.getCorreo());
                user.setPreferido(actualizado.getPreferido());
                user.setTipo(actualizado.getTipo());
                user.setBloquedao(actualizado.getBloquedao());
                notifyObservers("USER_UPDATED", user); // Observer: Notificar
                return true;
            }
        }
        return false;
    }

    public Boolean AgregarCanal(Canal canal) {
        if (!canales.contains(canal)) {
            canales.add(canal);
            notifyObservers("CHANNEL_ADDED", canal); // Observer: Notificar
            return true;
        }
        return false;
    }

    public boolean VerificarMensaje(String codigo) {
        for (Mensaje mensaje : mensajes) {
            if (codigo.equals(mensaje.getCodigo())) {
                return false;
            }
        }
        return true;
    }

    public Boolean AgregarMensaje(Mensaje mensaje) {
        boolean esUnico = VerificarMensaje(mensaje.getCodigo());
        if (esUnico) {
            mensajes.add(mensaje);
            notifyObservers("MESSAGE_SENT", mensaje); // Observer: Notificar
            return true;
        }
        return false;
    }

    public Boolean EliminarMensaje(Mensaje mensaje) {
        boolean esUnico = !VerificarMensaje(mensaje.getCodigo());
        if (esUnico) {
            mensajes.remove(mensaje);
            notifyObservers("MESSAGE_DELETED", mensaje); // Observer: Notificar
            return true;
        }
        return false;
    }

    public Collection<Canal> getCanales() {
        return canales;
    }

    public Collection<Mensaje> getMensajes() {
        return mensajes;
    }

    public Collection<User> getUsuarios() {
        return usuarios;
    }

    public String getPatente() {
        return patente;
    }
}