<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Acceuil</title>
</head>
<body>
    <h1>Examen web dynamique ETU003087</h1>
    <a href="prevision">Ajouter une prevision</a>
    <a href="depense">Ajouter un depense</a>
    <a href="depenses">Etat financier</a>
    <% if(request.getAttribute("erreur") != null){
        out.print(request.getAttribute("erreur"));
    } %>
</body>
</html>