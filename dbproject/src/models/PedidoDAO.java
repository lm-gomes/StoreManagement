package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import models.ItensPedidoDAO;

public class PedidoDAO {
    public static final String url = "jdbc:sqlite:/home/lm/Documents/Projects/DBProject/dbproject/data/database.db";

    public static void viewPedido(){
        String sql = "SELECT * from pedidos";
        try(Connection conn = DriverManager.getConnection(url); Statement pstmt = conn.createStatement(); ResultSet rs = pstmt.executeQuery(sql)){
            
                while(rs.next()){
                    System.out.printf("%-5d | %-10s | %-25s\n",
                    rs.getInt("id"),
                    rs.getString("data").toString(),
                    rs.getString("cliente_nome"));

                }
            
        }

        catch(SQLException e){

        }
    }

    public static void addPedido(String cliente_nome, String data, int[][] produtosPedido){
        String sql = "INSERT INTO pedidos (data, cliente_nome) VALUES (?, ?)";
        try(Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, data);
            pstmt.setString(2, cliente_nome);
            pstmt.executeUpdate();

            ResultSet keys = pstmt.getGeneratedKeys();
            while(keys.next()){
                int idGenerated = keys.getInt(1);
                ItensPedidoDAO.addItensPedido(idGenerated, produtosPedido);
            }

        }

        catch(SQLException e){

        }

    }
}
