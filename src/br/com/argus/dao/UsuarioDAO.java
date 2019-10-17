/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Usuario;
import br.com.argus.util.SQLUtil;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author santo
 */
public class UsuarioDAO extends Dao<Usuario> implements IUsuarioDAO {
    
    public UsuarioDAO(){
        super(Usuario.class);
    }

    @Override
    public Usuario buscarLoginUsuario(String login, String senha) throws DAOException {
        
        try {
            TypedQuery<Usuario> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_LOGIN, class1);
            typedQuery.setParameter("login", login);
            typedQuery.setParameter("senha", senha);
            return typedQuery.getSingleResult();
            
        } catch (NoResultException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            throw new DAOException("Não foi encontrado Usuario");
            
        }catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
            throw new DAOException("Erro de busca no "+ class1.getSimpleName()+ " " +e.getMessage());
        }
    }

    @Override
    public List<Usuario> buscarTodos(String string) throws DAOException {
          try {
            TypedQuery<Usuario> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_LOGIN, class1);
            return typedQuery.getResultList();
            
        } catch (NoResultException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            throw new DAOException("Não foi encontrado Usuario");
            
        }catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
            throw new DAOException("Erro de busca no "+ class1.getSimpleName()+ " " +e.getMessage());
        }
    }




    
}
