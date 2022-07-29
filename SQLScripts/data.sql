# Ingredients
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

# Taco Order

insert into Taco_Order (id, delivery_Name, delivery_Street, delivery_City, delivery_State, delivery_Zip, cc_number,
                        cc_expiration, cc_cvv, email)
VALUES (1, 'My first order', 'Kloosterstraat 27 a', 'Emblem', 'Antwerpen', '2520', '4111111111111112', '10/12', '999', 'test@email.com');

insert into Taco_Order (id, delivery_Name, delivery_Street, delivery_City, delivery_State, delivery_Zip, cc_number,
                        cc_expiration, cc_cvv, email)
VALUES (2, 'Test McTest', '1234 Test Lane', 'Testville', 'CO', '80123', '4111111111111111', '8/12', '124', 'test2@email.com');

# Tacos
insert into Taco(id, name, taco_order_id)
values (1, 'Taco one', 1);

insert into Taco(id, name, taco_order_id)
values (2, 'Taco two', 1);

insert into Taco(id, name, taco_order_id)
values (3, 'Taco three', 2);

# taco_to_ingredient

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