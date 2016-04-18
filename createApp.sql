CREATE TABLE soundclip
(
  id bigserial NOT NULL,
  name character varying(255),
  ext character varying(10) NOT NULL,
  uploader character varying(255),
  data character varying NOT NULL,
  isPrivate boolean NOT NULL,
  CONSTRAINT soundclips_pkey PRIMARY KEY (id)
);

CREATE TABLE users
(
  id bigserial NOT NULL,
  name character varying(255) NOT NULL,
  pw character varying(255) NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id),
  CONSTRAINT users_name_unique UNIQUE (name)
);

CREATE ROLE soundup LOGIN
  ENCRYPTED PASSWORD 'md54e59dba9d8cb443b9aa5fe6ac162ce8e'
  SUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;