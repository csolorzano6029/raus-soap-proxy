FROM gcr.io/distroless/java21-debian12:nonroot

# MAINTAINER Carlos Solorzano "csolorzano@ec.krugercorp.com"

ENV SPRING_PROFILES_ACTIVE=prod
ENV TZ=${TZ}
ENV LANG=C.UTF-8

EXPOSE 8080

WORKDIR /api

COPY raus-services/build/libs/*.jar /api/app.jar

CMD ["app.jar"]