/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atm;

/**
 *
 * @author Nayem
 */
public class App {

    /**
     * @param args the command line arguments
     */
    private int userID;
    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }
    void setUserId(int userID){
        this.userID = userID;
    }
    
}
