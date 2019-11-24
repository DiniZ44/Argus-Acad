CREATE VIEW aluno_resp_view AS
select a.nome, r.nome as nome_responsavel 
from aluno a inner join resp_financeiro r 
on (a.responsavel_financeiro_id = r.id)