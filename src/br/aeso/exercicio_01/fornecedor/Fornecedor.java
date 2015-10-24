package br.aeso.exercicio_01.fornecedor;

import br.aeso.exercicio_01.endereco.Endereco;

public class Fornecedor {

	private int codigo;
	private String nome;
	private String cpf;
	private String cnpj;
	private Endereco endereco;
	
	public Fornecedor(String nome, String cpf, String cnpj){
		this.nome = nome;
		this.cpf = cpf;
		this.cnpj = cnpj;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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
		this.cpf = cpf;//replaceAll("\\.|\\-|\\ ", "");
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	/*
	public String formatarCpf() {
		return cpf.substring(0, 3) + '.' + cpf.substring(3, 6) + '.' + 
			   cpf.substring(6, 9)+ '-' + cpf.substring(9, 11)
				;
	}
	*/

	@Override
	public String toString() {
		return "Fornecedor" +"/n" + "codigo=" + codigo + ", cpf=" + cpf + ", cnpj="
				+ cnpj + ", nome=" + nome;
	}
	
	
}
