/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av1.dao;


import av1.model.Processo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author rafae
 */
public class ProcessoDAOImpl {
    private EntityManager em;
         public ProcessoDAOImpl() {
        EntityManager _em = getEM();
        this.em = _em;
    }
       public EntityManager getEM() {
            EntityManagerFactory factory = Persistence.
            createEntityManagerFactory("Rafael_Viana_AV1");
            return factory.createEntityManager();
    }
       
    public Processo salvar(Processo processo) throws Exception {
        try {
            em.getTransaction().begin();
            if (processo.getId() == 0) {
                //INSERT
                em.persist(processo);
            } else 
             if (!em.contains(processo)) {
                    if (em.find(Processo.class, processo.getId()) == null) {
                        throw new Exception("Erro ao atualizar o processo.");
                    }
                    processo = em.merge(processo);
                }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return processo;
    }
    
     public void excluir(Long id) {
    	Processo fornecedor = em.find(Processo.class, id);
        try {
            em.getTransaction().begin();
            em.remove(fornecedor);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Processo detalhar(Long id) {
    	Processo processo = null;
        try {
            processo = em.find(Processo.class, id);
        } finally {
            em.close();
        }
        return processo;
    }
    
      public Processo getById(long id) {
        Processo processo = null;
        processo = em.find(Processo.class, id);
        return processo;
    }

    
    @SuppressWarnings("unchecked")
	public List<Processo> listar() {
        List<Processo> processos = new ArrayList<Processo>();
        Query query = em.createQuery("SELECT c FROM Processo c");
        try {
           
        	processos = (List<Processo>) query.getResultList();
        } finally {
            em.close();
        }       
        return processos;
    }
 
}
