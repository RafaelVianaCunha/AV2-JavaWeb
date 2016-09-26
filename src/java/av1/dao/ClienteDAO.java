/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av1.dao;

import java.util.List;

import av1.model.Cliente;


public interface ClienteDAO {
    public Cliente salvar(Cliente cliente) throws Exception;
    
    public void excluir(Long id);
    
    public Cliente detalhar(Long id);
    
    public List<Cliente> listar();
}
