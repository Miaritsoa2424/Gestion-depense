package base;

public abstract class BaseModel implements BaseInterface {
    int id;
    double montant;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }

    public BaseModel(int id,double montant){
        this.setId(id);
        this.setMontant(montant);
    }

    
   
}
