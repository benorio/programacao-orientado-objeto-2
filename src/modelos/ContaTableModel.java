/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import dados.Conta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hnr
 */
public class ContaTableModel extends AbstractTableModel{
    
    private List<Conta> dados = new ArrayList<>();
    private String[]colunas = {"Id","Descricao","Valor","Data","Tipo de Movimentação"};
    //private ArrayList<String[]> ResultSets;

    
    /*public ContaTableModel(ResultSet rs) throws SQLException {
        setResult(rs);
    } */
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getDescricao();
            case 2:
                return dados.get(linha).getValor();
            case 3:
                return dados.get(linha).getData();
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
         
        switch(coluna){
            case 0:
                dados.get(linha).setId(Integer.parseInt((String)valor));
                break;
            case 1:
                dados.get(linha).setDescricao((String)valor);
                break;
            case 2:
                dados.get(linha).setValor(Double.parseDouble((String)valor));
                break;
            case 3:
                dados.get(linha).setData((String)valor);
                break;
        }
        
        this.fireTableRowsUpdated(linha, linha);
    }
    
    
    public void addRow(Conta c){
        this.dados.add(c);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha); 
    }
    
    /*public void setResult(ResultSet rs) throws SQLException {
        ResultSets = new ArrayList<>();
        
        while (rs.next()){
            String[] row = {
                rs.getString("id"),
                rs.getString("descricao"),
                rs.getString("valor"),
                rs.getString("data")
            };
            ResultSets.add(row);
        }
        fireTableStructureChanged();
    }*/
}
