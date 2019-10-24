package DAO;

import br.com.teste.models.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PessoaDAO {


  private EntityManager getEntityManager() {
    EntityManagerFactory factory;
    EntityManager entityManager;
      //Obtém o factory a partir da unidade de persistência.
      factory = Persistence.createEntityManagerFactory("Cadastrados");
      //Cria um entity manager.
      entityManager = factory.createEntityManager();
      //Fecha o factory para liberar os recursos utilizado.
    
    return entityManager;
  }

  /**
   * Método utilizado para salvar ou atualizar as informações de uma pessoa.

   * @param pessoa
   * @return
   * @throws java.lang.Exception
   */
    public Pessoa cadastrar(Pessoa pessoa) throws Exception {
    EntityManager entityManager = getEntityManager();
    try {
      // Inicia uma transação com o banco de dados.
      entityManager.getTransaction().begin();
      System.out.println("Salvando pessoa.");
      // Verifica se a pessoa ainda não está salva no banco de dados.
     
      if(pessoa.getId() == null){
        entityManager.persist(pessoa);
      } else {
        pessoa = entityManager.merge(pessoa);
      }
      entityManager.getTransaction().commit();
    } finally {
      entityManager.close();
    }
    return pessoa;
  }
  
  public Pessoa buscar(Integer id) {
    EntityManager entityManager = getEntityManager();
    Pessoa pessoa = null;
    try {
      //Consulta uma pessoa pelo seu ID.
      pessoa = entityManager.find(Pessoa.class, id);
    } finally {
      entityManager.close();
    }
    return pessoa;
    }

  /**
   * Método que apaga a pessoa do banco de dados.
   * @param id
   */
  
  
  public void excluir(Integer id) {
    EntityManager entityManager = getEntityManager();
    try {
      // Inicia uma transação com o banco de dados.
      entityManager.getTransaction().begin();
      // Consulta a pessoa na base de dados através do seu ID.
      Pessoa pessoa = entityManager.find(Pessoa.class, id);
      System.out.println("Excluindo os dados de: " + pessoa.getNome());
      // Remove a pessoa da base de dados.
      entityManager.remove(pessoa);
      // Finaliza a transação.
      entityManager.getTransaction().commit();
    } finally {
      entityManager.close();
    }
  }

  public List<Pessoa> listar(){
    EntityManager entityManager = getEntityManager();

    String queryString = "select x from Pessoa x";

    Query query = entityManager.createQuery(queryString);

    List<Pessoa> pessoa = query.getResultList();
    
    return pessoa;
  }


}
