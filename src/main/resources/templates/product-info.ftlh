<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
</head>
<body>
<h1>BUYSELL</h1><br>
<h4>Подробная информация</h4>
<b>Название товара: </b>${product.title}<br>
<b>Описание товара: </b>${product.description}<br>
<b>Цена товара: </b>${product.price}<br>
<b>Город товара: </b>${product.city}<br>
<b>Автор товара: </b>${product.author}<br>
<h3>Удалить товар</h3>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар">
</form>
</body>
</html>