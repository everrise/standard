create table CHART (
    ID int not null auto_increment,
    CREATED_AT datetime,
    UPDATED_AT datetime,
    DELETED_AT datetime,
    CHART_QUANTITY int,
    CHART_COUNTRY varchar(1000),
    CHART_ID int not null,
    CHART varchar(100) not null,
    constraint CHART_PK primary key(ID)
);
