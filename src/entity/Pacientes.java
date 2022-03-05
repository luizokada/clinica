package entity;

import java.util.ArrayList;

public class Pacientes {
	private  ArrayList<Paciente> pacientes; 
	private int codigo = 0;
	
	public Pacientes() {
		super();
		this.pacientes = new ArrayList<Paciente>();
		

	}
	
	
	public void addPaciente(Paciente paciente) {
		this.pacientes.add(paciente);
		this.codigo = this.codigo + 1;
	}
	
	
	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}


	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}


	public void removePaciente(int codigo){
		boolean encontrado = false;
		int i = 0;
		while(!encontrado &&  i < this.pacientes.size()) {
			if(this.pacientes.get(i).getCodigo() == codigo) {
				this.pacientes.remove(i);
				encontrado = true;
			}
			i ++;
		}
	}

}
