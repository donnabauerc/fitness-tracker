docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 --name postgres -e POSTGRES_USER=app -e POSTGRES_PASSWORD=app -e POSTGRES_DB=fitnessdb -p 5432:5432 postgres:10.5