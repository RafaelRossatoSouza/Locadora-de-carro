package Modelo;

import java.util.HashSet;

public class LocadoraSouthCar implements Locadora {

	/*
	 * classe da locadora SouthCar. Ela possui um tipo ja setado e um hashSet de carros. Possui tamb�m
	 * os m�todos de adicionar carro no hashSet e de lista-lo. Outro metodo q est� implementado calcula aluguel porem 
	 * este metodo n�o � usado em nenhum lugar do programa, ja q a saida esperada � apenas os carros cadastrados na locadora.
	 */
	private static HashSet<Carro> carros = new HashSet<Carro>();
	private String tipo;

	public LocadoraSouthCar() {

	}

	public LocadoraSouthCar(HashSet<Carro> carro, String tipo) {
		super();
		this.carros = carro;
		this.tipo = "compacto";
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
		this.tipo = "compacto";
	}

	public String cadastrarCarro(Carro carro) {

		carros.add(carro);
		return "Carro cadastrado com sucesso!";
	}

	public String ListarCarro() {

		String listaCarros = "";

		if (carros.size() == 0) {
			return "N�o existe carro cadastrado nessa locadora";
		} else {
			for (Carro car : carros) {

				listaCarros += car.getNome() + ":SouthCar" + "\n";
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
				calcula = qtdDiasSemana * 210;
			}
			if (qtdDiasSemana != 0) {
				calcula = calcula + 200;
			}
		}

		return calcula;
	}
}