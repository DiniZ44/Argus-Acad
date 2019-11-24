--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.14
-- Dumped by pg_dump version 9.6.14

-- Started on 2019-11-22 10:07:35

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2323 (class 1262 OID 24719)
-- Name: Projeto_PBD; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "Projeto_PBD" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE "Projeto_PBD" OWNER TO postgres;

\connect "Projeto_PBD"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2325 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 190 (class 1259 OID 81095)
-- Name: aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aluno (
    id integer NOT NULL,
    status boolean,
    matricula character varying(50),
    data_nascimento bytea,
    mae character varying(50) NOT NULL,
    naturalidade character varying(50) NOT NULL,
    nome character varying(150) NOT NULL,
    pai character varying(50) NOT NULL,
    contato_id integer,
    endereco_id integer,
    responsavel_financeiro_id integer
);


ALTER TABLE public.aluno OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 81283)
-- Name: aluno_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.aluno_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.aluno_sequence OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 81104)
-- Name: carne_pagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.carne_pagamento (
    id integer NOT NULL,
    status boolean,
    data bytea NOT NULL,
    valor double precision,
    resp_financeiro_id integer
);


ALTER TABLE public.carne_pagamento OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 81285)
-- Name: carne_pagamento_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.carne_pagamento_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.carne_pagamento_sequence OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 81112)
-- Name: contato; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contato (
    id integer NOT NULL,
    status boolean,
    celular character varying(20) NOT NULL,
    email character varying(50) NOT NULL,
    telefone character varying(20) NOT NULL
);


ALTER TABLE public.contato OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 81287)
-- Name: contato_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contato_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contato_sequence OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 24834)
-- Name: coordenador_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.coordenador_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.coordenador_sequence OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 81117)
-- Name: cord_pedagogo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cord_pedagogo (
    id integer NOT NULL,
    status boolean,
    cpf character varying(15) NOT NULL,
    login character varying(50) NOT NULL,
    nome character varying(100) NOT NULL,
    senha character varying(15) NOT NULL,
    tipocargo character varying(255)
);


ALTER TABLE public.cord_pedagogo OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 81122)
-- Name: diretor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.diretor (
    id integer NOT NULL,
    status boolean,
    cpf character varying(15) NOT NULL,
    login character varying(50) NOT NULL,
    nome character varying(100) NOT NULL,
    senha character varying(15) NOT NULL,
    tipocargo character varying(255)
);


ALTER TABLE public.diretor OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 24836)
-- Name: diretor_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.diretor_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.diretor_sequence OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 81127)
-- Name: disciplina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.disciplina (
    id integer NOT NULL,
    status boolean,
    carga_horaria character varying(5) NOT NULL,
    codigo character varying(255) NOT NULL,
    nome character varying(20) NOT NULL,
    statusaluno character varying(255),
    professor_id integer
);


ALTER TABLE public.disciplina OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 81289)
-- Name: disciplina_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.disciplina_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.disciplina_sequence OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 81135)
-- Name: disciplina_turma; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.disciplina_turma (
    id integer NOT NULL,
    status boolean,
    disciplina_id integer,
    turma_id integer
);


ALTER TABLE public.disciplina_turma OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 81140)
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endereco (
    id integer NOT NULL,
    status boolean,
    bairro character varying(120) NOT NULL,
    cep character varying(9) NOT NULL,
    cidade character varying(50) NOT NULL,
    complemento character varying(50) NOT NULL,
    logradouro character varying(120) NOT NULL,
    numero character varying(20) NOT NULL,
    tipoestadouf character varying(255)
);


ALTER TABLE public.endereco OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 81291)
-- Name: endereco_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.endereco_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.endereco_sequence OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 81087)
-- Name: falta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.falta (
    id integer NOT NULL,
    status boolean,
    data bytea,
    justificativa character varying(255),
    preseca boolean,
    vinculoalunoturma_id integer
);


