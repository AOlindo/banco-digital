package com.aolindo.bancodigital.model;

public class ContaPoupanca extends Conta {

	public ContaPoupanca() {
		super();
		
	}

	public ContaPoupanca(Cliente cliente, Integer agencia, String numero, Double saldo) {
		super(cliente, agencia, numero, saldo);
	}


}
