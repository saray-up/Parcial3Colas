package Parcial3Colas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Menu {
        public static void main(String[] args) {
        Metodos metodos = new Metodos();
        Queue<ObjLlamada> cola = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menú de opciones Call Center---");
            System.out.println("1. Ingresar solicitud");
            System.out.println("2. Transferir solicitud");
            System.out.println("3. Cancelar solicitud");
            System.out.println("4. Actualizar solicitud");
            System.out.println("5. Mostrar solicitudes");
            System.out.println("6. Finalizar solicitud");
            System.out.println("7. Asignar asesor a una solicitud");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 
            switch (opcion) {
                case 1:
                    cola = metodos.ingresarDatosSolicitud(cola, sc);
                    break;
                case 2:
                    cola = metodos.TransferirSolicitud(cola, sc, opcion);
                    break;
                case 3:
                    cola = metodos.cancelarSolicitud(cola);
                    break;
                case 4:
                    cola = metodos.actualizarSolicitud(cola, sc);
                    break;
                case 5:
                    cola= metodos.mostrarSolicitudes(cola);
                    break;
                case 6:
                    cola= metodos.finalizarSolicitud(cola);
                    break;
                case 7:
                    cola = metodos.AsignarAsesor(cola, sc);
                    break;
                 case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 8);
    }
}

