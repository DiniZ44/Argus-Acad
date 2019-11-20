/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.business;

import br.com.argus.dao.IUsuarioDAO;
import br.com.argus.dao.UsuarioDAO;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.exceptions.DAOException;
import br.com.argus.exceptions.ValidacaoException;
import br.com.argus.model.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santo
 */
public class UsuarioBusiness extends Business<Usuario> implements IUsuarioBusiness{
    
    private IUsuarioDAO usuarioDAO;

    public UsuarioBusiness() {
        usuarioDAO = new UsuarioDAO();
        init(usuarioDAO);
    }

    @Override
    public void criarOuAtualizar(Usuario t) throws BussinesException {
        super.criarOuAtualizar(t); 
    }
    
    

    @Override
    public void isValid(Usuario t) throws ValidacaoException {
         
    }

    @Override
    public Usuario buscarLoginUsuario(String login, String senha) throws BussinesException {
        try {
            
            Usuario user = usuarioDAO.buscarLoginUsuario(login, senha);
            return user;
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BussinesException(e.getMessage());
        }
    }

    @Override
    public List<Usuario> buscarTodos(String string) throws BussinesException {
          try {
            List<Usuario> usuarios = usuarioDAO.buscarTodos(string);
            return usuarios;
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BussinesException(e.getMessage());
        }
    }

    @Override
    public Usuario buscarTipo(String tipocargo) throws BussinesException {
         try { 
        Usuario user = usuarioDAO.buscarTipo(tipocargo);
            return user;
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BussinesException(e.getMessage());
        }
    }

    @Override
    public Usuario buscarCPF(String cpf) throws BussinesException {
        try {
            Usuario user = usuarioDAO.buscarCPF(cpf);
            return user;
        } catch (DAOException ex) {
            ex.printStackTrace();
            throw new BussinesException(ex.getMessage());
        }
    }
    
}
