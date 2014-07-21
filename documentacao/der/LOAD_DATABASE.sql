INSERT INTO PERFIL (descricao) VALUES ('Administrador');

INSERT INTO PERFIL (descricao) VALUES ('Funcionario');


INSERT INTO USUARIO (perfil_codigo, nome, login, senha, data_cadastro, data_ultimo_acesso, flg_ativo) VALUES (1, 'Administrador', 'admin', '123', now());