package br.lawtrel.pdv.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produto {

    private StringProperty codigo;
    private StringProperty descricao;
    private int quantidade;
    private int preco;

    public Produto(String codigo, String descricao, int quantidade, int preco) {
        this.codigo = new SimpleStringProperty(codigo);
        this.descricao = new SimpleStringProperty(descricao);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Produto(StringProperty codigo, StringProperty descricao) {

        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Produto() {
        this.codigo = new SimpleStringProperty();
        this.descricao = new SimpleStringProperty();
        this.quantidade = 0;
        this.preco = 0;

    }

    public StringProperty codigoProperty() {
        return codigo;
    }

    public String getCodigo() {
        return codigo.get();
    }

    public void setCodigo(String codigo) {
        this.codigo.set(codigo);

    }

    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPreco() {
        return preco;
    }


    public void setPreco(int preco) {
        this.preco = preco;

    }
}
