
商品表

create table goods(
    id int AUTO_INCREMENT primary key,
    title varchar(30) not null,
    price float not null,
    num int not null,
    sales int default 0,
    image varchar(40) default null
)

15003411932
123

/**分类表 主键自增 分类+商品组合唯一 **/
create table goods_classify(
                         id int AUTO_INCREMENT primary key ,
                         classify varchar(10) not null,
                         goodsId int not null,
                         unique (classify,goodsId)
)

/**购物车**/

create table shopping_cart(
                      id int AUTO_INCREMENT primary key,
                      phone char(11) not null,
                      num int not null default 1
)

create table shopping_cart(
                              id int AUTO_INCREMENT primary key,
                              phone char(11) not null,
                              goodsId int not null,
                              num int not null default 1,
                              /*foreign key (goodsId) references goods(id),*/
                              UNIQUE (goodsId,phone)
)

/**详细条目订单**/
create table order_detailed(
                               id int AUTO_INCREMENT primary key ,
                               goodsId int not null,
                               price float not null,
                               num int not null,
                               orderId int not null,
                               foreign key (goodsId) references goods(id),
                               foreign key (orderId) references order_total(id)
)

/**大订单**/
create table order_total(
                               id int AUTO_INCREMENT primary key ,
                               date varchar(20) not null,
                               total_price float not null,
                               discount float not null,
                               phone int not null,
                               address int not null,
                               status int default 0,
                               /*foreign key (phone) references user_info(phone),*/
                               foreign key (address) references address(id)
)

/* 地址 */
create table user_address(
                               id int AUTO_INCREMENT primary key ,
                               name varchar(40) not null,
                               x float not null,
                               y float not null,
                               address_detailed text default null,
                               Unique(x,y)
)

/** 用户和地址 **/
create table user_address(
                               id int AUTO_INCREMENT primary key ,
                               phone int not null,
                               addressId int not null,
                               statue int default 0,
                               foreign key user_address(addressId) references address(id)
)