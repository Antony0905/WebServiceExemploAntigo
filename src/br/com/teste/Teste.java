package br.com.teste;

import br.com.webservice.dao.ClienteDAO;
import br.com.webservice.model.Cliente;

public class Teste {

	public static void main(String[] args) {

		Cliente cliente = new Cliente();
		ClienteDAO dao = new ClienteDAO();

		cliente.setNome("João");
		cliente.setCpf("1212321321");
		cliente.setId(22);
		cliente.setEndereco("rua asdadaasdsda");
		
		Boolean result = dao.inserir(cliente);

		System.out.println(result);
	}
}
