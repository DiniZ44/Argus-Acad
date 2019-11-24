/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.util;

import br.com.argus.model.Resp_Financeiro;


/**
 *
 * @author Hakkinen
 */
public class SQLUtil {
    
    //DML
    public static final String BUSCAR_LOGIN = "select u from Usuario u where u.login = :login and u.senha = :senha";
    public static final String BUSCAR_LOGIN_APENAS = "select u from Usuario u where u.login = :login";
    public static final String BUSCAR_CPF_PROFESSOR = "SELECT u FROM Professor u WHERE u.cpf = :cpf";
    public static final String BUSCAR_CPF_USUARIO = "SELECT u FROM Usuario u WHERE u.cpf = :cpf";
    public static final String BUSCAR_CPF_RESPONSAVEL = "SELECT u FROM Resp_Financeiro u WHERE u.cpf = :cpf";
    public static final String BUSCAR_TIPO_USUARIO = "SELECT u FROM Usuario u WHERE u.tipoCargo='";
    public static final String PESQUISA_RES_FINANCEIRO= "SELECT p FROM Resp_Financeiro p WHERE p.nome LIKE '";
    public static String TIPO = "SELECT";
    public static final String BUSCAR_TURMA_ORDEM =  "SELECT c FROM Turma c order by c.nome";
    public static final String BUSCAR_ALUNO_ORDEM = "SELECT c FROM Aluno c order by c.nome";
    public static final String BUSCAR_DISCIPLINA_ORDEM= "SELECT c FROM Disciplina c order by c.nome";
//    public static final String = "";
//    public static final String = "";
//    public static final String = "";
    // Fazer consulta por turma para ver disciplinas
    // Fazer consulta por disciplina para ver alunos

    
    	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static final String GATILHOS_LOG = "CREATE OR REPLACE FUNCTION gera_log()\n" + 
			"RETURNS TRIGGER\n" + 
			"AS $$\n" + 
			"BEGIN\n" + 
			"INSERT INTO log (data, autor, alteracao, tabela)\n" + 
			"VALUES (now(), user, TG_OP, TG_RELNAME);\n" + 
			"RETURN NEW;\n" + 
			"END; \n" + 
			"$$ LANGUAGE plpgsql;\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_admin\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON administrador\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_aluga\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON aluga\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_caixa\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON caixa\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_contato\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON contato\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_endereco\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON endereco\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_funcionario\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON funcionario\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_pessoa_fisica\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON pessoa_fisica\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_pessoa_juridica\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON pessoa_juridica\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_quarto\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON quarto\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_reserva\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON reserva\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_super_usuario\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON super_usuario\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();";

    
}
