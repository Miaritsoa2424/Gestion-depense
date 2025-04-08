package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import base.BaseModel;
import connexion.DbConnect;

public class Prevision extends BaseModel {
    String libelle;
    String dt;

    public Prevision(int id, String libelle, double montant, String dt) {
        super(id, montant);
        this.libelle = libelle;
        this.dt = dt;
    }

    public Prevision(String libelle, double montant, String dt) {
        super(0, montant);
        this.libelle = libelle;
        this.dt = dt;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public static Prevision findById(int id) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Prevision prev = null;

        try {
            DbConnect dbconnection = new DbConnect();
            dbconnection.openConnetion();
            connection = dbconnection.getConnection();
            String query = "SELECT * FROM exam_web_dynamique_prevision WHERE id = " + id + ";";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                prev = new Prevision(resultSet.getInt("id"), resultSet.getString("libelle"),
                        resultSet.getDouble("montant"), resultSet.getString("dt"));
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
        return prev;
    }

    @Override
    public void save() throws Exception {
        Connection connection = null;
        Statement statement = null;
        try {
            DbConnect dbconnection = new DbConnect();
            dbconnection.openConnetion();
            connection = dbconnection.getConnection();
            String query = "INSERT INTO exam_web_dynamique_prevision(libelle, montant, dt) VALUES ('"
                    + this.getLibelle() + " ', "
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

    public static ArrayList<Prevision> findAll() throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Prevision prev = null;
        ArrayList<Prevision> listDep = new ArrayList<>();

        try {
            DbConnect dbconnection = new DbConnect();
            dbconnection.openConnetion();
            connection = dbconnection.getConnection();
            String query = "SELECT * FROM exam_web_dynamique_prevision;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                prev = new Prevision(resultSet.getInt("id"), resultSet.getString("libelle"),
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
    //     ArrayList<Prevision> pv = Prevision.findAll();
    //     for (Prevision prevision : pv) {
    //         System.out.println(prevision.getLibelle());
    //     }
    //     // System.out.println(pv.size());
    // }

}
