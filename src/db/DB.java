package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    /**
     * Estabelece conexão com o banco de dados
     * por meio da interface Connection recebendo a URL do BD e as propriedades do arquivo
     * @return Connection
     */
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                //dburl está em db.properties
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
                System.out.println("Conexão feita");
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    /**
     * Encerra a conexão com o banco de dados
     */
    public static void closeConnection(){
        if(conn != null){
            try {
                conn.close();
                System.out.println("Desconectado com o BD");
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    /**
     * Faz a leitura do caminho do Banco de Dados
     * @return retorna suas propriedades do tipo Properties
     */
    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            System.out.println("Carregando URL");
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    /**
     * Encerra o objeto Statement
     * @param statement
     */
    public static void closeStatement(Statement statement){
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    /**
     * Encerra o objeto ResultSet
     * @param resultSet
     */
    public static void closeResultSet(ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
