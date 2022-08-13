CREATE TABLE if not exists post (
                      id SERIAL PRIMARY KEY,
                      name TEXT,
                      description TEXT,
                      created TIMESTAMP,
                      visible BOOLEAN,
                      city_id INT
);

CREATE TABLE if not exists candidate (
                      id SERIAL PRIMARY KEY,
                      name TEXT,
                      description TEXT,
                      created TIMESTAMP,
                      photo bytea
);

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  email varchar,
  password TEXT
);
ALTER TABLE users ADD CONSTRAINT email_unique UNIQUE (email);