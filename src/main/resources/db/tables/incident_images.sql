CREATE TABLE IF NOT EXISTS gits.incident_images (
  incident_id       BIGINT      REFERENCES gits.incident(id),
  images_id         BIGINT      REFERENCES gits.image(id)
);