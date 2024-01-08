<!DOCTYPE html>
<html>
<head>
    <title>ElJur | Вход</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>ElJur</h2>
        <h3>Авторизация</h3>
        <form action="/login" method="post">
            Логин: <input type="text" name="username"><br><br>
            Пароль: <input type="password" name="password"><br><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Вход" class="btn btn-success"/>
        </form>
    </div>
</body>
</html>