package controllers;

import java.util.Scanner;

import models.PedidoDAO;
import models.ProdutoDAO;

import java.text.SimpleDateFormat;
import java.util.Date;


public class PedidoCON {
    public static void newPedido(){
        Scanner scanner = new Scanner(System.in);

        // Registra a data em que o pedido é feito.
        Date date = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Digite o nome do cliente: ");
        String pedidoName = scanner.nextLine();
        System.out.println("Quantos produtos?\n>>");
        int pedidoQtd = scanner.nextInt();
        int pedidoProdutos[][] = new int[pedidoQtd][2];

        
        for(int i = 0; i < pedidoQtd; i++){
            System.out.printf("Digite o ID do produto %d: ", i);
            int produtoId = scanner.nextInt();
            System.out.println("Digite a quantidade: ");
            int produtoQtd = scanner.nextInt();
            pedidoProdutos[i][0] = produtoId;
            pedidoProdutos[i][1] = produtoQtd; 
            
        }
        PedidoDAO.addPedido(pedidoName, simpleDate.format(date), pedidoProdutos);
    }

     public static void rmPedido(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do pedido: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        PedidoDAO.delPedido(id);
    }

    public static void detailsPedido(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do pedido: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        PedidoDAO.viewPedido(true, id);
        
    }
}
