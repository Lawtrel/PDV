package br.lawtrel.pdv.Model;

public class Produto {
    private String codProduto;
    private String name;
    private int quantity;
    private double price;



    public Produto() {}

    public Produto(String codProduto,String name, int quantity, double price) {
        this.codProduto = codProduto;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCodProduto() {
        return codProduto;
    }

    public  void  setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setDescricao(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return name;
    }

    public void setCodigo(String codProduto) {
        this.codProduto = codProduto;
    }

    public String getCodigo() {
        return codProduto;
    }

    public void setQuantidade(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantidade() {
        return quantity;
    }

    public void setPreco(int price) {
        this.price = price;
    }

    public double getPreco() {
        return price;
    }
}
