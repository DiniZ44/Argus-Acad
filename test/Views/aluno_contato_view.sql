Create VIEW aluno_contato_view as 
SELECT a.nome, c.celular, c.email, c.telefone 
from aluno a inner join contato c ON c.id = a.contato_id
