<%@ page import="domain.news.News" %><%--
  Created by IntelliJ IDEA.
  User: eldos
  Date: 29.09.2023
  Time: 01:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    News news = (News) request.getAttribute("news");
%>

<html>
<head>
    <title>More</title>
    <%@ include file="/import/frontend-libs.jsp" %>
</head>
<body>
<header>
    <%@ include file="/import/navbar.jsp" %>
</header>
<div class="container">
    <div class="row mt-5">
        <h1 class="display-3"><%=news.getTitle()%></h1>
    </div>
    <div class="row mt-5">
        <form action="/update" method="post">
            <input type="hidden" name="news_id" value="<%=news.getId()%>"/>
            <div class="form-group">
                <label for="table_title_input">TITLE:</label>
                <input type="text" id="table_title_input" name="news_title" class="form-control" value="<%=news.getTitle()%>" required>
            </div>

            <div class="form-group">
                <label for="table_description_input">CONTENT:</label>
                <textarea id="table_description_input" name="news_content" class="form-control"  aria-label="With textarea" required>
                    <%=news.getContent()%>
                </textarea>
            </div>

            <div class="form-group">
                <label for="table_deadline_date_input">POST DATE:</label>
                <input type="date" id="table_deadline_date_input" name="news_postdate" class="form-control" value="<%=news.getPostDate()%>" required>
            </div>
            <div class="form-group">
                <label for="news_language">LANGUAGE:</label>
                <select name="news_language" class="form-select" id="news_language" required>
                    <option value="1"
                            <%
                                if (news.getLanguageId().equals(1L)) {
                            %>

                            selected
                            <%
                                }
                            %>
                    >ENGLISH
                    </option>
                    <option value="2"
                            <%
                                if (news.getLanguageId().equals(2L)) {
                            %>

                            selected
                            <%
                                }
                            %>
                    >RUSSIAN
                    </option>
                </select>
            </div>

            <div class="form-group mt-3">
                <button type="submit" class="btn btn-success" data-bs-dismiss="modal">SAVE</button>
            </div>
        </form>
        <form action="/delete" method="post">
            <input type="hidden" name="news_id" value="<%=news.getId()%>"/>
            <div class="form-group mt-3 col-5">
                <button type="submit" class="btn btn-danger">DELETE</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
