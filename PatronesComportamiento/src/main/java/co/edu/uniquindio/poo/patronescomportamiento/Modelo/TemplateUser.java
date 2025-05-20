//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.poo.patronescomportamiento.Modelo;

public abstract class TemplateUser {
    public TemplateUser() {
    }

    public final String Formato(String mensaje) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.encabezado());
        sb.append(this.Cuerpo(mensaje));
        sb.append(this.Final());
        return sb.toString();
    }

    public abstract String encabezado();

    public abstract String Cuerpo(String var1);

    public abstract String Final();
}
