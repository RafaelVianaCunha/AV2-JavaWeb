package av1.controller;
import av1.dao.ClienteDAOImpl;
import av1.model.Cliente;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ClienteController {
	@RequestMapping("novo-cliente")
	public String novoPedido() {
		return "formulario";
	}
	
	@RequestMapping("listar-cliente")
	public ModelAndView listar() {
		ClienteDAOImpl dao = new ClienteDAOImpl();
		List<Cliente> clientes = dao.listar();
		ModelAndView mv = new ModelAndView("cliente");
		mv.addObject("clientes", clientes);
		return mv;
	}

	@RequestMapping("salvar-cliente")
	public String salvar(@Valid Cliente cliente, BindingResult result) {
		if (result.hasFieldErrors()) {
			return "formulario";
		}
		ClienteDAOImpl dao = new ClienteDAOImpl();
		try {
			dao.salvar(cliente);
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}finally{
                    return "forward:listar-cliente";
                }
                
		
	}

	@RequestMapping("editar-cliente")
	public ModelAndView editar(long id) {
		ClienteDAOImpl dao = new ClienteDAOImpl();
		Cliente cliente = dao.detalhar(id);
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("cliente", cliente);
		return mv;
	}

	@RequestMapping("excluir-cliente")
	public String excluir(long id) {
		ClienteDAOImpl dao = new ClienteDAOImpl();
		dao.excluir(id);
		return "forward:listar-cliente";
	}
        
        @RequestMapping("/cliente")
        public String redirect() {
            return "forward:listar-cliente";
        }
}
