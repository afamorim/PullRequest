CREATE SEQUENCE public.seq_tipo_pergunta;

CREATE TABLE public.tipo_pergunta (
                codigo INTEGER NOT NULL DEFAULT nextval('public.seq_tipo_pergunta'),
                descricao VARCHAR NOT NULL,
                CONSTRAINT tipo_pergunta_pk PRIMARY KEY (codigo)
);

ALTER SEQUENCE public.seq_tipo_pergunta OWNED BY public.tipo_pergunta.codigo;


CREATE SEQUENCE public.seq_perfil;

CREATE TABLE public.perfil (
                codigo INTEGER NOT NULL DEFAULT nextval('public.seq_perfil'),
                descricao VARCHAR NOT NULL,
                CONSTRAINT perfil_pk PRIMARY KEY (codigo)
);


ALTER SEQUENCE public.seq_perfil OWNED BY public.perfil.codigo;

CREATE SEQUENCE public.seq_usuario;

CREATE TABLE public.usuario (
                codigo BIGINT NOT NULL DEFAULT nextval('public.seq_usuario'),
                perfil_codigo INTEGER NOT NULL,
                nome VARCHAR NOT NULL,
                login VARCHAR NOT NULL,
                senha VARCHAR NOT NULL,
                data_cadastro TIMESTAMP NOT NULL,
                data_ultimo_acesso TIMESTAMP NOT NULL,
                flg_ativo VARCHAR NOT NULL,
                CONSTRAINT usuario_pk PRIMARY KEY (codigo)
);


ALTER SEQUENCE public.seq_usuario OWNED BY public.usuario.codigo;



CREATE SEQUENCE public.seq_pesq_sast;

CREATE TABLE public.pesquisa_satisfacao (
                codigo BIGINT NOT NULL DEFAULT nextval('public.seq_pesq_sast'),
                descricao VARCHAR NOT NULL,
                flg_ativo VARCHAR NOT NULL,
                data_cadastro TIMESTAMP NOT NULL,
                CONSTRAINT codigo PRIMARY KEY (codigo)
);


ALTER SEQUENCE public.seq_pesq_sast OWNED BY public.pesquisa_satisfacao.codigo;


CREATE SEQUENCE public.seq_pergunta;

CREATE TABLE public.pergunta (
                codigo BIGINT NOT NULL DEFAULT nextval('public.seq_pergunta'),
                descricao VARCHAR NOT NULL,
                tipo_pergunta_codigo INTEGER NOT NULL,
                CONSTRAINT FK_PERGUNTA PRIMARY KEY (codigo)
);


ALTER SEQUENCE public.seq_pergunta OWNED BY public.pergunta.codigo;

CREATE TABLE public.perguntas_pesquisa (
                pesquisa_codigo BIGINT NOT NULL,
                pergunta_codigo BIGINT NOT NULL,
                usuario_cadastro BIGINT NOT NULL,
                data_cadastro TIMESTAMP NOT NULL,
                flg_resposta_obrigatoria VARCHAR NOT NULL,
                CONSTRAINT perguntas_pesquisa_pk PRIMARY KEY (pesquisa_codigo, pergunta_codigo)
);


CREATE SEQUENCE public.seq_resp_est;

CREATE TABLE public.responsavel_estabelecimento (
                codigo INTEGER NOT NULL DEFAULT nextval('public.seq_resp_est'),
                data_cadastro TIMESTAMP NOT NULL,
                usuario_cadastro BIGINT NOT NULL,
                nome VARCHAR NOT NULL,
                telefone VARCHAR NOT NULL,
                email VARCHAR NOT NULL,
                nascimento DATE NOT NULL,
                CONSTRAINT responsavel_estabelecimento_pk PRIMARY KEY (codigo)
);

ALTER SEQUENCE public.seq_resp_est OWNED BY public.responsavel_estabelecimento.codigo;

CREATE TABLE public.CLIENTE (
                CODIGO BIGINT NOT NULL,
                usuario_cadastro BIGINT NOT NULL,
                DATA_CADASTRO TIMESTAMP DEFAULT NOW() NOT NULL,
                NOME VARCHAR NOT NULL,
                NASCIMENTO DATE NOT NULL,
                TELEFONE VARCHAR NOT NULL,
                EMAIL VARCHAR NOT NULL,
                DATA_ULTIMO_ACESSO TIME NOT NULL,
                DATA_PRIMEIRO_ACESSO TIMESTAMP NOT NULL,
                ENDERECO VARCHAR NOT NULL,
                BAIRRO VARCHAR NOT NULL,
                foto_cliente BYTEA NOT NULL,
                apelido VARCHAR NOT NULL,
                CONSTRAINT cliente_codigo_pk PRIMARY KEY (CODIGO)
);


