package br.aeso.exercicio_01.fornecedor;

import br.aeso.exercicio_01.endereco.Endereco;

public class Fornecedor {

	private Integer codigo;
	private String nome;
	private String cpf;
	private String banco;
	private Endereco endereco;
	
	public Fornecedor(Integer codigo, String nome, String cpf, String banco){
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.banco = banco;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String formatarCpf() {
		return cpf.substring(0, 3) + '.' + cpf.substring(3, 6) + '.' + 
			   cpf.substring(6, 9)+ '-' + cpf.substring(9, 11)
				;
	}

	@Override
	public String toString() {
		return "Fornecedor [codigo=" + codigo + ", nome=" + nome + ", cpf="
				+ cpf + ", banco=" + banco + "]";
	}
	
	
}
