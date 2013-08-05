create table PRODUCT (
    PRODUCT_ID bigint not null auto_increment,
    CREATED_AT datetime,
    UPDATED_AT datetime,
    DELETED_AT datetime,
    MANUFACTURER_ID bigint not null,
    NAME varchar(200) not null,
    constraint PRODUCT_PK primary key(PRODUCT_ID)
);
