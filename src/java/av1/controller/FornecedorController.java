/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av1.controller;

import av1.dao.FornecedorDAOImpl;
import av1.model.Endereco;
import av1.model.Fornecedor;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rafae
 */
@Controller
public class FornecedorController {
    
    @RequestMapping("listar-fornecedor")
	public ModelAndView listar() {
		FornecedorDAOImpl dao = new FornecedorDAOImpl();
		List<Fornecedor> fornecedor = dao.listar();
		ModelAndView mv = new ModelAndView("fornecedor");
		mv.addObject("fornecedores", fornecedor);
		return mv;
	} 
        
//        @RequestMapping("novo-fornecedor")
//	public String novoPedido() {
//              model.addAttribute("fornecedor", new Fornecedor()); 
//		return "formulario-fornecedor";
//	}
        
        @RequestMapping(value = "novo-fornecedor", method = RequestMethod.GET)
	public ModelAndView initCadastrarFornecedor() {
                ModelAndView mv = new ModelAndView("formulario-fornecedor");
		mv.addObject("fornecedor", new Fornecedor());
		return mv;
	}
    
     @RequestMapping("/")
        public String redirect() {
            return "forward:listar-fornecedor";
        }
        
        @RequestMapping(value="salvar-fornecedor", method=RequestMethod.POST)
	public String salvar(@Valid  @ModelAttribute("fornecedor") Fornecedor fornecedor, BindingResult result) {
            if (result.hasFieldErrors()) {
                    return "formulario";
            }
            FornecedorDAOImpl dao = new FornecedorDAOImpl();
            try {
                    dao.salvar(fornecedor);
            } catch (Exception e) {
                    System.out.println("Erro: "+e.getMessage());
            }finally{
                return "forward:listar-fornecedor";
            }
	}
}
