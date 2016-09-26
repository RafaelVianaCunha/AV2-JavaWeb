/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import av1.model.Cliente;



public class ClienteDAOImpl implements ClienteDAO {

    private EntityManager em;

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("Rafael_Viana_AV1");
        return factory.createEntityManager();
    }

    public ClienteDAOImpl() {
        EntityManager _em = getEM();
        this.em = _em;
    }

   
    public Cliente salvar(Cliente cliente) throws Exception {
        try {
            em.getTransaction().begin();
            if (cliente.getId() == 0) {
                //INSERT
                em.persist(cliente);
            } else
             if (!em.contains(cliente)) {
                    if (em.find(Cliente.class, cliente.getId()) == null) {
                        throw new Exception("Erro ao atualizar o Cliente.");
                    }
                    cliente = em.merge(cliente);
                }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return cliente;
    }

   
    public void excluir(Long id) {
    	Cliente cliente = em.find(Cliente.class, id);
        try {
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

   
    public Cliente detalhar(Long id) {
    	Cliente cliente = null;
        try {
            cliente = em.find(Cliente.class, id);
        } finally {
            em.close();
        }

        return cliente;
    }
    
      public Cliente getById(long id) {
        Cliente cliente = null;
        cliente = em.find(Cliente.class, id);
        return cliente;
    }

    
    @SuppressWarnings("unchecked")
	public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        Query query = em.createQuery("SELECT c FROM Cliente c");
        try {
           
        	clientes = (List<Cliente>) query.getResultList();
        } finally {
            em.close();
        }       
        return clientes;
    }
        
      
}
