package controllers;
import java.util.Scanner;
import models.Produto;
import models.ProdutoDAO;

public class ProdutoCON {
    public static void newProduto(){

        Produto produto = new Produto();
        Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome do produto: ");
            String nameProduct = scanner.nextLine();
            System.out.println("Digite a quantidade: ");
            int qtdProduct = scanner.nextInt();
            System.out.println("Digite o preco: ");
            float priceProduct = scanner.nextFloat();

            produto.setNome(nameProduct);
            produto.setQuantidade(qtdProduct);
            produto.setPreco(priceProduct);
            scanner.nextLine();
            
            ProdutoDAO.addProduto(nameProduct, qtdProduct, priceProduct);
        }

    public static void rmProduto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do prduto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        ProdutoDAO.delProduto(id);
    }
    
}
