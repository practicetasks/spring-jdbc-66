# Задача

Необходимо описать класс для таблицы `products`

1. Создать класс `Product` `(id, name, price, category)`
2. Создать интерфейс `ProductDao`
    - создать методы
        - `findAll`
        - `findById`
        - `create`
        - `update`
        - `deleteById`
3. Создать класс `ProductDaoImpl`, необходимо реализовать все методы интерфейса
4. Создать класс `ProductController`
    - создать эндпойнты:
        - `GET /products` - получение списка товаров
        - `GET /products/{id}` - получение товара по идентификатору
        - `POST /products` - создание товара
         request:
         ```json
         {
            "name": "НАЗВАНИЕ ТОВАРА",
            "price": 999,
            "category": {
                "id": 1
            } 
         }
         ```
         response:
         ```json
         {
            "id": 1,
            "name": "НАЗВАНИЕ ТОВАРА",
            "price": 999,
            "category": {
                "id": 1,
                "name": null
            } 
         }
         ```
        - `PUT /products` - обновление товара
          request:
         ```json
         {
            "id": 1,
            "name": "ОБНОВЛЕННОЕ НАЗВАНИЕ ТОВАРА",
            "price": 1000
         }
         ```
        response:
         ```json
         {
            "id": 1,
            "name": "ОБНОВЛЕННОЕ НАЗВАНИЕ ТОВАРА",
            "price": 1000,
            "category": null
         }
         ```
        - `DELETE /products/{id}` - удаление товара по идентификатору

