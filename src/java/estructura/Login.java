/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

/**
 *
 * @author TAWSBC
 */
public class Login {

    public Login() {
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;

    }
}