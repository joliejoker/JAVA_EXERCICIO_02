package br.aeso.execicio_01.generico;
import java.util.ArrayList;


public interface IRepositorioArrayList<T> {
	
	public void cadastrar(T obj);
	public T procurar(String cpf);
	public void atualizar(String cpf, T obj);
	public void remover(String cpf);
	public ArrayList<T> listar();
	}
