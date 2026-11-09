package Punto3;

public class SeleccionSolicitudes {
    private Cola<Solicitud> solicitudesPendientes;

    public SeleccionSolicitudes(){
        solicitudesPendientes = new Cola<>();
    }

    public void agregarSolicitud(Solicitud solicitud){
        solicitudesPendientes.encolar(solicitud);
    }

    public Cola<Solicitud> getSolicitudesPendientes(){
        return solicitudesPendientes;
    }

    public Cola<Solicitud> seleccionarSolicitudes(Cola<Solicitud> solicitudesPendientes, int minutosDisponibles){
        Cola<Solicitud> solicitudesSeleccionadas = new Cola<>();
        Cola<Solicitud> auxiliar = new Cola<>();

        if (minutosDisponibles <= 0) {
            return solicitudesSeleccionadas;
        }
        int restante = minutosDisponibles;

        //PRIMERA PASADA POR LA COLA: SELECCIÓN SOLO DE PRIORIDAD ALTA

        while(!solicitudesPendientes.isEmpty()){
            Solicitud actual = solicitudesPendientes.desencolar();
            if (actual.getPrioridad() == Prioridad.ALTA && actual.getDuracion()<=restante) {
                solicitudesSeleccionadas.encolar(actual);
                restante -= actual.getDuracion();
            }else{
                auxiliar.encolar(actual);
            }
        }

        while (!auxiliar.isEmpty()){
            Solicitud actual = auxiliar.desencolar();
                if (actual.getPrioridad() == Prioridad.NORMAL && actual.getDuracion()<=restante) {
                    solicitudesSeleccionadas.encolar(actual);
                    restante -= actual.getDuracion();
                }else{
                    this.solicitudesPendientes.encolar(actual);
                }
        }
        return solicitudesSeleccionadas;
    }
}
