package models;

public class Produto {
    public int id;
    public String nome;
    public int quantidade;
    public float preco;

    public Produto(){
        nome = "?";
        quantidade = 0;

    }

    public Produto(String nome, int quantidade){
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public float getPreco(){
        return preco;
    }

    public void setPreco(float preco){
        this.preco = preco;
    }
}
