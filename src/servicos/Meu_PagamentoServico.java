/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.daos.Meu_PagamentoDAO;
import dados.entidades.Meu_Pagamento;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author IFNMG
 */

public class Meu_PagamentoServico {
    
    //Atributo para representar a camada de dados
    private Meu_PagamentoDAO dao = new Meu_PagamentoDAO();
    
    /**
     * Solicita a camada DAO para buscar os Meu_Pagamento
     * cadastrados
     * @return 
     */
    public List<Meu_Pagamento> listar(){
        
        //Qualquer regra de negócio (se aplicável)
        
        //Pedir a DAO para listar e retornar
        return dao.listar();
        
    }
    
    /**
     * Recebe um Movimento_Conta e manda para a camada DAO salvar
     * no BD
     */
    public void salvar(Meu_Pagamento m){
        
        //Qualquer regra de negócio (se aplicável)
        
        //Manda a camada DAO salvar no BD
        dao.salvar(m);
        
    }
    
    /**
     * Recebe um Movimento_Conta e manda para a camada DAO atualizar 
     */
    public void editar(Meu_Pagamento m){
        
        //Qualquer regra de negócio (se aplicável)
        
        
        //Mandar a DAO atualizar os dados no BD
        dao.editar(m);
        
    }
    
    /**
     *  Recebe um Movimento_Conta para passar para a DAO excluir no BD
     */
    public void excluir(Meu_Pagamento m){
        //Qualquer regra de negócio (se aplicável)
        
        //Mandar para a DAO excluir
        dao.excluir(m);
    }
    
    public List<Meu_Pagamento> FiltrarAPagar(){
        
        //Qualquer regra de negócio (se aplicável)
        
        //Mandar para a DAO buscar os filmes pelo nome
        return dao.FiltrarAPagar();
    }
    
    public List<Meu_Pagamento> FiltrarPagos(){
        
        //Qualquer regra de negócio (se aplicável)
        
        //Mandar para a DAO buscar os filmes pelo nome
        return dao.FiltrarPagos();
    }
    
    
      public List<Meu_Pagamento> Pesquisar(String nome) {

        return dao.Pesquisar(nome);
    }
    
    public List<Meu_Pagamento> PesquisarData(LocalDate nome) {

        return dao.PesquisarData(nome);
    }
    
    public List<Meu_Pagamento> PesquisarDataVencimento(LocalDate nome) {

        return dao.PesquisarDataVencimento(nome);
    }
}
