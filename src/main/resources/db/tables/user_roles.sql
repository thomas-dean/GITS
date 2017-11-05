CREATE TABLE IF NOT EXISTS gits.user_roles (
  user_id         BIGINT        NOT NULL,
  roles_id        BIGINT        REFERENCES gits.role(id)
);
