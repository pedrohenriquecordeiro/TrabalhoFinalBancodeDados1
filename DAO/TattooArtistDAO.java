/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.ClientDAO.connection;
import connection.ConnectionModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Client;
import model.TattooArtist;

/**
 *
 * @author pedro
 */
public class TattooArtistDAO {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;
    
    public static ArrayList<TattooArtist> consultAll() throws ClassNotFoundException, SQLException{
        ArrayList<TattooArtist> artists = new ArrayList<TattooArtist>();
        String sql = "select *  from tattoo_artist";
        connection = ConnectionModel.connector();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                TattooArtist tattooArtist = new TattooArtist(Integer.parseInt(resultSet.getString(1)),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
                artists.add(tattooArtist);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        connection.close();
        return artists;
    }
    
     public static boolean delete(int id ) throws ClassNotFoundException, SQLException{
        boolean sucess = false;
        TattooArtist tattooArtist = null;
        String sql = "delete from tattoo_artist where idartist = ? ";
        connection = ConnectionModel.connector();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int done = preparedStatement.executeUpdate();
            if(done > 0){
                sucess = true;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        connection.close();
        return sucess;
    }
     
     public static String selectOne(int id ) throws ClassNotFoundException, SQLException{
        String name = null;
        String sql = "select nm from tattoo_artist where idartist = ?";
        connection = ConnectionModel.connector();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                name = resultSet.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        connection.close();
        return name;
    }
     
     
     
     
     
     public static boolean insert(TattooArtist tattooArtist) throws ClassNotFoundException, SQLException{
        boolean sucess = false;
        String sql = "insert into tattoo_artist(nm,tel,login,passw) values (?,?,?,?)";
        connection = ConnectionModel.connector();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,tattooArtist.getName());
            preparedStatement.setString(2,tattooArtist.getTel());
            preparedStatement.setString(3,tattooArtist.getLogin());
            preparedStatement.setString(4,tattooArtist.getPassw());
            int done = preparedStatement.executeUpdate();
            if(done > 0){
                sucess = true;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        connection.close();
        return sucess;
    }
     
     
     public static boolean check(String login , String password){
         boolean sucess = false;
         String sql = "select * from tattoo_artist where login=? and passw=?";
            if (!(login.equals("") || password.equals(""))) {
                try {
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, login);
                    preparedStatement.setString(2, password);
                    resultSet = preparedStatement.executeQuery();  

                    if (resultSet.next()) {
                        sucess = true;
                    } 
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
        }else{
            JOptionPane.showMessageDialog(null, "Enter a username and password.","",JOptionPane.ERROR_MESSAGE);
        }
        return sucess;
     }
    
}
