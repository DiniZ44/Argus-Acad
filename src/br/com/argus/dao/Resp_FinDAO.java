/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Professor;
import br.com.argus.model.Resp_Financeiro;
import br.com.argus.util.SQLUtil;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author santo
 */
public class Resp_FinDAO extends Dao<Resp_Financeiro> implements IResp_FinDAO{
    
    public Resp_FinDAO() {
        super(Resp_Financeiro.class);
    }
    
        @Override
    public Resp_Financeiro buscarRep (String pesquisa) throws DAOException {
        try {

            Query q = entityManager().createQuery(SQLUtil.PESQUISA_RES_FINANCEIRO+ pesquisa +"'");
           Resp_Financeiro responsavel =(Resp_Financeiro) q.getSingleResult() ;
           responsavel.getNome();
           return responsavel;
            
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
            
        }catch(Exception e){
            e.printStackTrace();
            throw new DAOException("Erro de busca no "+ class1.getSimpleName()+ " " +e.getMessage());
        }
    }

    @Override
    public Resp_Financeiro buscarCPF(String cpf) throws DAOException {
         try {
            TypedQuery<Resp_Financeiro> typedQuery = entityManager().createQuery("SELECT u FROM Resp_Financeiro u WHERE u.cpf = :cpf", class1);
            typedQuery.setParameter("cpf", cpf);
            return typedQuery.getSingleResult();
            
        } catch (NoResultException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            throw new DAOException("Não foi encontrado nenhum cpf");
            
        }catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
            throw new DAOException("Erro de busca no "+ class1.getSimpleName()+ " " +e.getMessage());
        }
    }
    
}
