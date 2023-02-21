-- Adminer 4.8.1 PostgreSQL 15.2 dump

DROP TABLE IF EXISTS "cartao";
DROP SEQUENCE IF EXISTS cartao_id_cartao_seq;
CREATE SEQUENCE cartao_id_cartao_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."cartao" (
    "id_cartao" bigint DEFAULT nextval('cartao_id_cartao_seq') NOT NULL,
    "nome_cartao" character varying(255) NOT NULL,
    "status_cartao" boolean NOT NULL,
    "tipo_cartao" character varying(255) NOT NULL,
    "fk_usuario" integer NOT NULL,
    CONSTRAINT "cartao_pkey" PRIMARY KEY ("id_cartao")
) WITH (oids = false);


DROP TABLE IF EXISTS "usuario";
DROP SEQUENCE IF EXISTS usuario_id_usuario_seq;
CREATE SEQUENCE usuario_id_usuario_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."usuario" (
    "id_usuario" integer DEFAULT nextval('usuario_id_usuario_seq') NOT NULL,
    "nome_usuario" character varying NOT NULL,
    "email_usuario" character varying NOT NULL,
    "senha_usuario" character varying,
    CONSTRAINT "usuario_pkey" PRIMARY KEY ("id_usuario")
) WITH (oids = false);

INSERT INTO "usuario" ("id_usuario", "nome_usuario", "email_usuario", "senha_usuario") VALUES
(1,	'Ana Paula Lima',	'anapaulalima@gmail.com',	'gGHmE5I20Mbj');

ALTER TABLE ONLY "public"."cartao" ADD CONSTRAINT "cartao_fk_usuario_fkey" FOREIGN KEY (fk_usuario) REFERENCES usuario(id_usuario) ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE;

-- 2023-02-21 01:08:22.103075+00
