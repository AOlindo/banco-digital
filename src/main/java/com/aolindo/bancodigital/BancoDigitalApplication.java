package com.aolindo.bancodigital;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aolindo.bancodigital.exception.RegraBancoException;
import com.aolindo.bancodigital.model.Cliente;
import com.aolindo.bancodigital.model.Conta;
import com.aolindo.bancodigital.model.ContaCorrente;
import com.aolindo.bancodigital.model.ContaPoupanca;

@SpringBootApplication
public class BancoDigitalApplication {

	static Scanner entrada = new Scanner(System.in);
	static ContaCorrente cc = new ContaCorrente();
	static ContaPoupanca cp = new ContaPoupanca();

	public static void main(String[] args) {

		Integer numero = 0;

		var opcao = exibirMenu();
		while (opcao != 6) {
			try {
				switch (opcao) {
				case 1:
					abrirConta();
					break;
				case 2:
					realizarDeposito();
					break;
				case 3:
					realizarSaque();
					break;
				case 4:
					realizarTransferencia();
					break;
				case 5:
					consultarSaldo();
					break;

				}
			} catch (RegraBancoException e) {
				System.out.println("Erro: " + e.getMessage());
				System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu");
				entrada.next();
			}
			opcao = exibirMenu();
		}

		System.out.println("Finalizando a aplicação.");
	}

	private static void abrirConta() {
		Cliente cliente = new Cliente();
		System.out.println("Informe seu nome: ");
		String nome = entrada.next();
		cliente.setNome(nome);
		System.out.println("Deseja abrir conta corrente ou poupanca? 1 - Conta Corrente 2 - Conta Poupança");
		int opcao = entrada.nextInt();
		System.out.println("Agencia: ");
		Integer agencia = entrada.nextInt();
		System.out.println("Numero: ");
		String numero = entrada.next();
		System.out.println("SaldoInicial: ");
		Double saldo = entrada.nextDouble();
		if (opcao == 1) {
			cc.setCliente(cliente);
			cc.setAgencia(agencia);
			cc.setNumero(numero);
			cc.setSaldo(saldo);
			System.out.println("Conta corrente criada com sucesso");
		} else if (opcao == 2) {
			cp.setCliente(cliente);
			cp.setAgencia(agencia);
			cp.setNumero(numero);
			cp.setSaldo(saldo);
			System.out.println("Conta poupanca criada com sucesso");
		} else {
			System.out.println("Opcao invalida!");
		}

	}

	private static void realizarDeposito() {
		System.out.println("Qual a conta deseja realizar o deposito? 1 - Conta Corrente 2 - Conta Poupança");
		int opcao = entrada.nextInt();
		if (opcao == 1) {
			depositar(cc);
		} else if (opcao == 2) {
			depositar(cp);
		} else {
			System.out.println("Opcao invalida!");
		}

	}

	public static void depositar(Conta conta) {
		System.out.println("Informe valor para deposito: ");
		Double valorDeposito = entrada.nextDouble();
		conta.depositar(valorDeposito);
		System.out.println("Valor depositado");
	}

	private static void realizarSaque() {
		System.out.println("Qual a conta deseja realizar o saque? 1 - Conta Corrente 2 - Conta Poupança");
		int opcao = entrada.nextInt();
		if (opcao == 1) {
			sacar(cc);
		} else if (opcao == 2) {
			sacar(cp);
		} else {
			System.out.println("Opcao invalida!");
		}

	}

	public static void sacar(Conta conta) {
		System.out.println("Informe valor para saque: ");
		Double valorSaque = entrada.nextDouble();
		conta.sacar(valorSaque);
		System.out.println("Saque realizado");
	}

	private static void realizarTransferencia() {
		System.out.println("Qual a conta deseja realizar a transferencia? 1 - Conta Corrente 2 - Conta Poupança");
		int opcao = entrada.nextInt();
		System.out.println("Informe valor de transferencia");
		Double valorTransferencia = entrada.nextDouble();
		if (opcao == 1) {
			cc.transferir(valorTransferencia, cp);
		} else if (opcao == 2) {
			cp.transferir(valorTransferencia, cc);
		} else {
			System.out.println("Opcao invalida!");
		}

	}

	public static void transferir(Conta conta, Double valorTransferencia) {
		conta.transferir(valorTransferencia, conta);
		System.out.println("Transferencia realizada");
	}

	private static void consultarSaldo() {
		System.out.println("Qual a conta deseja imprimir extrato? 1 - Conta Corrente 2 - Conta Poupança");
		int opcao = entrada.nextInt();
		if (opcao == 1) {
			System.out.println("==== Extato Conta Corrente ====");
			cc.imprimirExtrato();

		} else {
			System.out.println("==== Extato Conta Poupanca ====");
			cp.imprimirExtrato();

		}

	}

	private static int exibirMenu() {
		System.out.println("""
				BANCO DIGITAL - ESCOLHA UMA OPÇÃO:
				1 - Abertura de conta
				2 - Realizar depósito em uma conta
				3 - Realizar saque em uma conta
				4 - Realizar transferência
				5 - Consultar saldo
				9 - Sair
				""");
		return entrada.nextInt();
	}

}
