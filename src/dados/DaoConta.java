/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import conexao.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dados.Conta;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *"INSERT INTO conta (descricao,valor,date_format(data,'%d/%m/%Y)"
 * @author hnr
 */
public class DaoConta {
 
    ConnectionFactory con = new ConnectionFactory();
    
    
    public void inserir(Conta c){
        Connection conexao = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;       
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO conta (descricao,valor,data,tipoMovimentacao) values(?,?,?,?)");
            
            stmt.setString(1,c.getDescricao());
            stmt.setDouble(2,c.getValor());
            stmt.setString(3,c.getData());
            stmt.setString(4,c.getTipoMovimentacao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            con.closeConnection(conexao, stmt);
    }
                
    }

    public void alterar(Conta c){
        Connection conexao = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("update conta set descricao = ?, valor = ?, data = ?, tipoMovimentacao = ? where id = ?");
            
            stmt.setString(1,c.getDescricao());
            stmt.setDouble(2,c.getValor());
            stmt.setString(3,c.getData());
            stmt.setString(4,c.getTipoMovimentacao());
            stmt.setInt(5,c.getId());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);
        } finally {
            con.closeConnection(conexao, stmt);
        }
        
    }

    public void excluir(Conta c){
        Connection conexao = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("delete from conta where id = ?");
            stmt.setInt(1,c.getId());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover" + ex);
        } finally {
            con.closeConnection(conexao, stmt);
        }
        
    }
    
    public List<Conta> listar(){
        Connection conexao = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        List<Conta> contas = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement("select * from conta");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Conta conta = new Conta();
                conta.setId(rs.getInt("id"));
                conta.setDescricao(rs.getString("descricao"));
                conta.setValor(rs.getDouble("Valor"));
                conta.setData(rs.getString("data"));
                conta.setTipoMovimentacao(rs.getString("tipoMovimentacao"));
                contas.add(conta);
            }
            
        } catch (SQLException ex) {
        } finally {
            con.closeConnection(conexao, stmt,rs);
        }
        
     return contas;   
    }     
}
