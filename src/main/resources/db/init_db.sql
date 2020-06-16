CREATE DATABASE quarkus_security_jdbc;
\c quarkus_security_jdbc
CREATE TABLE user_tbl (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);

INSERT INTO user_tbl (username, password, role) VALUES ('user', 'user', 'user');
INSERT INTO user_tbl (username, password, role) VALUES ('admin', 'admin', 'admin');