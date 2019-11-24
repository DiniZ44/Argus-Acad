CREATE VIEW observacao_view as
select o.descricao, a.nome, c.nome as n_coordenador
from observacao_aluno o inner join aluno a on 
(a.id = o.aluno_id) inner join cord_pedagogo c on 
(c.id = o.coordenador_id )