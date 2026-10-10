# MS-Notificaciones

Microservicio encargado de enviar correos de confirmacion al cliente.

## Caractersticas
- **Consumidor RabbitMQ:** Escucha la cola 
- Notificaciones.queue para detectar cuando se crea una orden y simular el envio del correo de confirmacion.
- Expone un endpoint POST /api/notificaciones/test para probar envios directamente desde Postman.
- Se registra en Netflix Eureka.
- Protegido va Microsoft Entra ID (Azure AD).

## Instrucciones de Uso
- Puerto por defecto: 8085
- Ejecutar con mvn spring-boot:run o a travs de docker-compose up.
