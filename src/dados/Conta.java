/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.Date;

/**
 *
 * @author hnr
 */
public class Conta {
    
    private int id;
    private String descricao;
    private double valor;
    private String data;
    private String tipoMovimentacao;
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public String getTipoMovimentacao(){
        return tipoMovimentacao;
    }
    
    public void setTipoMovimentacao(String tipoMovimentacao){
        this.tipoMovimentacao = tipoMovimentacao;
    }
    
}
