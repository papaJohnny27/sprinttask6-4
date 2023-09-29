package servlet.admin;

import domain.Database;
import domain.news.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/details")
public class MoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        News news = Database.getNewsById(id);
        req.setAttribute("news",news);

        req.getRequestDispatcher("/more.jsp").forward(req,resp);
    }
}
