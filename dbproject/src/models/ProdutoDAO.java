package models;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ProdutoDAO {
    public static final String url = "jdbc:sqlite:/home/lm/Documents/Projects/DBProject/dbproject/data/database.db";

    public static void delProduto(int id){
        String sql = "DELETE FROM produtos WHERE id = ?";
        try(Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        catch(SQLException e){

        }
    }

    public static void viewProduto(){
        String sql = "SELECT * from produtos";
        try(Connection conn = DriverManager.getConnection(url); Statement pstmt = conn.createStatement(); ResultSet rs = pstmt.executeQuery(sql)){
            while(rs.next()){
                System.out.printf("%-5d | %-5s | %-5f | %-5d\n",
                 rs.getInt("id"),
                  rs.getString("nome"),
                  rs.getFloat("preco"),
                  rs.getInt("quantidade"));
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }


    }


    public static void addProduto(String name, int quantidade, float preco){
        
        String sql = "INSERT INTO produtos (nome, quantidade, preco) VALUES (?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, name);
            pstmt.setInt(2, quantidade);
            pstmt.setFloat(3, preco);
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            
        }
    }
}
