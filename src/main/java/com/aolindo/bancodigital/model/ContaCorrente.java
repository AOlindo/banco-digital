package com.aolindo.bancodigital.model;

public class ContaCorrente extends Conta  {

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(Cliente cliente, Integer agencia, String numero, Double saldo) {
		super(cliente, agencia, numero, saldo);
		
	}


}
