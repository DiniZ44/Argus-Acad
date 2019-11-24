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
    
    //  DML
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
    public static final String BUSCAR_LOG = "select l.data, l.alteracao, l.autor, l.tabela FROM log l ";
    
    
    //  VIEWS

    public static final String OBSERVACAO_VIEW = "CREATE VIEW observacao_view as\n" +
                                                "select o.descricao, a.nome, c.nome as n_coordenador\n" +
                                                "from observacao_aluno o inner join aluno a on \n" +
                                                "(a.id = o.aluno_id) inner join cord_pedagogo c on \n" +
                                                "(c.id = o.coordenador_id )";
    
    public static final String ALUNO_VIEW = "CREATE VIEW aluno_resp_view AS\n" +
                                            "select a.nome, r.nome as nome_responsavel \n" +
                                            "from aluno a inner join resp_financeiro r \n" +
                                            "on (a.responsavel_financeiro_id = r.id)";
    
    public static final String ALUNO_CONTATO = "Create VIEW aluno_contato_view as \n" +
                                                "SELECT a.nome, c.celular, c.email, c.telefone \n" +
                                                "from aluno a inner join contato c ON c.id = a.contato_id ";
    

    //  PROCEDURES
    
    
    // TRIGGERS
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
			"CREATE TRIGGER tr_gera_log_super_user\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON super_usuario\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_secretaria\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON secretaria\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_coord\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON cord_pedagogo\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" + 
			"CREATE TRIGGER tr_gera_log_diretor\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON diretor\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n" +
                        "CREATE TRIGGER tr_gera_log_endereco\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON endereco\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n"+
                        "CREATE TRIGGER tr_gera_log_contato\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON contato\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n"+
                        "CREATE TRIGGER tr_gera_log_aluno\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON aluno\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n"+
                        "CREATE TRIGGER tr_gera_log_professor\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON professor\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n"+
                        "CREATE TRIGGER tr_gera_log_turma\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON turma\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n"+"CREATE TRIGGER tr_gera_log_disciplina\n" + 
			"BEFORE INSERT OR UPDATE OR DELETE\n" + 
			"ON disciplina\n" + 
			"FOR EACH ROW\n" + 
			"EXECUTE PROCEDURE gera_log();\n" + 
			"\n";
    
}
