CREATE SEQUENCE public.distributions_seq;

CREATE TABLE public.distributions (
	id int4 NOT NULL DEFAULT nextval('distributions_seq'::regclass),
	"name" varchar NULL,
	"version" varchar NULL,
	codename varchar NULL,
	CONSTRAINT distributions_pkey PRIMARY KEY (id)
);

INSERT INTO public.distributions 
("name", "version", codename) 
VALUES
('Debian', '12.4.0', 'bookworm'),
('Ubuntu', '22.04.3', 'jammy');
