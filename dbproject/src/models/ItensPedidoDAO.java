package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItensPedidoDAO {

    public static final String url = "jdbc:sqlite:/home/lm/Documents/Projects/DBProject/dbproject/data/database.db";

    public static void addItensPedido(int idPedido, int[][] produtosPedido){
        String sql = "INSERT INTO itens_pedido(pedido_id, produto_id, quantidade) VALUES (?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)){
            for(int i = 0; i < produtosPedido.length; i++){
                pstmt.setInt(1, idPedido);
                pstmt.setInt(2, produtosPedido[i][0]);
                pstmt.setInt(3, produtosPedido[i][1]);
                pstmt.executeUpdate();
            }
        }
        catch(SQLException e){

        }
    }
}
