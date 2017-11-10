CREATE TABLE IF NOT EXISTS gits.incident (
  id                          BIGINT            PRIMARY KEY,
  date_on_site                TIMESTAMP         NOT NULL,
  date_created                TIMESTAMP         DEFAULT CURRENT_DATE,
  date_cleaned_up             TIMESTAMP         ,
  effort_id                   BIGINT            REFERENCES gits.cleanup_effort(id),
  amount_of_damage_id         BIGINT            REFERENCES gits.damage(id),
  investigation_status_id     BIGINT            REFERENCES gits.investigation_status(id),
  structure_id                BIGINT            REFERENCES gits.structure(id),
  address                     TEXT              ,
  nearest_cross_streets       TEXT              ,
  latitude                    DOUBLE PRECISION  NOT NULL,
  longitude                   DOUBLE PRECISION  NOT NULL,
  moniker                     TEXT              ,
  submitter_id                BIGINT            REFERENCES gits.user(id),
  law_enforcement_official_id BIGINT            REFERENCES gits.user(id),
  crew_id                     BIGINT            REFERENCES gits.crew(id)
);