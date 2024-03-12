# Proyecto Assesment Pragma 2024/03: Producto Financiero

## Descripción general

El **microservicio** llamado ***Producto Financiero (finance-product)*** es el encargado
de almacenar la información correspondiente a los productos financieros especificados
en el problema propuesto

### Host: localhost
### Port: 8080
### Path: /api/development/v1/finance-service/decision-products

## Aspectos técnicos

### Lenguaje y framework
Este es un servicio desarrollado en **Java 21** con **Spring Boot 3.2.3** y
gestor de dependencias **Maven**.

### Base de datos
La base de datos se llama H2. La decisión de esta base de datos se debe a su usabilidad simple
y veloz. Para pruebas está más que bien, aun cuando no persiste la data.

### Seguridad
Se realizó una robusta implementación de seguridad a través del uso de **LWT** a través de la librería
*Spring Security* y utilizando cifrado asimétrico **RSA PKCS#8**. La llave pública se dispone en este
servicio, mientras que la clave privada se deja en el servicio consumidor (Postman para pruebas).
El algoritmo utilizado para la generación del JWT fue **RS256**

Para configurar el JWT en Postman se deben seguir los siguientes pasos:
en la pestaña de *Authorization* se debe seleccionar, en *Type* ```JWT Bearer```. Una vez allí,
los campos que salen se deben establecer de la siguiente manera:
* Algorithm: RS256
* Private key: Copiar y pegar todo el contenido de la llave privada, la cual se encuentra en la ruta
  *src/main/java/resources/cert/private_key.pem*
* Payload: Se debe configurar el siguiente json:
    ``` json
    {
      "sub": "finance-product",
      "name": "finance-service",
      "iat": {{$timestamp}}
    }
    ```
* Request header prefix: Bearer
* JWT headers: un json vacío ```{}```

### Pruebas
Como es natural al haber utilizado Spring Framework, las pruebas unitarias fueron realizadas con 
**jUnit 5**

## Ejecución

#### <a href="https://github.com/fcordonezo/AP202403_documentation/blob/develop/collections/FinanceService_collection.json" download>Descargar colección Postman</a>

Hay dos opciones para poder lanzar el proyecto de forma local:
1. Usando el comando mvn, para lo cual hay que tener instalado Maven así como el SDK de Java 21
    en el computador, y también se deben configurar las variables de entorno. Después de tener estas
    configuraciones, simplemente se debe abrir un terminal, posicionarse en la raíz del proyecto
    y escribir los siguientes comandos
    ``` shell
    mvn clean install
    mvn spring-boot:run
   ```
2. Ejecutando el proyecto desde IntelliJ Idea, para lo cual lo único necesario es configurar la
    versión de Java 21 desde la configuración *File → Project Structure → SDK*, y luego seleccionar
    la clase main desde la opción de *Aplication* en la configuración *run/debug configuration*
    o, en su defecto, correr los comandos *Maven* desde el panel derecho. Los comandos son 
    ```clean```, ```compile``` y ```spring-boot```

*Por defecto se ejecuta en el puerto 8080, por lo que se debe tener en cuenta el no tener
ninguna otra aplicación ejecutándose en este puerto.*

## Definición funcional

### Objeto de negocio

Se realizó un completo análisis del objeto de negocio y el resultado se plasma en el siguiente Json:
```json
{
    "financeProductId": "int",
    "code": "string",
    "description": "string",
    "ruleSet": "string"
}
```
```financeProductId```: Hace referencia al identificador único de cada producto financiero.  
```code```: Es un String de 3 caracteres de longitud, el cual es un código único para cada
producto financiero.  
```description```: La descripción del producto financiero.  
```ruleSet```: Es un Json en forma de string el cual contiene las reglas que se deben aplicar al
producto financiero. Este Json se estructura de la siguiente manera:
* ``` json
  {
    "countries": "array", 
    "minAge": "int",
    "minIncome": "float"
  }
  ```
  ```countries```: Es un arreglo que contiene, en String, cada país que se debe tener en cuenta
  en la validación. Si está vacío, se entiende que no se debe validar ningún país.  
  ```minAge```: La edad mínima del cliente.  
  ```minIncome```: Los ingresos mínimos del cliente.

