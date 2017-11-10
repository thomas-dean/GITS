CREATE SEQUENCE IF NOT EXISTS gits.gang_id_seq;

CREATE TABLE IF NOT EXISTS gits.gang (
  id              BIGINT        PRIMARY KEY DEFAULT nextval('gits.gang_id_seq'::regclass),
  name            TEXT          NOT NULL
);
