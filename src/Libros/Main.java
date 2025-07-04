package Libros;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
    	// PRUEBA DE CONEXION A BASE DE DATOS
  
//    	        try {
//    	           
//    	            Class.forName("com.mysql.cj.jdbc.Driver");
//    	            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros","root","12071609");
//    	            conexion.close();
//    	         
//
//    	        } catch (ClassNotFoundException e) {
//    	            e.printStackTrace();
//    	        }
//    	    
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Libro> listaLibros = new ArrayList<>();
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
            
            	
                if (opcion == 1) {
                	System.out.print("ID: ");
                	int id = scanner.nextInt();
                	scanner.nextLine();
                	System.out.print("Título: ");
                	String titulo = scanner.nextLine();
                	System.out.print("Autor: ");
                	String autor = scanner.nextLine();
                	
                	
        			Libro nuevoLibro = new Libro(id,titulo,autor);
        	        listaLibros.add(nuevoLibro);
        	        System.out.println(nuevoLibro);

                	
                	nuevaDao dao = new nuevaDao();
        			dao.crearLibro(nuevoLibro);
        			
        			System.out.println(listaLibros);

              
            } else if (opcion == 2) {
            	
            	System.out.println("\nMostrando los libros........ " );
            	
            	nuevaDao nuevaLectura = new nuevaDao();
            	nuevaLectura.leerLibros();
            	
            	System.out.println("Se han mostrado todos los libros que incluye el archivo de texto: " + "\nlibros.txt");
            	
            }  else if (opcion == 3) {
            	
            	System.out.println("Modifica un libro ");
            	
                System.out.println("INTRODUCE UN ID ");
            	
            	int guardoId = Integer.parseInt(scanner.nextLine());
            	
            	
            	nuevaDao actualizarLibro = new nuevaDao();
            	actualizarLibro.updateLibro(guardoId, scanner);
            	
            	System.out.println("libro actualizado correctamente ");
    
            	
            } else if (opcion == 4) {

                System.out.println("Introduce un ID para borrar libro: ");
                int id = Integer.parseInt(scanner.nextLine());

                System.out.println("¿Estás seguro de que quieres borrar el libro con ID " + id + "? (s/n)");
                String confirmacion = scanner.nextLine();

                if (confirmacion.equalsIgnoreCase("s")) {
                    nuevaDao nuevaDAO = new nuevaDao();
                    nuevaDAO.deletedLibro(id);
                    System.out.println("📕 Libro borrado correctamente.");
                } else {
                    System.out.println("❌ Operación cancelada. El libro no se ha borrado.");
                }
            

            
            } else if (opcion == 5) {
            	
                System.out.println("SALIR ......Hasta pronto, Fernando!");
                
            } else {
            	
                System.out.println("❌ Opción no válida. Intenta otra vez.");
            }
            

        } while (opcion != 5);

        scanner.close();
       
    }


}



