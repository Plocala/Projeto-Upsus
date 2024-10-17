<<<<<<< Updated upstream
-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
-- Insert data into the paciente table
-- Insert data into the paciente table
-- Insert data into the paciente table
-- Insert data into the paciente table
-- Insert data into the paciente table
insert into paciente (id, datanascimento, dataultimaconsulta, num, sexo, dataalteracao, datacadastro, cpf, cartaosus, obs, email, nome, nomemae, bairro, cep, cidade, codigoarea, complemento, estado, numero, anotacao) values
(1, '1990-01-01', '2023-01-01', '123', true, '2023-01-01', '2023-01-01', '12345678901', '123456789012345', 'Nenhuma anotacao', 'paciente1@example.com', 'Paciente 1', 'Mae 1', 'Bairro 1', '12345-678', 'Cidade 1', '11', 'Complemento 1', 'Estado 1', '123', 'Nenhuma anotacao'),
(2, '1985-02-02', '2023-01-02', '456', false, '2023-01-02', '2023-01-02', '23456789012', '234567890123456', 'Nenhuma anotacao', 'paciente2@example.com', 'Paciente 2', 'Mae 2', 'Bairro 2', '23456-789', 'Cidade 2', '22', 'Complemento 2', 'Estado 2', '456', 'Nenhuma anotacao');

-- Insert data into the exame table
insert into exame (id, dataalteracao, datacadastro, momento, paciente_id, resultado, tipo, anotacao) values
(1, '2023-01-01', '2023-01-01', '2023-01-01 10:00:00', 1, 'Negativo', 'Sangue', 'Nenhuma anotacao'),
(2, '2023-01-02', '2023-01-02', '2023-01-02 11:00:00', 2, 'Positivo', 'Urina', 'Nenhuma anotacao');

-- Insert data into the profissional table
insert into profissional (id, formacao, num, dataalteracao, datacadastro, cpf, email, especialidade, nome, bairro, cep, cidade, codigoarea, complemento, estado, numero, senha) values
(1, 1, '789', '2023-01-01', '2023-01-01', '34567890123', 'profissional1@example.com', 'Cardiologia', 'Profissional 1', 'Bairro 1', '12345-678', 'Cidade 1', '11', 'Complemento 1', 'Estado 1', '123', 'senha1'),
(2, 2, '012', '2023-01-02', '2023-01-02', '45678901234', 'profissional2@example.com', 'Pediatria', 'Profissional 2', 'Bairro 2', '23456-789', 'Cidade 2', '22', 'Complemento 2', 'Estado 2', '456', 'senha2');

-- Insert data into the profissional_exame table
insert into profissional_exame (exame_id, profissional_id) values
(1, 1),
(2, 2);

-- Insert data into the tarefa table
insert into tarefa (id, status, dataalteracao, datacadastro, nome, descricao) values
(1, 1, '2023-01-01', '2023-01-01', 'Tarefa 1', 'Descricao da Tarefa 1'),
(2, 2, '2023-01-02', '2023-01-02', 'Tarefa 2', 'Descricao da Tarefa 2');
=======
>>>>>>> Stashed changes
