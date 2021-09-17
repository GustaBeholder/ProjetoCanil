package br.com.gustavolemillion.dao;



import br.com.gustavolemillion.entity.Cliente;
import br.com.gustavolemillion.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public List<Cliente> retornaCliente() throws RuntimeException {
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        Cliente cliente;
        String sql = "SELECT * FROM cliente";

        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){

                cliente = new Cliente();
                cliente.setId(rs.getInt("idCliente"));
                cliente.setNomePessoa(rs.getString("nomePessoa"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNascimento(rs.getDate("dataNascimento"));
                cliente.setCep(rs.getString("cep"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumeroEndereco(rs.getString("numeroEndereco"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));

                listaCliente.add(cliente);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaCliente;
    }

    public void adcionaCliente(Cliente cliente) throws RuntimeException {
        String sql = "insert into cliente (nomePessoa, cpf, rg, dataNascimento, cep, rua, numeroEndereco, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);

            stmt.setString(1, cliente.getNomePessoa());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setDate(4, cliente.getDataNascimento());
            stmt.setString(5, cliente.getCep());
            stmt.setString(6, cliente.getRua());
            stmt.setString(7, cliente.getNumeroEndereco());
            stmt.setString(8, cliente.getBairro());
            stmt.setString(9, cliente.getCidade());
            stmt.setString(10, cliente.getEstado());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editaCliente(int id, Cliente novoCliente) throws RuntimeException {
        String sql = "update cliente set nomePessoa = '"+novoCliente.getNomePessoa()+"',cpf = '"+novoCliente.getCpf()+"', rg = '"+
                novoCliente.getRg()+"', dataNascimento = "+novoCliente.getDataNascimento()+", cep = ,'"+novoCliente.getCep()+
                "', rua = '"+novoCliente.getRua()+"', numeroEndereco = '"+novoCliente.getNumeroEndereco()+"', bairro = '"+novoCliente.getBairro()+
                "', cidade = '"+novoCliente.getCidade()+"', estado = '"+novoCliente.getEstado()+"' where id = "+id;
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.execute();
            stmt.close();
            System.out.println("Atualizado!");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public void deletaCliente(Cliente cliente) throws RuntimeException{
        String sql = "delete from cliente where idCliente = "+ cliente.getId();
        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.execute();
            stmt.close();
            System.out.println("Deletado!");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTelefone(Cliente cliente) throws  RuntimeException{
        String sql = "delete from Telefone_Cliente where idCliente = "+ cliente.getId();
        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.execute();
            stmt.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteReservaCliente(Cliente cliente) throws  RuntimeException{
        String sql = "delete from reserva where idCliente = "+ cliente.getId();
        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.execute();
            stmt.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
