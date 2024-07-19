# KM COUNTER API
Java RESTful API criada para calculo de distância entre duas rotas. 

## Diagrama de Classes

```mermaid
 classDiagram
    class Client {
        +String name
        +String zipCode
    }

    class Route {
        +Client originClient
        +Client destinationClient
        +Double distance
    }

    Route --> Client : originClient
    Route --> Client : destinationClient
```
