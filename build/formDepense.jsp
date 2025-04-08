<%@ page import="java.util.List" %>
<%@ page import="entities.Prevision" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Depense</title>
</head>
<body>
    <h1>Depenser de l'argent</h1>

    <form action="depense" method="post">
        <label for="prevision">Rubrique :</label>
        <br>
        <select name="prevision" id="prevision">
<% 
                List<Prevision> previsions = (List<Prevision>) request.getAttribute("prevision");
                if (previsions != null) {
                    for (Prevision prevision : previsions) {
            %>
                        <option value="<%= prevision.getId() %>"><%= prevision.getLibelle() %></option>
            <% 
                    }
                } else {
            %>
                <option value="">No previsions available</option>
            <% 
                }
            %>        </select>
        <br>
        <label for="montant">Montant</label>
        <br>
        <input type="number" name="montant" id="montant" placeholder="Ex:200">
        <br>
        <label for="dt">Date :</label>
        <br>
        <input type="date" name="dt" id="dt">
        <input type="submit" value="Valider">
    </form>
                <a href="index.jsp">Retour</a>

</body>
</html>