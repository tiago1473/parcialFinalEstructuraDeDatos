package Punto1;

public class Operacion {
    private String codigo;
    private Estado estado;

    public Operacion(String codigo, Estado estado) {
        this.codigo = codigo;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "======== Operación ======== " + "\n" +
                "Código: " + this.codigo + "\n" +
                "Estado: " + this.estado + "\n";
    }
}
