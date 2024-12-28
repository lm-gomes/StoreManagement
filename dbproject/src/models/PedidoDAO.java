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

    public static void viewPedido(boolean detailView, int pedidoId){
        if(!detailView){
            String sql = "SELECT * from pedidos";
            try(Connection conn = DriverManager.getConnection(url); Statement pstmt = conn.createStatement(); ResultSet rs = pstmt.executeQuery(sql)){

                    if(!rs.isBeforeFirst()){
                        System.out.println("Não há pedidos.\n");
                    }

                    while(rs.next()){
                        System.out.printf("%-5d | %-10s | %-25s\n",
                        rs.getInt("id"),
                        rs.getString("data").toString(),
                        rs.getString("cliente_nome"));

                    }
                
            }

            catch(SQLException e){
                System.err.println(e);
            }
        }

        else{
            String sql = "SELECT \n" + //
                                "    pedidos.id AS pedido_id, \n" + //
                                "    pedidos.cliente_nome, \n" + //
                                "    pedidos.data,\n" + //
                                "    itens_pedido.produto_id, \n" + //
                                "    produtos.nome AS produto_nome, \n" + //
                                "    itens_pedido.quantidade\n" + //
                                "FROM \n" + //
                                "    pedidos\n" + //
                                "JOIN \n" + //
                                "    itens_pedido ON pedidos.id = itens_pedido.pedido_id\n" + //
                                "JOIN \n" + //
                                "    produtos ON itens_pedido.produto_id = produtos.id\n" + //
                                "WHERE \n" + //
                                "    pedidos.id = ?;";
            try(Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql);){
                pstmt.setInt(1, pedidoId);
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    
                    System.out.printf("%-4d | %-10s | %s | %-4d | %-10s | %-4d\n",
                    rs.getInt("pedido_id"),
                    rs.getString("cliente_nome"),
                    rs.getString("data").toString(),
                    rs.getInt("produto_id"),
                    rs.getString("produto_nome"),
                    rs.getInt("quantidade"));
                }
            }

            catch(SQLException e){
                System.err.println(e);
            }
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

    public static void delPedido(int id){
        String sql = "DELETE FROM pedidos WHERE id = ?";
        try(Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        catch(SQLException e){

        }
    }
    }

