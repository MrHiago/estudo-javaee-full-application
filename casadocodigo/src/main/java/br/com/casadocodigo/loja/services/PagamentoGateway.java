package br.com.casadocodigo.loja.services;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import br.com.casadocodigo.loja.models.Pagamento;

public class PagamentoGateway implements Serializable {

	private static final long serialVersionUID = 1L;

	public String pagar(BigDecimal valorTotal) {
		Pagamento pagamento = new Pagamento(valorTotal);
		String target = "http://book-payment.herokapp.com/payment";
		Client client = ClientBuilder.newClient();
		Entity<Pagamento> json = Entity.json(pagamento);
		return client.target(target).request().post(json, String.class);
	}
}
