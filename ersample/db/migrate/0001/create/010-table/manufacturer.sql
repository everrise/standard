create table MANUFACTURER (
    MANUFACTURE_ID bigint not null auto_increment,
    CREATED_AT datetime,
    UPDATED_AT datetime,
    DELETED_AT datetime,
    NAME varchar(200) not null,
    constraint MANUFACTURER_PK primary key(MANUFACTURE_ID)
);
