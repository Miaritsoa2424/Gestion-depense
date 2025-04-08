<%@ page import="java.util.List" %>
<%@ page import="entities.Prevision" %>
<%@ page import="service.DepenseService" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Depenses</title>
            </head>

            <body>
                <h1>Etat financier</h1>
                <table border="1">
                    <tr>
                        <td>Rubrique</td>
                        <td>Montant</td>
                        <td>Reste</td>
                    </tr>
                    <% List<Prevision> previsions = (List<Prevision>) request.getAttribute("prevision");
                            if (previsions != null) {
                            for (Prevision prevision : previsions) {
                            %>
                            <tr>
                            <td>
                                <%= prevision.getLibelle() %>
                            </td>
                            <td>
                                <%= prevision.getMontant() %>
                            </td>
                            <td>
                                <%= DepenseService.depenseDisponible(prevision.getId()) %>
                            </td>
                            <% } } else { %>
                                <td colspan="3">Aucun prevision</td></tr>
                                <% } %>
                </table>
                <a href="index.jsp">Retour</a>

            </body>

            </html>