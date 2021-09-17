package br.com.gustavolemillion.dao;


import br.com.gustavolemillion.entity.Reserva;
import br.com.gustavolemillion.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ReservaDAO {

    private Connection connection;

    public ReservaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public List<Reserva> retornaReserva() throws RuntimeException{
        List<Reserva> listaReserva = new ArrayList<Reserva>();
        Reserva reserva;
        String sql = "SELECT * FROM reserva";

        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setIdCachorro(rs.getInt("idCachorro"));
                reserva.setIdCliente(rs.getInt("idCliente"));
                reserva.setDataReserva(rs.getDate("dataReserva"));
                reserva.setPagoReserva(rs.getString("pagoReserva"));
                reserva.setPagoIntegral(rs.getString("pagoIntegral"));
                reserva.setEntrega(rs.getString("entregue"));
                reserva.setValorReserva(rs.getDouble("valorReserva"));
                reserva.setValorIntegral(rs.getDouble("valorIntegral"));
                reserva.setFormaEntrega(rs.getString("formaEntrega"));
                reserva.setFormaPagamento(rs.getString("formaPagamento"));
                listaReserva.add(reserva);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }





        return listaReserva;
    }

    public void criaReserva(Reserva reserva) throws RuntimeException{
        String sql = "INSERT into reserva (idCachorro, idCliente, dataReserva, pagoReserva, pagoIntegral, entregue, valorReserva, valorIntegral, formaEntrega, formaPagamento) values (?,?,?,?,?,?,?,?,?,?)";

        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql);

            stmt.setInt(1, reserva.getIdCachorro());
            stmt.setInt(2, reserva.getIdCliente());
            stmt.setDate(3, reserva.getDataReserva());
            stmt.setString(4, reserva.getPagoReserva());
            stmt.setString(5, reserva.getPagoIntegral());
            stmt.setString(6, reserva.getEntrega());
            stmt.setDouble(7, reserva.getValorReserva());
            stmt.setDouble(8, reserva.getValorIntegral());
            stmt.setString(9, reserva.getFormaEntrega());
            stmt.setString(10, reserva.getFormaPagamento());
            stmt.execute();
            stmt.close();
            System.out.println("Reserva feita!");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }


    }

    public void editaReserva(int id, Reserva novaReserva) throws RuntimeException, SQLException {
        String sql = "UPDATE reserva set idCachorro = " + novaReserva.getIdCachorro() + ",idCliente = " + novaReserva.getIdReserva() +
                ", dataReserva = '" + novaReserva.getDataReserva() + "',pagoReserva = '" + novaReserva.getPagoReserva() +
                "', pagoIntegral = '" + novaReserva.getPagoIntegral() + "', entregue = '" + novaReserva.getEntrega() + "', valorReserva = " + novaReserva.getValorReserva() +
                ", valorIntegral = " + novaReserva.getValorIntegral() + ", formaEntrega = '" + novaReserva.getFormaEntrega() + "', formaPagamento = '" + novaReserva.getFormaPagamento() + "'  where idReserva = " + id;
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        System.out.println("Atualizado!");
    }

    public void deletaReserva(Reserva reserva) throws RuntimeException, SQLException{
        String sql = "delete from reserva where idReserva = "+ reserva.getIdReserva();

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        System.out.println("Deletado!");
    }

}
