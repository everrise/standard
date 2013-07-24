create table ARTICLE (
    IDS int not null auto_increment,
    ARTICLE varchar(100) not null,
    ARTICLE_ID int not null,
    CATEGORY_ID int not null,
    ARTICLE_CONTENT varchar(1000),
    DELETED_AT datetime,
    UPDATED_AT datetime,
    CREATED_AT datetime,
    constraint ARTICLE_PK primary key(IDS)
);
