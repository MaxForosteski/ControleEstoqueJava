--
-- PostgreSQL database cluster dump
--

-- Started on 2025-03-06 13:52:38

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'SCRAM-SHA-256$4096:vDXGbAVWN3nlScnmFwpmaA==$qZqZ8vqp04fuHIsO9Kf0jY3fgW6+uhtq4PB/9flNn+A=:uksvEykZQZWOCxei7FQqoyE7oONXKVEb03/jHkDNg1w=';

--
-- User Configurations
--








--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

-- Started on 2025-03-06 13:52:38

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2025-03-06 13:52:39

--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

-- Started on 2025-03-06 13:52:39

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 224 (class 1255 OID 16446)
-- Name: verificar_estoque(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.verificar_estoque() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    IF( SELECT QUANTITY FROM ESTOQUE WHERE ID = NEW.ProductId) - NEW.quantity < 0 THEN
        RAISE EXCEPTION 'ERRO: Estoque insuficiente para o produto %!', NEW.ProductID;
    END IF;

    RETURN NEW;
END;
$$;


ALTER FUNCTION public.verificar_estoque() OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 219 (class 1259 OID 16407)
-- Name: Estoque; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Estoque" (
    "ProdutoId" bigint NOT NULL,
    "Quantity" integer,
    "IsActive" boolean,
    "CreatedOn" timestamp without time zone,
    "UpdatedOn" timestamp without time zone
);


ALTER TABLE public."Estoque" OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16430)
-- Name: Movimento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Movimento" (
    "Id" bigint NOT NULL,
    "ProductId" bigint NOT NULL,
    "MovementId" bigint NOT NULL,
    "Quantity" integer NOT NULL,
    "IsActive" boolean,
    "CreatedOn" timestamp without time zone,
    "UpdatedOn" timestamp without time zone
);


ALTER TABLE public."Movimento" OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16429)
-- Name: Movimento_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."Movimento" ALTER COLUMN "Id" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Movimento_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 218 (class 1259 OID 16395)
-- Name: Produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Produto" (
    "Id" bigint NOT NULL,
    "Name" character varying(255) NOT NULL,
    "Price" numeric,
    "Description" character varying(700),
    "IsActive" boolean,
    "CreatedOn" timestamp without time zone,
    "UpdatedOn" timestamp without time zone
);


ALTER TABLE public."Produto" OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16394)
-- Name: Produto_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."Produto" ALTER COLUMN "Id" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Produto_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 221 (class 1259 OID 16418)
-- Name: TipoMovimento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."TipoMovimento" (
    "Id" bigint NOT NULL,
    "Description" character varying(255) NOT NULL,
    "IsActive" boolean,
    "CreateOn" timestamp without time zone,
    "UpdatedOn" timestamp without time zone
);


ALTER TABLE public."TipoMovimento" OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16417)
-- Name: TipoMovimento_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."TipoMovimento" ALTER COLUMN "Id" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."TipoMovimento_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 4871 (class 0 OID 16407)
-- Dependencies: 219
-- Data for Name: Estoque; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Estoque" ("ProdutoId", "Quantity", "IsActive", "CreatedOn", "UpdatedOn") FROM stdin;
\.


--
-- TOC entry 4875 (class 0 OID 16430)
-- Dependencies: 223
-- Data for Name: Movimento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Movimento" ("Id", "ProductId", "MovementId", "Quantity", "IsActive", "CreatedOn", "UpdatedOn") FROM stdin;
\.


--
-- TOC entry 4870 (class 0 OID 16395)
-- Dependencies: 218
-- Data for Name: Produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Produto" ("Id", "Name", "Price", "Description", "IsActive", "CreatedOn", "UpdatedOn") FROM stdin;
\.


--
-- TOC entry 4873 (class 0 OID 16418)
-- Dependencies: 221
-- Data for Name: TipoMovimento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."TipoMovimento" ("Id", "Description", "IsActive", "CreateOn", "UpdatedOn") FROM stdin;
\.


--
-- TOC entry 4881 (class 0 OID 0)
-- Dependencies: 222
-- Name: Movimento_Id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Movimento_Id_seq"', 1, false);


--
-- TOC entry 4882 (class 0 OID 0)
-- Dependencies: 217
-- Name: Produto_Id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Produto_Id_seq"', 1, false);


--
-- TOC entry 4883 (class 0 OID 0)
-- Dependencies: 220
-- Name: TipoMovimento_Id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."TipoMovimento_Id_seq"', 1, false);


--
-- TOC entry 4715 (class 2606 OID 16411)
-- Name: Estoque Estoque_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Estoque"
    ADD CONSTRAINT "Estoque_pkey" PRIMARY KEY ("ProdutoId");


--
-- TOC entry 4711 (class 2606 OID 16401)
-- Name: Produto Identifier; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Produto"
    ADD CONSTRAINT "Identifier" PRIMARY KEY ("Id");


--
-- TOC entry 4719 (class 2606 OID 16434)
-- Name: Movimento Movimento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Movimento"
    ADD CONSTRAINT "Movimento_pkey" PRIMARY KEY ("Id");


--
-- TOC entry 4717 (class 2606 OID 16422)
-- Name: TipoMovimento TipoMovimento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."TipoMovimento"
    ADD CONSTRAINT "TipoMovimento_pkey" PRIMARY KEY ("Id");


--
-- TOC entry 4713 (class 2606 OID 16403)
-- Name: Produto Unique_Name; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Produto"
    ADD CONSTRAINT "Unique_Name" UNIQUE ("Name") INCLUDE ("Name");


--
-- TOC entry 4723 (class 2620 OID 16447)
-- Name: Produto Trigger_Verficar_Estoque; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER "Trigger_Verficar_Estoque" BEFORE INSERT OR UPDATE ON public."Produto" FOR EACH ROW EXECUTE FUNCTION public.verificar_estoque();


--
-- TOC entry 4721 (class 2606 OID 16440)
-- Name: Movimento Movimento_MovementId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Movimento"
    ADD CONSTRAINT "Movimento_MovementId_fkey" FOREIGN KEY ("MovementId") REFERENCES public."TipoMovimento"("Id");


--
-- TOC entry 4722 (class 2606 OID 16435)
-- Name: Movimento Movimento_ProductId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Movimento"
    ADD CONSTRAINT "Movimento_ProductId_fkey" FOREIGN KEY ("ProductId") REFERENCES public."Produto"("Id");


--
-- TOC entry 4720 (class 2606 OID 16412)
-- Name: Estoque Product Identifier; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Estoque"
    ADD CONSTRAINT "Product Identifier" FOREIGN KEY ("ProdutoId") REFERENCES public."Produto"("Id");


-- Completed on 2025-03-06 13:52:39

--
-- PostgreSQL database dump complete
--

-- Completed on 2025-03-06 13:52:39

--
-- PostgreSQL database cluster dump complete
--