ALTER TABLE public.falta OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 81293)
-- Name: falta_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.falta_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.falta_sequence OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 81148)
-- Name: liquida_carne; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.liquida_carne (
    id integer NOT NULL,
    status boolean,
    pago boolean,
    carne_pagamento_id integer
);


ALTER TABLE public.liquida_carne OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 81295)
-- Name: liquidacarne_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.liquidacarne_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.liquidacarne_sequence OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 81297)
-- Name: obs_aluno_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.obs_aluno_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.obs_aluno_sequence OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 81153)
-- Name: observacao_aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.observacao_aluno (
    id integer NOT NULL,
    status boolean,
    data bytea,
    descricao character varying(255),
    coordenador_id integer,
    vinculoalunoturma_id integer
);


ALTER TABLE public.observacao_aluno OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 81161)
-- Name: professor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.professor (
    id integer NOT NULL,
    status boolean,
    cpf character varying(15) NOT NULL,
    data_nascimento bytea NOT NULL,
    naturalidade character varying(255) NOT NULL,
    nome character varying(255) NOT NULL,
    contato_id integer,
    endereco_id integer
);


ALTER TABLE public.professor OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 81299)
-- Name: professor_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.professor_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.professor_sequence OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 81301)
-- Name: resp_fin_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.resp_fin_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.resp_fin_sequence OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 81169)
-- Name: resp_financeiro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.resp_financeiro (
    id integer NOT NULL,
    status boolean,
    cpf character varying(15) NOT NULL,
    nome character varying(100) NOT NULL
);


ALTER TABLE public.resp_financeiro OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 81174)
-- Name: secretaria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.secretaria (
    id integer NOT NULL,
    status boolean,
    cpf character varying(15) NOT NULL,
    login character varying(50) NOT NULL,
    nome character varying(100) NOT NULL,
    senha character varying(15) NOT NULL,
    tipocargo character varying(255)
);


ALTER TABLE public.secretaria OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 24846)
-- Name: secretaria_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.secretaria_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.secretaria_sequence OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 81179)
-- Name: super_usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.super_usuario (
    id integer NOT NULL,
    status boolean,
    cpf character varying(15) NOT NULL,
    login character varying(50) NOT NULL,
    nome character varying(100) NOT NULL,
    senha character varying(15) NOT NULL,
    tipocargo character varying(255)
);


ALTER TABLE public.super_usuario OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 24848)
-- Name: super_usuario_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.super_usuario_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.super_usuario_sequence OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 81184)
-- Name: turma; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.turma (
    id integer NOT NULL,
    status boolean,
    anoletivo character varying(20),
    nome character varying(20) NOT NULL
);


ALTER TABLE public.turma OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 81303)
-- Name: turma_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.turma_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.turma_sequence OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 81305)
-- Name: usuario_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_sequence OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 81189)
-- Name: vinculo_aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vinculo_aluno (
    id integer NOT NULL,
    status boolean,
    media double precision,
    mediafinal double precision,
    nota1 double precision,
    nota2 double precision,
    nota3 double precision,
    nota4 double precision,
    situacaoaluno character varying(255),
    aluno_id integer,
    disciplinaturma_id integer
);


ALTER TABLE public.vinculo_aluno OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 81307)
-- Name: vinculo_aluno_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vinculo_aluno_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vinculo_aluno_sequence OWNER TO postgres;

