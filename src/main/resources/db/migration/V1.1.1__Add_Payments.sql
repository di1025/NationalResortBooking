CREATE SEQUENCE payments_id_seq;
create table payments (
   id bigint not null DEFAULT NEXTVAL('payments_id_seq'),
   card_number integer NOT NULL,
   card_type varchar (25) NOT NULL,
   holder_first_name varchar(255) not NULL,
   holder_last_name varchar(255) not NULL,
   primary key (id)
);
ALTER SEQUENCE payments_id_seq OWNED BY payments.id;
