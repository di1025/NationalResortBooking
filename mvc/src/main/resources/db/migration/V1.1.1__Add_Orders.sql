CREATE SEQUENCE orders_id_seq;
create table orders (
   id bigint not null DEFAULT NEXTVAL('orders_id_seq'),
   order_date date NOT NULL,
   quantity Integer NOT NULL,
   order_total numeric (10,2) NOT NULL,
   users_id bigint DEFAULT NULL,
   paid_date date,
   primary key (id),
   CONSTRAINT fk_order_user
     FOREIGN KEY (users_id)
     REFERENCES users (id)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION

);
ALTER SEQUENCE orders_id_seq OWNED BY orders.id;