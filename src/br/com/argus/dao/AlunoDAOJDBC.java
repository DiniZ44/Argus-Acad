/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.dao;

import br.com.argus.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author santo
 */
public class AlunoDAOJDBC implements IAlunoDAOJDBC{
    
    //private PreparedStatement statement;
     //private ResultSet resultSet;
    // private Connection ConexaoBD;

    @Override
    public void inserir(Aluno aluno) throws Exception {
//        statement = ConexaoBD.prepareStatement("insert into aluno (nome,mae,pai,naturalidade) values(?,?,?,?)");
//        statement.setString(1, aluno.getNome());
//        statement.setString(2, aluno.getMae());
//        statement.setString(3, aluno.getPai());
//        statement.setString(4, aluno.getNaturalidade());
//        statement.executeUpdate();
        
    }


    @Override
    public Aluno buscar(Aluno aluno) throws Exception {
//        statement= ConexaoBD.prepareStatement("SELECT * FROM usuario WHERE login='"+aluno.getNome()+"'");
//         resultSet=statement.executeQuery();
//         resultSet.next();
//        //VERIFICA SE RETORNOU ALGUM RESULTADO SE NÃO RETORNA NULL
//        if (!resultSet.isFirst()) {
//           return null;
//        }
//        //SE PASSOU DO IF SIGNIFICA QUE ACHOU O USUÁRIO, LOGO VAI RETURNAR O USUÁRIO ENCONTRADO
//        Aluno aluno1= new Aluno();
//        aluno1.setId(resultSet.getInt("id"));
//        aluno1.setNome(resultSet.getString("nome"));
//        aluno1.setMae(resultSet.getString("mae"));
//        aluno1.setPai(resultSet.getString("pai"));
//        aluno1.setNaturalidade(resultSet.getString("naturalidade"));
//        return aluno1;
return null;
    }

























    
}
