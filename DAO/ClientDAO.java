/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connection.ConnectionModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Client;

/**
 *
 * @author pedro
 */
public class ClientDAO {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;
  
    public static ArrayList<Client> consultAll() throws ClassNotFoundException, SQLException{
        ArrayList<Client> clients = new ArrayList<Client>();
        String sql = "select *  from client";
        connection = ConnectionModel.connector();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Client client = new Client(Integer.parseInt(resultSet.getString(1)),resultSet.getString(2),
                        resultSet.getString(3),Integer.parseInt(resultSet.getString(4)),resultSet.getString(5),resultSet.getString(6),Integer.parseInt(resultSet.getString(7)));
                clients.add(client);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        connection.close();
        return clients;
    }
    
    
    
    public static boolean update(Client client) throws ClassNotFoundException, SQLException{
        boolean sucess = false;
        ArrayList<Client> clients = new ArrayList<Client>();
        String sql = "update client set nm=?,tel=?,age=?,next_session=?,local_picture=?,idartist_fk=? where iduser=?";
        connection = ConnectionModel.connector();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,client.getName());
            preparedStatement.setString(2,client.getTel());
            preparedStatement.setInt(3,client.getAge());
            preparedStatement.setString(4,client.getNext_session());
            preparedStatement.setString(5,client.getLocal_picture());
            preparedStatement.setInt(6,client.getTattoo_artist());
            preparedStatement.setInt(7,client.getIduser());
            int confirm = preparedStatement.executeUpdate();
            if( confirm > 0){
                sucess = true;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        connection.close();
        return sucess;
    }
    
    
    
    public static boolean delete(Client client) throws ClassNotFoundException, SQLException{
        boolean sucess = false;
        ArrayList<Client> clients = new ArrayList<Client>();
        String sql = "delete from client where iduser = ?";
        connection = ConnectionModel.connector();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,client.getIduser());
            int confirm = preparedStatement.executeUpdate();
            if( confirm > 0){
                sucess = true;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        connection.close();
        return sucess;
    }
    
    public static boolean insert(Client client) throws ClassNotFoundException, SQLException{
        boolean sucess = false;
        ArrayList<Client> clients = new ArrayList<Client>();
        String sql = "insert into client(nm,tel,age,next_session,local_picture,idartist_fk) values (?,?,?,?,?,?)";
        connection = ConnectionModel.connector();
        try {
            preparedStatement = connection.prepareStatement(sql);
            //client without id , bd will create it
            preparedStatement.setString(1,client.getName());
            preparedStatement.setString(2,client.getTel());
            preparedStatement.setInt(3,client.getAge());
            preparedStatement.setString(4,client.getNext_session());
            preparedStatement.setString(5,client.getLocal_picture());
            preparedStatement.setInt(6,client.getTattoo_artist());
            int added = preparedStatement.executeUpdate();
            if(added  > 0){
                sucess = true;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        connection.close();
        return sucess;
    }
    
    
    
    
}
