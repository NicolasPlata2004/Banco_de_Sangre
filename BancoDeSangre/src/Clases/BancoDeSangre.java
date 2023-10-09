package Clases;
import java.io.*;
import java.util.Scanner;
class BancoDeSangre {
    private Cola<Donante> colaEsperaDonantes = new Cola<>();
    private ListaEnlazada<Donante> historialDonantes = new ListaEnlazada<>();
    private Cola<Paciente> colaEsperaPacientes = new Cola<>();
    private ListaEnlazada<Paciente> historialPacientes = new ListaEnlazada<>();


    public void cargarDatosDonantes(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 6) {
                    Donante donante = new Donante(partes[0], partes[1], partes[2], partes[3], partes[4], Integer.parseInt(partes[5]));
                    agregarDonante(donante);
                } else {
                    System.err.println("Error en el formato de la línea: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarHistorialDonantes(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 6) {
                    Donante donante = new Donante(partes[0], partes[1], partes[2], partes[3], partes[4], Integer.parseInt(partes[5]));
                    historialDonantes.agregar(donante);
                } else {
                    System.err.println("Error en el formato de la línea: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDatosPacientes(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 6) {
                    Paciente paciente = new Paciente(partes[0], partes[1], partes[2], partes[3], partes[4], Integer.parseInt(partes[5]));
                    agregarPaciente(paciente);
                } else {
                    System.err.println("Error en el formato de la línea: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarHistorialPacientes(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 6) {
                    Paciente paciente = new Paciente(partes[0], partes[1], partes[2], partes[3], partes[4], Integer.parseInt(partes[5]));
                    historialPacientes.agregar(paciente);
                } else {
                    System.err.println("Error en el formato de la línea: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarDatosDonantes(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Guardar elementos de la cola de espera en el archivo
            Cola<Donante> colaTemp = new Cola<>();
            while (!colaEsperaDonantes.estaVacia()) {
                Donante donante = colaEsperaDonantes.desencolar();
                bw.write(donante.toString());
                bw.newLine();
                colaTemp.encolar(donante);
            }

            // Restaurar la cola de espera original
            while (!colaTemp.estaVacia()) {
                colaEsperaDonantes.encolar(colaTemp.desencolar());
            }

            System.out.println("Datos de Donante guardados exitosamente en la cola de espera.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarHistorialDonantes(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {

            Nodo<Donante> temp = historialDonantes.obtenerCabeza();
            while (temp != null) {
                bw.write(temp.valor.toString());
                bw.newLine();
                temp = temp.siguiente;
            }

            System.out.println("Datos de Donante en el historial guardados exitosamente en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarDatosPacientes(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Guardar elementos de la cola de espera en el archivo
            Cola<Paciente> colaTemp = new Cola<>();
            while (!colaEsperaPacientes.estaVacia()) {
                Paciente paciente = colaEsperaPacientes.desencolar();
                bw.write(paciente.toString());
                bw.newLine();
                colaTemp.encolar(paciente);
            }

            // Restaurar la cola de espera original
            while (!colaTemp.estaVacia()) {
                colaEsperaPacientes.encolar(colaTemp.desencolar());
            }

            System.out.println("Datos de pacientes guardados exitosamente en la cola de espera.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarHistorialPacientes(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {

            Nodo<Paciente> temp = historialPacientes.obtenerCabeza();
            while (temp != null) {
                bw.write(temp.valor.toString());
                bw.newLine();
                temp = temp.siguiente;
            }

            System.out.println("Datos de pacientes en el historial guardados exitosamente en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarDonante(Donante donante) {
        colaEsperaDonantes.encolar(donante);
    }


    public void agregarPaciente(Paciente paciente) {
        colaEsperaPacientes.encolar(paciente);

    }

    public void agregarPacienteHistorial(Paciente paciente) {
        historialPacientes.agregar(paciente);
    }

    public void agregarDonanteHistorial(Donante donante) {
        historialDonantes.agregar(donante);
    }

    public void eliminarDonante(String documentoD) {
        Donante donanteAEliminar = null;

        // Buscar al paciente en la cola de espera
        Cola<Donante> colaEsperaTemp = new Cola<>();
        while (!colaEsperaDonantes.estaVacia()) {
            Donante donante = colaEsperaDonantes.desencolar();
            if (donante.documentoD.equals(documentoD)) {
                donanteAEliminar = donante;
                System.out.println("Donante encontrado en la cola de espera y eliminado.");
                agregarDonanteHistorial(donante);
            } else {
                colaEsperaTemp.encolar(donante);
            }
        }
        colaEsperaDonantes = colaEsperaTemp;

        if (donanteAEliminar == null) {
            System.out.println("No se encontró un Donante con el documento proporcionado en la cola de espera.");
            return;
        }

        // Actualizar el archivo de texto
        guardarDatosDonantes("/Users/juanm/OneDrive/Escritorio/Universidad/EStructura de datos/Datos/DatosDonantes.txt");

        System.out.println("Paciente eliminado del archivo de texto.");
    }

    public void eliminarPaciente(String documentoP) {
        Paciente pacienteAEliminar = null;

        // Buscar al paciente en la cola de espera
        Cola<Paciente> colaEsperaTemp = new Cola<>();
        while (!colaEsperaPacientes.estaVacia()) {
            Paciente paciente = colaEsperaPacientes.desencolar();
            if (paciente.documentoP.equals(documentoP)) {
                pacienteAEliminar = paciente;
                System.out.println("Paciente encontrado en la cola de espera y eliminado.");
                agregarPacienteHistorial(paciente);
            } else {
                colaEsperaTemp.encolar(paciente);
            }
        }
        colaEsperaPacientes = colaEsperaTemp;

        if (pacienteAEliminar == null) {
            System.out.println("No se encontró un Paciente con el documento proporcionado en la cola de espera.");
            return;
        }

        // Actualizar el archivo de texto
        guardarDatosPacientes("/Users/juanm/OneDrive/Escritorio/Universidad/EStructura de datos/Datos/DatosPacientes.txt");

        System.out.println("Paciente eliminado del archivo de texto.");
    }

    public void mostrarHistorialDonantes() {
        System.out.println("Historial de donantes:");

        if (historialDonantes.estaVacia()) {
            System.out.println("El historial de donantes está vacío.");
            return;
        }

        Nodo<Donante> temp = historialDonantes.obtenerCabeza();
        while (temp != null) {
            System.out.println("Nombre: " + temp.valor.nombreD +
                    ", Documento: " + temp.valor.documentoD +
                    ", Correo: " + temp.valor.correoD +
                    ", celular: " + temp.valor.celularD +
                    ", Tipo de Sangre: " + temp.valor.tipoSangreD +
                    ", Edad: " + temp.valor.edadD);
            temp = temp.siguiente;
        }
    }

    public void mostrarHistorialPacientes() {
        System.out.println("Historial de pacientes:");

        if (historialPacientes.estaVacia()) {
            System.out.println("El historial de pacientes está vacío.");
            return;
        }

        Nodo<Paciente> temp = historialPacientes.obtenerCabeza();
        while (temp != null) {
            System.out.println("Nombre: " + temp.valor.nombreP +
                    ", Documento: " + temp.valor.documentoP +
                    ", Correo: " + temp.valor.correoP +
                    ", celular: " + temp.valor.celularP +
                    ", Tipo de Sangre: " + temp.valor.tipoDeSangreP +
                    ", Edad: " + temp.valor.edadD);
            temp = temp.siguiente;
        }
    }

    public void mostrarDonantes() {
        System.out.println("Lista de Donante en la cola de espera:");

        if (colaEsperaDonantes.estaVacia()) {
            System.out.println("La cola de espera de Donante está vacía.");
            return;
        }

        // Crear una cola temporal para mostrar los pacientes sin modificar la original
        Cola<Donante> colaTemp = new Cola<>();
        while (!colaEsperaDonantes.estaVacia()) {
            Donante donante = colaEsperaDonantes.desencolar();
            System.out.println("Nombre: " + donante.nombreD +
                    ", Documento: " + donante.documentoD +
                    ", Correo: " + donante.correoD +
                    ", celular: " + donante.celularD +
                    ", Tipo de Sangre: " + donante.tipoSangreD +
                    ", Edad: " + donante.edadD);
            colaTemp.encolar(donante);
        }

        // Restaurar la cola de espera original
        while (!colaTemp.estaVacia()) {
            colaEsperaDonantes.encolar(colaTemp.desencolar());
        }
    }


    public void mostrarPacientes() {
        System.out.println("Lista de pacientes en la cola de espera:");

        if (colaEsperaPacientes.estaVacia()) {
            System.out.println("La cola de espera de pacientes está vacía.");
            return;
        }

        // Crear una cola temporal para mostrar los pacientes sin modificar la original
        Cola<Paciente> colaTemp = new Cola<>();
        while (!colaEsperaPacientes.estaVacia()) {
            Paciente paciente = colaEsperaPacientes.desencolar();
            System.out.println("Nombre: " + paciente.nombreP +
                    ", Documento: " + paciente.documentoP +
                    ", Correo: " + paciente.correoP +
                    ", celular: " + paciente.celularP +
                    ", Tipo de Sangre: " + paciente.tipoDeSangreP +
                    ", Edad: " + paciente.edadD);
            colaTemp.encolar(paciente);
        }

        // Restaurar la cola de espera original
        while (!colaTemp.estaVacia()) {
            colaEsperaPacientes.encolar(colaTemp.desencolar());
        }
    }

    public void BuscarDonantesPorDoc(String DocumentoD) {
        System.out.println(" Donantes con Documeno " + DocumentoD + " en la cola de espera:");

        Cola<Donante> colaTemp = new Cola<>();
        boolean encontrado = false;

        while (!colaEsperaDonantes.estaVacia()) {
            Donante donante = colaEsperaDonantes.desencolar();
            colaTemp.encolar(donante);

            if (donante.documentoD.trim().equalsIgnoreCase(DocumentoD.trim())) {
                System.out.println("Nombre: " + donante.nombreD +
                        ", Documento: " + donante.documentoD +
                        ", Correo: " + donante.correoD +
                        ", Celular: " + donante.celularD +
                        ", Tipo de Sangre: " + donante.tipoSangreD +
                        ", Edad: " + donante.edadD);
                encontrado = true;
            }
        }

        // Restaurar la cola de espera original
        while (!colaTemp.estaVacia()) {
            colaEsperaDonantes.encolar(colaTemp.desencolar());
        }

        if (!encontrado) {
            System.out.println("No se encontraron Donantes con tipo de sangre " + DocumentoD + " en la cola de espera.");
        }
    }

    public void BuscarPacientesPorDoc(String DocumentoP) {
        System.out.println("Lista de pacientes con tipo de sangre " + DocumentoP + " en la cola de espera:");

        Cola<Paciente> colaTemp = new Cola<>();
        boolean encontrado = false;

        while (!colaEsperaPacientes.estaVacia()) {
            Paciente paciente = colaEsperaPacientes.desencolar();
            colaTemp.encolar(paciente);

            if (paciente.documentoP.trim().equalsIgnoreCase(DocumentoP.trim())) {
                System.out.println("Nombre: " + paciente.nombreP +
                        ", Documento: " + paciente.documentoP +
                        ", Correo: " + paciente.correoP +
                        ", Celular: " + paciente.celularP +
                        ", Tipo de Sangre: " + paciente.tipoDeSangreP +
                        ", Edad: " + paciente.edadD);
                encontrado = true;
            }
        }

        // Restaurar la cola de espera original
        while (!colaTemp.estaVacia()) {
            colaEsperaPacientes.encolar(colaTemp.desencolar());
        }

        if (!encontrado) {
            System.out.println("No se encontraron pacientes con tipo de sangre " + DocumentoP + " en la cola de espera.");
        }
    }

    public void agregarDonanteDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del donante:");
        System.out.print("Nombre: ");
        String nombreD = scanner.nextLine();

        System.out.print("Documento: ");
        String documentoD = scanner.nextLine();

        System.out.print("Celular: ");
        String celularD = scanner.nextLine();

        System.out.print("Correo: ");
        String correoD = scanner.nextLine();

        System.out.print("Tipo de Sangre: ");
        String tipoSangreD = scanner.nextLine();

        System.out.print("Edad: ");
        int edadD = 0;
        try {
            edadD = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error al leer la edad. Asegúrate de ingresar un número entero.");
            return;
        }

        Donante nuevoDonante = new Donante(nombreD, documentoD, celularD, correoD, tipoSangreD, edadD);
        agregarDonante(nuevoDonante);

        System.out.println("Donante agregado exitosamente.");
    }

    public void eliminarDonanteDesdeCosnsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el documento del Donante que se desea eliminar: ");
        String documentoEliminar = scanner.nextLine();

        eliminarDonante(documentoEliminar);
    }

    public void agregarPacienteDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del paciente:");
        System.out.print("Nombre: ");
        String nombreP = scanner.nextLine();

        System.out.print("Documento: ");
        String documentoP = scanner.nextLine();

        System.out.print("Celular: ");
        String celularP = scanner.nextLine();

        System.out.print("Correo: ");
        String correoP = scanner.nextLine();

        System.out.print("Tipo de Sangre: ");
        String tipoSangreP = scanner.nextLine();

        System.out.print("Edad: ");
        int edadP = 0;
        try {
            edadP = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error al leer la edad. Asegúrate de ingresar un número entero.");
            return;
        }
        Paciente nuevoPaciente = new Paciente(nombreP, documentoP, celularP, correoP, tipoSangreP, edadP);
        agregarPaciente(nuevoPaciente);

        System.out.println("Paciente agregado agregado exitosamente.");
    }

    public void eliminarPacienteDesdeCosnsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el documento del Paciente que se desea eliminar: ");
        String documentoEliminar = scanner.nextLine();


        eliminarPaciente(documentoEliminar);


    }

    public void buscarPacientesPorDocumento() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tipo de sangre que desea buscar: ");
        String Documento = scanner.nextLine();

        BuscarPacientesPorDoc(Documento);
    }

    public void buscarDonantePorDocumento() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el Documento que desea buscar: ");
        String Documento = scanner.nextLine();

        BuscarDonantesPorDoc(Documento);
    }

    public void editarPaciente(String documentoP) {
        Paciente pacienteAEditar = null;

        // Buscar al paciente en la cola de espera
        Cola<Paciente> colaEsperaTemp = new Cola<>();
        while (!colaEsperaPacientes.estaVacia()) {
            Paciente paciente = colaEsperaPacientes.desencolar();
            if (paciente.documentoP.equals(documentoP)) {
                pacienteAEditar = paciente;
                System.out.println("Paciente encontrado en la cola de espera.");

                // Solicitar nuevos datos al usuario
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese los nuevos datos del paciente:");

                System.out.print("Nombre: ");
                paciente.nombreP = scanner.nextLine();

                System.out.print("Celular: ");
                paciente.celularP = scanner.nextLine();

                System.out.print("Correo: ");
                paciente.correoP = scanner.nextLine();

                System.out.print("Tipo de Sangre: ");
                paciente.tipoDeSangreP = scanner.nextLine();

                System.out.print("Edad: ");
                try {
                    paciente.edadD = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Error al leer la edad. Asegúrate de ingresar un número entero.");
                    return;
                }

                System.out.println("Paciente editado exitosamente.");
            }
            colaEsperaTemp.encolar(paciente);
        }
        colaEsperaPacientes = colaEsperaTemp;

        if (pacienteAEditar == null) {
            System.out.println("No se encontró un Paciente con el documento proporcionado en la cola de espera.");
        }

        // Actualizar el archivo de texto
        guardarDatosPacientes("/Users/juanm/OneDrive/Escritorio/Universidad/EStructura de datos/Datos/DatosPacientes.txt");
    }

    public void editarDonante(String documentoD) {
        Donante donanteAEditar = null;

        // Buscar al donante en la cola de espera
        Cola<Donante> colaEsperaTemp = new Cola<>();
        while (!colaEsperaDonantes.estaVacia()) {
            Donante donante = colaEsperaDonantes.desencolar();
            if (donante.documentoD.equals(documentoD)) {
                donanteAEditar = donante;
                System.out.println("Donante encontrado en la cola de espera.");

                // Solicitar nuevos datos al usuario
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese los nuevos datos del donante:");

                System.out.print("Nombre: ");
                donante.nombreD = scanner.nextLine();

                System.out.print("Celular: ");
                donante.celularD = scanner.nextLine();

                System.out.print("Correo: ");
                donante.correoD = scanner.nextLine();

                System.out.print("Tipo de Sangre: ");
                donante.tipoSangreD = scanner.nextLine();

                System.out.print("Edad: ");
                try {
                    donante.edadD = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Error al leer la edad. Asegúrate de ingresar un número entero.");
                    return;
                }

                System.out.println("Donante editado exitosamente.");
            }
            colaEsperaTemp.encolar(donante);
        }
        colaEsperaDonantes = colaEsperaTemp;

        if (donanteAEditar == null) {
            System.out.println("No se encontró un Donante con el documento proporcionado en la cola de espera.");
        }

        // Actualizar el archivo de texto
        guardarDatosDonantes("/Users/juanm/OneDrive/Escritorio/Universidad/EStructura de datos/Datos/DatosDonantes.txt");
    }
    public void editarPacienteDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el documento del Paciente que desea editar: ");
        String documentoEditar = scanner.nextLine();

        editarPaciente(documentoEditar);
    }
    public void editarDonanteDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el documento del Donante que desea editar: ");
        String documentoEditar = scanner.nextLine();

        editarDonante(documentoEditar);
    }
}
