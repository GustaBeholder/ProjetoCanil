package br.com.gustavolemillion.dao;

import br.com.gustavolemillion.entity.Cachorro;
import br.com.gustavolemillion.factory.ConnectionFactory;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CachorroDAO {

    private Connection connection;

    public CachorroDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<Cachorro> retornaMatriz() throws RuntimeException{
        List<Cachorro> listaCachorro = new ArrayList<Cachorro>();
        Cachorro cachorro;
        String sql = "SELECT * FROM cachorro where tipo = 'mãe'";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){

                cachorro = new Cachorro();
                cachorro.setId(rs.getInt("idCachorro"));
                cachorro.setNome(rs.getString("nome"));
                cachorro.setNomeMae(rs.getString("nomeMae"));
                cachorro.setNomePadreador(rs.getString("nomePadreador"));
                cachorro.setNumeroPedigree(rs.getString("numeroPedigree"));
                cachorro.setNumeroMicrochip(rs.getString("numeroMicrochip"));
                cachorro.setDono(rs.getString("dono"));
                cachorro.setTipo(rs.getString("tipo"));
                cachorro.setSexo(rs.getString("Sexo"));

                listaCachorro.add(cachorro);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listaCachorro;
    }

    public List<Cachorro> retornaFilhotes() throws RuntimeException{
        List<Cachorro> listaCachorro = new ArrayList<Cachorro>();
        Cachorro cachorro;
        String sql = "SELECT * FROM cachorro where tipo = 'filhote'";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){

                cachorro = new Cachorro();
                cachorro.setId(rs.getInt("idCachorro"));
                cachorro.setNome(rs.getString("nome"));
                cachorro.setNomeMae(rs.getString("nomeMae"));
                cachorro.setNomePadreador(rs.getString("nomePadreador"));
                cachorro.setNumeroPedigree(rs.getString("numeroPedigree"));
                cachorro.setNumeroMicrochip(rs.getString("numeroMicrochip"));
                cachorro.setDono(rs.getString("dono"));
                cachorro.setTipo(rs.getString("tipo"));
                cachorro.setSexo(rs.getString("Sexo"));

                listaCachorro.add(cachorro);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listaCachorro;
    }

    public List<Cachorro> retornaPadreador() throws RuntimeException{
        List<Cachorro> listaCachorro = new ArrayList<Cachorro>();
        Cachorro cachorro;
        String sql = "SELECT * FROM cachorro where tipo = 'padreador'";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){

                cachorro = new Cachorro();
                cachorro.setId(rs.getInt("idCachorro"));
                cachorro.setNome(rs.getString("nome"));
                cachorro.setNomeMae(rs.getString("nomeMae"));
                cachorro.setNomePadreador(rs.getString("nomePadreador"));
                cachorro.setNumeroPedigree(rs.getString("numeroPedigree"));
                cachorro.setNumeroMicrochip(rs.getString("numeroMicrochip"));
                cachorro.setDono(rs.getString("dono"));
                cachorro.setTipo(rs.getString("tipo"));
                cachorro.setSexo(rs.getString("Sexo"));

                listaCachorro.add(cachorro);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listaCachorro;
    }

    public void adicionaCachorro(Cachorro cachorro) throws RuntimeException {
        String sql = "insert into cachorro (nome,nomeMae,nomePadreador,numeroPedigree, numeroMicrochip, dono, tipo, sexo) values (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);

            stmt.setString(1, cachorro.getNome());
            stmt.setString(2, cachorro.getNomeMae());
            stmt.setString(3, cachorro.getNomePadreador());
            stmt.setString(4, cachorro.getNumeroPedigree());
            stmt.setString(5, cachorro.getNumeroMicrochip());
            stmt.setString(6, cachorro.getDono());
            stmt.setString(7, cachorro.getTipo());
            stmt.setString(8, cachorro.getSexo());
            stmt.execute();
            stmt.close();
            System.out.println("Adcionado!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editaCachorro(int id, Cachorro novoCachorro) throws RuntimeException, SQLException {
        String sql = "UPDATE cachorro set nome = '"+ novoCachorro.getNome() +"',nomeMae = '"+ novoCachorro.getNomeMae()+
                "', nomePadreador = '"+novoCachorro.getNomePadreador()+"',numeroPedigree = '"+novoCachorro.getNumeroPedigree()+
                "', numeroMicrochip = '"+novoCachorro.getNumeroMicrochip()+"', dono = '"+novoCachorro.getDono()+"', tipo = '"+novoCachorro.getTipo()+
                "', sexo = '"+novoCachorro.getSexo()+"' where idCachorro = "+id;
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        System.out.println("Atualizado!");
    }

    public void deletaCachorro(Cachorro cachorro) throws RuntimeException, SQLException{

        String sql = "delete from cachorro where idCachorro = "+ cachorro.getId();

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.execute();
        stmt.close();
        System.out.println("Deletado!");
    }

    public void deletaCarteiraVacinacao(Cachorro cachorro) throws RuntimeException, SQLException{
        String sql = "delete from Carteira_Vacinacao where idCachorro = "+ cachorro.getId();

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.execute();
        stmt.close();
    }

    public  void deletaPrescricaoTratamento(Cachorro cachorro)throws RuntimeException, SQLException{
        String sql = "delete from Prescricao_Tratamento where idCachorro = "+ cachorro.getId();

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.execute();
        stmt.close();
    }

    public  void deletaPrescricaoAlimentacao(Cachorro cachorro)throws RuntimeException, SQLException{
        String sql = "delete from Prescricao_Alimentacao where idCachorro = "+ cachorro.getId();

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.execute();
        stmt.close();
    }

    public  void deletaPrescricaoReserva(Cachorro cachorro)throws RuntimeException, SQLException{
        String sql = "delete from reserva where idCachorro = "+ cachorro.getId();

        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.execute();
        stmt.close();
    }
}
