CREATE SEQUENCE authorities_id_seq;
create table authorities (
   id bigint not null DEFAULT NEXTVAL('authorities_id_seq'),
   authority varchar(255) not NULL,
   user_id bigint not NULL,
   primary key (id),
   CONSTRAINT fk_authorities_user
     FOREIGN KEY (user_id)
     REFERENCES users (id)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION

);
ALTER SEQUENCE authorities_id_seq OWNED BY authorities.id;


