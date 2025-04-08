<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        form{
            display: flex;
        }
    </style>
    <title>Login</title>
</head>
<body>
    <form action="login" method="post">
        <label for="nom">Nom :</label>
        <input type="text" name="nom" id="nom" placeholder="Entrez votre nom" required>

        <label for="mdp">Mot de passe</label>
        <input type="password" name="mdp" id="mdp" placeholder="Entrez votre mot de passe" required>

        <button type="submit">Se connecter</button>
    </form>
</body>
</html>