package t2alest2;

public class Main {
	public static void main(String[] args) {
		Tarefa t1 = new Tarefa("abc", 12);
		Tarefa t2 = new Tarefa("cde", 12);
		Tarefa t3 = new Tarefa("fgh", 12);
		Tarefa t4 = new Tarefa("ijk", 12);
		
		GrafoDeTarefas<Tarefa> g = new GrafoDeTarefas<Tarefa>();
		
		g.addVertice(t1);
		g.addVertice(t2);
		g.addVertice(t4);
		g.addVertice(t3);
		
		g.addAresta(g.retornaVertice(t1), g.retornaVertice(t3));
		g.addAresta(g.retornaVertice(t3), g.retornaVertice(t2));
		//g.addAresta(g.retornaVertice(t2), g.retornaVertice(t4));
		g.addAresta(g.retornaVertice(t1), g.retornaVertice(t4));
		
		
		OrdGrafo og = new OrdGrafo(g);
		
		for(Vertice<Tarefa> v : og.ordemTopo())
			System.out.println(v.getTarefa().getNome());
	
	}
}
