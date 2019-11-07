/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.util;

/**
 *
 * @author santo
 */
public class SQLUtil {
    
    public static final String BUSCAR_LOGIN = "select u from Usuario u where u.login = :login and u.senha = :senha";
    public static final String BUSCAR_TIPO_USUARIO = "select u from Usuario u where u.tipocargo = : tipocargo";
    public static final String BUSCAR_TODOS_USUARIOS = "select u from Usuario";
//    public static final String BUSCAR_ALUNOS_TABLE = "select pf from PessoaFisicaView pf inner join Endereco e on pf.endereco.id = e.id where lower(str(pf.nome)) like :busca or pf.cpf = :busca";
    
}
