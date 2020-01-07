CREATE TABLE IF NOT EXISTS supplier (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name varchar(30)
);

CREATE TABLE IF NOT EXISTS productCategory (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name varchar(30),
    description varchar(30)
);

CREATE TABLE IF NOT EXISTS product (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name varchar(30),
    description varchar(30),
    price decimal,
    weight double,
    imageUlr varchar(80),
    category int references productCategory (id) ,
    supplier int references  supplier (id)
);

CREATE TABLE IF NOT EXISTS customer (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    firstName varchar(30),
    lastName varchar(30),
    username varchar(30),
    password varchar(30),
    emailAddress varchar(50)
);

CREATE TABLE IF NOT EXISTS location (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name varchar(30),
    country varchar(30),
    city varchar(30),
    streetAddress varchar(30)
);

CREATE TABLE IF NOT EXISTS revenue (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    location int references location (id),
    date timestamp,
    sum decimal
);

CREATE TABLE IF NOT EXISTS stock (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    product int references product (id),
    location int references location (id),
    quantity int
);

CREATE TABLE IF NOT EXISTS `order` (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    shippedFrom int references location (id),
    customer int references  customer (id),
    createAt date,
    country varchar(30),
    city varchar(30),
    streetAddress varchar(30)
);

CREATE TABLE IF NOT EXISTS orderDetail (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    `order` int references `order` (id),
    product int references  product (id),
    quantity int
)