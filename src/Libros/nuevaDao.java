package Libros;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//FUNCIONES CRUD (CREATED, READ, UPDATE, DELETE)

public class nuevaDao {

	  public void crearLibro(Libro libro) {// FUNCION CREATED 
		  
		  try {
			  FileWriter creoLibroDao = new FileWriter("libros.txt", true);
			  creoLibroDao.write(libro.getId() + ";" + libro.getTitulo() + ";" + libro.getAutor() + "\n");
			  creoLibroDao.close();
			  System.out.println("Libro creado y metido al archivo libros.txt ");
		  }catch(IOException e) {
			  System.out.println("Error al crea libro " + e.getMessage());
		  }
		  
		  
	  }
	  
	  
	  public void leerLibros() { // FUNCION READ

		    try {
		        FileReader lector = new FileReader("libros.txt");               
		        Scanner lectorArchivo = new Scanner(lector);                     

		        while (lectorArchivo.hasNextLine()) {                           
		            String linea = lectorArchivo.nextLine();                  
		            System.out.println(linea);                                 
		        }

		        lectorArchivo.close();                                            

		    } catch (IOException e) {
		        System.out.println("Error al leer el archivo: " + e.getMessage()); 
		    }
		}
	  
	  public void updateLibro(int guardoId, Scanner scanner) {
		    ArrayList<Libro> listaLibros = new ArrayList<>();

		    try {
		        FileReader fr = new FileReader("libros.txt");
		        Scanner sc = new Scanner(fr);

		        while (sc.hasNextLine()) {
		            String[] partes = sc.nextLine().split(";");
		            int id = Integer.parseInt(partes[0]);
		            String titulo = partes[1];
		            String autor = partes[2];
		            listaLibros.add(new Libro(id, titulo, autor));
		        }

		        Libro libroQueBusco = null;
		        for (Libro libroActual : listaLibros) {
		            if (libroActual.getId() == guardoId) {
		                libroQueBusco = libroActual;
		                break;
		            }
		        }

		        if (libroQueBusco != null) {
		            System.out.println("Indicame el titulo ");
		            String titulo1 = scanner.nextLine();
		            System.out.println("Indicame el autor ");
		            String autor1 = scanner.nextLine();
		            libroQueBusco.setTitulo(titulo1);
		            libroQueBusco.setAutor(autor1);
		        }

		        FileWriter fw = new FileWriter("libros.txt");
		        for (Libro l : listaLibros) {
		            fw.write(l.getId() + ";" + l.getTitulo() + ";" + l.getAutor() + "\n");
		        }

		        fw.close();
		        sc.close();
		        fr.close();

		    } catch (IOException e) {
		        System.out.println("Error al leer archivo: " + e.getMessage());
		    }
		}
	  
	  public void deletedLibro(int idEliminar) {
		    ArrayList<Libro> listaLibros = new ArrayList<>();

		    try {
		    
		        FileReader fr = new FileReader("libros.txt");
		        Scanner scArchivo = new Scanner(fr);

		        while (scArchivo.hasNextLine()) {
		            String[] partes = scArchivo.nextLine().split(",");
		            int id = Integer.parseInt(partes[0]);
		            String titulo = partes[1];
		            String autor = partes[2];
		            listaLibros.add(new Libro(id, titulo, autor));
		        }

		        scArchivo.close();
		        fr.close();

		        // Busco labor para eliminarlo
		        Libro libroEliminar = null;
		        for (Libro libro : listaLibros) {
		            if (libro.getId() == idEliminar) {
		                libroEliminar = libro;
		                break;
		            }
		        }

		        // Elimino y guardo los cambios
		        if (libroEliminar != null) {
		            listaLibros.remove(libroEliminar);
		            System.out.println("✅ Libro eliminado correctamente.");

		            // Guardo los cambios en el archivo
		            FileWriter fw = new FileWriter("libros.txt");
		            for (Libro libro : listaLibros) {
		                fw.write(libro.getId() + ";" + libro.getTitulo() + ";" + libro.getAutor() + "\n");
		            }
		            fw.close();

		        } else {
		            System.out.println("⚠️ No se encontró un libro con ese ID.");
		        }

		    } catch (IOException e) {
		        System.out.println("Error al leer o escribir el archivo: " + e.getMessage());
		    }
		}
		  
		  
}
	  

