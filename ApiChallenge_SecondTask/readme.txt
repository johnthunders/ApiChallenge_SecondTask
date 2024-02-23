Second task: API test automation

Explicación detallada de cada método @Test en el código proporcionado:

testGetInventory():

Este método prueba el endpoint /v2/store/inventory.
Es posible que falle si la ruta del endpoint no es correcta o si el servidor no puede encontrar la ruta especificada.
También podría fallar si el servidor responde con un código de estado diferente al esperado, como un 404 en lugar de un 200.

testPlaceOrder():
Este método prueba el endpoint /v2/store/order utilizando un método POST para colocar una orden.
Puede fallar si la solicitud no está formateada correctamente o si el servidor responde con un código de estado diferente al esperado (200 en este caso).
Es importante verificar que el cuerpo de la solicitud esté correctamente formateado de acuerdo con la especificación de la API.

testGetOrderById():
Este método prueba el endpoint /v2/store/order/{orderId} utilizando un método GET para obtener una orden por su ID.
Puede fallar si la respuesta del servidor no contiene la orden esperada con el ID especificado.
La aserción .body("id", equalTo(1)) verifica que el cuerpo de la respuesta contenga un campo "id" igual a 1. Si este no es el caso, la prueba fallará.

testDeleteOrder():
Este método prueba el endpoint /v2/store/order/{orderId} utilizando un método DELETE para eliminar una orden por su ID.
Puede fallar si el servidor no puede eliminar la orden correctamente o si no se encuentra la orden con el ID especificado.
Es importante verificar que el código de estado de la respuesta sea el esperado (200 en este caso) y que la orden se haya eliminado correctamente.