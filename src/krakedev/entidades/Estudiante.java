package krakedev.entidades;

import java.util.ArrayList;

public class Estudiante {
	private String cedula;
	private String nombre;
	private String apellido;
	private ArrayList<Nota> notas = new ArrayList<Nota>();
	//-------------------
	public Estudiante(String cedula, String nombre, String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}	
	//-------------------
	public void agregarNota(Nota nuevaNota) {
		if(notas != null || !notas.isEmpty() ) {
			for(Nota notaB: notas) {
				if(!nuevaNota.getMateria().getCodigo().equals(notaB.getMateria().getCodigo())) {
					if(nuevaNota.getCalificacion() >= 0 && nuevaNota.getCalificacion() <=10) {
						notas.add(nuevaNota);
						break;
					}else {
						System.out.println("A-----------------");
						System.out.println("La nota no valida");
						break;
					}
				}else {
					System.out.println("A----------------");
					System.out.println("Materia repetida");
				}
			}
		} 
		if(notas.isEmpty() == true){
			if(nuevaNota.getCalificacion() >= 0.0 && nuevaNota.getCalificacion() <=10) {
				notas.add(nuevaNota);
			}else {
				System.out.println("A----------------");
				System.out.println("La nota no valida");
			}
		}
	}
	public void modificarNota(String codigo,double nuevaNota) {
		for(Nota notaB: notas) {
			if(notaB.getMateria().getCodigo().equals(codigo)) {
				if(nuevaNota > 0 && nuevaNota <=10) {
					notaB.setCalificacion(nuevaNota);
					break;
				}else {
					System.out.println("M----------------");
					System.out.println("La nota no valida");
					break;
				}
			}else {
				System.out.println("M----------------");
				System.out.println("Codigo de materia no encontrado");
			}
		}
	}
	public double calcularPromedioNotasEstudiante() {
		double promedio = 0;
		double sub = 0;
		for(Nota notaP:notas) {
			sub = sub +notaP.getCalificacion();
		}
		promedio = sub/notas.size();
		return promedio;
	}
	public void mostrar() {
		System.out.println("Estudiante [Nombre: "+ nombre + "Apellido: " + apellido + "Cédula: " + cedula + "]");
		for(Nota notaB:notas) {
			notaB.mostrar();
		}
	}
	//---------------
	public String getCedula() {
		return cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public ArrayList<Nota> getNotas() {
		return notas;
	}
	
}
	