package t2alest2;

public class Tarefa implements Comparable<Tarefa>{
	private String nome;
	private Integer tempo;
	private Status status;
	
	public Tarefa(String nome, Integer tempo) {
		this.nome = nome;
		this.tempo = tempo;
		status = Status.TRANCADO;
	}
	
	public Tarefa(String text) {
		String fields[] = text.split("_");
		this.nome = fields[0];
		this.tempo = Integer.parseInt(fields[1]);
		status = Status.TRANCADO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Tarefa other = (Tarefa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public int compareTo(Tarefa outraTarefa) {
		return this.nome.compareTo(outraTarefa.getNome());
	}
	
	
}
