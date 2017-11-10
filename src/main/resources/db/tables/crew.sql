CREATE TABLE IF NOT EXISTS gits.crew (
  id              BIGINT        PRIMARY KEY,
  crew_id         VARCHAR(5)    NOT NULL,
  supervisor      TEXT          NOT NULL
);