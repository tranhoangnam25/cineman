#!/usr/bin/env bash
set -a; [ -f ./db.env ] && . ./db.env; set +a
set -e
cd "$(dirname "$0")"
mkdir -p logs
(cd backend && mvn -q -DskipTests package && nohup java -jar target/cineman1-backend-1.0.0.jar > ../logs/backend.log 2>&1 &)
(cd frontend && npm install && nohup npm run dev -- --host 0.0.0.0 --port 5173 > ../logs/frontend.log 2>&1 &)
echo started
