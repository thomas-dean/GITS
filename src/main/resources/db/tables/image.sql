CREATE SEQUENCE IF NOT EXISTS gits.image_id_seq;

CREATE TABLE IF NOT EXISTS gits.image (
  id              BIGINT        PRIMARY KEY DEFAULT nextval('gits.image_id_seq'::regclass),
  data            BYTEA         NOT NULL,
  incident_id     BIGINT        REFERENCES gits.incident(id)
);
