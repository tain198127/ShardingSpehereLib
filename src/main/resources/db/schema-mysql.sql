create database ss_0;
create database ss_1;
create database ss_2;

create table ss_0.sharding_test
(
    id           int auto_increment,
    reg_date     datetime null,
    name         varchar(255) null,
    sharding_key varchar(255) null,
    constraint sharding_test_0_pk
        primary key (id)
);

create table ss_0.sharding_test_0
(
    id           int auto_increment,
    reg_date     datetime null,
    name         varchar(255) null,
    sharding_key varchar(255) null,
    constraint sharding_test_0_pk
        primary key (id)
);
create table ss_0.sharding_test_1
(
    id           int auto_increment,
    reg_date     datetime null,
    name         varchar(255) null,
    sharding_key varchar(255) null,
    constraint sharding_test_1_pk
        primary key (id)
);
create table ss_0.sharding_test_2
(
    id           int auto_increment,
    reg_date     datetime null,
    name         varchar(255) null,
    sharding_key varchar(255) null,
    constraint sharding_test_2_pk
        primary key (id)
);

create table ss_1.sharding_test_3
(
    id           int auto_increment,
    reg_date     datetime null,
    name         varchar(255) null,
    sharding_key varchar(255) null,
    constraint sharding_test_3_pk
        primary key (id)
);

create table ss_1.sharding_test_4
(
    id           int auto_increment,
    reg_date     datetime null,
    name         varchar(255) null,
    sharding_key varchar(255) null,
    constraint sharding_test_4_pk
        primary key (id)
);

create table ss_1.sharding_test_5
(
    id           int auto_increment,
    reg_date     datetime null,
    name         varchar(255) null,
    sharding_key varchar(255) null,
    constraint sharding_test_5_pk
        primary key (id)
);



create table ss_2.sharding_test_6
(
    id           int auto_increment,
    reg_date     datetime null,
    name         varchar(255) null,
    sharding_key varchar(255) null,
    constraint sharding_test_6_pk
        primary key (id)
);


create table ss_2.sharding_test_7
(
    id           int auto_increment,
    reg_date     datetime null,
    name         varchar(255) null,
    sharding_key varchar(255) null,
    constraint sharding_test_7_pk
        primary key (id)
);


create table ss_2.sharding_test_8
(
    id           int auto_increment,
    reg_date     datetime null,
    name         varchar(255) null,
    sharding_key varchar(255) null,
    constraint sharding_test_8_pk
        primary key (id)
);

