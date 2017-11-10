CREATE SEQUENCE IF NOT EXISTS gits.crew_id_seq;

CREATE TABLE IF NOT EXISTS gits.crew (
  id              BIGINT        PRIMARY KEY DEFAULT nextval('gits.crew_id_seq'::regclass),
  crew_id         VARCHAR(5)    NOT NULL,
  supervisor      TEXT          NOT NULL
);