--
-- TOC entry 2289 (class 0 OID 81095)
-- Dependencies: 190
-- Data for Name: aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.aluno (id, status, matricula, data_nascimento, mae, naturalidade, nome, pai, contato_id, endereco_id, responsavel_financeiro_id) VALUES (7, true, '6243784932', '\xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007cf0c1b78', 'Maria de Lourdes', 'BRASIL', 'Hakkinen Diniz', 'Paulo Gomes Soares', 4, 4, 1);
INSERT INTO public.aluno (id, status, matricula, data_nascimento, mae, naturalidade, nome, pai, contato_id, endereco_id, responsavel_financeiro_id) VALUES (9, true, '24354678', '\xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007d0010b78', 'Simone', 'BRASIL', 'Felipe Souza ', 'Nao sei', 6, 6, 2);
INSERT INTO public.aluno (id, status, matricula, data_nascimento, mae, naturalidade, nome, pai, contato_id, endereco_id, responsavel_financeiro_id) VALUES (8, true, '2435466768', '\xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007d2081878', 'Maria de Lourdes', 'BRASIL', 'Claire Emilie Diniz', 'Pereira Silva', 5, 5, 1);
INSERT INTO public.aluno (id, status, matricula, data_nascimento, mae, naturalidade, nome, pai, contato_id, endereco_id, responsavel_financeiro_id) VALUES (10, true, '234546767654', '\xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007e30b0878', 'Maria', 'Arrgentino', 'Jose Clodoaldo', 'Francsico', 8, 8, 1);


--
-- TOC entry 2326 (class 0 OID 0)
-- Dependencies: 206
-- Name: aluno_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.aluno_sequence', 10, true);


--
-- TOC entry 2290 (class 0 OID 81104)
-- Dependencies: 191
-- Data for Name: carne_pagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2327 (class 0 OID 0)
-- Dependencies: 207
-- Name: carne_pagamento_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.carne_pagamento_sequence', 1, false);


--
-- TOC entry 2291 (class 0 OID 81112)
-- Dependencies: 192
-- Data for Name: contato; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.contato (id, status, celular, email, telefone) VALUES (1, true, '(54)76543-2345', 'joelminha@gmail.com', '(87)65456-7876');
INSERT INTO public.contato (id, status, celular, email, telefone) VALUES (2, true, '(89)76789-7678', 'ytfdrtyuio', '(45)67898-7654');
INSERT INTO public.contato (id, status, celular, email, telefone) VALUES (3, true, '(83)97826-1878', 'whdvghwjkdwidwmkl', '(00)00000-0000');
INSERT INTO public.contato (id, status, celular, email, telefone) VALUES (4, true, '(87)99941-9310', 'santoshakkinen7@gmail.com', '(87)99941-9310');
INSERT INTO public.contato (id, status, celular, email, telefone) VALUES (5, true, '(87)9941-9310', 'claire.emilie@gmail.com', '(87)99941-9310');
INSERT INTO public.contato (id, status, celular, email, telefone) VALUES (6, true, '(87)99145-6102', 'felipe.souza@gmail.com', '(87)99456-1465');
INSERT INTO public.contato (id, status, celular, email, telefone) VALUES (7, true, '(45)67890-8765', 'adfsrgthyukijghfdsa', '(12)34567-8908');
INSERT INTO public.contato (id, status, celular, email, telefone) VALUES (8, true, '(23)45678-6543', 'clodosval@hotmail.com', '(23)45678-6543');


--
-- TOC entry 2328 (class 0 OID 0)
-- Dependencies: 208
-- Name: contato_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contato_sequence', 8, true);


--
-- TOC entry 2329 (class 0 OID 0)
-- Dependencies: 185
-- Name: coordenador_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.coordenador_sequence', 1, false);


--
-- TOC entry 2292 (class 0 OID 81117)
-- Dependencies: 193
-- Data for Name: cord_pedagogo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cord_pedagogo (id, status, cpf, login, nome, senha, tipocargo) VALUES (4, true, '0002351', 'coordenador', 'Coordenador', 'coordenador', 'SECRETARIA');


--
-- TOC entry 2293 (class 0 OID 81122)
-- Dependencies: 194
-- Data for Name: diretor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.diretor (id, status, cpf, login, nome, senha, tipocargo) VALUES (3, true, '0000121', 'diretor', 'Diretoria', 'diretor', 'DIRETORIA');


