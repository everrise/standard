create table USER (
    ID bigint not null auto_increment,
    CREATED_AT datetime,
    UPDATED_AT datetime,
    DELETED_AT datetime,
    MEMO varchar(1000),
    BIRTHDAY date,
    DEPARTMENT_ID bigint,
    PASSWORD varchar(255) not null,
    LOGIN_ID varchar(255) not null,
    NAME varchar(100) not null,
    constraint USER_PK primary key(ID)
);
