CREATE SEQUENCE public.seq_configuracao;

CREATE TABLE public.CONFIGURACAO (
                codigo INTEGER NOT NULL,
                valor VARCHAR NOT NULL,
                nome VARCHAR NOT NULL,
                CONSTRAINT configuracao_pk PRIMARY KEY (codigo)
);


CREATE TABLE public.SMS (
                codigo INTEGER NOT NULL,
                FILA_CODIGO BIGINT NOT NULL,
                CLIENTE_CODIGO BIGINT NOT NULL,
                conteudo VARCHAR NOT NULL,
                destino VARCHAR NOT NULL,
                data_envio TIMESTAMP NOT NULL,
                data_confirmacao TIMESTAMP NOT NULL,
                data_cadastro TIMESTAMP NOT NULL,
                data_agendamento_envio_sms TIMESTAMP NOT NULL,
                STATUS_SMS INTEGER NOT NULL,
                status_entrega_sms INTEGER NOT NULL,
                retorno_entrega_sms VARCHAR NOT NULL,
                codigo_fornecedor_sms INTEGER NOT NULL,
                CONSTRAINT sms_codigo PRIMARY KEY (codigo)
);

ALTER TABLE public.SMS ADD CONSTRAINT fila_cliente_sms_fk
FOREIGN KEY (CLIENTE_CODIGO, FILA_CODIGO)
REFERENCES public.FILA_CLIENTE (CLIENTE_CODIGO, FILA_CODIGO)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;