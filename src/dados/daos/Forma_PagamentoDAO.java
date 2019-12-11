/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.daos;

import dados.entidades.Forma_Pagamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

/**
 *
 * @author W4ND3K0
 */
public class Forma_PagamentoDAO {
    
    /**
     * Salvar a Forma_Pagamento no BD
     */
    public void salvar(Forma_Pagamento f) {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Iniciar a transação
        gerenciador.getTransaction().begin();

        //Mandar persistir o Forma_Pagamento
        gerenciador.persist(f);

        //Commit
        gerenciador.getTransaction().commit();

    }

    /**
     * Retorna uma lista com todos as Forma_Pagamento que estejam cadastrados no banco de
     * dados
     *
     * @return
     */
    public List<Forma_Pagamento> listar() {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Criando a consulta ao BD
        TypedQuery consulta = gerenciador.createQuery(
                "Select f from Forma_Pagamento f", Forma_Pagamento.class);

        //Retornar a lista de Forma_Pagamento
        return consulta.getResultList();
    }

    /**
     * Salva as alterações no BD
     */
    public void editar(Forma_Pagamento f) {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Iniciar a transação
        gerenciador.getTransaction().begin();

        //Mandar sincronizar as alterações 
        gerenciador.merge(f);
        
        //Commit na transação
        gerenciador.getTransaction().commit();
    }
    
    /**
     * Exclui a Forma_Pagamento do BD
     */
    public void excluir(Forma_Pagamento f){
        
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Iniciar a transação
        gerenciador.getTransaction().begin();
        
        //Para excluir tem que dar o merge primeiro para 
        //sincronizar a Forma_Pagamento do BD com a Forma_Pagamento que foi
        //selecionado na tela
        f = gerenciador.merge(f);

        //Mandar sincronizar as alterações 
        gerenciador.remove(f);
        
        //Commit na transação
        gerenciador.getTransaction().commit();   
    }
    
    public List<Forma_Pagamento> Pesquisar(String nome) {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Criando a consulta ao BD
        TypedQuery<Forma_Pagamento> consulta = gerenciador.createQuery(
                "Select f from Forma_Pagamento f where f.Descricao_FormaPagamento like :nome",
                Forma_Pagamento.class);

        //Substituindo o parametro :nome pelo valor da variavel n
        consulta.setParameter("nome", nome + "%");

        //Retornar os dados
        return consulta.getResultList();
    }
    
}
