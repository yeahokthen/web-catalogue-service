DROP TABLE IF EXISTS book;
CREATE TABLE book(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    author VARCHAR(255) not null ,
    isbn varchar(255) UNIQUE NOT NULL ,
    price float NOT NULL ,
    title varchar(255) NOT NULL ,
    created_date timestamp ,
    last_modified_date timestamp,
    version integer NOT NULL
);