# Conversor de Monedas

Este proyecto es una aplicación de consola de Java para convertir monedas utilizando la API de Exchange Rate. Utiliza Spring Boot para su configuración y manejo de dependencias.

## Estructura del Proyecto

El proyecto se compone de los siguientes archivos y paquetes:

- `ConversorDeMonedasApplication.java`: Clase principal que inicia la aplicación.
- `ConsumoAPI.java`: Clase para consumir datos de una API externa.
- `Principal.java`: Clase que contiene la lógica del menú y las conversiones de moneda.

## Requisitos

Para ejecutar este proyecto necesitas tener instalado:

- Java 11 o superior.
- Maven.
- Una clave de API de [Exchange Rate API](https://v6.exchangerate-api.com).
- Gson

## Configuración

Configura tu clave de API:
En el archivo application.properties, agrega tu clave de API:

```
api.key=TU_API_KEY
```

Agregar Gson el modulo Gson al proyecto

## Uso
El menú de la aplicación permite convertir entre las siguientes monedas:

- Dólar a Peso Argentino.
- Peso Argentino a Dólar.
- Dólar a Real Brasileño.
- Real Brasileño a Dólar.
- Dólar a Peso Colombiano.
- Peso Colombiano a Dólar.
- Salir.

Sigue las instrucciones en pantalla para ingresar la cantidad que deseas convertir y obtener la tasa de cambio actual.
