package av1.dao;

import javax.persistence.EntityManager;

import av1.model.Cliente;
import av1.model.Pedido;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PedidoDAOImpl {
	private EntityManager em;
         public PedidoDAOImpl() {
        EntityManager _em = getEM();
        this.em = _em;
    }
       public EntityManager getEM() {
            EntityManagerFactory factory = Persistence.
            createEntityManagerFactory("Rafael_Viana_AV1");
            return factory.createEntityManager();
    }
	 public Pedido salvar(Pedido pedido) throws Exception {
	        try {
	            em.getTransaction().begin();
	            if (pedido.getId() == 0) {
	                //INSERT
	                em.persist(pedido);
	            } else 
	             if (!em.contains(pedido)) {
	                    if (em.find(Cliente.class, pedido.getId()) == null) {
	                        throw new Exception("Erro ao atualizar o pedido.");
	                    }
	                    pedido = em.merge(pedido);
	                }
	            em.getTransaction().commit();
	        } finally {
	            em.close();
	        }
	        return pedido;
	    }
}
