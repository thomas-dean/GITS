CREATE TABLE IF NOT EXISTS gits.user_role (
  id              BIGINT        PRIMARY KEY,
  user_id         BIGINT        NOT NULL,
  role_id         BIGINT        REFERENCES gits.role(id)
);