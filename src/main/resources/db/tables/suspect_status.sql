CREATE SEQUENCE IF NOT EXISTS gits.suspect_status_id_seq;

CREATE TABLE IF NOT EXISTS gits.suspect_status (
  id              BIGINT        PRIMARY KEY DEFAULT nextval('gits.suspect_status_id_seq'::regclass),
  status          TEXT          NOT NULL
);
