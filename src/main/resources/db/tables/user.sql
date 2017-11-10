CREATE SEQUENCE IF NOT EXISTS gits.user_id_seq;

CREATE TABLE IF NOT EXISTS gits.user (
  id              BIGINT        PRIMARY KEY DEFAULT nextval('gits.user_id_seq'::regclass),
  user_name       TEXT          UNIQUE NOT NULL,
  employee_number INTEGER       NOT NULL,
  job_title       TEXT          NOT NULL,
  password        TEXT          NOT NULL
);
