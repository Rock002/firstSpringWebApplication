<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
</head>
<body>
    <form action="/" method="get">
        Поиск по названию: <input type="text" name="title"><br>
        <input type="submit" value="Поиск">
    </form>
    <h1>BUYSELL</h1><br>
    <h4>Товары</h4>
    <#list products as product>
        <div>
            <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">Подробнее</a></p>
        </div>
    </#list>
    <br>
    <h3>Создать новый товар</h3>
    <form action="/product/create" method="post" enctype="multipart/form-data">
        Название: <input type="text" name="title"/><br>
        Описание: <input type="text" name="description"/><br>
        Цена: <input type="number" name="price"/><br>
        Город: <input type="text" name="city"/><br>
        Автор: <input type="text" name="author"/><br>
        Первая фотография: <input type="file" name="file1"/><br>
        Вторая фотография: <input type="file" name="file2"/><br>
        Третья фотография: <input type="file" name="file3"/><br>
        <input type="submit" value="Добавить товар"/>
    </form>
</body>
</html>