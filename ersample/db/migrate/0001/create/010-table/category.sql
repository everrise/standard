create table CATEGORY (
    ID int not null auto_increment,
    CATEGORY varchar(100) not null,
    CATEGORY_ID int not null,
    CATEGORY_CONTENT varchar(1000),
    CATEGORY_NUMBER int,
    DELETED_AT datetime,
    UPDATED_AT datetime,
    CREATED_AT datetime,
    constraint CATEGORY_PK primary key(ID)
);
