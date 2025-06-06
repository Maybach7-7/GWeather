\c postgres;
DROP DATABASE IF EXISTS gweather_db;
CREATE DATABASE gweather_db;
\connect gweather_db

CREATE SCHEMA app;
SET search_path = app, public;

CREATE TABLE users(
	id serial,
    username text NOT NULL,
    password text NOT NULL,
	primary key(id)
);


CREATE TABLE locations(
    user_id integer NOT NULL,
    latitude text NOT NULL,
    longitude text NOT NULL,
    primary key(user_id, latitude, longitude),
    CONSTRAINT fk_user FOREIGN KEY(user_id)
    REFERENCES users(id);
);

ALTER DATABASE web SET search_path = app, public;
