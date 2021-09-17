package br.com.gustavolemillion.factory;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            return (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "canil", "SenhaCanil");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
