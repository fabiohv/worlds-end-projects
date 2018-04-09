/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class AcessoDB {
    
    public void insere(Pessoa p){
        Connection con = Conexao.pegaConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into cadastro (id,nome,telefone,logradouro,numero,complemento,bairro,cep,cidade) "
                    + "values (id_cadastro.nextval,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTelefone());
            stmt.setString(3, p.getLogradouro());
            stmt.setInt(4,p.getNumero());
            stmt.setString(5, p.getComplemento());
            stmt.setString(6, p.getBairro());
            stmt.setString(7, p.getCep());
            stmt.setString(8, p.getCidade());
            
            stmt.executeUpdate();
            System.out.println("Adicionado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir: " +ex);
        } finally{
            Conexao.fechaConexao(con, stmt);
        }
    }
    
    public List<Pessoa> busca(){
        Connection con = Conexao.pegaConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from cadastro");
            
            rs = stmt.executeQuery();
            while (rs.next()){
                Pessoa p = new Pessoa();
                
                p.setCodigo(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setTelefone(rs.getString("telefone"));
                p.setLogradouro(rs.getString("logradouro"));
                p.setNumero(rs.getInt("numero"));
                p.setComplemento(rs.getString("complemento"));
                p.setBairro(rs.getString("bairro"));
                p.setCep(rs.getString(7));
                p.setCidade(rs.getString("cidade"));
                
                pessoas.add(p);
            
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Erro ao carregar os dados: " +ex);
        } finally{
            Conexao.fechaConexao(con, stmt, rs);
        }
        return pessoas;
    }
    
    public List<Pessoa> busca(String filtro){
        Connection con = Conexao.pegaConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        try {
            if (filtro == ""){
                stmt = con.prepareStatement("select * from cadastro order by id");
            }
            else {
                stmt = con.prepareStatement("select * from cadastro where id = ?");
                stmt.setString(1, filtro);
                System.out.println(filtro);
            }
            rs = stmt.executeQuery();
            while (rs.next()){
                Pessoa p = new Pessoa();
                
                p.setCodigo(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setTelefone(rs.getString("telefone"));
                p.setLogradouro(rs.getString("logradouro"));
                p.setNumero(rs.getInt("numero"));
                p.setComplemento(rs.getString("complemento"));
                p.setBairro(rs.getString("bairro"));
                p.setCep(rs.getString(7));
                p.setCidade(rs.getString("cidade"));
                
                pessoas.add(p);
            
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Erro ao carregar os dados: " +ex);
        } finally{
            Conexao.fechaConexao(con, stmt, rs);
        }
        return pessoas;
    }
    
    public void deleta(int id){
        Connection con = Conexao.pegaConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from cadastro where id = ?");
            
            stmt.setInt(1,id);
            
            stmt.executeUpdate();
            System.out.println("Removido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao remover: " +ex);
        } finally{
            Conexao.fechaConexao(con, stmt);
        }
    }
    
}
