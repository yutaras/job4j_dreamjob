CREATE TABLE if not exists candidate (
                      id SERIAL PRIMARY KEY,
                      name TEXT,
                      description TEXT,
                      created TIMESTAMP,
                      photo bytea
);