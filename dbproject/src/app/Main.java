package app;
import database.DatabaseConnection;
import models.ProdutoDAO;
import controllers.ProdutoCON;


import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //Estabelece conexão com o banco de dados.
        DatabaseConnection.connection();
        int userInput = 0;
        Scanner scanner = new Scanner(System.in);
        while(true){
                System.out.println("[1]Consultar produtos\n[2]Cadastrar produto\n[3]Remover produto\n[4]Sair\n>");
                userInput = scanner.nextInt();
                scanner.nextLine();
                if(userInput == 4){
                    System.out.println("Fim do programa!");
                    break;
                }

                switch(userInput){
                    case 1:{
                        ProdutoDAO.viewProduto();
                        break;
                    }

                    case 2:{
                        ProdutoCON.newProduto();
                        System.out.println("Produto adicionado!\n");
                        break;
                        
                    }

                    case 3:{
                        ProdutoCON.rmProduto();
                        System.out.println("Produto removido!");
                        break;
                    }

                    case 4:{

                        break;
                    }

                    default:{

                    }
                
            }

        }

        scanner.close();
    }   
}