--
-- TOC entry 2330 (class 0 OID 0)
-- Dependencies: 186
-- Name: diretor_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.diretor_sequence', 1, false);


--
-- TOC entry 2294 (class 0 OID 81127)
-- Dependencies: 195
-- Data for Name: disciplina; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.disciplina (id, status, carga_horaria, codigo, nome, statusaluno, professor_id) VALUES (1, true, '90h', '6738823476', 'Matematica', NULL, 1);
INSERT INTO public.disciplina (id, status, carga_horaria, codigo, nome, statusaluno, professor_id) VALUES (2, true, '90h', '76783432894', 'Portugues', NULL, 2);
INSERT INTO public.disciplina (id, status, carga_horaria, codigo, nome, statusaluno, professor_id) VALUES (3, true, '60h', '637282389', 'Historia', NULL, 3);
INSERT INTO public.disciplina (id, status, carga_horaria, codigo, nome, statusaluno, professor_id) VALUES (4, true, '60h', '327883', 'Direitos Humanos', NULL, 3);
INSERT INTO public.disciplina (id, status, carga_horaria, codigo, nome, statusaluno, professor_id) VALUES (6, true, '60h', '46589451', 'Banco de Dados', NULL, 4);


--
-- TOC entry 2331 (class 0 OID 0)
-- Dependencies: 209
-- Name: disciplina_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.disciplina_sequence', 6, true);


--
-- TOC entry 2295 (class 0 OID 81135)
-- Dependencies: 196
-- Data for Name: disciplina_turma; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.disciplina_turma (id, status, disciplina_id, turma_id) VALUES (1, true, 2, 1);
INSERT INTO public.disciplina_turma (id, status, disciplina_id, turma_id) VALUES (5, true, 1, 1);
INSERT INTO public.disciplina_turma (id, status, disciplina_id, turma_id) VALUES (6, true, 2, 1);


--
-- TOC entry 2296 (class 0 OID 81140)
-- Dependencies: 197
-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.endereco (id, status, bairro, cep, cidade, complemento, logradouro, numero, tipoestadouf) VALUES (1, true, 'rftrgteytg', '76456-765', 'frgtrg', 'wdfvt', 'rftred', '432', 'AMAPA');
INSERT INTO public.endereco (id, status, bairro, cep, cidade, complemento, logradouro, numero, tipoestadouf) VALUES (2, true, 'dfgrewda', '56789-087', 'dfdgrefsd', 'cdfdds', 'grfvcds', '34', 'BAHIA');
INSERT INTO public.endereco (id, status, bairro, cep, cidade, complemento, logradouro, numero, tipoestadouf) VALUES (3, true, 'wshudxgwuhxjs', '65632-178', 'gydhdsmc', 'dwbhnjsmakx', 'sexrdcfvgbhj', '', 'DISTRITO_FERERAL');
INSERT INTO public.endereco (id, status, bairro, cep, cidade, complemento, logradouro, numero, tipoestadouf) VALUES (4, true, 'Alto da Boa Vista', '56870-000', 'Triunfo', 'Casa', 'Fidias Corte de Alencar', '12', 'PERNAMBUCO');
INSERT INTO public.endereco (id, status, bairro, cep, cidade, complemento, logradouro, numero, tipoestadouf) VALUES (5, true, 'Alto da Boa Vista', '56870-000', 'TRIUNFO', 'Casa', 'Fidias Corte de Alencar', '12', 'PERNAMBUCO');
INSERT INTO public.endereco (id, status, bairro, cep, cidade, complemento, logradouro, numero, tipoestadouf) VALUES (6, true, 'Pioo', '56870-000', 'TRIUNFO', 'AP', 'Centro', '234', 'PERNAMBUCO');
INSERT INTO public.endereco (id, status, bairro, cep, cidade, complemento, logradouro, numero, tipoestadouf) VALUES (7, true, 'safdghjhdfdsa', '12345-678', 'sfdgghfds', 'scdgdhtsds', 'dfghjklkkjghfgdf', '234', 'CEARA');
INSERT INTO public.endereco (id, status, bairro, cep, cidade, complemento, logradouro, numero, tipoestadouf) VALUES (8, true, 'bairro aa', '23456-786', 'Cidade b', 'AP', 'Log a', '23', 'ALAGOAS');


