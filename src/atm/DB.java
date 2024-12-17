/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm;

/**
 *
 * @author Nayem
 * 
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class DB {
    private Connection connect;
    private Statement statement;
    private ResultSet result;
    private int flag;
    private int user_id;
    
    
    DB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/atm?" + "user=root&password=");
        }catch(Exception e){
            System.out.println("Error!" + e);
        }
    }
    DB(String id, String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/atm?" + "user=root&password=");
            statement = connect.createStatement();
            result = statement.executeQuery("SELECT * FROM `user` WHERE `card_number` = '" +  id +"' LIMIT 1");
//            while(result.next()){
//                System.out.println(result.getString("password"));
//            }  
           if(result == null){
               
               this.flag = 0;
               
           }else{

               while(result.next()){
                    if(password.equals(result.getString("password"))){
                        int user_id = Integer.parseInt(result.getString("id"));
                        setUserId(user_id);
                        this.flag = 1;
                    }  
               }
           }
           
        }catch(Exception e){
            
            System.out.println("Error!" + e);
            
        }finally{
          
        }
    }
    
    int deposite(int amount, int user_id){
        
        System.out.println(amount +" deposit for user id - " + user_id);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/atm?" + "user=root&password=");
            statement = connect.createStatement();
            statement.executeUpdate("INSERT INTO `ledger`(`user_id`, `amount`, `type`) VALUES ( " + user_id + ", " + amount + " , 1)");
            JOptionPane.showMessageDialog(null,"Deposited Successfully");
            return 1;
        }catch(Exception e){
            System.out.println("Error!! - " + e);
            return 0;
        }
        
    }
    
    int getFlag(){
        return this.flag;
    }
    
    void setUserId(int id){
        this.user_id = id;
    }
    
    int getUserId(){
        return this.user_id;
    }  
    
    int makeCashOut(int userId, int amount){
        try{
            int return_value = 0;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/atm?" + "user=root&password=");
            statement = connect.createStatement();
            result = statement.executeQuery("SELECT * FROM `ledger` WHERE `user_id` = " + userId + " AND `type` = 1");
            
            int totalDeposit = 0;
            while(result.next()){
               totalDeposit = result.getInt("amount") + totalDeposit;  
            }
            
            System.out.println("Total Deposit From user " + userId + " is " + totalDeposit);
            
            result = statement.executeQuery("SELECT * FROM `ledger` WHERE `user_id` = " + userId + " AND `type` = 2");
            int totalCashOut = 0;
            
            while(result.next()){
               totalCashOut = result.getInt("amount") + totalCashOut;  
            }
            
            System.out.println("Total cashout From user " + userId + " is " + totalCashOut);
            
            if((totalDeposit - totalCashOut) - 500 > amount ){
                statement.executeUpdate("INSERT INTO `ledger`(`user_id`, `amount`, `type`) VALUES ( " + userId + ", " + amount + " , 2)");
                return_value =  1; //success
            }else if((totalDeposit - totalCashOut - 500) < amount){
               return_value = 2; //unsuccessfull , insert valid amount
            }
            return return_value;
            
        }catch(Exception e){
            System.out.println("Error! " + e);
              return 0;
        }
    }
    int resetPass(int userId, String oldPass,String confirmPass){
        int return_status = 0;
        
        try {
            statement = connect.createStatement();
            result = statement.executeQuery("SELECT * FROM `user` WHERE `id` = '" + userId + "' AND `password` = '"+ oldPass + "'");
            if(result != null){
                System.out.println("Old Password matched");
                statement.executeUpdate("UPDATE `user` SET `password` = '" + confirmPass + "' WHERE `id` = " + userId);
                return_status = 1;
            }else{
                System.out.println("Old Password did not matched");
                return_status = 2; //incorrect old password
            }
            return return_status;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return return_status;
        }
    }
}
