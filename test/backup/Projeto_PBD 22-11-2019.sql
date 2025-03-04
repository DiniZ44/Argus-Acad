PGDMP     
    +    	        
    w            Projeto_PBD    9.6.14    9.6.14 s    	           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            	           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            	           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            	           1262    24719    Projeto_PBD    DATABASE     �   CREATE DATABASE "Projeto_PBD" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE "Projeto_PBD";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            	           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12387    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            	           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    81095    aluno    TABLE     �  CREATE TABLE public.aluno (
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
    DROP TABLE public.aluno;
       public         postgres    false    3            �            1259    81283    aluno_sequence    SEQUENCE     w   CREATE SEQUENCE public.aluno_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.aluno_sequence;
       public       postgres    false    3            �            1259    81104    carne_pagamento    TABLE     �   CREATE TABLE public.carne_pagamento (
    id integer NOT NULL,
    status boolean,
    data bytea NOT NULL,
    valor double precision,
    resp_financeiro_id integer
);
 #   DROP TABLE public.carne_pagamento;
       public         postgres    false    3            �            1259    81285    carne_pagamento_sequence    SEQUENCE     �   CREATE SEQUENCE public.carne_pagamento_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.carne_pagamento_sequence;
       public       postgres    false    3            �            1259    81112    contato    TABLE     �   CREATE TABLE public.contato (
    id integer NOT NULL,
    status boolean,
    celular character varying(20) NOT NULL,
    email character varying(50) NOT NULL,
    telefone character varying(20) NOT NULL
);
    DROP TABLE public.contato;
       public         postgres    false    3            �            1259    81287    contato_sequence    SEQUENCE     y   CREATE SEQUENCE public.contato_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.contato_sequence;
       public       postgres    false    3            �            1259    24834    coordenador_sequence    SEQUENCE     }   CREATE SEQUENCE public.coordenador_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.coordenador_sequence;
       public       postgres    false    3            �            1259    81117    cord_pedagogo    TABLE       CREATE TABLE public.cord_pedagogo (
    id integer NOT NULL,
    status boolean,
    cpf character varying(15) NOT NULL,
    login character varying(50) NOT NULL,
    nome character varying(100) NOT NULL,
    senha character varying(15) NOT NULL,
    tipocargo character varying(255)
);
 !   DROP TABLE public.cord_pedagogo;
       public         postgres    false    3            �            1259    81122    diretor    TABLE       CREATE TABLE public.diretor (
    id integer NOT NULL,
    status boolean,
    cpf character varying(15) NOT NULL,
    login character varying(50) NOT NULL,
    nome character varying(100) NOT NULL,
    senha character varying(15) NOT NULL,
    tipocargo character varying(255)
);
    DROP TABLE public.diretor;
       public         postgres    false    3            �            1259    24836    diretor_sequence    SEQUENCE     y   CREATE SEQUENCE public.diretor_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.diretor_sequence;
       public       postgres    false    3            �            1259    81127 
   disciplina    TABLE       CREATE TABLE public.disciplina (
    id integer NOT NULL,
    status boolean,
    carga_horaria character varying(5) NOT NULL,
    codigo character varying(255) NOT NULL,
    nome character varying(20) NOT NULL,
    statusaluno character varying(255),
    professor_id integer
);
    DROP TABLE public.disciplina;
       public         postgres    false    3            �            1259    81289    disciplina_sequence    SEQUENCE     |   CREATE SEQUENCE public.disciplina_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.disciplina_sequence;
       public       postgres    false    3            �            1259    81135    disciplina_turma    TABLE     �   CREATE TABLE public.disciplina_turma (
    id integer NOT NULL,
    status boolean,
    disciplina_id integer,
    turma_id integer
);
 $   DROP TABLE public.disciplina_turma;
       public         postgres    false    3            �            1259    81140    endereco    TABLE     �  CREATE TABLE public.endereco (
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
    DROP TABLE public.endereco;
       public         postgres    false    3            �            1259    81291    endereco_sequence    SEQUENCE     z   CREATE SEQUENCE public.endereco_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.endereco_sequence;
       public       postgres    false    3            �            1259    81087    falta    TABLE     �   CREATE TABLE public.falta (
    id integer NOT NULL,
    status boolean,
    data bytea,
    justificativa character varying(255),
    preseca boolean,
    vinculoalunoturma_id integer
);
    DROP TABLE public.falta;
       public         postgres    false    3            �            1259    81293    falta_sequence    SEQUENCE     w   CREATE SEQUENCE public.falta_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.falta_sequence;
       public       postgres    false    3            �            1259    81148    liquida_carne    TABLE     �   CREATE TABLE public.liquida_carne (
    id integer NOT NULL,
    status boolean,
    pago boolean,
    carne_pagamento_id integer
);
 !   DROP TABLE public.liquida_carne;
       public         postgres    false    3            �            1259    81295    liquidacarne_sequence    SEQUENCE     ~   CREATE SEQUENCE public.liquidacarne_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.liquidacarne_sequence;
       public       postgres    false    3            �            1259    81297    obs_aluno_sequence    SEQUENCE     {   CREATE SEQUENCE public.obs_aluno_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.obs_aluno_sequence;
       public       postgres    false    3            �            1259    81153    observacao_aluno    TABLE     �   CREATE TABLE public.observacao_aluno (
    id integer NOT NULL,
    status boolean,
    data bytea,
    descricao character varying(255),
    coordenador_id integer,
    vinculoalunoturma_id integer
);
 $   DROP TABLE public.observacao_aluno;
       public         postgres    false    3            �            1259    81161 	   professor    TABLE     (  CREATE TABLE public.professor (
    id integer NOT NULL,
    status boolean,
    cpf character varying(15) NOT NULL,
    data_nascimento bytea NOT NULL,
    naturalidade character varying(255) NOT NULL,
    nome character varying(255) NOT NULL,
    contato_id integer,
    endereco_id integer
);
    DROP TABLE public.professor;
       public         postgres    false    3            �            1259    81299    professor_sequence    SEQUENCE     {   CREATE SEQUENCE public.professor_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.professor_sequence;
       public       postgres    false    3            �            1259    81301    resp_fin_sequence    SEQUENCE     z   CREATE SEQUENCE public.resp_fin_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.resp_fin_sequence;
       public       postgres    false    3            �            1259    81169    resp_financeiro    TABLE     �   CREATE TABLE public.resp_financeiro (
    id integer NOT NULL,
    status boolean,
    cpf character varying(15) NOT NULL,
    nome character varying(100) NOT NULL
);
 #   DROP TABLE public.resp_financeiro;
       public         postgres    false    3            �            1259    81174 
   secretaria    TABLE       CREATE TABLE public.secretaria (
    id integer NOT NULL,
    status boolean,
    cpf character varying(15) NOT NULL,
    login character varying(50) NOT NULL,
    nome character varying(100) NOT NULL,
    senha character varying(15) NOT NULL,
    tipocargo character varying(255)
);
    DROP TABLE public.secretaria;
       public         postgres    false    3            �            1259    24846    secretaria_sequence    SEQUENCE     |   CREATE SEQUENCE public.secretaria_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.secretaria_sequence;
       public       postgres    false    3            �            1259    81179    super_usuario    TABLE       CREATE TABLE public.super_usuario (
    id integer NOT NULL,
    status boolean,
    cpf character varying(15) NOT NULL,
    login character varying(50) NOT NULL,
    nome character varying(100) NOT NULL,
    senha character varying(15) NOT NULL,
    tipocargo character varying(255)
);
 !   DROP TABLE public.super_usuario;
       public         postgres    false    3            �            1259    24848    super_usuario_sequence    SEQUENCE        CREATE SEQUENCE public.super_usuario_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.super_usuario_sequence;
       public       postgres    false    3            �            1259    81184    turma    TABLE     �   CREATE TABLE public.turma (
    id integer NOT NULL,
    status boolean,
    anoletivo character varying(20),
    nome character varying(20) NOT NULL
);
    DROP TABLE public.turma;
       public         postgres    false    3            �            1259    81303    turma_sequence    SEQUENCE     w   CREATE SEQUENCE public.turma_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.turma_sequence;
       public       postgres    false    3            �            1259    81305    usuario_sequence    SEQUENCE     y   CREATE SEQUENCE public.usuario_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.usuario_sequence;
       public       postgres    false    3            �            1259    81189    vinculo_aluno    TABLE     `  CREATE TABLE public.vinculo_aluno (
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
 !   DROP TABLE public.vinculo_aluno;
       public         postgres    false    3            �            1259    81307    vinculo_aluno_sequence    SEQUENCE        CREATE SEQUENCE public.vinculo_aluno_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.vinculo_aluno_sequence;
       public       postgres    false    3            �          0    81095    aluno 
   TABLE DATA               �   COPY public.aluno (id, status, matricula, data_nascimento, mae, naturalidade, nome, pai, contato_id, endereco_id, responsavel_financeiro_id) FROM stdin;
    public       postgres    false    190   �       	           0    0    aluno_sequence    SEQUENCE SET     =   SELECT pg_catalog.setval('public.aluno_sequence', 10, true);
            public       postgres    false    206            �          0    81104    carne_pagamento 
   TABLE DATA               V   COPY public.carne_pagamento (id, status, data, valor, resp_financeiro_id) FROM stdin;
    public       postgres    false    191   ;�       	           0    0    carne_pagamento_sequence    SEQUENCE SET     G   SELECT pg_catalog.setval('public.carne_pagamento_sequence', 1, false);
            public       postgres    false    207            �          0    81112    contato 
   TABLE DATA               G   COPY public.contato (id, status, celular, email, telefone) FROM stdin;
    public       postgres    false    192   X�       	           0    0    contato_sequence    SEQUENCE SET     >   SELECT pg_catalog.setval('public.contato_sequence', 8, true);
            public       postgres    false    208            	           0    0    coordenador_sequence    SEQUENCE SET     C   SELECT pg_catalog.setval('public.coordenador_sequence', 1, false);
            public       postgres    false    185            �          0    81117    cord_pedagogo 
   TABLE DATA               W   COPY public.cord_pedagogo (id, status, cpf, login, nome, senha, tipocargo) FROM stdin;
    public       postgres    false    193   n�       �          0    81122    diretor 
   TABLE DATA               Q   COPY public.diretor (id, status, cpf, login, nome, senha, tipocargo) FROM stdin;
    public       postgres    false    194   ��       	           0    0    diretor_sequence    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.diretor_sequence', 1, false);
            public       postgres    false    186            �          0    81127 
   disciplina 
   TABLE DATA               h   COPY public.disciplina (id, status, carga_horaria, codigo, nome, statusaluno, professor_id) FROM stdin;
    public       postgres    false    195   �       	           0    0    disciplina_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.disciplina_sequence', 6, true);
            public       postgres    false    209            �          0    81135    disciplina_turma 
   TABLE DATA               O   COPY public.disciplina_turma (id, status, disciplina_id, turma_id) FROM stdin;
    public       postgres    false    196   ��       �          0    81140    endereco 
   TABLE DATA               r   COPY public.endereco (id, status, bairro, cep, cidade, complemento, logradouro, numero, tipoestadouf) FROM stdin;
    public       postgres    false    197   ��       	           0    0    endereco_sequence    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.endereco_sequence', 8, true);
            public       postgres    false    210            �          0    81087    falta 
   TABLE DATA               _   COPY public.falta (id, status, data, justificativa, preseca, vinculoalunoturma_id) FROM stdin;
    public       postgres    false    189   -�       	           0    0    falta_sequence    SEQUENCE SET     =   SELECT pg_catalog.setval('public.falta_sequence', 1, false);
            public       postgres    false    211            �          0    81148    liquida_carne 
   TABLE DATA               M   COPY public.liquida_carne (id, status, pago, carne_pagamento_id) FROM stdin;
    public       postgres    false    198   J�       	           0    0    liquidacarne_sequence    SEQUENCE SET     D   SELECT pg_catalog.setval('public.liquidacarne_sequence', 1, false);
            public       postgres    false    212            	           0    0    obs_aluno_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.obs_aluno_sequence', 1, false);
            public       postgres    false    213            �          0    81153    observacao_aluno 
   TABLE DATA               m   COPY public.observacao_aluno (id, status, data, descricao, coordenador_id, vinculoalunoturma_id) FROM stdin;
    public       postgres    false    199   g�       �          0    81161 	   professor 
   TABLE DATA               r   COPY public.professor (id, status, cpf, data_nascimento, naturalidade, nome, contato_id, endereco_id) FROM stdin;
    public       postgres    false    200   ��        	           0    0    professor_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.professor_sequence', 4, true);
            public       postgres    false    214            !	           0    0    resp_fin_sequence    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.resp_fin_sequence', 2, true);
            public       postgres    false    215            �          0    81169    resp_financeiro 
   TABLE DATA               @   COPY public.resp_financeiro (id, status, cpf, nome) FROM stdin;
    public       postgres    false    201   s�       �          0    81174 
   secretaria 
   TABLE DATA               T   COPY public.secretaria (id, status, cpf, login, nome, senha, tipocargo) FROM stdin;
    public       postgres    false    202   ґ       "	           0    0    secretaria_sequence    SEQUENCE SET     B   SELECT pg_catalog.setval('public.secretaria_sequence', 1, false);
            public       postgres    false    187            �          0    81179    super_usuario 
   TABLE DATA               W   COPY public.super_usuario (id, status, cpf, login, nome, senha, tipocargo) FROM stdin;
    public       postgres    false    203   �       #	           0    0    super_usuario_sequence    SEQUENCE SET     E   SELECT pg_catalog.setval('public.super_usuario_sequence', 1, false);
            public       postgres    false    188            �          0    81184    turma 
   TABLE DATA               <   COPY public.turma (id, status, anoletivo, nome) FROM stdin;
    public       postgres    false    204   [�       $	           0    0    turma_sequence    SEQUENCE SET     <   SELECT pg_catalog.setval('public.turma_sequence', 1, true);
            public       postgres    false    216            %	           0    0    usuario_sequence    SEQUENCE SET     >   SELECT pg_catalog.setval('public.usuario_sequence', 4, true);
            public       postgres    false    217             	          0    81189    vinculo_aluno 
   TABLE DATA               �   COPY public.vinculo_aluno (id, status, media, mediafinal, nota1, nota2, nota3, nota4, situacaoaluno, aluno_id, disciplinaturma_id) FROM stdin;
    public       postgres    false    205   ��       &	           0    0    vinculo_aluno_sequence    SEQUENCE SET     D   SELECT pg_catalog.setval('public.vinculo_aluno_sequence', 6, true);
            public       postgres    false    218            ;           2606    81103    aluno aluno_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.aluno DROP CONSTRAINT aluno_pkey;
       public         postgres    false    190    190            =           2606    81111 $   carne_pagamento carne_pagamento_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.carne_pagamento
    ADD CONSTRAINT carne_pagamento_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.carne_pagamento DROP CONSTRAINT carne_pagamento_pkey;
       public         postgres    false    191    191            ?           2606    81116    contato contato_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.contato
    ADD CONSTRAINT contato_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.contato DROP CONSTRAINT contato_pkey;
       public         postgres    false    192    192            A           2606    81121     cord_pedagogo cord_pedagogo_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.cord_pedagogo
    ADD CONSTRAINT cord_pedagogo_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.cord_pedagogo DROP CONSTRAINT cord_pedagogo_pkey;
       public         postgres    false    193    193            E           2606    81126    diretor diretor_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.diretor
    ADD CONSTRAINT diretor_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.diretor DROP CONSTRAINT diretor_pkey;
       public         postgres    false    194    194            I           2606    81134    disciplina disciplina_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.disciplina
    ADD CONSTRAINT disciplina_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.disciplina DROP CONSTRAINT disciplina_pkey;
       public         postgres    false    195    195            M           2606    81139 &   disciplina_turma disciplina_turma_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.disciplina_turma
    ADD CONSTRAINT disciplina_turma_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.disciplina_turma DROP CONSTRAINT disciplina_turma_pkey;
       public         postgres    false    196    196            O           2606    81147    endereco endereco_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.endereco DROP CONSTRAINT endereco_pkey;
       public         postgres    false    197    197            9           2606    81094    falta falta_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.falta
    ADD CONSTRAINT falta_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.falta DROP CONSTRAINT falta_pkey;
       public         postgres    false    189    189            Q           2606    81152     liquida_carne liquida_carne_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.liquida_carne
    ADD CONSTRAINT liquida_carne_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.liquida_carne DROP CONSTRAINT liquida_carne_pkey;
       public         postgres    false    198    198            S           2606    81160 &   observacao_aluno observacao_aluno_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.observacao_aluno
    ADD CONSTRAINT observacao_aluno_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.observacao_aluno DROP CONSTRAINT observacao_aluno_pkey;
       public         postgres    false    199    199            U           2606    81168    professor professor_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.professor
    ADD CONSTRAINT professor_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.professor DROP CONSTRAINT professor_pkey;
       public         postgres    false    200    200            Y           2606    81173 $   resp_financeiro resp_financeiro_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.resp_financeiro
    ADD CONSTRAINT resp_financeiro_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.resp_financeiro DROP CONSTRAINT resp_financeiro_pkey;
       public         postgres    false    201    201            ]           2606    81178    secretaria secretaria_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.secretaria
    ADD CONSTRAINT secretaria_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.secretaria DROP CONSTRAINT secretaria_pkey;
       public         postgres    false    202    202            a           2606    81183     super_usuario super_usuario_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.super_usuario
    ADD CONSTRAINT super_usuario_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.super_usuario DROP CONSTRAINT super_usuario_pkey;
       public         postgres    false    203    203            e           2606    81188    turma turma_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.turma
    ADD CONSTRAINT turma_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.turma DROP CONSTRAINT turma_pkey;
       public         postgres    false    204    204            K           2606    81199 '   disciplina uk_eljvghu5wa2lowt86mlf41ldq 
   CONSTRAINT     d   ALTER TABLE ONLY public.disciplina
    ADD CONSTRAINT uk_eljvghu5wa2lowt86mlf41ldq UNIQUE (codigo);
 Q   ALTER TABLE ONLY public.disciplina DROP CONSTRAINT uk_eljvghu5wa2lowt86mlf41ldq;
       public         postgres    false    195    195            c           2606    81207 *   super_usuario uk_f3buadg1qkxm5xsln0bgyt3hf 
   CONSTRAINT     d   ALTER TABLE ONLY public.super_usuario
    ADD CONSTRAINT uk_f3buadg1qkxm5xsln0bgyt3hf UNIQUE (cpf);
 T   ALTER TABLE ONLY public.super_usuario DROP CONSTRAINT uk_f3buadg1qkxm5xsln0bgyt3hf;
       public         postgres    false    203    203            G           2606    81197 $   diretor uk_maqe97uidbuo0e0hjl0l4gugo 
   CONSTRAINT     ^   ALTER TABLE ONLY public.diretor
    ADD CONSTRAINT uk_maqe97uidbuo0e0hjl0l4gugo UNIQUE (cpf);
 N   ALTER TABLE ONLY public.diretor DROP CONSTRAINT uk_maqe97uidbuo0e0hjl0l4gugo;
       public         postgres    false    194    194            _           2606    81205 '   secretaria uk_pjqcupo3u6uwh19bhlbfw8hkt 
   CONSTRAINT     a   ALTER TABLE ONLY public.secretaria
    ADD CONSTRAINT uk_pjqcupo3u6uwh19bhlbfw8hkt UNIQUE (cpf);
 Q   ALTER TABLE ONLY public.secretaria DROP CONSTRAINT uk_pjqcupo3u6uwh19bhlbfw8hkt;
       public         postgres    false    202    202            C           2606    81195 *   cord_pedagogo uk_pjxp7h7up5nep79nqhnpcskjr 
   CONSTRAINT     d   ALTER TABLE ONLY public.cord_pedagogo
    ADD CONSTRAINT uk_pjxp7h7up5nep79nqhnpcskjr UNIQUE (cpf);
 T   ALTER TABLE ONLY public.cord_pedagogo DROP CONSTRAINT uk_pjxp7h7up5nep79nqhnpcskjr;
       public         postgres    false    193    193            W           2606    81201 &   professor uk_pk1omryj5cud6uslkepgyfrca 
   CONSTRAINT     `   ALTER TABLE ONLY public.professor
    ADD CONSTRAINT uk_pk1omryj5cud6uslkepgyfrca UNIQUE (cpf);
 P   ALTER TABLE ONLY public.professor DROP CONSTRAINT uk_pk1omryj5cud6uslkepgyfrca;
       public         postgres    false    200    200            [           2606    81203 ,   resp_financeiro uk_sfb94dox6vlxr0xk70ekfrf2j 
   CONSTRAINT     f   ALTER TABLE ONLY public.resp_financeiro
    ADD CONSTRAINT uk_sfb94dox6vlxr0xk70ekfrf2j UNIQUE (cpf);
 V   ALTER TABLE ONLY public.resp_financeiro DROP CONSTRAINT uk_sfb94dox6vlxr0xk70ekfrf2j;
       public         postgres    false    201    201            g           2606    81193     vinculo_aluno vinculo_aluno_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.vinculo_aluno
    ADD CONSTRAINT vinculo_aluno_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.vinculo_aluno DROP CONSTRAINT vinculo_aluno_pkey;
       public         postgres    false    205    205            v           2606    81278 *   vinculo_aluno fk_1cic95j5lk15wrj0i5k2lqug8    FK CONSTRAINT     �   ALTER TABLE ONLY public.vinculo_aluno
    ADD CONSTRAINT fk_1cic95j5lk15wrj0i5k2lqug8 FOREIGN KEY (disciplinaturma_id) REFERENCES public.disciplina_turma(id);
 T   ALTER TABLE ONLY public.vinculo_aluno DROP CONSTRAINT fk_1cic95j5lk15wrj0i5k2lqug8;
       public       postgres    false    205    2125    196            o           2606    81243 -   disciplina_turma fk_2tp337bv6a1ymm822ck44ufbl    FK CONSTRAINT     �   ALTER TABLE ONLY public.disciplina_turma
    ADD CONSTRAINT fk_2tp337bv6a1ymm822ck44ufbl FOREIGN KEY (turma_id) REFERENCES public.turma(id);
 W   ALTER TABLE ONLY public.disciplina_turma DROP CONSTRAINT fk_2tp337bv6a1ymm822ck44ufbl;
       public       postgres    false    204    196    2149            n           2606    81238 -   disciplina_turma fk_a49f1nn6uobd1i5wgmi76ndvl    FK CONSTRAINT     �   ALTER TABLE ONLY public.disciplina_turma
    ADD CONSTRAINT fk_a49f1nn6uobd1i5wgmi76ndvl FOREIGN KEY (disciplina_id) REFERENCES public.disciplina(id);
 W   ALTER TABLE ONLY public.disciplina_turma DROP CONSTRAINT fk_a49f1nn6uobd1i5wgmi76ndvl;
       public       postgres    false    2121    195    196            r           2606    81258 -   observacao_aluno fk_bfit3ay1btk8crd1k8boxxgrs    FK CONSTRAINT     �   ALTER TABLE ONLY public.observacao_aluno
    ADD CONSTRAINT fk_bfit3ay1btk8crd1k8boxxgrs FOREIGN KEY (vinculoalunoturma_id) REFERENCES public.vinculo_aluno(id);
 W   ALTER TABLE ONLY public.observacao_aluno DROP CONSTRAINT fk_bfit3ay1btk8crd1k8boxxgrs;
       public       postgres    false    205    2151    199            u           2606    81273 *   vinculo_aluno fk_bmggi1u04hhjs5k172m0ajwr9    FK CONSTRAINT     �   ALTER TABLE ONLY public.vinculo_aluno
    ADD CONSTRAINT fk_bmggi1u04hhjs5k172m0ajwr9 FOREIGN KEY (aluno_id) REFERENCES public.aluno(id);
 T   ALTER TABLE ONLY public.vinculo_aluno DROP CONSTRAINT fk_bmggi1u04hhjs5k172m0ajwr9;
       public       postgres    false    205    2107    190            s           2606    81263 &   professor fk_c6gt1vylqf4u3l02ifu9dhwdv    FK CONSTRAINT     �   ALTER TABLE ONLY public.professor
    ADD CONSTRAINT fk_c6gt1vylqf4u3l02ifu9dhwdv FOREIGN KEY (contato_id) REFERENCES public.contato(id);
 P   ALTER TABLE ONLY public.professor DROP CONSTRAINT fk_c6gt1vylqf4u3l02ifu9dhwdv;
       public       postgres    false    2111    192    200            t           2606    81268 &   professor fk_cg9si6hurvcdp70e6otox1s20    FK CONSTRAINT     �   ALTER TABLE ONLY public.professor
    ADD CONSTRAINT fk_cg9si6hurvcdp70e6otox1s20 FOREIGN KEY (endereco_id) REFERENCES public.endereco(id);
 P   ALTER TABLE ONLY public.professor DROP CONSTRAINT fk_cg9si6hurvcdp70e6otox1s20;
       public       postgres    false    197    200    2127            j           2606    81218 "   aluno fk_dky20u41x9c3xw6c1uo7g6rn6    FK CONSTRAINT     �   ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT fk_dky20u41x9c3xw6c1uo7g6rn6 FOREIGN KEY (endereco_id) REFERENCES public.endereco(id);
 L   ALTER TABLE ONLY public.aluno DROP CONSTRAINT fk_dky20u41x9c3xw6c1uo7g6rn6;
       public       postgres    false    2127    190    197            l           2606    81228 ,   carne_pagamento fk_er8hrnvebyl5vk64w38jid0u9    FK CONSTRAINT     �   ALTER TABLE ONLY public.carne_pagamento
    ADD CONSTRAINT fk_er8hrnvebyl5vk64w38jid0u9 FOREIGN KEY (resp_financeiro_id) REFERENCES public.resp_financeiro(id);
 V   ALTER TABLE ONLY public.carne_pagamento DROP CONSTRAINT fk_er8hrnvebyl5vk64w38jid0u9;
       public       postgres    false    201    191    2137            k           2606    81223 "   aluno fk_f97c2nu6v3u4ipip6h4bx4myp    FK CONSTRAINT     �   ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT fk_f97c2nu6v3u4ipip6h4bx4myp FOREIGN KEY (responsavel_financeiro_id) REFERENCES public.resp_financeiro(id);
 L   ALTER TABLE ONLY public.aluno DROP CONSTRAINT fk_f97c2nu6v3u4ipip6h4bx4myp;
       public       postgres    false    190    2137    201            q           2606    81253 -   observacao_aluno fk_mndylryra2e33tfxb6p6u6wtf    FK CONSTRAINT     �   ALTER TABLE ONLY public.observacao_aluno
    ADD CONSTRAINT fk_mndylryra2e33tfxb6p6u6wtf FOREIGN KEY (coordenador_id) REFERENCES public.cord_pedagogo(id);
 W   ALTER TABLE ONLY public.observacao_aluno DROP CONSTRAINT fk_mndylryra2e33tfxb6p6u6wtf;
       public       postgres    false    199    2113    193            m           2606    81233 '   disciplina fk_n27x6vngvsn9jemjwmtibimx5    FK CONSTRAINT     �   ALTER TABLE ONLY public.disciplina
    ADD CONSTRAINT fk_n27x6vngvsn9jemjwmtibimx5 FOREIGN KEY (professor_id) REFERENCES public.professor(id);
 Q   ALTER TABLE ONLY public.disciplina DROP CONSTRAINT fk_n27x6vngvsn9jemjwmtibimx5;
       public       postgres    false    195    2133    200            h           2606    81208 "   falta fk_neapu18itsli36ul42jj97kvv    FK CONSTRAINT     �   ALTER TABLE ONLY public.falta
    ADD CONSTRAINT fk_neapu18itsli36ul42jj97kvv FOREIGN KEY (vinculoalunoturma_id) REFERENCES public.vinculo_aluno(id);
 L   ALTER TABLE ONLY public.falta DROP CONSTRAINT fk_neapu18itsli36ul42jj97kvv;
       public       postgres    false    2151    189    205            i           2606    81213 "   aluno fk_qx9f1y0oyv9nuplpe9atym0x4    FK CONSTRAINT     �   ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT fk_qx9f1y0oyv9nuplpe9atym0x4 FOREIGN KEY (contato_id) REFERENCES public.contato(id);
 L   ALTER TABLE ONLY public.aluno DROP CONSTRAINT fk_qx9f1y0oyv9nuplpe9atym0x4;
       public       postgres    false    192    190    2111            p           2606    81248 *   liquida_carne fk_rn1y0q2vt9g90qkg1pkg21rtx    FK CONSTRAINT     �   ALTER TABLE ONLY public.liquida_carne
    ADD CONSTRAINT fk_rn1y0q2vt9g90qkg1pkg21rtx FOREIGN KEY (carne_pagamento_id) REFERENCES public.carne_pagamento(id);
 T   ALTER TABLE ONLY public.liquida_carne DROP CONSTRAINT fk_rn1y0q2vt9g90qkg1pkg21rtx;
       public       postgres    false    198    191    2109            �     x���MK1�s�W�H��=�j�����^f7�Mɶ"���B{�V�@��׳=s�hL��l~`�(��^{����I�T��]tV���z�[�A�J�0*1�}��=���8}�I�>��<"_�C�8�����f���R���(ӑ��!�Pv8�@m��Ev}�6�5�����hW2�y+L�r8g�P���\��伻J� �?�-PE~��Dx�+R>P�f[d'�ɪͩ�k��E-FqѲE�����{.3�e*�@���*�i����"��M�u�GݩZ      �      x������ � �      �     x�u��n� E��%f�eްˇt�6��T~�r�����,f�����4�#%g�2.�-�4�9��0٘�k�@�*��Xi%!��6�R��Z���n��=f�p�jC��*d�!�4����݇p�FwDwLcMס�\�G!c'�0ҁ��[^��8�Y�-��x���5ٸ��O1E��(�"�K�Q��?}����=��8��*�|��% ���e�¹��6�ޭ4���T�`�jQ���5��hvy��t	y{M���B��Ar      �   5   x�3�,�4000265�L��/JI�KL�/�tFb#��:��8y:r��qqq ~)_      �   /   x�3�,�4 C#CΔ̢Ԓ�"N����r��t����� ��      �   �   x�-�;� E�zf^AC�p�(p�l�P�H|�S�����/hC̒���t�ﮄ�������"�V�;�R?��H�F�Y!#[�-�!���?A��N�0L!�Pb溻#�鎔��(��5�&�]H�rC�٥,�      �      x�3�,�4�4�2҆@�ʏ���� C-8      �   a  x����N�0E����i�`�*��вBBN&��>,�n��=ذ@B�<�3�xtg��V���d�$I�,M@�d�(���d_�-g1�P*��( I��1��$$M:��Jt�����'0�/��d읾�M�}��I:��Q����Fw��J�;w���f��WU��i�+���|V�J�d��7�`jD��:?l�gQE�l{9K�p�-�����	�	��9���(���\��t_lX��\�����)!��1�P���쭁�B������;Ma�_#�HB
�J��F��;*��;��Z
���񒳜X�h�5��>9O�hQ��հ�Ҩ`�_��e���O���      �      x������ � �      �      x������ � �      �      x������ � �      �   �   x���Kj�0E��^b,ٖ�iG����L��Iާ��Wt�� 8�
ငd�ђ�.��o[u�E�B�+FaFj8s�H-z�B9ƚ�Pp 
i 7꽓$Nt�w��y7�*	޾�cmϟhH���F���(_
���c���j2^�����-����ʯ�p��u��Y��o+x�&�E�lC�j��������S��e^��2O��ϡm�
bzk��4��/      �   O   x�3�,�403г44�3�0�56��H����K�Sp��ˬR�2*144�342׳�4�53�tK��,HU�/�J����� y&�      �   4   x�3�,�4 C#c#C����ԒĢ�|�`3E��9�5�1�ӑ+F��� R��      �   5   x�3�,�4� C�Ĕ��<NGY\R���_
p�u������� �       �       x�3�,�420��4<�A�1/_��+F��� H*�       	      x�3�,�4@�1~����\1z\\\ ?�     