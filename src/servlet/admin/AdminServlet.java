package servlet.admin;

import domain.Database;
import domain.language.Language;
import domain.news.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<News> news = Database.getAllNews();
        req.setAttribute("news",news);

        req.getRequestDispatcher("/admin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("news_title");
        String content = req.getParameter("news_content");
        LocalDate postdate = LocalDate.parse(req.getParameter("news_post_date"));
        String language = req.getParameter("news_language");

        Language language1 = Database.getLanguageByCode(language);
        Database.addNews(title,content,language1.getId(),postdate);

        resp.sendRedirect("/admin");
    }

}