COMMENT ON COLUMN public.CLIENTE.DATA_ULTIMO_ACESSO IS 'CAMPO COM OBJETIVO DE MANTER ATUALIZADO ULTIMO ACESSO DAQUELE CLIENTE. PROVAVELMENTE TEREMOS UMA TRIGGER PARA ATUALIZAR ESSE CAMPO TODA VEZ QUE FOR CRIADA UMA FILA COM O USUARIO';
COMMENT ON COLUMN public.CLIENTE.DATA_PRIMEIRO_ACESSO IS 'CAMPO COM OBJETIVO DE REGISTRAR QUAL PRIMEIRO ACESSO DO CLIENTE. NAO NECESSARIAMENTE O PRIMEIRO ACESSO SERA A DATA DE CADASTRO';
COMMENT ON COLUMN public.CLIENTE.ENDERECO IS 'CAMPO COM OBJETIVO DE RASTREAR LOCALIZACAO PARA SUGERIR PROMOCOES BASEADO NA LOCALIZACAO';
COMMENT ON COLUMN public.CLIENTE.BAIRRO IS 'CAMPO COM OBJETIVO DE RASTREAR LOCALIZACAO PARA SUGERIR PROMOCOES BASEADO NA LOCALIZACAO';

CREATE SEQUENCE public.seq_status_fila_1;

CREATE TABLE public.STATUS_FILA (
                codigo INTEGER NOT NULL DEFAULT nextval('public.seq_status_fila_1'),
                nome VARCHAR NOT NULL,
                CONSTRAINT status_fila_pk PRIMARY KEY (codigo)
);


ALTER SEQUENCE public.seq_status_fila_1 OWNED BY public.STATUS_FILA.codigo;

CREATE SEQUENCE public.seq_estabelecimento;

CREATE TABLE public.ESTABELECIMENTO (
                codigo BIGINT NOT NULL DEFAULT nextval('public.seq_estabelecimento'),
                usuario_cadastro BIGINT NOT NULL,
                data_cadastro TIMESTAMP NOT NULL,
                nome VARCHAR NOT NULL,
                telefone BIGINT NOT NULL,
                quantidade_total_vagas INTEGER NOT NULL,
                url_logo VARCHAR,
                telefone_1 VARCHAR NOT NULL,
                email VARCHAR NOT NULL,
                responsavel_estabelecimento_codigo INTEGER NOT NULL,
                endereco VARCHAR NOT NULL,
                localizacao_google_maps VARCHAR NOT NULL,
                foto BYTEA NOT NULL,
                CONSTRAINT estabelecimento_pk PRIMARY KEY (codigo)
);

ALTER SEQUENCE public.seq_estabelecimento OWNED BY public.ESTABELECIMENTO.codigo;


CREATE TABLE public.ESTABELECIMENTO_CLIENTE (
                estabelecimento_codigo BIGINT NOT NULL,
                cliente_codigo BIGINT NOT NULL,
                usuario_cadastro BIGINT NOT NULL,
                data_cadastro VARCHAR NOT NULL,
                envia_email_aniversario BOOLEAN NOT NULL,
                envia_sms_aniversario BOOLEAN NOT NULL,
                data_ultima_visita TIMESTAMP NOT NULL,
                flg_cliente_vip BOOLEAN NOT NULL,
                CONSTRAINT estabelecimento_cliente_pk PRIMARY KEY (estabelecimento_codigo, cliente_codigo)
);


CREATE SEQUENCE public.seq_fila;

CREATE TABLE public.FILA (
                codigo BIGINT NOT NULL DEFAULT nextval('public.seq_fila'),
                pesquisa_satisfacao_codigo BIGINT NOT NULL,
                descricao VARCHAR NOT NULL,
                ESTABELECIMENTO_codigo BIGINT NOT NULL,
                STATUS_FILA_codigo INTEGER NOT NULL,
                usuario_cadastro BIGINT NOT NULL,
                data_cadastro TIMESTAMP NOT NULL,
                notificado_proximo BOOLEAN DEFAULT false NOT NULL,
                CONSTRAINT fila_pk PRIMARY KEY (codigo)
);


ALTER SEQUENCE public.seq_fila OWNED BY public.FILA.codigo;


CREATE TABLE public.FILA_CLIENTE (
                CLIENTE_CODIGO BIGINT NOT NULL,
                FILA_CODIGO BIGINT NOT NULL,
                quantidade SMALLINT NOT NULL,
                data_cadastro TIMESTAMP NOT NULL,
                usuario_cadastro BIGINT NOT NULL,
                data_entrada TIMESTAMP NOT NULL,
                data_saida TIMESTAMP,
                data_cancelamento TIMESTAMP NOT NULL,
                motivo_cancelamento VARCHAR,
                nota_atendimento INTEGER NOT NULL,
                comentario_satisfacao VARCHAR,
                flg_reserva BOOLEAN NOT NULL,
                flg_resposta_pesquisa VARCHAR NOT NULL,
                CONSTRAINT fila_cliente_pk PRIMARY KEY (CLIENTE_CODIGO, FILA_CODIGO)
);


