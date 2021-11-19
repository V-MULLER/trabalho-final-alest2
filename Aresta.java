package t2alest2;

public class Aresta <TIPO>{
	
	private Vertice<Tarefa> inicio;
	private Vertice<Tarefa> fim;
	
	public Aresta(Vertice<Tarefa> inicio, Vertice<Tarefa> fim) {
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public Vertice<Tarefa> getInicio() {
		return inicio;
	}
	public void setInicio(Vertice<Tarefa> inicio) {
		this.inicio = inicio;
	}
	public Vertice<Tarefa> getFim() {
		return fim;
	}
	public void setFim(Vertice<Tarefa> fim) {
		this.fim = fim;
	}
	
	
}
