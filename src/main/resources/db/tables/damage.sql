CREATE SEQUENCE IF NOT EXISTS gits.damage_id_seq;

CREATE TABLE IF NOT EXISTS gits.damage (
  id              BIGINT        PRIMARY KEY DEFAULT nextval('gits.damage_id_seq'::regclass),
  damage          TEXT          NOT NULL
);
