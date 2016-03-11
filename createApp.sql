CREATE TABLE soundclip
(
  id bigint NOT NULL,
  name character varying(255),
  ext character varying(10) NOT NULL,
  uploader character varying(255),
  data character varying NOT NULL,
  private boolean NOT NULL,
  CONSTRAINT soundclips_pkey PRIMARY KEY (id)
);

CREATE ROLE soundup LOGIN
  ENCRYPTED PASSWORD 'md54e59dba9d8cb443b9aa5fe6ac162ce8e'
  SUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;