CREATE SEQUENCE IF NOT EXISTS gits.image_format_id_seq;

CREATE TABLE IF NOT EXISTS gits.image_format (
  id            BIGINT      PRIMARY KEY DEFAULT nextval('gits.image_format_id_seq'::regclass),
  format        TEXT        NOT NULL
);