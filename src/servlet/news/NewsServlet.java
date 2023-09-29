package servlet.news;

import domain.Database;
import domain.language.Language;
import domain.news.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long languageId = null;
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("languageId"))
                languageId = Long.valueOf(cookie.getValue());
        }

        List<News> news;

        if (languageId != null) {
            news = Database.getAllNewsByLanguageId(languageId);
        } else {
            news = Database.getAllNews();
        }

        req.setAttribute("news", news);
        req.getRequestDispatcher("/news.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String preferredLanguageCode = req.getParameter("preferred_language_code");

        Language language = Database.getLanguageByCode(preferredLanguageCode);
        if (language != null) {
            Cookie languageCookie = new Cookie("languageId", language.getId().toString());
            resp.addCookie(languageCookie);
        }

        resp.sendRedirect("/news");
    }
}