/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author santo
 */
public class LoginQuery {
    
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    
    public LoginQuery() {
    entityManagerFactory = Persistence.createEntityManagerFactory("postgresql");
    entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    }
    
    public List<Usuario> listLogin() {
        return entityManager.createNamedQuery("Login_1.findAll", Usuario.class).getResultList();
    }
    
}
