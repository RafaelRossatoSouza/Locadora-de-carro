package Modelo;

import java.util.Date;

public interface Locadora {

	public String cadastrarCarro(Carro carro);

	public String ListarCarro();

	public Float calculaAluguel(int qtdDias, boolean fidelidade, int qtdDiasFDS);

}