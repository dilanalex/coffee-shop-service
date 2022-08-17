-- Table: public.customer

-- DROP TABLE IF EXISTS public.customer;

CREATE TABLE IF NOT EXISTS public.customer
(
    customer_id bigint NOT NULL,
    address_1 character varying(255) COLLATE pg_catalog."default" NOT NULL,
    address_2 character varying(255) COLLATE pg_catalog."default",
    created_date timestamp without time zone,
    email character varying(100) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(255) COLLATE pg_catalog."default",
    modified_date timestamp without time zone,
    phone character varying(30) COLLATE pg_catalog."default",
    status character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (customer_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customer
    OWNER to postgres;
    
    
-- Table: public.customer_queue

-- DROP TABLE IF EXISTS public.customer_queue;

CREATE TABLE IF NOT EXISTS public.customer_queue
(
    cutomer_queue_id bigint NOT NULL,
    queue_id bigint NOT NULL,
    CONSTRAINT customer_queue_pkey PRIMARY KEY (cutomer_queue_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customer_queue
    OWNER to postgres;    
    
    
-- DROP TABLE IF EXISTS public.tray;
------------------------------------
CREATE TABLE IF NOT EXISTS public.tray
(
    tray_id bigint NOT NULL,
    created_date timestamp without time zone,
    modified_date timestamp without time zone,
    status character varying(255) COLLATE pg_catalog."default",
    tax numeric(19,2),
    total numeric(19,2),
    customer_id bigint,
    customer_in_queue boolean,
    cutomer_queue_id bigint,
    CONSTRAINT tray_pkey PRIMARY KEY (tray_id),
    CONSTRAINT fk1fogcj9uccm12kxcfsua1wyst FOREIGN KEY (customer_id)
        REFERENCES public.customer (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkn1peg8g99m0ivt179qrt7ijkt FOREIGN KEY (cutomer_queue_id)
        REFERENCES public.customer_queue (cutomer_queue_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tray
    OWNER to postgres;

-------------------------------------------
CREATE TABLE IF NOT EXISTS public.item
(
    item_id bigint NOT NULL,
    created_by character varying(255) COLLATE pg_catalog."default",
    created_date timestamp without time zone,
    description character varying(255) COLLATE pg_catalog."default",
    image_path character varying(255) COLLATE pg_catalog."default",
    modified_by character varying(255) COLLATE pg_catalog."default",
    modified_date timestamp without time zone,
    name character varying(255) COLLATE pg_catalog."default",
    price double precision,
    tray_id bigint,
    CONSTRAINT item_pkey PRIMARY KEY (item_id),
    CONSTRAINT fk7h1vuar4ogrmbp5plp42gg7t3 FOREIGN KEY (tray_id)
        REFERENCES public.tray (tray_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.item
    OWNER to postgres;
    
