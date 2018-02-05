package br.com.webservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.webservice.factory.ConnectionFactory;
import br.com.webservice.model.Cliente;

public class ClienteDAO extends ConnectionFactory {

	private static ClienteDAO instance;

	public static ClienteDAO getInstance() {
		if (instance == null)
			instance = new ClienteDAO();
		return instance;
	}

	public Boolean inserir(Cliente cliente) {
		Connection conexao = null;
		conexao = criarConexao();
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement("insert into cliente values (" + cliente.getId() + ",'" + cliente.getNome()
					+ "','" + cliente.getCpf() + "','" + cliente.getEndereco() + "')");
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	public ArrayList<Cliente> listarTodos() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> clientes = null;

		conexao = criarConexao();
		clientes = new ArrayList<Cliente>();
		try {
			pstmt = conexao.prepareStatement("select * from cliente order by nome");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();

				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));

				clientes.add(cliente);
			}

		} catch (Exception e) {
			System.out.println("Erro ao listar todos os clientes: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return clientes;
	}

}
