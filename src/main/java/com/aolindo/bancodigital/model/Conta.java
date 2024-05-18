package com.aolindo.bancodigital.model;

import com.aolindo.bancodigital.exception.RegraBancoException;
import com.aolindo.bancodigital.service.ContaInterface;

public class Conta implements ContaInterface{

	private Integer agencia;
	private String numero;
	private Double saldo;
	private Cliente cliente;
	
	public Conta() {
		
	}
	public Conta(Cliente cliente, Integer agencia, String numero, Double saldo) {
		this.cliente = cliente;
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
	}
	
	@Override
	public void sacar(Double valor) {
		if(this.saldo > valor) {
			saldo -= valor;	
		}else {
			new RegraBancoException("Saldo Insuficiente");
		}
		
	}

	@Override
	public void depositar(Double valor) {
		if(saldo == null) {
			saldo = 0.0;
		}
		if (valor < 0) {
			new RegraBancoException("Depositar valor maior que 0");
		}else {
			this.saldo += valor;
		}
	}

	@Override
	public void transferir(Double valor, Conta contaDestino) {
		if (saldo > valor) {
			sacar(valor);
			contaDestino.depositar(valor);
		}else {
			new RegraBancoException("Transferencia invalida. Conta esta sem saldo");
		}
		
	}
	@Override
	public void imprimirExtrato() {
		System.out.println(String.format("Nome: %s", cliente.getNome() ));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %s", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	public Integer getAgencia() {
		return agencia;
	}

	public String getNumero() {
		return numero;
	}

	public Double getSaldo() {
		return saldo;
	}
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

	
	
	
	
}