--
-- TOC entry 2332 (class 0 OID 0)
-- Dependencies: 210
-- Name: endereco_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.endereco_sequence', 8, true);


--
-- TOC entry 2288 (class 0 OID 81087)
-- Dependencies: 189
-- Data for Name: falta; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2333 (class 0 OID 0)
-- Dependencies: 211
-- Name: falta_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.falta_sequence', 1, false);


--
-- TOC entry 2297 (class 0 OID 81148)
-- Dependencies: 198
-- Data for Name: liquida_carne; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2334 (class 0 OID 0)
-- Dependencies: 212
-- Name: liquidacarne_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.liquidacarne_sequence', 1, false);


--
-- TOC entry 2335 (class 0 OID 0)
-- Dependencies: 213
-- Name: obs_aluno_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.obs_aluno_sequence', 1, false);


--
-- TOC entry 2298 (class 0 OID 81153)
-- Dependencies: 199
-- Data for Name: observacao_aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2299 (class 0 OID 81161)
-- Dependencies: 200
-- Data for Name: professor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.professor (id, status, cpf, data_nascimento, naturalidade, nome, contato_id, endereco_id) VALUES (1, true, '812.761.278-92', '\xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007e30b0d78', 'BR', 'Joelma', 1, 1);
INSERT INTO public.professor (id, status, cpf, data_nascimento, naturalidade, nome, contato_id, endereco_id) VALUES (2, true, '763.527.890-29', '\xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007e30b0478', 'iuytgr', 'Leide', 2, 2);
INSERT INTO public.professor (id, status, cpf, data_nascimento, naturalidade, nome, contato_id, endereco_id) VALUES (3, true, '928.183.213-72', '\xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007e30b1178', 'dsbuagyus', 'Katrucio', 3, 3);
INSERT INTO public.professor (id, status, cpf, data_nascimento, naturalidade, nome, contato_id, endereco_id) VALUES (4, true, '456.485.214-95', '\xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007d70b1678', 'adsfdgfhghjkjhgfd', 'Hidelberto', 7, 7);


--
-- TOC entry 2336 (class 0 OID 0)
-- Dependencies: 214
-- Name: professor_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.professor_sequence', 4, true);


--
-- TOC entry 2337 (class 0 OID 0)
-- Dependencies: 215
-- Name: resp_fin_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.resp_fin_sequence', 2, true);


--
-- TOC entry 2300 (class 0 OID 81169)
-- Dependencies: 201
-- Data for Name: resp_financeiro; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.resp_financeiro (id, status, cpf, nome) VALUES (1, true, '060.917.484-32', 'Hakkinen Diniz ');
INSERT INTO public.resp_financeiro (id, status, cpf, nome) VALUES (2, true, '116.127.897-65', 'Felipe Souza');


--
-- TOC entry 2301 (class 0 OID 81174)
-- Dependencies: 202
-- Data for Name: secretaria; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.secretaria (id, status, cpf, login, nome, senha, tipocargo) VALUES (1, true, '000012321', 'secretario', 'Secretaria', 'secretario', 'SECRETARIA');


--
-- TOC entry 2338 (class 0 OID 0)
-- Dependencies: 187
-- Name: secretaria_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.secretaria_sequence', 1, false);


--
-- TOC entry 2302 (class 0 OID 81179)
-- Dependencies: 203
-- Data for Name: super_usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.super_usuario (id, status, cpf, login, nome, senha, tipocargo) VALUES (2, true, '00000001', 'admin', 'Adminstrador', 'admin', 'SUPER_USUARIO');


