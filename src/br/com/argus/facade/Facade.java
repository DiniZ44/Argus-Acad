/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.facade;

import br.com.argus.business.IUsuarioBusiness;
import br.com.argus.business.UsuarioBusiness;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Usuario;
import java.util.List;

/**
 *
 * @author santo
 */
public class Facade implements IFacade{
   
    private static Facade instance;
    
    public static Facade getInstance(){
        
        if(instance == null){
            instance = new Facade();
        }return instance;
    }
    
    
    private IUsuarioBusiness usuarioBusiness;
    
    private Facade(){
        usuarioBusiness = new UsuarioBusiness();
    }



    //Usuario
    @Override
    public Usuario buscarLoginUsuario(String login, String senha) throws BussinesException {
        return usuarioBusiness.buscarLoginUsuario(login, senha);
    }
    @Override
    public List<Usuario> buscarTodos(String string) throws BussinesException {
        return usuarioBusiness.buscarTodos(string);
    }
    @Override
    public void inserirOuAtualizar(Usuario usuario) throws BussinesException {
        usuarioBusiness.criarOuAtualizar(usuario);
    }
    @Override
    public void desabilitarUsuario(Usuario usuario) throws BussinesException {
         usuarioBusiness.remover(usuario);
    }
    @Override
    public void deletarUsuario(Usuario usuario) throws BussinesException {
         usuarioBusiness.deletar(usuario);
    }
    @Override
    public void buscarUsuario(Usuario usuario) throws BussinesException {
         usuarioBusiness.buscar(Usuario.class, usuario.getId());
    }

    
}
