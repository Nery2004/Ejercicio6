import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElectroTech {
    public static void main(String[] args) {
        List<Dispositivo> dispositivos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---Bienvendio a ElectroTech---");
            System.out.println("1. Agregar Dispositivo");
            System.out.println("2. Mostrar Dispositivos");
            System.out.println("3. Salir");
            System.out.print("Elije una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Pasar de linea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del dueño: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Tipo de dispositivo (Telefono/Computadora): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Modelo/Marca: ");
                    String modeloMarca = scanner.nextLine();

                    String estado;
                    do {
                        System.out.print("Estado (encendido/apagado): ");
                        estado = scanner.nextLine().toLowerCase();
                        if (!estado.equals("encendido") && !estado.equals("apagado")) {
                            System.out.println("Estado no válido. Por favor, ingresa 'encendido' o 'apagado'.");
                        }
                    } while (!estado.equals("encendido") && !estado.equals("apagado"));

                    Dispositivo dispositivo;
                    if (tipo.equalsIgnoreCase("Telefono")) {
                        dispositivo = new Telefono(nombre, modeloMarca);
                    } else if (tipo.equalsIgnoreCase("Computadora")) {
                        dispositivo = new Computadora(nombre, modeloMarca);
                    } else {
                        System.out.println("Tipo de dispositivo no valido.");
                        continue;
                    }

                    if (estado.equals("encendido")) {
                        dispositivo.encender();
                    } else {
                        dispositivo.apagar();
                    }

                    dispositivos.add(dispositivo);
                    System.out.println("Dispositivo agregado correctamente.");

                    // Guardar el dispositivo ingresado de forma automatica
                    guardarDispositivosEnCSV(dispositivos, "dispositivos.csv");
                    break;
                case 2:
                    // Mostrar el contenido del archivo CSV
                    mostrarCSV("dispositivos.csv");
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida. Por favor, elige una opcion valida.");
            }
        }
    }
    //Para guardar todas las listas en el archivo CSV 
    public static void guardarDispositivosEnCSV(List<Dispositivo> dispositivos, String archivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            writer.println("Nombre,Tipo,Modelo/Marca,Estado");
            for (Dispositivo dispositivo : dispositivos) {
                String tipo = dispositivo instanceof Telefono ? "Telefono" : dispositivo instanceof Computadora ? "Computadora" : "Desconocido";
                String modeloMarca = tipo.equals("Telefono") ? ((Telefono) dispositivo).getModelo() : tipo.equals("Computadora") ? ((Computadora) dispositivo).getMarca() : "";
                String estado = dispositivo.validarEstado();
                writer.println(dispositivo.nombre + "," + tipo + "," + modeloMarca + "," + estado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Pra que muestre el archivo csv
    public static void mostrarCSV(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
