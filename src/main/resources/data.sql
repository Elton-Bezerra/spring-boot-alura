insert into usuario(nome, email, senha) values ('Aluno', 'aluno@gmail.com', '123456');

insert into curso(nome, categoria) values ('Spring Boot I', 'Programação');
insert into curso(nome, categoria) values ('CPG', 'Bruxaria');

insert into Topico(titulo, mensagem, data_criacao, status, autor_id, curso_id) values('Dúvida', 'Erro ao criar projeto', {ts '2012-09-17 18:47:52.69'}, 'NAO_RESPONDIDO', 1, 1);
insert into Topico(titulo, mensagem, data_criacao, status, autor_id, curso_id) values('Dúvida 2', 'Spring Boot não inicializa', {ts '2012-09-17 18:50:52.69'}, 'NAO_RESPONDIDO', 1, 1);
insert into Topico(titulo, mensagem, data_criacao, status, autor_id, curso_id) values('Dúvida 3', 'Como não me suicidar trabalhando com isso?', {ts '2012-09-17 18:48:52.69'}, 'NAO_RESPONDIDO', 1, 2);