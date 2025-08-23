# RAUS Integration SUSALUD Microservice

## 📌 Descripción (Español)

Este proyecto implementa un **microservicio de integración** entre aplicaciones internas y el sistema **SUSALUD**.  
El servicio expone una **API REST** que recibe solicitudes en formato JSON, las transforma en **peticiones SOAP**, se comunica con el servicio de SUSALUD, procesa la respuesta, y devuelve un resultado en formato JSON.

### ⚙️ Arquitectura del Proyecto

El proyecto está dividido en módulos:

- **raus-client** → Contiene los clientes SOAP para consumir el servicio de SUSALUD.  
- **raus-core** → Maneja la lógica de negocio, servicios, mapeos y configuración (exposición de WSDL, marshallers, etc.).  
- **raus-services** → Es el punto de entrada de la aplicación Spring Boot. Expone controladores REST que consumen la capa core y cliente.  
- **deploy/docker** → Contiene el `Dockerfile` para empaquetar y desplegar el servicio en contenedor.  

El flujo general es:

1. El cliente envía una solicitud REST (`/api/affiliates/query`).  
2. El controlador REST (`QueryAffiliatesController`) la recibe y valida.  
3. La capa de servicios en `raus-core` transforma el request en una llamada SOAP.  
4. `raus-client` se comunica con el servicio de SUSALUD.  
5. La respuesta SOAP es mapeada a un objeto interno y devuelta como JSON al cliente.

### 🚀 Levantar el Proyecto

#### 1. Clonar y compilar
```bash
git clone <repo-url>
cd raus-integration-susalud-ms
./gradlew clean build -x test
```

#### 2. Ejecutar en local
```bash
cd raus-services
./gradlew bootRun
```

#### 3. Ejecutar con Docker
```bash
docker build -t raus-integration-susalud-ms -f deploy/docker/Dockerfile .
docker run -d -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=dev \
  --name raus-integration-susalud raus-integration-susalud-ms
```

### 🧪 Ejecutar Tests
```bash
./gradlew test
```

### 📂 Perfiles disponibles
- `dev` → Desarrollo local  
- `prod` → Producción  

---

## 📌 Description (English)

This project implements an **integration microservice** between internal applications and the **SUSALUD** system.  
The service exposes a **REST API** that receives JSON requests, transforms them into **SOAP requests**, communicates with the SUSALUD service, processes the response, and returns the result in JSON format.

### ⚙️ Project Architecture

The project is divided into modules:

- **raus-client** → Contains SOAP clients to consume SUSALUD services.  
- **raus-core** → Handles business logic, services, mappings, and configuration (WSDL exposure, marshallers, etc.).  
- **raus-services** → The Spring Boot entry point. Exposes REST controllers that use the core and client layers.  
- **deploy/docker** → Contains the `Dockerfile` to package and deploy the service in a container.  

General workflow:

1. A client sends a REST request (`/api/affiliates/query`).  
2. The REST controller (`QueryAffiliatesController`) receives and validates it.  
3. The service layer in `raus-core` transforms the request into a SOAP call.  
4. `raus-client` communicates with the SUSALUD service.  
5. The SOAP response is mapped into an internal object and returned as JSON.  

### 🚀 Running the Project

#### 1. Clone and build
```bash
git clone <repo-url>
cd raus-integration-susalud-ms
./gradlew clean build -x test
```

#### 2. Run locally
```bash
cd raus-services
./gradlew bootRun
```

#### 3. Run with Docker
```bash
docker build -t raus-integration-susalud-ms -f deploy/docker/Dockerfile .
docker run -d -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=dev \
  --name raus-integration-susalud raus-integration-susalud-ms
```

### 🧪 Run Tests
```bash
./gradlew test
```

### 📂 Available Profiles
- `dev` → Local development  
- `prod` → Production  
