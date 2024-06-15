package br.lawtrel.pdv.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Venda implements Serializable {
    private int codVenda;
    private LocalDate data;
    private double valor;
    private boolean pago;
    private List<Produto> itensdeVenda;
    private String formaDePagamento;

    //private Cliente cliente;
    public  Venda() {

    }
    public  Venda(int codVenda, LocalDate data, double valor, boolean pago,String formaDePagamento) {
        this.codVenda = codVenda;
        this.data = data;
        this.valor = valor;
        this.pago = pago;
        this.formaDePagamento = formaDePagamento;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public LocalDate getData() {
        return  data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean getPago() {
        return  pago;
    }

    public void setPago(boolean pago) {this.pago = pago;}

    public List<Produto> getItensdeVenda() {
        return itensdeVenda;
    }

    public void setItensdeVenda(List<Produto> itensdeVenda) {
        this.itensdeVenda = itensdeVenda;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }
    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

}
