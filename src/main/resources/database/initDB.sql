create table product
(
    id varchar(36) not null
        constraint products_pk
        primary key,
    product_name varchar(64),
    price varchar,
    date timestamp default CURRENT_TIMESTAMP
);