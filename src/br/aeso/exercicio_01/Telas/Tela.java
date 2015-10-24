package br.aeso.exercicio_01.Telas;

import java.util.Scanner;

import br.aeso.exercicio_01.fachada.Fachada;
import br.aeso.exercicio_01.fornecedor.Fornecedor;
import br.aeso.exercicio_01.util.CPFInvalidoException;
import br.aeso.exercicio_01.util.CampoObrigatorioInvalidoException;
import br.aeso.exercicio_01.util.FornecedorInvalidoException;
import br.aeso.exercicio_01.util.FornecedorJaCadastradoException;

public class Tela {
		// 754.621.443-26
		// 345.135.354-74
		// 171.093.227-93
	public static Fachada fachada;

	
	
	public static void main(String []args){
		fachada = new Fachada();
		Scanner teclado = new Scanner(System.in);
		
		SolicitaAcao(teclado);
		
		//fachada.fecharConexaoJDBC();
				
	}

	private static Fornecedor SolicitaDadosFornecedor(Scanner teclado) {
		System.out.println("Informe os dados do fornecedor: ");
		System.out.println("Nome do fornecedor: ");
		String nome = teclado.next();
		System.out.println("CPF ou CNPJ do fornecedor: ");
		String cpf = teclado.next();
		System.out.println("Banco do fornecedor: ");
		String banco = teclado.next();
		
		Fornecedor fornecedor = new Fornecedor(nome, cpf, banco);
		return fornecedor;
		
	}

		private static void SolicitaAcao(Scanner teclado) {
			
			teclado.reset();
					
			System.out.println("1 - Cadastrar fornecedor");
			System.out.println("2 - Procurar fornecedor");
			System.out.println("3 - Atualizar fornecedor");
			System.out.println("4 - Remover fornecedor");
			System.out.println("5 - Listar fornecedores");
			System.out.println("6 - Sair do programa");
			
			int opcao = teclado.nextInt();
			switch (opcao) {
			case 1:
				Fornecedor fornecedor = SolicitaDadosFornecedor(teclado);
				
				try {
					fachada.cadastrarForn(fornecedor);
					System.out.println("Fornecedor cadastrado com sucesso! \n");
				} catch (FornecedorInvalidoException | CPFInvalidoException | FornecedorJaCadastradoException e1) {
					 //TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				SolicitaAcao(teclado);
				fornecedor = null;

				break;

			case 2:
				Fornecedor fornecedor2 = null;
				
				try {
					System.out.println("Entre com o CPF: ");
					String cpf3 = teclado.next();
					fornecedor2 = fachada.procurarForn(cpf3);
					System.out.println(fornecedor2 + "\n");
				} catch (CPFInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				SolicitaAcao(teclado);
				
				break;
			case 3:
				Fornecedor fornecedor3;
				try {
					System.out.println("Entre com o CPF: ");
					String cpf = teclado.next();
					fornecedor3 = fachada.procurarForn(cpf);
					System.out.println("Entre com o novo nome: ");
					String nome = teclado.next();
					System.out.println("Entre com o novo banco: ");
					String cnpj = teclado.next();
					fornecedor3.setNome(nome);
					fornecedor3.setCnpj(cnpj);
					fachada.atualizarForn(fornecedor3);
					System.out.println("Fornecedor atualizado com sucesso! \n");
				} catch (CPFInvalidoException e) {
					e.printStackTrace();
				} catch (CampoObrigatorioInvalidoException e) {
					e.printStackTrace();
				}
				
				SolicitaAcao(teclado);
				
				break;
				
			case 4:
				Fornecedor fornecedor4;
				try {
					System.out.println("Entre com o CPF: ");
					String cpf4 = teclado.next();
					fachada.removerForn(cpf4);
				} catch (CPFInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 5:
				try {
					fachada.listarForn();
				} catch (CPFInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 6:
				System.out.println("Você saiu do programa com sucesso!");
				break;			
			}
		}
	
	

}
