# MS-Notificaciones

Microservicio encargado de enviar correos de confirmacin al cliente.

## Caractersticas
- **Consumidor RabbitMQ:** Escucha la cola 
otificaciones.queue para detectar cuando se cre una orden y simular el envo del correo de confirmacin.
- Expone un endpoint POST /api/notificaciones/test para probar envos directamente desde Postman.
- Se registra en Netflix Eureka.
- Protegido va Microsoft Entra ID (Azure AD).

## Instrucciones de Uso
- Puerto por defecto: 8085
- Ejecutar con mvn spring-boot:run o a travs de docker-compose up.
