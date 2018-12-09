CREATE SEQUENCE orders_id_seq;
create table orders (
   id bigint not null DEFAULT NEXTVAL('orders_id_seq'),
   order_date date NOT NULL,
   quantity number (3) NOT NULL,
   order_total number (10) NOT NULL,
   bill_address_id bigint NOT NULL,
   users_id bigint NOT NULL,
   payment_id bigint NOT NULL,
   paid_date date,
   primary key (id)
   foreign key (bill_address_id references bill_address.id,users_id references users.id, payment_id references payment.id)
);
ALTER SEQUENCE orders_id_seq OWNED BY orders.id;
