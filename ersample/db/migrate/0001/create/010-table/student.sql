create table STUDENT (
    ID bigint not null auto_increment,
    CREATED_AT datetime,
    UPDATED_AT datetime,
    DELETED_AT datetime,
    EMAIL varchar(100) not null,
    ADDRESS varchar(255),
    NAME varchar(100) not null,
    constraint STUDENT_PK primary key(ID)
);
