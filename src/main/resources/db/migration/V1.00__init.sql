CREATE TABLE demo
(
    pk          VARCHAR(10) PRIMARY KEY,
    name        VARCHAR(10) NOT NULL,
    quantity    INTEGER NOT NULL
);

--insert into demo (pk, name, quantity) values ('001', 'name-01', 10);