CREATE SEQUENCE IF NOT EXISTS gits.role_id_seq;

CREATE TABLE IF NOT EXISTS gits.role (
  id              BIGINT        PRIMARY KEY DEFAULT nextval('gits.role_id_seq'::regclass),
  role            TEXT          NOT NULL
);