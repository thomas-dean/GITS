# GITS Database Project

## Installation

1. Install [PostgreSQL](https://www.postgresql.org/) version 10+.
2. Create a new database (see [this](https://medium.com/coding-blocks/creating-user-database-and-adding-access-on-postgresql-8bfcd2f4a91e) tutorial).
3. Run all scripts in the `schemas` directory.
4. Grant permissions on each schema.
    - e.g.: 
    ```SQL
    GRANT ALL ON SCHEMA gits TO your_user;
    GRANT USAGE ON SCHEMA gits to your_user;
    GRANT ALL ON ALL TABLES IN SCHEMA gits TO your_user;
    ``` 
5. Run all scripts in the `tables` directory.
    - NOTE: This may require some fiddling with the order you run the scripts. 
6. Run all scripts in the `data` directory.

## Overview

The database is structured such that every user has many roles and each role 
may have many users. There is also a table for reported incidents. These incidents
have:

* Various dates associated with the event
    - When the worker was on site
    - When the incident was reported
    - When the incident was cleaned up
* A level of effort required to clean up the graffiti, 
* A level of damage that was sustained by the structure
* The status of the investigation
* The type of structure that was vandalized
* Various location data
    - Latitude
    - Longitude
    - Address
    - Nearest cross roads
* The nickname of the person who did the vandalism (moniker)
* The user who submitted the incident
* The law enforcement officer assigned to the incident
* The crew associated with the incident
* The suspected vandals

## Tables

A brief overview of each table in the database.

### `cleanup_effort`

Level of effort required to cleanup an incident.

### `crew`

Group of individuals assigned to cleanup an incident.

### `damage`

Level of damage associated with an incident.

### `gang`

Group of individuals who are carrying out the vandalism.

### `graffiti_image`

Images of the graffiti.

### `incident`

A specific, documented case of graffiti.

### `incident_suspects`

A mapping of incidents to suspects.

### `investigation_status`

Enumeration of statuses an investigation may have.

### `structure`

Enumeration of structures that may be vandalized.

### `suspect`

Suspects in a graffiti investigation

### `suspect_status`

Enumeration of states that a suspect might be in (e.g. `IN_CUSTODY`).

### `user`

The user accounts that can access the application.

### `role`

The roles each user has which determines what actions a particular user can
preform.

### `user_roles`

A mapping of users to roles.
