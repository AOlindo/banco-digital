# Banco Digital

Este projeto é uma aplicação Java que simula as operações básicas de um banco digital, permitindo a abertura de contas, realização de depósitos, saques, transferências e consultas de saldo.

## Funcionalidades

- **Abrir Conta**: Permite abrir uma conta corrente ou poupança.
- **Realizar Depósito**: Realiza depósitos em contas.
- **Realizar Saque**: Realiza saques de contas.
- **Realizar Transferência**: Permite transferir saldo entre contas.
- **Consultar Saldo**: Exibe o extrato da conta.

## Estrutura do Projeto

### Classes Principais

- **BancoDigitalApplication**: Classe principal que gerencia a interação com o usuário e as operações bancárias.
- **Cliente**: Classe que representa o cliente do banco.
- **Conta**: Classe que define os atributos e métodos comuns a todas as contas.
- **ContaCorrente**: Classe que representa uma conta corrente.
- **ContaPoupanca**: Classe que representa uma conta poupança.

### Diagrama de Classes

```plaintext
  Cliente
     |
   Conta
   /    \
ContaCorrente ContaPoupanca
