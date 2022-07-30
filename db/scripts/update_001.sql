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