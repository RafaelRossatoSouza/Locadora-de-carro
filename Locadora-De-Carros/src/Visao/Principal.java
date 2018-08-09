package Visao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;


import javax.swing.JOptionPane;

import Modelo.Carro;

import Modelo.Locadora;
import Modelo.LocadoraNorthCar;
import Modelo.LocadoraSouthCar;
import Modelo.LocadoraWestCar;

public class Principal {

	// criando os objetos
	static Locadora localS = new LocadoraSouthCar();
	static Locadora localW = new LocadoraWestCar();
	static Locadora localN = new LocadoraNorthCar();
	

	/* Este método recebe do usuário os dados referentes ao carro a ser cadastrado e o cadastra na locadora a qual ele 
	 * pertence, dependendo da quantidade máxima de passageiros.
	 * 
	 */
	public static void CadastroClientes() throws ParseException {

		
		int op;
		String placa;
		String nome;
		int numMaxPessoas = 0;
		int opcaoMenu = -1;
		String stringCodigo;

		while (opcaoMenu != 0) {

			nome = JOptionPane.showInputDialog(null, "Digite o nome do Carro:");
			if (nome != null) {
				if (nome.equals("")) {
					JOptionPane.showMessageDialog(null, "Informe um nome valido!"); 

				} else {
					placa = JOptionPane.showInputDialog(null, "Digite a placa do carro:");
					if (placa != null) {
						if (placa.equals("")) {
							JOptionPane.showMessageDialog(null, "Informe uma placa válida!");

						} else {
							stringCodigo = JOptionPane.showInputDialog(null,
									"Digite o número máximo de passageiro do carro:");
							if (stringCodigo != null) {
								if (stringCodigo.equals("")) {
									JOptionPane.showMessageDialog(null, "Informe um número valido!");

								} else {
									if (ErroNumero(stringCodigo)) {                       // testa se é mesmo um numero
										numMaxPessoas = Integer.parseInt(stringCodigo);  // conversão 

										if (numMaxPessoas == 4) {    // se o numero max de pessoas for igual a 4 
																	 // é salvo na locadora SouthCar cujo a mesma comporta compactos	
											Carro car1 = new Carro(nome, placa, numMaxPessoas);
											localS.cadastrarCarro(car1); 

										} else if (numMaxPessoas == 2) { // se o numero max de pessoas for igual a 2 
											 // é salvo na locadora WestCar cujo a mesma comporta esportivos.

											Carro car1 = new Carro(nome, placa, numMaxPessoas); 
											localW.cadastrarCarro(car1);

										} else if (numMaxPessoas == 7) { // se o numero max de pessoas for igual a 7 
											 // é salvo na locadora NorthCar cujo a mesma comporta suv's.

											Carro car1 = new Carro(nome, placa, numMaxPessoas);
											localN.cadastrarCarro(car1);
										}

										stringCodigo = JOptionPane.showInputDialog(null,
												"Deseja fazer mais algum cadastro? \n Digite 1 para continuar e 0 para sair \n");
										op = Integer.parseInt(stringCodigo); // caso queira continuar cadastrando 
										if (op == 0) {                       // caso contrario digite 0 e o programa irá para tela principal
											opcaoMenu = 0;
										}

									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	/*
	 * Este método recebe do usuário o tipo de carro que ele deseja, quantidade de pessoas q irão ser transportadas no mesmo
	 * e o intervalo de datas. Dependendo da quantidade de pessoas é listado os carros de determinada agência.
	 */
	public static void ListarCarros() throws ParseException {

		int op;
		String tipo;
		int quantPessoas = 0;
		int opcaoMenu = -1;
		String stringConver;
		String data = "";

		while (opcaoMenu != 0) {

			tipo = JOptionPane.showInputDialog(null,
					"Digite o tipo de carro:\n" + "Opções: \n" + "Compacto  - capacidade 4 pessoas. \n"
							+ "Esportivo - capacidade 2 pessoas. \n" + "Suv´s     - capacidade 7 pessoas. ");
			if (tipo != null) {
				if (tipo.equals("")) {
					JOptionPane.showMessageDialog(null, "Informe um nome valido!");

				} else {
					stringConver = JOptionPane.showInputDialog(null, "Digite a quantidade de passageiros:");

					if (stringConver != null) {
						if (stringConver.equals("")) {
							JOptionPane.showMessageDialog(null, "Informe um número valido!");

						} else {
							if (ErroNumero(stringConver)) {
								quantPessoas = Integer.parseInt(stringConver);

								data = JOptionPane.showInputDialog(null,
										"Digite o intervalo de datas que deseja utilizar o veículo \n"
												+ " Exemplo: 16Mar2009 (seg), 17Mar2009 (ter)");

								if ((quantPessoas >= 1) && (quantPessoas <= 2)) {             //entre 1 ou duas pessoas
									JOptionPane.showMessageDialog(null, localW.ListarCarro());// é listado os carros esportivos
								}

								if ((quantPessoas >= 3) && (quantPessoas <= 4)) {             // entre 3 e 4 pessoas
									JOptionPane.showMessageDialog(null, localS.ListarCarro());// é listado os carros compactos
								}

								if ((quantPessoas >= 5) && (quantPessoas <= 7)) {			 // entre 5 e 7 pessoas	
									JOptionPane.showMessageDialog(null, localN.ListarCarro());// é listado os carros suv's
								}

								stringConver = JOptionPane.showInputDialog(null,
										"Deseja fazer mais alguma consulta? \n Digite 1 para continuar e 0 para sair \n");
								op = Integer.parseInt(stringConver);
								if (op == 0) {
									opcaoMenu = 0;
								}

							}
						}
					}
				}

			}
		}

	}

	/*
	 * Este método recebe do usuário um arquivo texto, divide cada campo em variaveis e de acordo com a capacidade do carro
	 * cadastra a respectiva locadora.
	 */
	public static void CadastrarViaTexto() throws IOException {

		String linha = "";
		String nome = "";
		String placa = "";
		String aux = "";
		int quantPass = 0;
		int i = 0;
		int opcaoMenu = -1;
		while (opcaoMenu != 0) {
			String path = "";

			// parte da leitura do arquivo
			path = JOptionPane.showInputDialog(null, "Digite o nome do arquivo \n" + "Exemplo: arquivo.txt");
			BufferedReader buffRead = new BufferedReader(new FileReader(path));
			while (true) {

				if (linha != null) {

					if (i == 1) {
						nome = linha;
						
					}

					if (i == 2) {
						placa = linha;

					}

					if (i == 3) {
						aux = linha;
						quantPass = Integer.parseInt(aux); // passa para inteiro a string q armazena a quant max de passageiros 

					}
					i++;

				} else
					break;
				linha = buffRead.readLine();
			}
			buffRead.close();
		// fim da leitura do arquivo
			
			if (quantPass == 4) { // se a quantd maxima de pessoas for igual a 4 

				Carro car1 = new Carro(nome, placa, quantPass);
				localS.cadastrarCarro(car1);       // salva o carro em compactos

			} else if (quantPass == 2) {     // se a quantd maxima de pessoas for igual a 2

				Carro car1 = new Carro(nome, placa, quantPass);
				localW.cadastrarCarro(car1);	// salva em esportivos			

			} else if (quantPass == 7) {    // se a quantd maxima de pessoas for igual a 7

				Carro car1 = new Carro(nome, placa, quantPass);
				localN.cadastrarCarro(car1);  // salva em suv's
			}
			String stringConver = JOptionPane.showInputDialog(null,
					" Cadastrado com sucesso. Aperte 0 para sair");
			int op = Integer.parseInt(stringConver);
			op = 0;
			if (op == 0) {
				opcaoMenu = 0;
			}
		}
	}

	
	/*
	 *Recebe do usuário um arquivo texto no formato passado na especificação do problema.
	 * Divide os campo do arquivo texto e de acordo com a quant de passageiros ele lista a locadora mais apropriada
	 */
	public static void ListarViaTexto() throws IOException {

		String linha = "";
		String aux = "";
		int quantPass = 0;
		int i = 0;
		int opcaoMenu = -1;

		while (opcaoMenu != 0) {
			
			// leitura aquivo texto
			String path = "";
			path = JOptionPane.showInputDialog(null, "Digite o nome do arquivo \n" + "Exemplo: arquivo.txt");

			BufferedReader buffRead = new BufferedReader(new FileReader(path));

			while (true) {
				if (linha != null) {

					aux = linha;

				} else
					break;
				linha = buffRead.readLine();
			}
			buffRead.close();

			String[] textoSeparado = aux.split(":"); // utiliza o : como separador de string
			String x1 = "";
			String x2 = "";
			String x3 = "";
			for (i = 0; i < textoSeparado.length; i++) {

				if (i == 0) {
					x1 = textoSeparado[i];
				}

				if (i == 1) {
					x2 = textoSeparado[i];
				}

				if (i == 2) {
					x3 = textoSeparado[i]; // a data é jogada em string inteira nesta variavel. Para utiliza-la é preciso 
				}							// separa-la usando o split(,) e converter cada string em date.

			}

			quantPass = Integer.parseInt(x2);
			
			//lista os carros de acordo com a quantidade de passageiros que o usuário irá transportar
			if ((quantPass >= 1) && (quantPass <= 2)) {
				JOptionPane.showMessageDialog(null, localW.ListarCarro());
			}

			if ((quantPass >= 3) && (quantPass <= 4)) {
				JOptionPane.showMessageDialog(null, localS.ListarCarro());
			}

			if ((quantPass >= 5) && (quantPass <= 7)) {
				JOptionPane.showMessageDialog(null, localN.ListarCarro());
			}

			String stringConver = JOptionPane.showInputDialog(null,
					"Listado com sucesso. Aperte 0 para sair");
			int op = Integer.parseInt(stringConver);

			op = 0;
			if (op == 0) {

				opcaoMenu = 0;
			}

		}
	}
	
	/*
	 * Menu da aplicação, onde é momstrado as funcionalidades básicas do sistema e através de um switch-case cada função é chamada
	 */
	public static void menuDeOp() throws ParseException, IOException {
		int opcaoMenu = -1;

		while (opcaoMenu != 0) {

			String stringOpcaoMenu = JOptionPane.showInputDialog(null,
					"===============================================\n"
							+ "                                  Menu de Opções                  \n"
							+ "===============================================\n\n\n\n"

							+ " 1 -  Cadastrar manualmente\n\n\n" + " 2 -  Cadastrar via arquivo texto \n\n\n"
							+ " 3 -  Procurar carro para locação \n\n\n"
							+ " 4 -  Procurar carro para locação via arquivo texto \n\n\n"
							+ " 0 -  Sair do Programa  \n\n" + "\n ===============================================");

			if (stringOpcaoMenu != null) {
				if (stringOpcaoMenu.equals("")) {
					JOptionPane.showMessageDialog(null, "Informe uma opção!");

				} else {
					if (ErroNumero(stringOpcaoMenu)) {
						opcaoMenu = Integer.parseInt(stringOpcaoMenu);

						switch (opcaoMenu) {
						case 1:
							CadastroClientes();
							break;
						case 2:
							CadastrarViaTexto();
							break;
						case 3:
							ListarCarros();
							break;
						case 4:
							ListarViaTexto();
							break;

						case 0:
							JOptionPane.showMessageDialog(null, "Programa finalizado!!! Aperte ok para sair.");
							break;
						default:
							JOptionPane.showMessageDialog(null, "Opção invalida!!!");

						}// fim switch
					} else {

						JOptionPane.showMessageDialog(null, "Não foi digitado um numero!");

					}
				}
			}
		}
	}

	// testa se o que foi passado é de fato um numero
	private static boolean ErroNumero(String numero) {

		try {
			int codigo = Integer.parseInt(numero);
			return true;
		} catch (NumberFormatException err) {
			return false;
		}
	}

	// main da aplicação
	public static void main(String[] args) throws ParseException, IOException {

		JOptionPane.showMessageDialog(null,
				"==================================================================\n\n"
						+ "                                         Bem Vindo \n"
						+ "                 Sistema de Locação de Veículos \n\n"
						+ "==================================================================\n");
		menuDeOp();

	}

}
