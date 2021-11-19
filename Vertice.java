package t2alest2;

import java.util.ArrayList;
import java.util.List;

public class Vertice <TIPO> implements Comparable<Tarefa>{
	
	private Tarefa tarefa;
	private List<Aresta<Tarefa>> arestasEntrada = new ArrayList<Aresta<Tarefa>>();
	private List<Aresta<Tarefa>> arestasSaida = new ArrayList<Aresta<Tarefa>>();
	
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
	public int compareTo(Tarefa outra ) {
		// TODO Auto-generated method stub
		return this.tarefa.compareTo(outra);
	}

	
}