--
-- TOC entry 2339 (class 0 OID 0)
-- Dependencies: 188
-- Name: super_usuario_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.super_usuario_sequence', 1, false);


--
-- TOC entry 2303 (class 0 OID 81184)
-- Dependencies: 204
-- Data for Name: turma; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.turma (id, status, anoletivo, nome) VALUES (1, true, '2019', '1° Ano B');


--
-- TOC entry 2340 (class 0 OID 0)
-- Dependencies: 216
-- Name: turma_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.turma_sequence', 1, true);


--
-- TOC entry 2341 (class 0 OID 0)
-- Dependencies: 217
-- Name: usuario_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_sequence', 4, true);


--
-- TOC entry 2304 (class 0 OID 81189)
-- Dependencies: 205
-- Data for Name: vinculo_aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.vinculo_aluno (id, status, media, mediafinal, nota1, nota2, nota3, nota4, situacaoaluno, aluno_id, disciplinaturma_id) VALUES (6, true, 0, 0, 0, 0, 0, 0, NULL, 10, 1);


--
-- TOC entry 2342 (class 0 OID 0)
-- Dependencies: 218
-- Name: vinculo_aluno_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.vinculo_aluno_sequence', 6, true);


--
-- TOC entry 2107 (class 2606 OID 81103)
-- Name: aluno aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY (id);


--
-- TOC entry 2109 (class 2606 OID 81111)
-- Name: carne_pagamento carne_pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carne_pagamento
    ADD CONSTRAINT carne_pagamento_pkey PRIMARY KEY (id);


--
-- TOC entry 2111 (class 2606 OID 81116)
-- Name: contato contato_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contato
    ADD CONSTRAINT contato_pkey PRIMARY KEY (id);


--
-- TOC entry 2113 (class 2606 OID 81121)
-- Name: cord_pedagogo cord_pedagogo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cord_pedagogo
    ADD CONSTRAINT cord_pedagogo_pkey PRIMARY KEY (id);


--
-- TOC entry 2117 (class 2606 OID 81126)
-- Name: diretor diretor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diretor
    ADD CONSTRAINT diretor_pkey PRIMARY KEY (id);


--
-- TOC entry 2121 (class 2606 OID 81134)
-- Name: disciplina disciplina_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disciplina
    ADD CONSTRAINT disciplina_pkey PRIMARY KEY (id);


--
-- TOC entry 2125 (class 2606 OID 81139)
-- Name: disciplina_turma disciplina_turma_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disciplina_turma
    ADD CONSTRAINT disciplina_turma_pkey PRIMARY KEY (id);


--
-- TOC entry 2127 (class 2606 OID 81147)
-- Name: endereco endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);


--
-- TOC entry 2105 (class 2606 OID 81094)
-- Name: falta falta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.falta
    ADD CONSTRAINT falta_pkey PRIMARY KEY (id);


--
-- TOC entry 2129 (class 2606 OID 81152)
-- Name: liquida_carne liquida_carne_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.liquida_carne
    ADD CONSTRAINT liquida_carne_pkey PRIMARY KEY (id);


--
-- TOC entry 2131 (class 2606 OID 81160)
-- Name: observacao_aluno observacao_aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observacao_aluno
    ADD CONSTRAINT observacao_aluno_pkey PRIMARY KEY (id);


--
-- TOC entry 2133 (class 2606 OID 81168)
-- Name: professor professor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.professor
    ADD CONSTRAINT professor_pkey PRIMARY KEY (id);


--
-- TOC entry 2137 (class 2606 OID 81173)
-- Name: resp_financeiro resp_financeiro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resp_financeiro
    ADD CONSTRAINT resp_financeiro_pkey PRIMARY KEY (id);


--
-- TOC entry 2141 (class 2606 OID 81178)
-- Name: secretaria secretaria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secretaria
    ADD CONSTRAINT secretaria_pkey PRIMARY KEY (id);


