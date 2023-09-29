<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.09.2023
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgba(35,67,105,0.85);">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">NEWS.COM</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/admin">ADMIN PANEL</a>
                </li>
            </ul>
            <span class="navbar-text">
                <form action="/news" method="post">
                    <input type="hidden" name="preferred_language_code" value="RU" required>
                    <button type="submit" class="btn btn-success">RU</button>

                </form>
                <form action="/news" method="post">
                    <input type="hidden" name="preferred_language_code" value="ENG" required>
                    <button type="submit" class="btn btn-success">ENG</button>
                </form>

            </span>
        </div>
    </div>
</nav>
