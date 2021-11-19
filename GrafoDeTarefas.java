package t2alest2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrafoDeTarefas<TIPO> {
	
	private List<Vertice<Tarefa>>  vertices= new ArrayList<Vertice<Tarefa>>();
	private List<Aresta<Tarefa>>	arestas =  new ArrayList<Aresta<Tarefa>>();
	
	public GrafoDeTarefas() {
	
	}
	
	public void addVertice(Tarefa novaTarefa) {
		Vertice<Tarefa> novoVertice = new Vertice<Tarefa>(novaTarefa);
		vertices.add(novoVertice);
	}
	
	public void addAresta(Vertice<Tarefa> tarefaInicio, Vertice<Tarefa> tarefaFim) {
		Vertice<Tarefa> inicio =findVertice(tarefaInicio);
		Vertice<Tarefa> fim =findVertice(tarefaFim);
		Aresta<Tarefa> aresta = new Aresta<Tarefa>(tarefaInicio, tarefaFim);
		
		inicio.addArestaSaida(aresta);
		fim.addArestaEntrada(aresta);
		arestas.add(aresta);
	}
	
	public Vertice<Tarefa> findVertice(Vertice<Tarefa> tarefa){
		Vertice<Tarefa> v = null;
		for(Vertice<Tarefa> i : vertices) {
			if(i.equals(tarefa)) {
				v = i;
				break;
			}
		}
		return v;
	}
	
	public Boolean verificaSeLiberado(Vertice<Tarefa> tarefa) {
		boolean status = false;
		if(tarefa.getArestasEntrada().isEmpty()) {
			return true;
		}
		for(Aresta<Tarefa> a : tarefa.getArestasEntrada()) {
			if(a.getInicio().getTarefa().getStatus().equals(Status.FEITO)) {
				status = true;
			}
			else {
				status = false;
			}
		}
		return status;
	}
	
	public Boolean verificaSeFeito(Vertice<Tarefa> tarefa) {
		if(tarefa.getTarefa().getTempo() == 0) {
			return true;
		}
		return false;
	}
	
	public List<Vertice<Tarefa>> retornaLiberados(List<Vertice<Tarefa>> tarefas){
		List<Vertice<Tarefa>> liberados = new ArrayList<Vertice<Tarefa>>();
		
		for(Vertice<Tarefa> v : tarefas) {
			if(v.getTarefa().getStatus().equals(Status.LIBERADO)) {
				liberados.add(v);
			}
		}
		return liberados;
	}
	
	public void ordenaLiberados(List<Vertice<Tarefa>> liberados) {
		liberados.sort((v1, v2) -> v1.getTarefa().compareTo(v2.getTarefa()));
	}
}
