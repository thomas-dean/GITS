CREATE SEQUENCE IF NOT EXISTS gits.structure_id_seq;

CREATE TABLE IF NOT EXISTS gits.structure (
  id              BIGINT        PRIMARY KEY DEFAULT nextval('gits.structure_id_seq'::regclass),
  structure       TEXT          NOT NULL
);
