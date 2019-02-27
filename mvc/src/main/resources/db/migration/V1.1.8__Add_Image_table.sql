CREATE SEQUENCE images_id_seq;
create table images (
   id bigint not null DEFAULT NEXTVAL('images_id_seq'),
   url varchar(255) DEFAULT NULL,
   extension varchar(255) DEFAULT NULL,
   s3_key varchar(255)DEFAULT NULL,
   users_id bigint DEFAULT NULL,
   uuid varchar(255)DEFAULT NULL,
   bucket varchar(255)DEFAULT NULL,
   primary key (id),
   CONSTRAINT fk_image_user
     FOREIGN KEY (users_id)
     REFERENCES users (id)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION
);

ALTER SEQUENCE images_id_seq OWNED BY images.id;