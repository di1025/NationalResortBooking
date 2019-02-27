CREATE SEQUENCE payments_id_seq;
create table payments (
   id bigint not null DEFAULT NEXTVAL('payments_id_seq'),
   card_number integer NOT NULL,
   card_type varchar (25) NOT NULL,
   holder_first_name varchar(255) not NULL,
   holder_last_name varchar(255) not NULL,
   order_id bigint NOT NULL,
   billing_address1 varchar (255) NOT NULL,
   billing_address2 varchar (255),
   billing_zip_code Integer NOT NULL,
   billing_city varchar(255) NOT NULL,
   billing_state varchar(255) NOT NULL,
   billing_country varchar(255) NOT NULL,
   billing_phone_number varchar (20) NOT NULL,
   primary key (id),
   CONSTRAINT fk_payment_order
     FOREIGN KEY (order_id)
     REFERENCES orders (id)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION
);
ALTER SEQUENCE payments_id_seq OWNED BY payments.id;
