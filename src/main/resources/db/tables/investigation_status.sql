CREATE SEQUENCE IF NOT EXISTS gits.investigation_status_id_seq;

CREATE TABLE IF NOT EXISTS gits.investigation_status (
  id              BIGINT        PRIMARY KEY DEFAULT nextval('gits.investigation_status_id_seq'::regclass),
  status          TEXT          NOT NULL
);