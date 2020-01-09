CREATE TABLE IF NOT EXISTS supplier (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name varchar(30)
);

CREATE TABLE IF NOT EXISTS product_Category (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name varchar(30),
    description varchar(30)
);

CREATE TABLE IF NOT EXISTS product (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name varchar(30),
    description varchar(30),
    price double,
    weight double,
    image_url varchar(80),
    category int references product_Category (id) ,
    supplier int references  supplier (id)
);

CREATE TABLE IF NOT EXISTS customer (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    first_name varchar(30),
    last_name varchar(30),
    username varchar(30),
    password varchar(30),
    email_address varchar(50)
);

CREATE TABLE IF NOT EXISTS location (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name varchar(30),
    country varchar(30),
    city varchar(30),
    street_address varchar(30)
);

CREATE TABLE IF NOT EXISTS revenue (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    location int references location (id),
    date timestamp,
    sum double
);

CREATE TABLE IF NOT EXISTS stock (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    product int references product (id),
    location int references location (id),
    quantity int
);

CREATE TABLE IF NOT EXISTS `order` (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    shipped_from int references location (id),
    customer_id int references  customer (id),
    create_at timestamp,
    country varchar(30),
    city varchar(30),
    street_address varchar(30)
);

CREATE TABLE IF NOT EXISTS order_detail (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    `order` int references `order` (id),
    product int references  product (id),
    quantity int
)