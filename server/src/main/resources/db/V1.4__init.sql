CREATE TABLE user(
    id int(10) PRIMARY key auto_increment,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    email varchar(60)
)