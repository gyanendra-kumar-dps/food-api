create table if not exists "customer" ("id" integer not null, "email" varchar(255), "name" varchar(255), "phone" varchar(255), primary key ("id"));
create table if not exists "meals" ("id" integer not null, "description" varchar(255), "image" varchar(255), "name" varchar(255), "price" varchar(255), primary key ("id"));
create table if not exists "order_meal" ("order_id" integer not null, "meal_id" integer not null);
create table if not exists "orders" ("id" integer not null, "total" float(53), primary key ("id"));
create sequence if not exists "customer_seq" start with 1 increment by 50 ;
create sequence if not exists "meal_seq" start with 1 increment by 50 ;
create sequence if not exists "order_seq" start with 1 increment by 50 ;
alter table if exists "order_meal" add constraint "FKkcx0t6f29c1ackxwatmqy582t" foreign key ("meal_id") references "meal" ;
alter table if exists "order_meal" add constraint "FKh5ugvq705pqig9e9wpog3fjb9" foreign key ("order_id") references "orders" ;
INSERT INTO "meals" (id, name, price, description, image) VALUES (1, 'Mac & Cheese', '8.99', 'Creamy cheddar cheese mixed with perfectly cooked macaroni, topped with crispy breadcrumbs. A classic comfort food.', 'images/mac-and-cheese.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (2, 'Margherita Pizza', '12.99', 'A classic pizza with fresh mozzarella, tomatoes, and basil on a thin and crispy crust.', 'images/margherita-pizza.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (3, 'Caesar Salad', '7.99', 'Romaine lettuce tossed in Caesar dressing, topped with croutons and parmesan shavings.', 'images/caesar-salad.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (4, 'Spaghetti Carbonara', '10.99', 'Al dente spaghetti with a creamy sauce made from egg yolk, pecorino cheese, pancetta, and pepper.', 'images/spaghetti-carbonara.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (5, 'Veggie Burger', '9.99', 'A juicy veggie patty served on a whole grain bun with lettuce, tomato, and a tangy sauce.', 'images/veggie-burger.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (6, 'Grilled Chicken Sandwich', '10.99', 'Tender grilled chicken breast with avocado, bacon, lettuce, and honey mustard on a toasted bun.', 'images/grilled-chicken-sandwich.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (7, 'Steak Frites', '17.99', 'Succulent steak cooked to your preference, served with crispy golden fries and herb butter.', 'images/steak-frites.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (8, 'Sushi Roll Platter', '15.99', 'An assortment of fresh sushi rolls including California, Spicy Tuna, and Eel Avocado.', 'images/sushi-roll-platter.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (9, 'Chicken Curry', '13.99', 'Tender pieces of chicken simmered in a rich and aromatic curry sauce, served with basmati rice.', 'images/chicken-curry.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (10, 'Vegan Buddha Bowl', '11.99', 'A hearty bowl filled with quinoa, roasted veggies, avocado, and a tahini dressing.', 'images/vegan-buddha-bowl.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (11, 'Seafood Paella', '19.99', 'A Spanish delicacy filled with saffron-infused rice, shrimp, mussels, and chorizo.', 'images/seafood-paella.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (12, 'Pancake Stack', '8.99', 'Fluffy pancakes stacked high, drizzled with maple syrup and topped with fresh berries.', 'images/pancake-stack.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (13, 'Miso Ramen', '12.99', 'A warming bowl of ramen with miso broth, tender pork, soft-boiled egg, and green onions.', 'images/miso-ramen.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (14, 'Beef Tacos', '9.99', 'Three soft tortillas filled with seasoned beef, fresh salsa, cheese, and sour cream.', 'images/beef-tacos.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (15, 'Chocolate Brownie', '5.99', 'A rich and fudgy brownie, topped with a scoop of vanilla ice cream and chocolate sauce.', 'images/chocolate-brownie.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (16, 'Lobster Bisque', '14.99', 'A creamy soup made from lobster stock, aromatic vegetables, and a touch of brandy.', 'images/lobster-bisque.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (17, 'Mushroom Risotto', '13.99', 'Creamy Arborio rice cooked with a medley of wild mushrooms and finished with parmesan.', 'images/mushroom-risotto.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (18, 'Eggplant Parmesan', '11.99', 'Layers of breaded eggplant, marinara sauce, and melted mozzarella and parmesan cheeses.', 'images/eggplant-parmesan.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (19, 'Lemon Cheesecake', '6.99', 'A creamy cheesecake with a tangy lemon flavor, served on a crumbly biscuit base.', 'images/lemon-cheesecake.jpg');
INSERT INTO "meals" (id, name, price, description, image) VALUES (20, 'Falafel Wrap', '8.99', 'Crispy falafels wrapped in a warm pita with lettuce, tomatoes, and a tahini sauce.', 'images/falafel-wrap.jpg');