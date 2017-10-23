CREATE TABLE IF NOT EXISTS gits.user_roles (
  id              BIGINT        PRIMARY KEY,
  user_id         BIGINT        NOT NULL,
  roles_id         BIGINT        REFERENCES gits.role(id)
);