--
-- TOC entry 2145 (class 2606 OID 81183)
-- Name: super_usuario super_usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.super_usuario
    ADD CONSTRAINT super_usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 2149 (class 2606 OID 81188)
-- Name: turma turma_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turma
    ADD CONSTRAINT turma_pkey PRIMARY KEY (id);


--
-- TOC entry 2123 (class 2606 OID 81199)
-- Name: disciplina uk_eljvghu5wa2lowt86mlf41ldq; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disciplina
    ADD CONSTRAINT uk_eljvghu5wa2lowt86mlf41ldq UNIQUE (codigo);


--
-- TOC entry 2147 (class 2606 OID 81207)
-- Name: super_usuario uk_f3buadg1qkxm5xsln0bgyt3hf; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.super_usuario
    ADD CONSTRAINT uk_f3buadg1qkxm5xsln0bgyt3hf UNIQUE (cpf);


--
-- TOC entry 2119 (class 2606 OID 81197)
-- Name: diretor uk_maqe97uidbuo0e0hjl0l4gugo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diretor
    ADD CONSTRAINT uk_maqe97uidbuo0e0hjl0l4gugo UNIQUE (cpf);


--
-- TOC entry 2143 (class 2606 OID 81205)
-- Name: secretaria uk_pjqcupo3u6uwh19bhlbfw8hkt; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secretaria
    ADD CONSTRAINT uk_pjqcupo3u6uwh19bhlbfw8hkt UNIQUE (cpf);


--
-- TOC entry 2115 (class 2606 OID 81195)
-- Name: cord_pedagogo uk_pjxp7h7up5nep79nqhnpcskjr; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cord_pedagogo
    ADD CONSTRAINT uk_pjxp7h7up5nep79nqhnpcskjr UNIQUE (cpf);


--
-- TOC entry 2135 (class 2606 OID 81201)
-- Name: professor uk_pk1omryj5cud6uslkepgyfrca; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.professor
    ADD CONSTRAINT uk_pk1omryj5cud6uslkepgyfrca UNIQUE (cpf);


--
-- TOC entry 2139 (class 2606 OID 81203)
-- Name: resp_financeiro uk_sfb94dox6vlxr0xk70ekfrf2j; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resp_financeiro
    ADD CONSTRAINT uk_sfb94dox6vlxr0xk70ekfrf2j UNIQUE (cpf);


--
-- TOC entry 2151 (class 2606 OID 81193)
-- Name: vinculo_aluno vinculo_aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vinculo_aluno
    ADD CONSTRAINT vinculo_aluno_pkey PRIMARY KEY (id);


--
-- TOC entry 2166 (class 2606 OID 81278)
-- Name: vinculo_aluno fk_1cic95j5lk15wrj0i5k2lqug8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vinculo_aluno
    ADD CONSTRAINT fk_1cic95j5lk15wrj0i5k2lqug8 FOREIGN KEY (disciplinaturma_id) REFERENCES public.disciplina_turma(id);


--
-- TOC entry 2159 (class 2606 OID 81243)
-- Name: disciplina_turma fk_2tp337bv6a1ymm822ck44ufbl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disciplina_turma
    ADD CONSTRAINT fk_2tp337bv6a1ymm822ck44ufbl FOREIGN KEY (turma_id) REFERENCES public.turma(id);


--
-- TOC entry 2158 (class 2606 OID 81238)
-- Name: disciplina_turma fk_a49f1nn6uobd1i5wgmi76ndvl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disciplina_turma
    ADD CONSTRAINT fk_a49f1nn6uobd1i5wgmi76ndvl FOREIGN KEY (disciplina_id) REFERENCES public.disciplina(id);


--
-- TOC entry 2162 (class 2606 OID 81258)
-- Name: observacao_aluno fk_bfit3ay1btk8crd1k8boxxgrs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observacao_aluno
    ADD CONSTRAINT fk_bfit3ay1btk8crd1k8boxxgrs FOREIGN KEY (vinculoalunoturma_id) REFERENCES public.vinculo_aluno(id);


