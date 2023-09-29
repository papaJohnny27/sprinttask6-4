<%@ page import="java.util.List" %>
<%@ page import="domain.news.News" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.09.2023
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News</title>
    <%@ include file="/import/frontend-libs.jsp" %>
</head>
<body>
<header>
    <%@ include file="/import/navbar.jsp" %>
</header>
<div class="container">
    <%
        List<News> news = (List<News>) request.getAttribute("news");
        for (News newsElement : news) {
    %>
    <div class="row mt-3">
        <div class="card">
            <div class="card-header">
                <%=newsElement.getPostDate()%>
            </div>
            <div class="card-body">
                <h5 class="card-title">
                    <%=newsElement.getTitle()%>
                </h5>
                <p class="card-text">
                    <%=newsElement.getContent()%>
                </p>
            </div>
        </div>
    </div>
    <%
        }
    %>
</div>
</body>
</html>
