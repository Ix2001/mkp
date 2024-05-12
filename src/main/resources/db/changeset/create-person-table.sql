--liquibase formatted sql
--changeset yabbos:EEMO-25
CREATE TABLE IF NOT EXISTS person (
    id BIGINT PRIMARY KEY,
    adress VARCHAR(255),
    emaill VARCHAR(255),
    name VARCHAR(255)
)