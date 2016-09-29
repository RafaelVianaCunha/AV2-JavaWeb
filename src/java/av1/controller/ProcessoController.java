/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av1.controller;

import av1.dao.FornecedorDAOImpl;
import av1.dao.ProcessoDAOImpl;
import av1.model.Fornecedor;
import av1.model.Processo;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
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
public class ProcessoController {
    
@RequestMapping("listar-processo")
    public ModelAndView listar() {
            ProcessoDAOImpl dao = new ProcessoDAOImpl();
            List<Processo> processo = dao.listar();
            ModelAndView mv = new ModelAndView("processo");
            mv.addObject("processos", processo);
            return mv;
    } 
    
    @RequestMapping("novo-processo")
	public ModelAndView novoProcesso() {
            FornecedorDAOImpl dao = new FornecedorDAOImpl();
            List<Fornecedor> fornecedor = dao.listar();
            ModelAndView mv = new ModelAndView("formulario-processo");
            mv.addObject("fornecedores", fornecedor);
            return mv;
        } 
		
	@RequestMapping("processo-buscar-fornecedor")
        public ModelAndView buscarFornecedor(Fornecedor fornecedorCNPJ) {
                Fornecedor fornecedor;
                Processo processo = new Processo();
                ModelAndView mv ;
		FornecedorDAOImpl dao = new FornecedorDAOImpl();
                String id = dao.getByCNPJ(fornecedorCNPJ.getCNPJ());
                if(id != null){
                    fornecedor = dao.getById(Long.parseLong(id));
                    mv = new ModelAndView("formulario-processo-fornecedor");
                    processo.setFornecedor(fornecedor);
                    processo.setIdFornecedor(id);
                    mv.addObject("processo", processo);
                }else{
                    mv = new ModelAndView("formulario-processo");
                }
		return mv;
	} 
             
       @RequestMapping(value="salvar-processo", method=RequestMethod.POST)
	public String salvar(@Valid  @ModelAttribute("processo") Processo processo, BindingResult result) {
            if (result.hasFieldErrors()) {
                    return "forward:formulario-processo-fornecedor";
            }
            
            ProcessoDAOImpl dao = new ProcessoDAOImpl();
            FornecedorDAOImpl fornecedorDao = new FornecedorDAOImpl();
            Fornecedor fornecedor = fornecedorDao.getById(Long.parseLong(processo.getIdFornecedor()));
            processo.setFornecedor(fornecedor);
            processo.gerarNumeroProcesso();
            try {
                    dao.salvar(processo);
            } catch (Exception e) {
                    System.out.println("Erro: "+e.getMessage());
            }finally{
                return "forward:listar-processo";
            }
	}
    
}
