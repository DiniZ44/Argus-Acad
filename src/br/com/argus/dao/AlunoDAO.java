/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Aluno;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author santo
 */
public class AlunoDAO extends Dao<Aluno> implements IAlunoDAO{
    
    public AlunoDAO() {
        super(Aluno.class);
    }

    @Override
    public List<Aluno> buscarALL() throws DAOException {
              EntityManager em = entityManager();
              List listT;
              listT = em.createQuery("SELECT a FROM Aluno a").getResultList();
              em.close();
            return  listT;
    }
    
}
