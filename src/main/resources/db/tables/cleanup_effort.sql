CREATE SEQUENCE IF NOT EXISTS gits.cleanup_effort_id_seq;

CREATE TABLE IF NOT EXISTS gits.cleanup_effort (
  id              BIGINT        PRIMARY KEY DEFAULT nextval('gits.cleanup_effort_id_seq'::regclass),
  effort          TEXT          NOT NULL
);
