package com.aolindo.bancodigital.service;

import com.aolindo.bancodigital.model.Conta;

public interface ContaInterface {

	void sacar(Double valor);
	void depositar(Double valor);
	void transferir(Double valor, Conta contaDestino);
	void imprimirExtrato();
}
