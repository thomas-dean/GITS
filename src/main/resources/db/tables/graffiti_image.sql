CREATE TABLE IF NOT EXISTS gits.graffiti_image (
  id              BIGINT        PRIMARY KEY,
  data            BYTEA         NOT NULL,
  incident_id     BIGINT        REFERENCES gits.incident(id)
);
