drop SEQUENCE bills_id_seq CASCADE;
create SEQUENCE bill_address_id_seq;
ALTER SEQUENCE bill_address_id_seq OWNED BY bill_address.id;