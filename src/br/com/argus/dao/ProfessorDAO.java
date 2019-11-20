/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.exceptions.DAOException;
import br.com.argus.model.Professor;
import br.com.argus.model.Resp_Financeiro;
import br.com.argus.model.Usuario;
import br.com.argus.util.SQLUtil;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author santo
 */
public class ProfessorDAO extends Dao<Professor> implements IProfessorDAO{
    
    public ProfessorDAO() {
        super(Professor.class);
    }

    @Override
    public Professor buscarCPF(String cpf) throws DAOException {
                 try {
            TypedQuery<Professor> typedQuery = entityManager().createQuery(SQLUtil.BUSCAR_CPF_PROFESSOR, class1);
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


    

