package t2alest2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

// Implementa o algoritmo Graus de Separação, através de caminhamento
// em largura (BFS) num grafo não dirigido
public class PistaDeTreinamento {
	public static void main(String args[]) {
		GrafoDeTarefas<Tarefa> g = new GrafoDeTarefas<Tarefa>(); // +- 119 mil nomes diferentes
		Map<Vertice<Tarefa>, Integer> dicTarefas = new HashMap<Vertice<Tarefa>, Integer>();
		// String dicRev[] = new String[8];
		
		int totalVertices = 0;
		Vertice<Tarefa> tarefaX = new Vertice<Tarefa>();
		Vertice<Tarefa> tarefaY = new Vertice<Tarefa>();
		//int indiceInicio = 0;
		//int indiceFim = 0;

		In arq = new In("dez.txt");
		String aux = "";
		arq.readLine();
		while (!(aux = arq.readLine()).equals("}")) {

			String dados[] = aux.split(" -> ");
			Tarefa tarefaInicial = new Tarefa(dados[0]);
			Tarefa tarefaFinal = new Tarefa(dados[1]);
			
			if (!dicTarefas.containsKey(g.retornaVertice(tarefaInicial))) {
				g.addVertice(tarefaInicial);
				dicTarefas.put(g.retornaVertice(tarefaInicial), totalVertices);
				tarefaX = g.retornaVertice(tarefaInicial);
				totalVertices++;
				
			}
			else {
				tarefaX = g.retornaVertice(tarefaInicial);
			}
			if (!dicTarefas.containsKey(g.retornaVertice(tarefaFinal))) {
				g.addVertice(tarefaFinal);
				dicTarefas.put(g.retornaVertice(tarefaFinal), totalVertices);
				tarefaY = g.retornaVertice(tarefaFinal);
				totalVertices++;
				
			}
			else {
				tarefaY = g.retornaVertice(tarefaFinal);
			}
			g.addAresta(tarefaX , tarefaY);
			/*if (g.sizeVertices() == 0) {
				g.addVertice(tarefaInicial);
				indiceInicio = g.getVertices().indexOf(g.retornaVertice(tarefaInicial));
				g.addVertice(tarefaFinal);
				indiceFim = g.getVertices().indexOf(g.retornaVertice(tarefaFinal));
				
				System.out.println(indiceInicio + " " + indiceFim);
				g.addAresta(g.getVertices().get(indiceInicio), g.getVertices().get(indiceFim));
			} else {

				for (int i = 0; i < g.getVertices().size(); i++) {
					if(!g.getVertices().get(i).equals(g.retornaVertice(tarefaInicial)))
						g.addVertice(tarefaInicial);
					System.out.println(g.sizeVertices());
					indiceInicio = g.getVertices().indexOf(g.retornaVertice(tarefaInicial));
					if(!g.getVertices().get(i).equals(g.retornaVertice(tarefaFinal))) 
						g.addVertice(tarefaFinal);
					indiceFim = g.getVertices().indexOf(g.retornaVertice(tarefaFinal));
					
					g.addAresta(g.getVertices().get(indiceInicio), g.getVertices().get(indiceFim));
					System.out.println(indiceInicio + " " + indiceFim);
				}
			}*/

			
			System.out.println("De: " + tarefaInicial.getNome() + " para: " + tarefaFinal.getNome());

		}
		arq.close();
		System.out.println("Total vertices:" + g.sizeVertices());
		System.out.println("Total arestas:" + g.sizeArestas());
		System.out.println();
		OrdGrafo og = new OrdGrafo(g);
		//StdOut.println(g);
		for (Vertice<Tarefa> v : og.ordemTopo())
			System.out.println(v.getTarefa().getNome());

		System.out.println();
		//System.out.println(g.toDot());

		// System.exit(1);
	}



}
