/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fabio
 */
public class PessoasTableModel extends AbstractTableModel{
    private List<Pessoa> dados = new ArrayList<>();
    private String[] colunas = {"Código","Nome","Telefone","Logradouro","Número","Complemento","Bairro","Cidade","CEP"};
    
    @Override
    public int getRowCount() {
        return this.dados.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int coluna) {
        return this.colunas[coluna];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
    
        switch(coluna){
            case 0:
                return dados.get(linha).getCodigo();
            case 1:
                return dados.get(linha).getNome();
            case 2:
                return dados.get(linha).getTelefone();
            case 3:
                return dados.get(linha).getLogradouro();
            case 4:
                return dados.get(linha).getNumero();
            case 5:
                return dados.get(linha).getComplemento();
            case 6:
                return dados.get(linha).getBairro();
            case 7:
                return dados.get(linha).getCidade();
            case 8:
                return dados.get(linha).getCep();
        }
        
        return null;
    }
    
    public void adicionaLinha(Pessoa p){
        this.dados.add(p);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    public void limpaTabela() {
        dados.clear();
        fireTableDataChanged();
    }
}
