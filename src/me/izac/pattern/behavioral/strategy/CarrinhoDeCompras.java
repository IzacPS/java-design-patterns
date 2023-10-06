package me.izac.pattern.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

	//Lista de produtos
	List<Produto> produtos;
	
	public CarrinhoDeCompras(){
		this.produtos =new ArrayList<>();
	}
	
	public void adicionarProduto(Produto produto){
		this.produtos.add(produto);
	}
	
	public void removerProduto(Produto produto){
		this.produtos.remove(produto);
	}
	
	public int calculatarTotal(){
		int sum = 0;
		for(Produto produto : produtos){
			sum += produto.getPreco();
		}
		return sum;
	}
	
	public void pay(PagamentoStrategy paymentMethod){
		int valor = calculatarTotal();
		paymentMethod.pagamento(valor);
	}
}