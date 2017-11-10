CREATE SEQUENCE IF NOT EXISTS gits.suspect_id_seq;

CREATE TABLE IF NOT EXISTS gits.suspect (
  id                BIGINT        PRIMARY KEY DEFAULT nextval('gits.suspect_id_seq'::regclass),
  name              TEXT          NOT NULL,
  photo             BYTEA         ,
  status_id         BIGINT        REFERENCES gits.suspect_status(id),
  gang_id           BIGINT        REFERENCES gits.gang(id)
);
