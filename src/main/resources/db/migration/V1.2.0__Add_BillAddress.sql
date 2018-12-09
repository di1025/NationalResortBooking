CREATE SEQUENCE bills_id_seq;
create table bill_address (
   id bigint not null DEFAULT NEXTVAL('bills_id_seq'),
   address1 varchar (255) NOT NULL,
   address2 varchar (255),
   zip_code number (10) NOT NULL,
   city varchar(255) NOT NULL,
   state varchar(255) NOT NULL,
   country varchar(255) NOT NULL,
   phone_number number (20) NOT NULL,
   primary key (id));
ALTER SEQUENCE bills_id_seq OWNED BY bill_address.id;
