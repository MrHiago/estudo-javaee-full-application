package br.com.casadocodigo.loja.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.Livro;

@Model
public class CarrinhoComprasBean {

	@Inject
	private LivroDao livroDao;

	@Inject
	private CarrinhoCompras carrinho;
	
	public String add(final Integer id) {
		Livro livro = this.livroDao.buscarPorId(id);
		CarrinhoItem item = new CarrinhoItem(livro);
		this.carrinho.add(item);
		return "carrinho?faces-redirect=true";
	}
	
	public List<CarrinhoItem> getItens(){
		return this.carrinho.getItens();
	}
	
	public void remover(CarrinhoItem item) {
		this.carrinho.remover(item);
	}
}
