import java.io.IOException;
import java.util.List;

import entities.Depense;
import entities.Prevision;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.DepenseService;

public class DepenseFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            List<Prevision> listPrevision;
            listPrevision = Prevision.findAll();
            req.setAttribute("prevision", listPrevision);
            RequestDispatcher dispat = req.getRequestDispatcher("formDepense.jsp");
            dispat.forward(req, res);
        } catch (Exception e) {
            res.sendRedirect("index.jsp");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int prevision = Integer.parseInt(req.getParameter("prevision"));
        Double montant = Double.parseDouble(req.getParameter("montant"));
        String date = req.getParameter("dt");

        try {
            Depense dp = new Depense(prevision, montant, date);
            Boolean result = DepenseService.depenser(dp);
            if (result) {
                req.setAttribute("erreur", "Inserer avec succes");
                RequestDispatcher dispat = req
                .getRequestDispatcher("index.jsp");
                dispat.forward(req, res);
            }
            req.setAttribute("erreur", "Vous depasser le montant du rubrique");
            RequestDispatcher dispat = req
                    .getRequestDispatcher("index.jsp");
            dispat.forward(req, res);

        } catch (Exception e) {
            res.sendRedirect("index.jsp");
        }
    }
}