--
-- TOC entry 2165 (class 2606 OID 81273)
-- Name: vinculo_aluno fk_bmggi1u04hhjs5k172m0ajwr9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vinculo_aluno
    ADD CONSTRAINT fk_bmggi1u04hhjs5k172m0ajwr9 FOREIGN KEY (aluno_id) REFERENCES public.aluno(id);


--
-- TOC entry 2163 (class 2606 OID 81263)
-- Name: professor fk_c6gt1vylqf4u3l02ifu9dhwdv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.professor
    ADD CONSTRAINT fk_c6gt1vylqf4u3l02ifu9dhwdv FOREIGN KEY (contato_id) REFERENCES public.contato(id);


--
-- TOC entry 2164 (class 2606 OID 81268)
-- Name: professor fk_cg9si6hurvcdp70e6otox1s20; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.professor
    ADD CONSTRAINT fk_cg9si6hurvcdp70e6otox1s20 FOREIGN KEY (endereco_id) REFERENCES public.endereco(id);


--
-- TOC entry 2154 (class 2606 OID 81218)
-- Name: aluno fk_dky20u41x9c3xw6c1uo7g6rn6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT fk_dky20u41x9c3xw6c1uo7g6rn6 FOREIGN KEY (endereco_id) REFERENCES public.endereco(id);


--
-- TOC entry 2156 (class 2606 OID 81228)
-- Name: carne_pagamento fk_er8hrnvebyl5vk64w38jid0u9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carne_pagamento
    ADD CONSTRAINT fk_er8hrnvebyl5vk64w38jid0u9 FOREIGN KEY (resp_financeiro_id) REFERENCES public.resp_financeiro(id);


--
-- TOC entry 2155 (class 2606 OID 81223)
-- Name: aluno fk_f97c2nu6v3u4ipip6h4bx4myp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT fk_f97c2nu6v3u4ipip6h4bx4myp FOREIGN KEY (responsavel_financeiro_id) REFERENCES public.resp_financeiro(id);


--
-- TOC entry 2161 (class 2606 OID 81253)
-- Name: observacao_aluno fk_mndylryra2e33tfxb6p6u6wtf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observacao_aluno
    ADD CONSTRAINT fk_mndylryra2e33tfxb6p6u6wtf FOREIGN KEY (coordenador_id) REFERENCES public.cord_pedagogo(id);


--
-- TOC entry 2157 (class 2606 OID 81233)
-- Name: disciplina fk_n27x6vngvsn9jemjwmtibimx5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disciplina
    ADD CONSTRAINT fk_n27x6vngvsn9jemjwmtibimx5 FOREIGN KEY (professor_id) REFERENCES public.professor(id);


--
-- TOC entry 2152 (class 2606 OID 81208)
-- Name: falta fk_neapu18itsli36ul42jj97kvv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.falta
    ADD CONSTRAINT fk_neapu18itsli36ul42jj97kvv FOREIGN KEY (vinculoalunoturma_id) REFERENCES public.vinculo_aluno(id);


--
-- TOC entry 2153 (class 2606 OID 81213)
-- Name: aluno fk_qx9f1y0oyv9nuplpe9atym0x4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT fk_qx9f1y0oyv9nuplpe9atym0x4 FOREIGN KEY (contato_id) REFERENCES public.contato(id);


--
-- TOC entry 2160 (class 2606 OID 81248)
-- Name: liquida_carne fk_rn1y0q2vt9g90qkg1pkg21rtx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.liquida_carne
    ADD CONSTRAINT fk_rn1y0q2vt9g90qkg1pkg21rtx FOREIGN KEY (carne_pagamento_id) REFERENCES public.carne_pagamento(id);


-- Completed on 2019-11-22 10:07:36

--
-- PostgreSQL database dump complete
--

