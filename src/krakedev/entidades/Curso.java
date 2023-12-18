package krakedev.entidades;

import java.util.ArrayList;

public class Curso {
	private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	
	public String buscarEstudiantePorCedula(Estudiante estudiante) {
		String dato=null;
		for(Estudiante estu: estudiantes) {
			if(estu.getCedula().equals(estudiante.getCedula())) {
				dato = "El alumno se encuentra en este curso";
				break;
			}
			else {
				dato = null;
			}
		}
		return dato;
	}
	public void matricularEstudiante(Estudiante estudiante) {
		String respuesta = buscarEstudiantePorCedula(estudiante); 
		if(respuesta != null) {
			System.out.println(respuesta);
		}else {
			estudiantes.add(estudiante);
		}
	}
	public double calcularPromedioCurso() {
		double promedio=0;
		double sub =0;
		for(Estudiante est: estudiantes) {
			sub = sub + est.calcularPromedioNotasEstudiante();
		}
		promedio = sub/estudiantes.size();
		return promedio;
	}
	public void mostrar() {
		System.out.println("Curso [");
		for(Estudiante est: estudiantes) {
			System.out.println("Estudiante [ Nombre: " + est.getNombre() + "-Apellido: " + est.getApellido() +
					"-Cédula: " + est.getCedula() + "-Promedio: " + est.calcularPromedioNotasEstudiante() + "]");
		}
		System.out.println("]");
	}
	//-------------------
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	
	
}
