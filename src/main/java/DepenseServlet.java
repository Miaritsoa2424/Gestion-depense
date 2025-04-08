import java.io.IOException;
import java.util.List;

import entities.Prevision;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DepenseServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            List<Prevision> listPrevision;
            listPrevision = Prevision.findAll();
            req.setAttribute("prevision", listPrevision);
            RequestDispatcher dispat = req.getRequestDispatcher("listeDep.jsp");
            dispat.forward(req, res);
        } catch (Exception e) {
            res.sendRedirect("index.jsp");
        }
    }
}
