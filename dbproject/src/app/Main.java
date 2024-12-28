package app;
import database.DatabaseConnection;
import models.ProdutoDAO;
import controllers.PedidoCON;
import controllers.ProdutoCON;
import models.PedidoDAO;


import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //Estabelece conexão com o banco de dados.
        DatabaseConnection.connection();
        int userInput = 0;
        int userInputMenu = 0;
        Scanner scanner = new Scanner(System.in);
        while(true){
                System.out.println("[1]Pedidos\n[2]Produtos\n[3]Sair\n>");
                userInput = scanner.nextInt();
                scanner.nextLine();
                if(userInput == 3){
                    System.out.println("Fim do programa!");
                    break;
                }

                switch(userInput){
                    
                    case 1:{
                        System.out.println("[1]Consultar pedidos\n[2]Cadastrar pedido\n[3]Atualizar pedido\n[4]Remover pedido\n>>");
                        userInputMenu = scanner.nextInt();
                        scanner.nextLine();
                        if(userInputMenu == 1){
                            PedidoDAO.viewPedido(false, 0);
                            System.out.println("[1]Detalhes do pedido \\ [0]Voltar\n>");
                            userInputMenu = scanner.nextInt();
                            if(userInputMenu == 1){
                                PedidoCON.detailsPedido();
                                
                            }
                        }
                        else if(userInputMenu == 2){
                            PedidoCON.newPedido();
                            System.out.println("Pedido adicionado!\n");
                        }

                        else if(userInputMenu == 4){
                            PedidoCON.rmPedido();
                            System.err.println("Pedido removido!");

                        }
                        break;
                    }

                    case 2:{
                        System.out.println("[1]Consultar produtos\n[2]Cadastrar produto\n[3]Atualizar produto\n[4]Remover produto\n>> ");
                        userInputMenu = scanner.nextInt();
                        if(userInputMenu == 1){
                            ProdutoDAO.viewProduto();
                        }
                        else if(userInputMenu == 2){
                            ProdutoCON.newProduto();
                            System.out.println("Produto adicionado!\n");
                        }
                        else if(userInputMenu == 3){
                            System.out.println("!Implement Update!\n");
                        }
                        else if(userInputMenu == 4){
                            ProdutoCON.rmProduto();
                            System.out.println("Produto removido!\n");
                        }

                        else{
                            System.out.println("Paia");
                        }
                        
                        break;
                        
                    }

                    case 3:{
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
