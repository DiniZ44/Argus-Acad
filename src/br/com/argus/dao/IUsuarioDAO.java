/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Usuario;
import java.util.List;

/**
 *
 * @author santo
 */
public interface IUsuarioDAO  extends IDao<Usuario>{
    
    public Usuario buscarLoginUsuario(String login, String senha) throws DAOException;
    
    public Usuario buscarLogin(String login) throws DAOException;
    
    public List<Usuario> buscarTodos(String string) throws DAOException;
    
    public Usuario buscarTipo(String tipocargo) throws DAOException;
    
    public Usuario buscarCPF (String cpf) throws DAOException;
}
