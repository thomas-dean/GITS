CREATE TABLE IF NOT EXISTS gits.user (
  id              BIGINT        PRIMARY KEY,
  user_name       TEXT          NOT NULL,
  employee_number INTEGER       NOT NULL,
  password        TEXT          NOT NULL,
);
