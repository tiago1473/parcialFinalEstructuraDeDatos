package Punto3;

public class Solicitud {
    private String codigo;
    private Prioridad prioridad;
    private int duracion;

    public Solicitud(String codigo, Prioridad prioridad, int duracion) {
        this.codigo = codigo;
        this.prioridad = prioridad;
        this.duracion = duracion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "codigo='" + codigo + '\'' +
                ", prioridad=" + prioridad +
                ", duracion=" + duracion +
                '}';
    }
}
