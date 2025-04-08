package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.BaseModel;
import connexion.DbConnect;

public class Depense extends BaseModel {
    int id_prevision;
    String dt;

    public Depense(int id, int id_prevision, double montant,String dt) {
        super(id, montant);
        this.id_prevision = id_prevision;
        this.dt = dt;
    }

    public Depense(int id_prevision, double montant,String dt) {
        super(0, montant);
        this.id_prevision = id_prevision;
        this.dt = dt;
    }
    
    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    
    public int getId_prevision() {
        return id_prevision;
    }

    public void setId_prevision(int id_prevision) {
        this.id_prevision = id_prevision;
    }



    @Override
    public void save() throws Exception {
        Connection connection = null;
        Statement statement = null;
        try {
            DbConnect dbconnection = new DbConnect();
            dbconnection.openConnetion();
            connection = dbconnection.getConnection();
            String query = "INSERT INTO exam_web_dynamique_depense(id_prevision, montant, dt) VALUES (" 
            + this.getId_prevision() + ", "
            + this.getMontant() + ", '" 
            + this.getDt().toString() + "');";
            statement = connection.createStatement();
            statement.execute(query);

        } catch (Exception e) {
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public static ArrayList<Depense> findAll() throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Depense prev = null;
        ArrayList<Depense> listDep = new ArrayList<>();

        try {
            DbConnect dbconnection = new DbConnect();
            dbconnection.openConnetion();
            connection = dbconnection.getConnection();
            String query = "SELECT * FROM exam_web_dynamique_depense;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                prev = new Depense(resultSet.getInt("id"), resultSet.getInt("id_prevision"),
                        resultSet.getDouble("montant"), resultSet.getString("dt"));
                listDep.add(prev);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return listDep;
    }

    // public static void main(String[] args) throws Exception {
    //     ArrayList<Depense> list = Depense.findAll();
    //     for (Depense depense : list) {
    //         System.out.println(depense.getId());
            
    //     }
    // }


}
