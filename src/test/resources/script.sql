DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS userroles;

CREATE TABLE users(
    id          SMALLSERIAL PRIMARY KEY,
    username    VARCHAR(50) UNIQUE NOT NULL,
    password    VARCHAR(50) NOT NULL
);

CREATE TABLE userroles(
    userid      SMALLSERIAL PRIMARY KEY,
    username    VARCHAR(50) NOT NULL
);

