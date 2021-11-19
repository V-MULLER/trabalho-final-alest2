package t2alest2;

import java.util.ArrayList;
import java.util.List;

public class GrafoDeTarefas<TIPO> {

	private List<Vertice<Tarefa>> vertices = new ArrayList<Vertice<Tarefa>>();
	// private List<Vertice<Tarefa>> verticesLiberados= new
	// ArrayList<Vertice<Tarefa>>();
	private List<Aresta<Tarefa>> arestas = new ArrayList<Aresta<Tarefa>>();

	public GrafoDeTarefas() {

	}

	public void addVertice(Tarefa novaTarefa) {
		Vertice<Tarefa> novoVertice = new Vertice<Tarefa>(novaTarefa);
		//for (int i = 0; i < vertices.size(); i++) {
			//if(!vertices.get(i).equals(this.retornaVertice(novaTarefa)))
				vertices.add(novoVertice);
		//}
	}

	public Vertice<Tarefa> retornaVertice(Tarefa novaTarefa) {
		Vertice<Tarefa> novoVertice = new Vertice<Tarefa>(novaTarefa);
		return novoVertice;
	}

	public void addAresta(Vertice<Tarefa> tarefaInicio, Vertice<Tarefa> tarefaFim) {
		Vertice<Tarefa> inicio = findVertice(tarefaInicio);
		Vertice<Tarefa> fim = findVertice(tarefaFim);
		Aresta<Tarefa> aresta = new Aresta<Tarefa>(inicio, fim);

		inicio.addArestaSaida(aresta);
		fim.addArestaEntrada(aresta);
		arestas.add(aresta);
	}

	public Vertice<Tarefa> findVertice(Vertice<Tarefa> tarefa) {
		Vertice<Tarefa> v = null;
		for (Vertice<Tarefa> i : vertices) {
			if (i.equals(tarefa)) {
				v = i;
				break;
			}
		}
		return v;
	}

	public int sizeVertices() {
		return getVertices().size();
	}

	public int sizeArestas() {
		return getArestas().size();
	}

	public List<Vertice<Tarefa>> getVertices() {
		return vertices;
	}

	public List<Aresta<Tarefa>> getArestas() {
		return arestas;
	}

	public List<Vertice<Tarefa>> adj(Vertice<Tarefa> v) {
		List<Vertice<Tarefa>> tarefas = new ArrayList<Vertice<Tarefa>>();

		for (Aresta<Tarefa> a : v.getArestasSaida())
			tarefas.add(a.getFim());
		return tarefas;
	}
	/*
	 * public Boolean verificaSeLiberado(Vertice<Tarefa> tarefa) { boolean status =
	 * false; if(tarefa.getArestasEntrada().isEmpty()) { return true; }
	 * for(Aresta<Tarefa> a : tarefa.getArestasEntrada()) {
	 * if(a.getInicio().getTarefa().getStatus().equals(Status.FEITO)) { status =
	 * true; } else { status = false; } } return status; }
	 * 
	 * public Boolean verificaSeFeito(Vertice<Tarefa> tarefa) {
	 * if(tarefa.getTarefa().getTempo() == 0) { return true; } return false; }
	 * 
	 * 
	 * 
	 * public void addLiberados(Vertice<Tarefa> tarefa){
	 * if(tarefa.getTarefa().getStatus().equals(Status.LIBERADO))
	 * verticesLiberados.add(tarefa);
	 * 
	 * }
	 * 
	 * public void ordenaLiberados(List<Vertice<Tarefa>> liberados) {
	 * liberados.sort((v1, v2) -> v1.getTarefa().compareTo(v2.getTarefa())); }
	 * 
	 * public void atualizaListaLiberados(List<Vertice<Tarefa>> liberados) { for(int
	 * i = 0; i< liberados.size(); i++) {
	 * if(liberados.get(i).getTarefa().getStatus().equals(Status.FEITO))
	 * liberados.remove(i); } }
	 */
}