### Ejemplo
```json
{
    "financeProductId": 1,
    "code": "CAH",
    "description": "Cuenta de ahorros",
    "ruleSet": "{\"countries\": [\"CO\"], \"minAge\": 18,\"minIncome\": 0.0}"
}
```
*En el campo ```ruleSet``` Todos los caracteres **"** van precedidos por un \ para que se entienda
que son parte del string*

### Dominio de datos

| code      | description              | ruleSet                                                                     |
|:----------|:-------------------------|-----------------------------------------------------------------------------|
| ```CAH``` | ```Cuenta de ahorros```  | ```{"countries": ["CO"], "minAge": 18,"minIncome": 0.0}```                  |
| ```TDB``` | ```Tarjeta débito```     | ```{"countries": ["CO"], "minAge": 18,"minIncome": 1300000.0}```            |
| ```TDC``` | ```Tarjeta de crédito``` | ```{"countries": ["CO"], "minAge": 20,"minIncome": 2500000.0}```            |
| ```SEG``` | ```Seguro```             | ```{"countries": [], "minAge": 15,"minIncome": 800000.0}```                 |
| ```INV``` | ```Inversión```          | ```{"countries": [], "minAge": 25,"minIncome": 4500000.0}```                |
| ```GIR``` | ```Giro```               | ```{"countries": ["CO", "PE", "EC", "PA"], "minAge": 0,"minIncome": 0.0}``` |
| ```TAM``` | ```Tarjeta amparada```   | ```{"countries": [], "minAge": 15,"minIncome": 0.0}```                      |

### Contrato Openapi 3.0.1
La firma puede ser encontrada en **[esta página](https://fcordonezo.github.io/AP202403_finance_product/)**
``` yaml
openapi: 3.0.1
info:
  title: Producto financiero
  version: 1.0.0
servers:
- url: http://localhost:8080/api/development/v1/finance-service/finance-products
  description: Generated server url
paths:
  /{financeProductId}:
    get:
      tags:
      - finance-product-controller
      summary: Obtener producto financiero por ID
      operationId: getById
      parameters:
      - name: financeProductId
        in: path
        required: true
        schema:
          type: integer
          format: int64
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/FinanceProductResponseDto'
      security:
      - BearerAuthentication: []
    put:
      tags:
      - finance-product-controller
      summary: Actualizar un producto financiero
      operationId: put
      parameters:
      - name: financeProductId
        in: path
        required: true
        schema:
          type: integer
          format: int64
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/FinanceProductRequestDto'
        required: true
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/FinanceProductResponseDto'
      security:
      - BearerAuthentication: []
    delete:
      tags:
      - finance-product-controller
      summary: Eliminar un producto financiero por ID
      operationId: delete
      parameters:
      - name: financeProductId
        in: path
        required: true
        schema:
          type: integer
          format: int64
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                type: object
      security:
      - BearerAuthentication: []
  /:
    get:
      tags:
      - finance-product-controller
      summary: Obtener todos los productos financieros
      operationId: getAll_1
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/FinanceProductResponseDto'
      security:
      - BearerAuthentication: []
    post:
      tags:
      - finance-product-controller
      summary: Agregar un producto financiero
      operationId: post_1
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/FinanceProductRequestDto'
        required: true
      responses:
        "201":
          description: Created
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/FinanceProductResponseDto'
      security:
      - BearerAuthentication: []
components:
  schemas:
    FinanceProductRequestDto:
      type: object
      properties:
        code:
          type: string
        description:
          type: string
        ruleSet:
          type: string
    FinanceProductResponseDto:
      type: object
      properties:
        financeProductId:
          type: integer
          format: int64
        code:
          type: string
        description:
          type: string
        ruleSet:
          type: string
  securitySchemes:
    BearerAuthentication:
      type: http
      scheme: bearer
      bearerFormat: JWT
```

## Documentación de referencia

Puede encontrar el repositorio de documentación en el [siguiente enlace](https://github.com/fcordonezo/AP202403_documentation)

### Documentación oficial

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#web)
* [Spring Security](https://spring.io/projects/spring-security)

### Guías

* [Construyendo un servicio RESTful](https://spring.io/guides/gs/rest-service/)
* [Construyendo servicios REST con Spring](https://spring.io/guides/tutorials/rest/)
* [Intro to JWT](https://jwt.io/introduction)

