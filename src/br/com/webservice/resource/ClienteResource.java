package br.com.webservice.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.webservice.controller.ClienteController;
import br.com.webservice.model.Cliente;

@Path("/cliente")
public class ClienteResource {

	@GET
	@Path("/listarTodos")
	@Produces("application/xml")
	public ArrayList<Cliente> listarTodos(){
		return new ClienteController().listarTodos();
	}
}
