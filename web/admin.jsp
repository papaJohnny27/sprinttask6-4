<%@ page import="java.util.List" %>
<%@ page import="domain.news.News" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.09.2023
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
    <%@ include file="/import/frontend-libs.jsp" %>
</head>
<body>
<header>
    <%@ include file="/import/navbar.jsp" %>
</header>
<div class="container">
    <button type="button" class="btn btn-primary row mt-5" data-bs-toggle="modal" data-bs-target="#exampleModalCenter">
        Создать
    </button>
    <div class="row mt-5">
        <div class="col-sm-12">
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>TITLE</th>
                    <th>POST DATE</th>
                    <th>LANGUAGE</th>
                    <th>MORE</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<News> newsList = (ArrayList<News>) request.getAttribute("news");
                    if (newsList != null) {
                        for (News news : newsList) {

                %>
                <tr>
                    <td>
                        <%
                            out.print(news.getId());
                        %>
                    </td>
                    <td>
                        <%
                            out.print(news.getTitle());
                        %>
                    </td>
                    <td>
                        <%
                            out.print(news.getPostDate());
                        %>
                    </td>
                    <td>
                        <%
                            out.print(news.getLanguageId());
                        %>
                    </td>
                    <td>
                        <a href="/details?id=<%=news.getId()%>" class="btn btn-info btn-sm">MORE</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>


    <div class="modal fade" id="exampleModalCenter" tabindex="-1" aria-labelledby="exampleModalCenterTitle" style="display: none;" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalCenterTitle">ADD NEWS</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="/admin" method="post">
                        <div class="form-group mt-3" >
                            <label for="table_title_input">TITLE:</label>
                            <input type="text" id="table_title_input" name="news_title" class="form-control" required>
                        </div>

                        <div class="form-group mt-3">
                            <label for="table_description_input">CONTENT:</label>
                            <textarea id="table_description_input" name="news_content" class="form-control" aria-label="With textarea" required></textarea>
                        </div>

                        <div class="form-group mt-3">
                            <label for="table_deadline_date_input">POST DATE:</label>
                            <input type="date" id="table_deadline_date_input" name="news_post_date" class="form-control" required>
                        </div>
                        <div class="form-group mt-3">
                            <label for="news_language">LANGUAGE:</label>
                            <select name="news_language" class="form-select" id="news_language" required>
                                <option value="ENG">ENGLISH</option>
                                <option value="RU" selected>RUSSIAN</option>
                            </select>
                        </div>

                        <div class="form-group mt-3">
                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">CANCEL</button>
                            <button type="submit" class="btn btn-success">ADD</button>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
