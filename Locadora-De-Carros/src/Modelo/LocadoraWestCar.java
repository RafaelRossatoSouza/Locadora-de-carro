
package Modelo;

import java.util.HashSet;

public class LocadoraWestCar implements Locadora {

	/*
	 * classe da locadora westCar. Ela possui um tipo ja setado e um hashSet de carros. Possui também
	 * os métodos de adicionar carro no hashSet e de lista-lo. Outro metodo q está implementado calcula aluguel porem 
	 * este metodo não é usado em nenhum lugar do programa, ja q a saida esperada é apenas os carros cadastrados na locadora.
	 */
	private HashSet<Carro> carros = new HashSet();
	private String tipo;

	public LocadoraWestCar() {

	}

	public LocadoraWestCar(HashSet<Carro> carro, String tipo) {
		super();
		this.carros = carro;
		this.tipo = "esportivo";
	}

	public HashSet<Carro> getCarro() {
		return carros;
	}

	public void setCarro(HashSet<Carro> carro) {
		this.carros = carro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = "esportivo";
	}

	public String cadastrarCarro(Carro carro) {
		if (carro.getPlaca().equals(carros)) {
			return "Este carro já está cadastrado";
		} else
			carros.add(carro);
		return "Carro cadastrado com sucesso!";
	}

	@Override
	public String ListarCarro() {
		String listaCarros = "";
		int cont = 0;
		if (carros.size() == 0) {
			return "Não existe carro cadastrado nessa locadora";
		} else {
			for (Carro car : carros) {
				cont++;
				listaCarros += car.getNome() + ":WestCar" + "\n";
			}
		}
		return listaCarros;
	}

	public Float calculaAluguel(int qtdDiasSemana, boolean fidelidade, int qtdDiasFDS) {

		float calcula = 0;

		if (fidelidade) {

			calcula = qtdDiasSemana * 150;
			if (qtdDiasFDS != 0) {
				calcula = calcula + 90;
			} else {
				calcula = qtdDiasSemana * 530;
			}
			if (qtdDiasSemana != 0) {
				calcula = calcula + 200;
			}
		}

		return calcula;
	}
}
