/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.exceptions.BussinesException;
import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Usuario;
import java.util.List;

/**
 *
 * @author santo
 */
public interface IUsuarioBusiness extends IBusiness<Usuario>{
    
    public Usuario buscarLoginUsuario(String login, String senha) throws BussinesException;
    
    public List<Usuario> buscarTodos(String string) throws BussinesException;
}
