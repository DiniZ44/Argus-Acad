/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Log;
import br.com.argus.util.SQLUtil;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Hakkinen
 */
public class LodDAO extends Dao<Log>implements ILogDAO{
    
    public LodDAO() {
        super(Log.class);
    }

    @Override
    public List<Log> buscarTudo() throws DAOException {
        try {
            TypedQuery<Log> typedQuery = (TypedQuery<Log>) entityManager().createQuery(SQLUtil.BUSCAR_LOG);
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
