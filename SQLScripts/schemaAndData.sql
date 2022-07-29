create table if not exists Taco_Order
(
    id              BIGINT                              NOT NULL AUTO_INCREMENT PRIMARY KEY,
    delivery_Name   varchar(50)                         not null,
    delivery_Street varchar(50)                         not null,
    delivery_City   varchar(50)                         not null,
    delivery_State  varchar(20)                         not null,
    delivery_Zip    varchar(10)                         not null,
    cc_number       varchar(16)                         not null,
    cc_expiration   varchar(5)                          not null,
    cc_cvv          varchar(3)                          not null,
    placed_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
    email           varchar(25)                         not null
) ENGINE = InnoDB;

create table if not exists Taco
(
    id            BIGINT                              NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name          varchar(50)                         not null,
    taco_order_id bigint                              not null,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null
) ENGINE = InnoDB;

create table if not exists Taco_to_Ingredient
(
    reference_id  BIGINT     NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ingredient_id varchar(4) not null,
    taco_id       bigint     not null,
    INDEX (taco_id),
    INDEX (ingredient_id)
) ENGINE = InnoDB;


create table if not exists Ingredient
(
    id   varchar(4)  not null primary key,
    name varchar(25) not null,
    type varchar(10) not null
) ENGINE = InnoDB;


alter table Taco
    add foreign key (taco_order_id) references Taco_Order (id);
alter table Taco_to_Ingredient
    add foreign key (ingredient_id) references Ingredient (id);
alter table Taco_to_Ingredient
    add foreign key (taco_id) references Taco (id);


SET FOREIGN_KEY_CHECKS = 0;
insert into Ingredient (id, name, type)
values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type)
values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, type)
values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, type)
values ('SRCR', 'Sour Cream', 'SAUCE');

insert into Taco_Order (id, delivery_Name, delivery_Street, delivery_City, delivery_State, delivery_Zip, cc_number,
                        cc_expiration, cc_cvv, email)
VALUES (1, 'My first order', 'Kloosterstraat 27 a', 'Emblem', 'Antwerpen', '2520', '4111111111111112', '10/12', '999',
        'test@email.com');

insert into Taco_Order (id, delivery_Name, delivery_Street, delivery_City, delivery_State, delivery_Zip, cc_number,
                        cc_expiration, cc_cvv, email)
VALUES (2, 'Test McTest', '1234 Test Lane', 'Testville', 'CO', '80123', '4111111111111111', '8/12', '124',
        'test2@email.com');

insert into Taco(id, name, taco_order_id)
values (1, 'Taco one', 1);

insert into Taco(id, name, taco_order_id)
values (2, 'Taco two', 1);

insert into Taco(id, name, taco_order_id)
values (3, 'Taco three', 2);

insert into Taco_to_Ingredient (taco_id, ingredient_id)
values (1, 'FLTO');
insert into Taco_to_Ingredient (taco_id, ingredient_id)
values (1, 'GRBF');

insert into Taco_to_Ingredient (taco_id, ingredient_id)
values (2, 'GRBF');
insert into Taco_to_Ingredient (taco_id, ingredient_id)
values (2, 'CARN');

insert into Taco_to_Ingredient (taco_id, ingredient_id)
values (3, 'GRBF');
insert into Taco_to_Ingredient (taco_id, ingredient_id)
values (3, 'CARN');
insert into Taco_to_Ingredient (taco_id, ingredient_id)
values (3, 'FLTO');
SET FOREIGN_KEY_CHECKS = 1;

create procedure deleteTacoOrder(in toid bigint)
begin
    delete ti
    from Taco_to_Ingredient ti
             inner join Taco T on ti.taco_id = T.id
    where taco_order_id = toid;
    delete from Taco where taco_order_id = toid;
    delete from Taco_Order where id = toid;
end;
