import java.io.*;
import java.util.List;

import entities.Prevision;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

public class PrevisionFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.sendRedirect("formPrevision.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String libelle = req.getParameter("libelle");
        Double montant = Double.parseDouble(req.getParameter("montant"));

        try {
            new Prevision(libelle, montant, "2025-04-08").save();
            req.setAttribute("erreur", "Prevision ajouter avec succes");
            RequestDispatcher dispat = req.getRequestDispatcher("index.jsp");
            dispat.forward(req, res);

        } catch (Exception e) {
            req.setAttribute("erreur", "Erreur d'insertion");
            RequestDispatcher dispat = req.getRequestDispatcher("index.jsp");
            dispat.forward(req, res);
        }
    }

}
