<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prevision</title>
</head>
<body>
    <h1>Ajouter une Prevision</h1>
    <form action="prevision" method="post">
        <label for="libelle">Libelle :</label>
        <br>
        <input type="text" name="libelle" id="libelle" placeholder="Ex : Carburant">
        <br>
        <label for="montant">Montant</label>
        <input type="number" name="montant" id="montant" placeholder="Ex :100000">
        
        <input type="submit" value="Ajouter">
    </form>
    <a href="index.jsp">Retour</a>
</body>
</html>