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
may have many users. This is all there is so far, but `incident`, `gang`, and
`suspect` tables will be added in the future.

## Tables

A brief overview of each table in the database.

### `user`

The user accounts that can access the application.

### `role`

The roles each user has which determines what actions a particular user can
preform.

### `user_roles`

A mapping of users to roles.
