/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.util;


/**
 *
 * @author Hakkinen
 */
public class SQLUtil {
    
    public static final String BUSCAR_LOGIN = "select u from Usuario u where u.login = :login and u.senha = :senha";
    public static final String BUSCAR_TIPO_USUARIO = "SELECT u FROM Usuario u WHERE u.tipoCargo='";
    public static final String PESQUISA_PROFESSOR = "SELECT p FROM Professor p WHERE p.nome LIKE '";
    public static String TIPO = "SELECT";
 //  public static final String BUSCAR_TODOS_USUARIOS = "select u from Usuario";
//    public static final String BUSCAR_ALUNOS_TABLE = "select pf from PessoaFisicaView pf inner join Endereco e on pf.endereco.id = e.id where lower(str(pf.nome)) like :busca or pf.cpf = :busca";
    
}
