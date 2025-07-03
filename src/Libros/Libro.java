package Libros;

public class Libro {
	
	private int id;
	private String titulo;
	private String autor;

	
	public Libro(int id,String titulo, String autor) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		
		
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	

	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String toString() {
		return "Titulo: " + titulo +"\n" +  "Autor: " + autor + "\n" + "Id: " + id;
	}

}
