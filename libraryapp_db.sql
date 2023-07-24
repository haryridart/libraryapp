--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2023-07-24 19:30:11

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
-- TOC entry 3338 (class 1262 OID 2454038)
-- Name: libraryapp_db; Type: DATABASE; Schema: -; Owner: -
--

CREATE DATABASE libraryapp_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';


\connect libraryapp_db

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
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA public;


--
-- TOC entry 3339 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 2454051)
-- Name: books; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.books (
    id integer NOT NULL,
    author character varying(255),
    book_id character varying(255) NOT NULL,
    published_date date,
    publisher character varying(255),
    title character varying(255),
    total_pages integer,
    borrow_id integer
);


--
-- TOC entry 214 (class 1259 OID 2454050)
-- Name: books_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.books_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3340 (class 0 OID 0)
-- Dependencies: 214
-- Name: books_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.books_id_seq OWNED BY public.books.id;


--
-- TOC entry 217 (class 1259 OID 2454060)
-- Name: borrows; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.borrows (
    id integer NOT NULL,
    borrower_name character varying(255),
    reserve_date date,
    return_date date,
    status integer
);


--
-- TOC entry 216 (class 1259 OID 2454059)
-- Name: borrows_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.borrows_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3341 (class 0 OID 0)
-- Dependencies: 216
-- Name: borrows_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.borrows_id_seq OWNED BY public.borrows.id;


--
-- TOC entry 3178 (class 2604 OID 2454054)
-- Name: books id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.books ALTER COLUMN id SET DEFAULT nextval('public.books_id_seq'::regclass);


--
-- TOC entry 3179 (class 2604 OID 2454063)
-- Name: borrows id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.borrows ALTER COLUMN id SET DEFAULT nextval('public.borrows_id_seq'::regclass);


--
-- TOC entry 3330 (class 0 OID 2454051)
-- Dependencies: 215
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.books (id, author, book_id, published_date, publisher, title, total_pages, borrow_id) FROM stdin;
\.


--
-- TOC entry 3332 (class 0 OID 2454060)
-- Dependencies: 217
-- Data for Name: borrows; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.borrows (id, borrower_name, reserve_date, return_date, status) FROM stdin;
\.


--
-- TOC entry 3342 (class 0 OID 0)
-- Dependencies: 214
-- Name: books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.books_id_seq', 1, false);


--
-- TOC entry 3343 (class 0 OID 0)
-- Dependencies: 216
-- Name: borrows_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.borrows_id_seq', 1, false);


--
-- TOC entry 3181 (class 2606 OID 2454058)
-- Name: books books_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);


--
-- TOC entry 3185 (class 2606 OID 2454065)
-- Name: borrows borrows_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.borrows
    ADD CONSTRAINT borrows_pkey PRIMARY KEY (id);


--
-- TOC entry 3183 (class 2606 OID 2454067)
-- Name: books uk_a2hycuy8mfqlvgkancp9q6sg0; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT uk_a2hycuy8mfqlvgkancp9q6sg0 UNIQUE (book_id);


--
-- TOC entry 3186 (class 2606 OID 2454068)
-- Name: books fkfnhknneg010e8qdh1a765vs4e; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT fkfnhknneg010e8qdh1a765vs4e FOREIGN KEY (borrow_id) REFERENCES public.borrows(id);


-- Completed on 2023-07-24 19:30:11

--
-- PostgreSQL database dump complete
--

