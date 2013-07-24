create table CHART (
    ID int not null auto_increment,
    CHART varchar(100) not null,
    CHART_ID int not null,
    CHART_COUNTRY varchar(1000),
    CHART_QUANTITY int,
    DELETED_AT datetime,
    UPDATED_AT datetime,
    CREATED_AT datetime,
    constraint CHART_PK primary key(ID)
);
