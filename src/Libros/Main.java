package Libros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NuevaDao dao = new NuevaDao();
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Añadir libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Modificar libro");
            System.out.println("4. Borrar libro");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();

                        Libro nuevoLibro = new Libro(id, titulo, autor);
                        dao.crearLibro(nuevoLibro);
                        System.out.println("Libro creado correctamente.");
                        break;

                    case 2:
                        ArrayList<Libro> listaDeLibros = dao.leerLibros();
                        for (Libro libro : listaDeLibros) {
                            System.out.println(libro);
                        }
                        break;

                    case 3:
                        System.out.print("Introduce el ID del libro a modificar: ");
                        int idModificar = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nuevo título: ");
                        String nuevoTitulo = scanner.nextLine();
                        System.out.print("Nuevo autor: ");
                        String nuevoAutor = scanner.nextLine();

                        boolean actualizado = dao.updateLibro(idModificar, nuevoTitulo, nuevoAutor);
                        if (actualizado) {
                            System.out.println("Libro actualizado correctamente.");
                        } else {
                            System.out.println("No se encontró un libro con ese ID.");
                        }
                        break;

                    case 4:
                        System.out.print("Introduce el ID del libro a borrar: ");
                        int idBorrar = Integer.parseInt(scanner.nextLine());
                        System.out.print("¿Seguro que quieres borrar el libro? (s/n): ");
                        String confirmacion = scanner.nextLine();

                        if (confirmacion.equalsIgnoreCase("s")) {
                            dao.deletedLibro(idBorrar);
                        } else {
                            System.out.println("Operación cancelada.");
                        }
                        break;

                    case 5:
                        System.out.println("Hasta pronto!");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            }
        } while (opcion != 5);

        scanner.close();
    }
}

            
            
            
            
            
            


