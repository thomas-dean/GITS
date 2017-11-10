CREATE TABLE IF NOT EXISTS gits.user_roles (
  user_id         BIGINT        REFERENCES gits.user(id),
  roles_id        BIGINT        REFERENCES gits.role(id)
);
