<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<head>
    <title>ElJur | Админ</title>
</head>
<body>
    <div class="container">
        <h3>Создание аккаунта преподавателя</h3>
        <form action="/registration" method="post">
            ФИО: <input type="text" name="FIO"><br><br>
            Логин: <input type="text" name="username"><br><br>
            Пароль: <input type="password" name="password"><br><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Создать" class="btn btn-success"/>
        </form>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
</body>
</html>