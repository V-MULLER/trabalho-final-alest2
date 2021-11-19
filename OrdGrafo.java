package t2alest2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OrdGrafo {
	private boolean[] marked;
	private Stack<Vertice<Tarefa>> ordem;
	private List<Vertice<Tarefa>>  verticesLiberados= new ArrayList<Vertice<Tarefa>>();
	
	public OrdGrafo(GrafoDeTarefas<Tarefa> g) {
		marked = new boolean[g.sizeVertices()]; // inicializa todos com false
		ordem = new Stack<Vertice<Tarefa>>();
		for (int s = 0; s < g.sizeVertices(); s++) {
			if (!marked[s])
				dfs(g, g.getVertices().get(s));
		}
	}
	
	private void dfs(GrafoDeTarefas<Tarefa> g, Vertice<Tarefa> v) {
		System.out.println("Entrei em " + v.getTarefa().getNome());
		marked[g.getVertices().indexOf(v)] = true;
		//v.getTarefa().setStatus(Status.LIBERADO);
		
		
		for (Vertice<Tarefa> w : g.adj(v)) {
			System.out.println("Adjacente: " + w.getTarefa().getNome());
			if (!marked[g.getVertices().indexOf(w)]) {
				if(verificaSeLiberado(w)) {
				w.getTarefa().setStatus(Status.LIBERADO);
				dfs(g, w);
				this.addLiberados(w);}
				
				
			}
				
		}
		ordem.push(v);
		System.out.println("adicionando " + v.getTarefa().getNome());
		
	 System.out.println("Terminei " + v.getTarefa().getNome());
	}

	public Iterable<Vertice<Tarefa>> ordemTopo() {
		return ordem;
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
	
	
	
	public void addLiberados(Vertice<Tarefa> tarefa){
		if(tarefa.getTarefa().getStatus().equals(Status.LIBERADO))
			verticesLiberados.add(tarefa);
	
	}
	
	public void ordenaLiberados(List<Vertice<Tarefa>> liberados) {
		liberados.sort((v1, v2) -> v1.getTarefa().compareTo(v2.getTarefa()));
	}
	
	public void atualizaListaLiberados(List<Vertice<Tarefa>> liberados) {
		for(int i = 0; i< liberados.size(); i++) {
			if(liberados.get(i).getTarefa().getStatus().equals(Status.FEITO))
				liberados.remove(i);
		}
	}
}
