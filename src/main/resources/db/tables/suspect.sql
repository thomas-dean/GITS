CREATE TABLE IF NOT EXISTS gits.suspects (
  id                BIGINT        PRIMARY KEY,
  name              TEXT          NOT NULL,
  photo             BYTEA         ,
  status_id         BIGINT        REFERENCES gits.suspect_status(id),
  gang_id           BIGINT        REFERENCES gits.gang(id)
);
