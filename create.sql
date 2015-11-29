CREATE TABLE soundclip
(
  id bigserial NOT NULL,
  name character varying(255),
  data bytea NOT NULL,
  ext character varying(10) NOT NULL,
  CONSTRAINT soundclip_pkey PRIMARY KEY (id),
  CONSTRAINT soundclip_name_unique UNIQUE (name)
);

CREATE TABLE usersoundclip
(
  id bigserial NOT NULL,
  name character varying(255),
  data bytea NOT NULL,
  ext character varying(10) NOT NULL,
  "user" character varying(255) NOT NULL,
  CONSTRAINT usc_pkey PRIMARY KEY (id),
  CONSTRAINT usc_user_fkey FOREIGN KEY ("user")
      REFERENCES users (name) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT usc_name_unique UNIQUE (name)
);

CREATE TABLE users
(
  id bigserial NOT NULL,
  name character varying(255) NOT NULL,
  hash character varying(255) NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id),
  CONSTRAINT users_name_unique UNIQUE (name)
);

CREATE ROLE soundup LOGIN
  ENCRYPTED PASSWORD 'md54e59dba9d8cb443b9aa5fe6ac162ce8e'
  SUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;