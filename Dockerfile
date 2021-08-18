FROM openjdk

ENV MYSQL_USERNAME=default \
	MYSQL_PASSWORD=default \
	MYSQL_DATABASE=default \
	MYSQL_HOST=default \
	MYSQL_PORT=3306

COPY . /home

CMD java -jar /home/target/*.jar
