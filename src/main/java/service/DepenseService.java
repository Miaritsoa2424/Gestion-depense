package service;

import java.util.ArrayList;

import connexion.DbConnect;
import entities.Depense;
import entities.Prevision;

public class DepenseService {

    public static double depenseDisponible(int id_prevision) throws Exception{
       Prevision prevision = Prevision.findById(id_prevision);
       return prevision.getMontant() - sommeDepense(id_prevision);
    }

    public static double sommeDepense(int id_prevision) throws Exception{
        ArrayList<Depense> dep = Depense.findAll();
        double montant = 0;
        if (!dep.isEmpty()) {
            for (Depense depense : dep) {
                if (depense.getId_prevision() == id_prevision) {
                    montant += depense.getMontant();
                }
            }
        }
        return montant;
    }

    public static boolean depenser(Depense depense) throws Exception{
        DbConnect dbConnect = null;
        try {
            dbConnect = new DbConnect();
            dbConnect.openConnetion();
            if (depense.getMontant() > depenseDisponible(depense.getId_prevision())) {
                return false;
            }
            depense.save();
            return true;

        } catch (Exception e) {
            throw e;
        }
    }
    // public static void main(String[] args) throws Exception {
    //     new Prevision("Carburant", 10000, "jh").save();;
    //     DepenseService.depenser(new Depense(1, 10, "jhsd"));
    // }

    
}
