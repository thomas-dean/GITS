CREATE TABLE IF NOT EXISTS gits.incident_suspects (
  incident_id       BIGINT      REFERENCES gits.incident(id),
  suspects_id       BIGINT      REFERENCES gits.suspects(id)
);