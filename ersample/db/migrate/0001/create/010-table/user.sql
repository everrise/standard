create table USER (
    ID bigint not null auto_increment,
    NAME varchar(100) not null,
    LOGIN_ID varchar(255) not null,
    PASSWORD varchar(255) not null,
    DEPARTMENT_ID bigint,
    BIRTHDAY date,
    MEMO varchar(1000),
    DELETED_AT datetime,
    UPDATED_AT datetime,
    CREATED_AT datetime,
    constraint USER_PK primary key(ID)
);
