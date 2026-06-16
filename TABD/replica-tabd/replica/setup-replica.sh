#!/bin/bash

set -e

echo "Aguardando master iniciar..."
sleep 15

rm -rf /var/lib/postgresql/data/*

export PGPASSWORD=replica123

pg_basebackup \
 -h postgres_master \
 -D /var/lib/postgresql/data \
 -U replicador \
 -Fp \
 -Xs \
 -P \
 -R

echo "hot_standby = on" >> /var/lib/postgresql/data/postgresql.conf

chown -R postgres:postgres /var/lib/postgresql/data

exec docker-entrypoint.sh postgres
