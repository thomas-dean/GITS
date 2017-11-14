CREATE SEQUENCE IF NOT EXISTS gits.image_id_seq;

CREATE TABLE IF NOT EXISTS gits.image (
  id              BIGINT        PRIMARY KEY DEFAULT nextval('gits.image_id_seq'::regclass),
  format_id       BIGINT        REFERENCES gits.image_format(id),
  data            BYTEA         NOT NULL
);
