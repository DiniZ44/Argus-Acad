			CREATE OR REPLACE FUNCTION gera_log()
			RETURNS TRIGGER
			AS $$
			BEGIN
			INSERT INTO log (data, autor, alteracao, tabela)
			VALUES (now(), user, TG_OP, TG_RELNAME);
			RETURN NEW;
			END;
			$$ LANGUAGE plpgsql;
			CREATE TRIGGER tr_gera_log_super_user
			BEFORE INSERT OR UPDATE OR DELETE
			ON super_usuario
			FOR EACH ROW
			EXECUTE PROCEDURE gera_log();
			
			CREATE TRIGGER tr_gera_log_secretaria
			BEFORE INSERT OR UPDATE OR DELETE
			ON secretaria
			FOR EACH ROW
			EXECUTE PROCEDURE gera_log();
			CREATE TRIGGER tr_gera_log_coord
			BEFORE INSERT OR UPDATE OR DELETE
			ON cord_pedagogo
			FOR EACH ROW
			EXECUTE PROCEDURE gera_log();
			
			CREATE TRIGGER tr_gera_log_diretor
			BEFORE INSERT OR UPDATE OR DELETE
			ON diretor
			FOR EACH ROW
			EXECUTE PROCEDURE gera_log();
			
            CREATE TRIGGER tr_gera_log_endereco
			BEFORE INSERT OR UPDATE OR DELETE
			ON endereco
			FOR EACH ROW
			EXECUTE PROCEDURE gera_log();
			
            CREATE TRIGGER tr_gera_log_contato
			BEFORE INSERT OR UPDATE OR DELETE
			ON contato
			FOR EACH ROW
			EXECUTE PROCEDURE gera_log();
			
            CREATE TRIGGER tr_gera_log_aluno
			BEFORE INSERT OR UPDATE OR DELETE
			ON aluno
			FOR EACH ROW
			EXECUTE PROCEDURE gera_log();
			
            CREATE TRIGGER tr_gera_log_professor
			BEFORE INSERT OR UPDATE OR DELETE
			ON professor
			FOR EACH ROW
			EXECUTE PROCEDURE gera_log();
			
            CREATE TRIGGER tr_gera_log_turma
			BEFORE INSERT OR UPDATE OR DELETE
			ON turma
			FOR EACH ROW
			EXECUTE PROCEDURE gera_log();
			