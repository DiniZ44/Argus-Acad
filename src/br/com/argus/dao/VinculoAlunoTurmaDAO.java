/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Turma;
import br.com.argus.model.VinculoAlunoTurma;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author santo
 */
public class VinculoAlunoTurmaDAO extends Dao<VinculoAlunoTurma> implements IVinculoAlunoTurmaDAO{
    
    public VinculoAlunoTurmaDAO() {
        super(VinculoAlunoTurma.class);
    }

    @Override
    public List<VinculoAlunoTurma> buscarTurma(Turma turma) throws DAOException {
        
         try {
            TypedQuery<VinculoAlunoTurma> typedQuery = entityManager().createQuery("", class1);
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
