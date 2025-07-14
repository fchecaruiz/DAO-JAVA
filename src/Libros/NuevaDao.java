package Libros;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NuevaDao {

    // Método para crear un libro (CREATE)
    public void crearLibro(Libro libro) {
        try {
            FileWriter creoLibroDao = new FileWriter("libros.txt", true);
            creoLibroDao.write(libro.getId() + ";" + libro.getTitulo() + ";" + libro.getAutor() + "\n");
            creoLibroDao.close();
        } catch (IOException e) {
            System.out.println("Error al crear libro " + e.getMessage());
        }
    }

    // Método para leer todos los libros (READ)
    public ArrayList<Libro> leerLibros() throws IOException {

    	return cargarLibrosDesdeArchivo();
    }

    // Método para actualizar un libro (UPDATE)
    public boolean updateLibro(int id, String nuevoTitulo, String nuevoAutor) throws IOException {
        ArrayList<Libro> listaLibros = cargarLibrosDesdeArchivo();
        boolean encontrado = false;

        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            FileWriter fw = new FileWriter("libros.txt");
            for (Libro libro : listaLibros) {
                fw.write(libro.getId() + ";" + libro.getTitulo() + ";" + libro.getAutor() + "\n");
            }
            fw.close();
        }

        return encontrado;
    }

    // Método para borrar un libro (DELETE)
    public void deletedLibro(int idEliminar) {
        try {
            ArrayList<Libro> listaLibros = cargarLibrosDesdeArchivo();

            Libro libroEliminar = null;
            for (Libro libro : listaLibros) {
                if (libro.getId() == idEliminar) {
                    libroEliminar = libro;
                    break;
                }
            }

            if (libroEliminar != null) {
                listaLibros.remove(libroEliminar);
                System.out.println("Libro eliminado correctamente.");

                FileWriter fw = new FileWriter("libros.txt");
                for (Libro libro : listaLibros) {
                    fw.write(libro.getId() + ";" + libro.getTitulo() + ";" + libro.getAutor() + "\n");
                }
                fw.close();

            } else {
                System.out.println("No se encontró un libro con ese ID.");
            }

        } catch (IOException e) {
            System.out.println("Error al leer o escribir el archivo: " + e.getMessage());
        }
    }

    // Método privado para cargar libros desde el archivo
    private ArrayList<Libro> cargarLibrosDesdeArchivo() throws IOException {
        ArrayList<Libro> listaLibros = new ArrayList<>();
        FileReader fr = new FileReader("libros.txt");
        Scanner sc = new Scanner(fr);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            String[] partes = linea.split(";");
            int id = Integer.parseInt(partes[0]);
            String titulo = partes[1];
            String autor = partes[2];

            Libro libro = new Libro(id, titulo, autor);
            listaLibros.add(libro);
        }

        sc.close();
        fr.close();
        return listaLibros;
    }
}

