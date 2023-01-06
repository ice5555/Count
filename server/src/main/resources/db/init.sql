CREATE TABLE home(  
    id int AUTO_INCREMENT,
    label VARCHAR(20) NULL,
    custom VARCHAR(20) null,
    count FLOAT NULL,
    comment text null,
    type VARCHAR(20) NULL,
    cus_date DATE NULL,
    constraint homepk
        PRIMARY key(id)

) COMMENT '';