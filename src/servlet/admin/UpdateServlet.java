package servlet.admin;

import domain.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("news_title");
        String content = req.getParameter("news_content");
        LocalDate postdate = LocalDate.parse(req.getParameter("news_postdate"));
        Long language =Long.parseLong(req.getParameter("news_language"));
        Long id = Long.parseLong(req.getParameter("news_id"));


        Database.updateNews(id,title,content,language,postdate);
        resp.sendRedirect("/admin");
    }
}
