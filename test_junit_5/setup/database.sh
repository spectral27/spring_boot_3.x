docker run --name postgresql-container -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
sleep 1
docker cp setup/initialize.sql postgresql-container:/home/initialize.sql
docker exec -it postgresql-container psql -U postgres -d postgres -f /home/initialize.sql
