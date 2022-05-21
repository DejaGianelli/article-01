#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE USER app_user WITH ENCRYPTED PASSWORD '1234';
	CREATE DATABASE article_01;
	GRANT ALL PRIVILEGES ON DATABASE article_01 TO app_user;
EOSQL