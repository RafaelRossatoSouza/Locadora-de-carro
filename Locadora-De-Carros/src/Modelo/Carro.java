package Modelo;

public class Carro {

	private String nome;
	private String placa;
	private int numMaxPessoas;
	private String tipoCarro;
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipoCarro() {
		return tipoCarro;
	}

	public void setTipoCarro(String tipoCarro) {
		this.tipoCarro = tipoCarro;
	}

	// ----------------construtor----------------------------------
	public Carro() {

	}

	public Carro(String nome, String placa, int numMaxPessoas) {
		super();

		this.nome = nome;
		this.placa = placa;
		this.numMaxPessoas = numMaxPessoas;

	}

	// --------------------get--------------------------------------
	public String getNome() {
		return nome;
	}

	public String getPlaca() {
		return placa;
	}

	public int getNumMaxPessoas() {
		return numMaxPessoas;
	}

	// ---------------------set-------------------------------------
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setNumMaxPessoas(int numMaxPessoas) {
		this.numMaxPessoas = numMaxPessoas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numMaxPessoas;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((tipoCarro == null) ? 0 : tipoCarro.hashCode());
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
		Carro other = (Carro) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numMaxPessoas != other.numMaxPessoas)
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (tipoCarro == null) {
			if (other.tipoCarro != null)
				return false;
		} else if (!tipoCarro.equals(other.tipoCarro))
			return false;
		return true;
	}

	// -------------------toString-----------------------------------
	@Override
	public String toString() {
		return "Carro [nome=" + this.getNome() + "placa=" + this.getPlaca() + "numero máximo de passageiros="
				+ this.getNumMaxPessoas() + "]";

	}

}
