package Punto3;

public class Main {
    public static void main(String[] args) {

        //SE CREA EL NUEVO SELECCIONADOR DE SOLICITUDES Y SE AGREGAN LAS 4 SOLICITUDES
        SeleccionSolicitudes seleccionador = new SeleccionSolicitudes();
        seleccionador.agregarSolicitud(new Solicitud("S1",Prioridad.NORMAL,10));
        seleccionador.agregarSolicitud(new Solicitud("S2",Prioridad.ALTA,30));
        seleccionador.agregarSolicitud(new Solicitud("S3",Prioridad.ALTA,15));
        seleccionador.agregarSolicitud(new Solicitud("S4",Prioridad.NORMAL,5));

        //SE IMPLEMENTA LA FUNCIÓN DE SELECCIONAR SOLICITUDES

        Cola<Solicitud> solicitudesSeleccionadas=seleccionador.seleccionarSolicitudes(seleccionador.getSolicitudesPendientes(),25);

        //SE IMPRIME LA LISTA DE SOLICITUDES SELECCIONADAS Y SOLICITUDES PENDIENTES QUE CONTINUAN EN EL SISTEMA
        System.out.println("====SOLICITUDES SELECCIONADAS====:");
        solicitudesSeleccionadas.imprimir();

        System.out.println("====SOLICITUDES PENDIENTES====:");
        seleccionador.getSolicitudesPendientes().imprimir();


    }
}