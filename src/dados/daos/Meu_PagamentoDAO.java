/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.daos;

import dados.entidades.Meu_Pagamento;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

/**
 *
 * @author IFNMG
 */
public class Meu_PagamentoDAO {
    
    /**
    * Retorna uma lista com todos os Meu_Pagamento que estejam cadastrados no banco de
    * dados
    *
    * @return
    */
    public List<Meu_Pagamento> listar() {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Criando a consulta ao BD
        TypedQuery consulta = gerenciador.createQuery(
                "Select m from Meu_Pagamento m", Meu_Pagamento.class);

        //Retornar a lista de Movimento_Conta
        return consulta.getResultList();
    }

    /**
     * Manda salvar um Meu_Pagamento no BD
     *  
     */
    public void salvar(Meu_Pagamento m) {
        
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Iniciar a transação
        gerenciador.getTransaction().begin();

        //Mandar persistir o Movimento_Conta
        gerenciador.persist(m);

        //Commit
        gerenciador.getTransaction().commit();
    }
    
    /**
     * Salva as alterações no BD
     */
    public void editar(Meu_Pagamento m) {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Iniciar a transação
        gerenciador.getTransaction().begin();

        //Mandar sincronizar as alterações 
        gerenciador.merge(m);
        
        //Commit na transação
        gerenciador.getTransaction().commit();
    }
    
    /**
     * Exclui o Meu_Pagamento do BD
     */
    public void excluir(Meu_Pagamento m){
        
         //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Iniciar a transação
        gerenciador.getTransaction().begin();
        
        //Para excluir tem que dar o merge primeiro para 
        //sincronizar o ator do BD com o Meu_Pagamento que foi
        //selecionado na tela
        m = gerenciador.merge(m);

        //Mandar sincronizar as alterações 
        gerenciador.remove(m);
        
        //Commit na transação
        gerenciador.getTransaction().commit();
    }
    
    public List<Meu_Pagamento> FiltrarAPagar() {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Criando a consulta ao BD
        TypedQuery<Meu_Pagamento> consulta = gerenciador.createQuery(
                "Select m from Meu_Pagamento m where m.Pagamento_MeuPagamento is null",
                Meu_Pagamento.class);

        //Substituindo o parametro :sit pelo valor da variavel n
        //consulta.setParameter("sit", Spag);

        //Retornar os dados
        return consulta.getResultList();

    }
    
    public List<Meu_Pagamento> FiltrarPagos() {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Criando a consulta ao BD
        TypedQuery<Meu_Pagamento> consulta = gerenciador.createQuery(
                "Select m from Meu_Pagamento m where m.Pagamento_MeuPagamento is not null",
                Meu_Pagamento.class);

        //Substituindo o parametro :sit pelo valor da variavel n
        //consulta.setParameter("sit", Spag);

        //Retornar os dados
        return consulta.getResultList();

    } 
    
    public List<Meu_Pagamento> Pesquisar(String nome) {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Criando a consulta ao BD
        TypedQuery<Meu_Pagamento> consulta = gerenciador.createQuery(
                "Select f from Meu_Pagamento f where f.Desc_MeuPagamento like :nome",
                Meu_Pagamento.class);

        //Substituindo o parametro :nome pelo valor da variavel n
        consulta.setParameter("nome", nome + "%");

        //Retornar os dados
        return consulta.getResultList();
    }
    
    public List<Meu_Pagamento> PesquisarData(LocalDate nome) {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Criando a consulta ao BD
        TypedQuery<Meu_Pagamento> consulta = gerenciador.createQuery(
                "Select f from Meu_Pagamento f where f.Pagamento_MeuPagamento = :nome",
                Meu_Pagamento.class);

        //Substituindo o parametro :nome pelo valor da variavel n
        consulta.setParameter("nome", nome);

        //Retornar os dados
        return consulta.getResultList();
    }
    
    public List<Meu_Pagamento> PesquisarDataVencimento(LocalDate nome) {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Criando a consulta ao BD
        TypedQuery<Meu_Pagamento> consulta = gerenciador.createQuery(
                "Select f from Meu_Pagamento f where f.Vencimento_MeuPagamento = :nome",
                Meu_Pagamento.class);

        //Substituindo o parametro :nome pelo valor da variavel n
        consulta.setParameter("nome", nome);

        //Retornar os dados
        return consulta.getResultList();
    }
}
