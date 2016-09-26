package av1.controller;

import av1.dao.ClienteDAO;
import av1.dao.ClienteDAOImpl;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import av1.dao.PedidoDAOImpl;
import av1.model.Cliente;
import av1.model.Pedido;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PedidoController {

	@RequestMapping("salvar-pedido")
	public String salvar(Pedido pedido, BindingResult result) {
		PedidoDAOImpl dao = new PedidoDAOImpl();
                ClienteDAOImpl daoCliente = new ClienteDAOImpl();
		try {
                    Cliente cliente = daoCliente.getById(pedido.getCliente().getId());
                    pedido.setCliente(cliente);                    
                    dao.salvar(pedido);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		} 
                    return "forward:listar-cliente";	
	}
	
	@RequestMapping("novo-pedido")
	public ModelAndView novoPedido() {
	ClienteDAO daoCliente = new ClienteDAOImpl();
        List<Cliente> clientes = daoCliente.listar();
        
        ModelAndView mv = new ModelAndView("formulario-pedido");
        mv.addObject("clientes", clientes);
        return mv;
	}
	
	
}
