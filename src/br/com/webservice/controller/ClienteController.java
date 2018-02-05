package br.com.webservice.controller;

import java.util.ArrayList;

import br.com.webservice.dao.ClienteDAO;
import br.com.webservice.model.Cliente;

public class ClienteController {

	ClienteDAO clienteDao = new ClienteDAO();

	public ArrayList<Cliente> listarTodos() {
		System.out.println("Consulta Realizada com sucesso!");
		return clienteDao.listarTodos();
	}

}
