package Clases;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        BancoDeSangre banco = new BancoDeSangre();
        Scanner scanner = new Scanner(System.in);

        banco.cargarDatosDonantes("/Users/juanm/OneDrive/Escritorio/Universidad/EStructura de datos/Datos/DatosDonantes.txt");
        banco.cargarDatosPacientes("/Users/juanm/OneDrive/Escritorio/Universidad/EStructura de datos/Datos/DatosPacientes.txt");
        banco.cargarHistorialPacientes("/Users/juanm/OneDrive/Escritorio/Universidad/EStructura de datos/Datos/HistorialPacientes.txt");
        banco.cargarHistorialDonantes("/Users/juanm/OneDrive/Escritorio/Universidad/EStructura de datos/Datos/HistorialDonantes.txt");
        int opcion;
        int opcionSubMenuDonantes;
        int opcionSubMenuPacientes;

        do {

            System.out.println("=== Menú ===");
            System.out.println("1. Donantes");
            System.out.println("2. Pacientes");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    boolean retrocederD = false;



                    do {

                        System.out.println("=== Menú ===");
                        System.out.println("1. Agregar Donante");
                        System.out.println("2. Eliminar Donantes");
                        System.out.println("3. listar cola de donantes");
                        System.out.println("4. Buscar Donante");
                        System.out.println("5. Ver historial de donantes");
                        System.out.println("5. Editar donante");
                        System.out.println("0. Salir");
                        System.out.print("Ingrese su opción: ");

                        opcionSubMenuDonantes = scanner.nextInt();


                        switch (opcionSubMenuDonantes) {
                            case 1:
                                System.out.println("Seleccionaste la Opción 1");
                                banco.agregarDonanteDesdeConsola();
                                banco.guardarDatosDonantes("/Users/juanm/OneDrive/Escritorio/Universidad/EStructura de datos/Datos/DatosDonantes.txt");
                                break;
                            case 2:
                                System.out.println("Seleccionaste la Opción 2");
                                banco.eliminarDonanteDesdeCosnsola();
                                banco.guardarHistorialDonantes("/Users/juanm/OneDrive/Escritorio/Universidad/EStructura de datos/Datos/HistorialDonantes.txt");
                                break;
                            case 3:
                                System.out.println("Seleccionaste la Opción 2");
                                banco.mostrarDonantes();
                                break;
                            case 4:
                                banco.buscarDonantePorDocumento();
                                break;
                            case 5:
                                banco.mostrarHistorialDonantes();
                                break;
                            case 6:
                              banco.editarDonanteDesdeConsola();
                                break;
                            case 0:
                                retrocederD = true;
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, ingresa una opción válida.");
                        }

                    }
                    while (!retrocederD);
                    break;
                case 2:
                    boolean retorcederP = false;
                    do {

                        System.out.println("=== Menú ===");
                        System.out.println("1. Agregar pacientes");
                        System.out.println("2. Eliminar pacientes");
                        System.out.println("3. listar cola de pacientes");
                        System.out.println("4. Buscar paciente");
                        System.out.println("5. Ver historial de pacientes");
                        System.out.println("6. Editar paciente");
                        System.out.println("0. Salir");
                        System.out.print("Ingrese su opción: ");


                        opcionSubMenuPacientes = scanner.nextInt();

                        switch (opcionSubMenuPacientes) {
                            case 1:
                                System.out.println("Seleccionaste la Opción 1");
                                banco.agregarPacienteDesdeConsola();
                                banco.guardarDatosPacientes("/Users/juanm/OneDrive/Escritorio/Universidad/EStructura de datos/Datos/DatosPacientes.txt");
                                break;
                            case 2:
                                System.out.println("Seleccionaste la Opción 2");
                                banco.eliminarPacienteDesdeCosnsola();
                                banco.guardarHistorialPacientes("/Users/juanm/OneDrive/Escritorio/Universidad/EStructura de datos/Datos/HistorialPacientes.txt");
                                break;
                            case 3:
                                System.out.println("Seleccionaste la Opción 2");
                                banco.mostrarPacientes();
                                break;
                            case 4:
                                banco.buscarPacientesPorDocumento();
                                break;
                            case 5:
                                banco.mostrarHistorialPacientes();
                                break;
                            case 6:
                                banco.editarPacienteDesdeConsola();
                                break;
                            case 0:
                                retorcederP = true;
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, ingresa una opción válida.");
                        }

                    }
                    while (!retorcederP);
                    break;

                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa una opción válida.");

            }
        }
        while (opcion != 0);

        scanner.close();
    }
}