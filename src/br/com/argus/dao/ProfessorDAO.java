/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Professor;
import br.com.argus.model.Usuario;
import br.com.argus.util.SQLUtil;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author santo
 */
public class ProfessorDAO extends Dao<Professor> implements IProfessorDAO{
    
    public ProfessorDAO() {
        super(Professor.class);
    }

    @Override
    public Professor buscarProf(String pesquisa) throws DAOException {
        try {

            Query q = entityManager().createQuery(SQLUtil.PESQUISA_PROFESSOR+ pesquisa +"'");
           Professor professor =(Professor) q.getSingleResult() ;
            professor.getNome();
           return professor;
            
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
            
        }catch(Exception e){
            e.printStackTrace();
            throw new DAOException("Erro de busca no "+ class1.getSimpleName()+ " " +e.getMessage());
        }
    }
    
}
