package br.aeso.exercicio_01.endereco;
import br.aeso.exercicio_01.fornecedor.Fornecedor;

public class Endereco {
	
	private Fornecedor fornecedor;
	private Endereco endereco;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	
	public Endereco(Fornecedor fornecedor, String rua, String numero, String complemento, 
			String bairro, String cidade, String cep){
		this.fornecedor = fornecedor;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;		
	}
	
	public Fornecedor getfornecedor(){
		return fornecedor;
	}
	public void setfornecedor(Fornecedor fornecedor){
		this.fornecedor = fornecedor;
	}
	
	public String getrua(){
		return rua;
	} 
	public void set(String rua){
		this.rua = rua;
	}
	
	public String getnumero(){
		return numero;
	}
	public void setnumero(String numero){
		this.numero = numero;
	}
	
	public String getcomplemento(){
		return complemento;
	}
	public void setcomplemento(){
		this.complemento = complemento;
	}
	
	public String getbairro(){
		return bairro;
	}
	public void setbairro(){
		this.bairro = bairro;
	}
	
	public String getcidade(){
		return cidade;
	}
	public void setcidade(){
		this.cidade = cidade;
	}
	
	public String getcep(){
		return cep;
	}
	public void setcep(){
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [fornecedor=" + fornecedor + ", rua=" + rua + ", numero=" + numero + ", complemento="
				+ complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + "]";
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
