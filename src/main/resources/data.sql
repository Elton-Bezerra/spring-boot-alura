insert into usuario(nome, email, senha) values ('Aluno', 'aluno@gmail.com', '123456');

insert into curso(nome, categoria) values ('Spring Boot I', 'Programação');
insert into curso(nome, categoria) values ('CPG', 'Bruxaria');

insert into Topico(titulo, mensagem, data_criacao, status, autor_id, curso_id) values('Dúvida', 'Erro ao criar projeto', '2019-07-05', 'NAO_RESPONDIDO', 1, 1);
insert into Topico(titulo, mensagem, data_criacao, status, autor_id, curso_id) values('Dúvida 2', 'Spring Boot não inicializa', '2019-07-05', 'NAO_RESPONDIDO', 1, 1);
insert into Topico(titulo, mensagem, data_criacao, status, autor_id, curso_id) values('Dúvida 3', 'Como não me suicidar trabalhando com isso?', '2019-07-05', 'NAO_RESPONDIDO', 1, 2);	