CREATE SEQUENCE public.seq_resp_pesquisa;

CREATE TABLE public.resposta_pesquisa (
                codigo BIGINT NOT NULL DEFAULT nextval('public.seq_resp_pesquisa'),
                cliente_codigo BIGINT NOT NULL,
                data_cadastro TIMESTAMP NOT NULL,
                descricao VARCHAR NOT NULL,
                pergunta_codigo BIGINT NOT NULL,
                CONSTRAINT resposta_pesquisa_pk PRIMARY KEY (codigo, cliente_codigo)
);


ALTER SEQUENCE public.seq_resp_pesquisa OWNED BY public.resposta_pesquisa.codigo;



ALTER TABLE public.pergunta ADD CONSTRAINT tipo_pergunta_pergunta_fk
FOREIGN KEY (tipo_pergunta_codigo)
REFERENCES public.tipo_pergunta (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.usuario ADD CONSTRAINT perfil_usuario_fk
FOREIGN KEY (perfil_codigo)
REFERENCES public.perfil (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;



ALTER TABLE public.ESTABELECIMENTO ADD CONSTRAINT usuario_estabelecimento_fk
FOREIGN KEY (usuario_cadastro)
REFERENCES public.usuario (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.responsavel_estabelecimento ADD CONSTRAINT usuario_responsavel_estabelecimento_fk
FOREIGN KEY (usuario_cadastro)
REFERENCES public.usuario (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;



ALTER TABLE public.FILA ADD CONSTRAINT usuario_fila_fk2
FOREIGN KEY (usuario_cadastro)
REFERENCES public.usuario (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.FILA_CLIENTE ADD CONSTRAINT usuario_fila_cliente_fk
FOREIGN KEY (usuario_cadastro)
REFERENCES public.usuario (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.CLIENTE ADD CONSTRAINT usuario_cliente_fk
FOREIGN KEY (usuario_cadastro)
REFERENCES public.usuario (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;



ALTER TABLE public.ESTABELECIMENTO_CLIENTE ADD CONSTRAINT usuario_estabelecimento_cliente_fk
FOREIGN KEY (usuario_cadastro)
REFERENCES public.usuario (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.perguntas_pesquisa ADD CONSTRAINT usuario_perguntas_pesquisa_fk
FOREIGN KEY (usuario_cadastro)
REFERENCES public.usuario (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.perguntas_pesquisa ADD CONSTRAINT pesquisa_satisfacao_perguntas_pesquisa_fk
FOREIGN KEY (pesquisa_codigo)
REFERENCES public.pesquisa_satisfacao (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.FILA ADD CONSTRAINT pesquisa_satisfacao_fila_fk
FOREIGN KEY (pesquisa_satisfacao_codigo)
REFERENCES public.pesquisa_satisfacao (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;


ALTER TABLE public.perguntas_pesquisa ADD CONSTRAINT perguntas_perguntas_pesquisa_fk
FOREIGN KEY (pergunta_codigo)
REFERENCES public.pergunta (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.resposta_pesquisa ADD CONSTRAINT pergunta_resposta_pesquisa_fk
FOREIGN KEY (pergunta_codigo)
REFERENCES public.pergunta (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.ESTABELECIMENTO ADD CONSTRAINT responsavel_estabelecimento_estabelecimento_fk
FOREIGN KEY (responsavel_estabelecimento_codigo)
REFERENCES public.responsavel_estabelecimento (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.FILA_CLIENTE ADD CONSTRAINT cliente_fila_cliente_fk
FOREIGN KEY (CLIENTE_CODIGO)
REFERENCES public.CLIENTE (CODIGO)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;


ALTER TABLE public.ESTABELECIMENTO_CLIENTE ADD CONSTRAINT cliente_estabelecimento_cliente_fk
FOREIGN KEY (cliente_codigo)
REFERENCES public.CLIENTE (CODIGO)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.FILA ADD CONSTRAINT status_fila_fila_fk
FOREIGN KEY (STATUS_FILA_codigo)
REFERENCES public.STATUS_FILA (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.FILA ADD CONSTRAINT estabelecimento_fila_fk
FOREIGN KEY (ESTABELECIMENTO_codigo)
REFERENCES public.ESTABELECIMENTO (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.ESTABELECIMENTO_CLIENTE ADD CONSTRAINT estabelecimento_estabelecimento_cliente_fk
FOREIGN KEY (estabelecimento_codigo)
REFERENCES public.ESTABELECIMENTO (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;


ALTER TABLE public.FILA_CLIENTE ADD CONSTRAINT fila_fila_cliente_fk
FOREIGN KEY (FILA_CODIGO)
REFERENCES public.FILA (codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;


ALTER TABLE public.resposta_pesquisa ADD CONSTRAINT fila_cliente_resposta_pesquisa_fk
FOREIGN KEY (cliente_codigo)
REFERENCES public.CLIENTE (CODIGO)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;