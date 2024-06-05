FROM eclipse-temurin:21-jre-alpine
RUN mkdir /app
COPY build/libs/food-api-*.jar /app/food-api.jar
RUN ls -R /app
RUN adduser --system app
#RUN addgroup --system app && adduser -S -s /bin/false -G app app
WORKDIR /app
#RUN chown -R app:app /app
USER app
EXPOSE 8080
CMD "java" "-jar" "food-api.jar"