ALTER TABLE perfil ADD COLUMN is_admin BOOLEAN NOT NULL DEFAULT FALSE;

ALTER TABLE USUARIO ALTER COLUMN data_ultimo_acesso DROP NOT NULL;

ALTER TABLE USUARIO DROP COLUMN flg_ativo;

ALTER TABLE USUARIO ADD COLUMN flg_ativo BOOLEAN NOT NULL DEFAULT TRUE;

CREATE SEQUENCE public.seq_url;

CREATE TABLE public.url (
    codigo INTEGER NOT NULL  DEFAULT nextval('public.seq_url'),
    url VARCHAR(100) NOT NULL UNIQUE,
    CONSTRAINT pk_url PRIMARY KEY (codigo)
);


CREATE TABLE public.perfil_url (
    perfil_codigo INTEGER NOT NULL,
    url_codigo INTEGER NOT NULL,
    CONSTRAINT pk_perfil_url PRIMARY KEY (perfil_codigo, url_codigo)
);

INSERT INTO url (url) VALUES ('/seguranca/usuario_form.xhtml');

INSERT INTO url (url) VALUES ('/seguranca/usuario_consulta.xhtml');

ALTER TABLE URL ADD COLUMN liberada BOOLEAN DEFAULT FALSE;

ALTER TABLE "public"."cliente" ALTER COLUMN data_primeiro_acesso DROP NOT NULL;
ALTER TABLE "public"."cliente" ALTER COLUMN data_ultimo_acesso DROP NOT NULL;

CREATE SEQUENCE public.seq_cliente;

ALTER TABLE CLIENTE ALTER COLUMN CODIGO SET DEFAULT nextval('seq_cliente');