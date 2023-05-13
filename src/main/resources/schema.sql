CREATE TABLE IF NOT EXISTS students
(
    id         SERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    age        INTEGER
);