package Parcial3Colas;

import java.util.Queue;
import java.util.Scanner;

public class Metodos {

    private static final String[][] Asesores = {
        {"Ana"},
        {"Carlos"},
        {"Laura"},
        {"Pedro"},
        {"Marta"}
    };

    public Queue<ObjLlamada> ingresarDatosSolicitud(Queue<ObjLlamada> cola, Scanner sc) {
        ObjLlamada o = new ObjLlamada();
        System.out.println("Ingrese el id de la solicitud: ");
        o.setId(sc.nextDouble());
        sc.nextLine();
        System.out.println("Ingrese el nombre del cliente: ");
        o.setCliente(sc.nextLine());
        System.out.println("Ingrese el motivo: ");
        o.setMotivo(sc.nextLine());
        System.out.println("Ingrese la hora de la solicitud (formato 24h, ej. 14,30): ");
        o.setHora(sc.nextDouble());
        sc.nextLine();
        System.out.println("Ingrese la prioridad de la solicitud: ");
        o.setPrioridad(sc.nextLine());
        System.out.println("Ingrese ingrese el estado de la solicitud: ");
        o.setEstado(sc.next());
        cola.add(o);
        sc.nextLine(); 
        return cola;
    }

    public Queue<ObjLlamada> AsignarAsesor(Queue<ObjLlamada> cola, Scanner sc) {
        ObjLlamada o = cola.peek();
        System.out.println("Ingrese el asesor para la solicitud del cliente " + o.getCliente() + ": ");
        o.setAsesor(sc.nextLine());
        cola.add(o);
        return cola;
    }

    public Queue<ObjLlamada> TransferirSolicitud(Queue<ObjLlamada> cola, Scanner sc, int id){
        if (!cola.isEmpty()) {
            ObjLlamada o = cola.peek();
            System.out.println("Ingrese el nuevo asesor para la solicitud del cliente " + o.getCliente() + ": ");
            String nuevoAsesor = sc.nextLine();
            o.setAsesor(nuevoAsesor);
            System.out.println("La solicitud del cliente " + o.getCliente() + " ha sido transferida a: " + nuevoAsesor);
        } else {
            System.out.println("La cola está vacía. No hay visitantes para cambiar de funcionario.");
        }
        return cola;
    }

    public Queue<ObjLlamada> cancelarSolicitud(Queue<ObjLlamada> cola){
        if (!cola.isEmpty()) {
            ObjLlamada o = cola.poll();
            System.out.println("La solicitud del/a cliente " + o.getCliente() + " ha sido cancelada.");
        } else {
            System.out.println("La cola está vacía. No hay solicitudes para cancelar.");
        }
        return cola;
    }

    public Queue<ObjLlamada> mostrarSolicitudes(Queue<ObjLlamada> cola) {
        if (!cola.isEmpty()) {
            ObjLlamada o = cola.peek();
            System.out.println("Todas las solicitudes: ");
            System.out.println("Id: " +o.getId());
                System.out.println("Nombre: " + o.getCliente());
                System.out.println("Motivo: " + o.getMotivo());
                System.out.println("Hora de solicitud: " + o.getHora());
                System.out.println("Prioridad: " + o.getPrioridad());
                System.out.println("Estado: " + o.getEstado());
                System.out.println("Asesor asignado: "+ o.getAsesor());
                System.out.println("--------------------------------");
        } else {
            System.out.println("La cola está vacía. No hay visitantes en espera.");
        }
        return cola;

    }

    public Queue<ObjLlamada> actualizarSolicitud(Queue<ObjLlamada> cola, Scanner sc){
        System.out.println("Ingrese el id de la solicitud que desea actualizar: ");
        double id = sc.nextDouble();
        boolean encontrado = false;
        for (ObjLlamada o : cola) {
            if (o.getId() == id) {
                System.out.println("Cliente encontrado:");
                System.out.println("1)Nombre: " + o.getCliente());
                System.out.println("2)Motivo: " + o.getMotivo());
                System.out.println("3)Hora de solicitud: " + o.getHora());
                System.out.println("4)Prioridad: " + o.getPrioridad());
                System.out.println("5)Estado: " + o.getEstado());
                System.out.println("--------------------------------");
                encontrado = true;
                System.out.println("Ingrese el numero del item que desea actualizar:");
                int opcion=sc.nextInt();;
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre del cliente: ");
                        String newCliente=" ";
                        if(o.getCliente()!= newCliente){
                            o.setCliente(newCliente);
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo motivo: ");
                        String newMotivo=" ";
                        if(o.getMotivo()!= newMotivo){
                            o.setMotivo(newMotivo);
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese la nueva hora de la solicitud: ");
                        double newHora=0;
                        if(o.getHora()!= newHora){
                            o.setHora(newHora);
                        }
                        break;
                    case 4:
                        System.out.println("Ingrese la nueva prioridad de la solicitud: ");
                        String newPrioridad= "";
                        if(o.getPrioridad()!= newPrioridad){
                            o.setPrioridad(newPrioridad);
                        }
                        break;
                    case 5:
                        System.out.println("Ingrese el nuevo estado de la solicitud: ");
                        String newEstado= "";
                        if(o.getEstado()!= newEstado){
                            o.setEstado(newEstado);
                        }
                        break;
                 default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                }
            }
        }
        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }
        return cola;
    }

    public Queue<ObjLlamada> finalizarSolicitud(Queue<ObjLlamada> cola){
        if (!cola.isEmpty()) {
            ObjLlamada o = cola.poll();
            System.out.println("La solicitud del/a cliente " + o.getCliente() + " ha sido finalizada.");
        } else {
            System.out.println("La cola está vacía. No hay solicitudes para finalizar.");
        }
        return cola;
    }

}




