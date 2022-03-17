create table goods
(
    id            int AUTO_INCREMENT primary key,
    title         varchar(30) not null,
    category_id   int         not null,
    merchant_id   int         not null,
    price         int              default 0,
    image         varchar(40)      default null,
    stock_qty     int         not null,
    sold_qty      int         not null,
    `create_time` timestamp   NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
);
create table category
(
    id            int AUTO_INCREMENT primary key,
    name          varchar(30) not null,
    image         varchar(50) not null,
    `create_time` timestamp   NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
);



create table shopping_cart
(
    id            int AUTO_INCREMENT primary key,
    user_id       int       not null,
    goods_id      int       not null,
    num           int       not null default 1,
    `create_time` timestamp NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
);


create table user_address
(
    id            int AUTO_INCREMENT primary key,
    user_id       int       not null,
    phone         int       not null,
    name          varchar(50),
    address       varchar(100),
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
);