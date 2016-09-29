/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av1.dao;

import av1.model.Fornecedor;
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
public class FornecedorDAOImpl {
    
    private EntityManager em;

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("Rafael_Viana_AV1");
        return factory.createEntityManager();
    }

    public FornecedorDAOImpl() {
        EntityManager _em = getEM();
        this.em = _em;
    }

    public Fornecedor salvar(Fornecedor fornecedor) throws Exception {
        try {
            em.getTransaction().begin();
            if (fornecedor.getId() == 0) {
                //INSERT
                em.persist(fornecedor);
            } else
             if (!em.contains(fornecedor)) {
                    if (em.find(Fornecedor.class, fornecedor.getId()) == null) {
                        throw new Exception("Erro ao atualizar o Fornecedor.");
                    }
                    fornecedor = em.merge(fornecedor);
                }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return fornecedor;
    }

   
    public void excluir(Long id) {
    	Fornecedor fornecedor = em.find(Fornecedor.class, id);
        try {
            em.getTransaction().begin();
            em.remove(fornecedor);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Fornecedor detalhar(Long id) {
    	Fornecedor fornecedor = null;
        try {
            fornecedor = em.find(Fornecedor.class, id);
        } finally {
            em.close();
        }

        return fornecedor;
    }
    
      public Fornecedor getById(long id) {
        Fornecedor fornecedor = null;
        fornecedor = em.find(Fornecedor.class, id);
        return fornecedor;
    }
      
    public String getByCNPJ(String CNPJ) {
        Fornecedor fornecedor = new Fornecedor();
        Object o ;
        Query query = em.createQuery("SELECT f.id FROM Fornecedor f where f.CNPJ = :cnpj");
        query.setParameter("cnpj", CNPJ);
        String id = query.getSingleResult().toString();
        
        //fornecedor.setId(s);
//         List<Fornecedor> fornecedores = query.getResultList();
//         if(!fornecedores.isEmpty()){     
//            o = fornecedores.get(0);
//             System.out.println(o.toString());
//            fornecedor = (Fornecedor)o;
////         }
//         
////        Query query = em.createQuery("SELECT f FROM Fornecedor f where f.CNPJ = ?");
////        query.setParameter(1, CNPJ);
////         return  (Fornecedor) query.getSingleResult();
////       return (Fornecedor) em.createQuery("from Fornecedor where CNPJ=:cnpjFornecedor").setParameter("cnpjFornecedor", CNPJ);
//        System.out.println("av1.dao.FornecedorDAOImpl.getByCNPJ()");
//        return fornecedor;

//                Query query = em.createQuery("SELECT f FROM Fornecedor f where f.CNPJ = :cnpj");
//                query.setParameter("cnpj", CNPJ);
//                fornecedor = (Fornecedor) query.getSingleResult();
           
	return id;
     
  }

    
    @SuppressWarnings("unchecked")
	public List<Fornecedor> listar() {
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        Query query = em.createQuery("SELECT c FROM Fornecedor c");
        try {
           
        	fornecedores = (List<Fornecedor>) query.getResultList();
        } finally {
            em.close();
        }       
        return fornecedores;
    }

    private Object getSession() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
