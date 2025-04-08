
CREATE TABLE exam_web_dynamique_prevision(
    id INT PRIMARY KEY AUTO_INCREMENT,
    libelle VARCHAR(50) NOT NULL,
    montant DECIMAL(15,2) NOT NULL DEFAULT 0,
    dt VARCHAR(255)
);

CREATE TABLE exam_web_dynamique_depense (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_prevision INT NOT NULL,
    montant DECIMAL(15,2) NOT NULL DEFAULT 0,
    dt VARCHAR(255)
);
