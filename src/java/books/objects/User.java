/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package books.objects;

/**
 *
 * @author Ethan
 */
public class User 
{
    private int userID;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String emailAddress;
    private String administrator;
    
    public User()
    {
        userID = 0;
        firstName = "";
        lastName = "";
        userName = "";
        password = "";
        emailAddress = "";
        administrator = "N";
    }
    
    public User(int id, String fn, String ln, String un, String p, String ea, String a)
    {
        userID = id;
        firstName = fn;
        lastName = ln;
        userName = un;
        password = p;
        emailAddress = ea;
        administrator = a;
    }
    
    public void setUserID(int id)
    {
        userID = id;
    }
    
    public int getUserID()
    {
        return userID;
    }
    
    public void setFirstName(String fn)
    {
        firstName = fn;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setLastName(String ln)
    {
        lastName = ln;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setUserName(String un)
    {
        userName = un;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setPassword(String p)
    {
        password = p;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setEmailAddress(String ea)
    {
        emailAddress = ea;
    }
    
    public String getEmailAddress()
    {
        return emailAddress;
    }
    
    public void setUserType(String a)
    {
        administrator = a;
    }
    
    public String isAdministrator()
    {
        return administrator;
    }
}
