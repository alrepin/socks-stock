-- liquibase formatted sql

-- changeset alrepin:1
create table if not exists "color"
(
    "id"    BIGINT auto_increment
        primary key,
    "value" CHARACTER VARYING(255)
);

create table if not exists "sock"
(
    "cotton_part" INTEGER not null,
    "quantity"    INTEGER,
    "color"       BIGINT  not null,
    primary key ("color", "cotton_part"),
    constraint "FKfqlmufmgwra2kbflsfh73iddy"
        foreign key ("color") references "color"
);