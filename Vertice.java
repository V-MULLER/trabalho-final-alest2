package t2alest2;

import java.util.ArrayList;
import java.util.List;

public class Vertice <TIPO> implements Comparable<Tarefa>{
	
	private Tarefa tarefa;
	private List<Aresta<Tarefa>> arestasEntrada = new ArrayList<Aresta<Tarefa>>();
	private List<Aresta<Tarefa>> arestasSaida = new ArrayList<Aresta<Tarefa>>();
	
	public Vertice() {}
	
	public Vertice(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public void addArestaEntrada(Aresta<Tarefa> aresta) {
		arestasEntrada.add(aresta);
	}
	
	public void addArestaSaida(Aresta<Tarefa> aresta) {
		arestasSaida.add(aresta);
	}
	
	public List<Aresta<Tarefa>> getArestasEntrada() {
		return arestasEntrada;
	}

	public List<Aresta<Tarefa>> getArestasSaida() {
		return arestasSaida;
	}
	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tarefa == null) ? 0 : tarefa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		if (tarefa == null) {
			if (other.tarefa != null)
				return false;
		} else if (!tarefa.equals(other.tarefa))
			return false;
		return true;
	}

	@Override
	public int compareTo(Tarefa outra ) {
		// TODO Auto-generated method stub
		return this.tarefa.compareTo(outra);
	}

	
}
