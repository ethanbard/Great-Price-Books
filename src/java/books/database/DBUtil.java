/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package books.database;

import java.sql.*;

/**
 *
 * @author Ethan
 */
public class DBUtil 
{
    public static void closeStatement(Statement stat)
    {
        try
        {
            if (stat != null)
                stat.close();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
    
    public static void closePreparedStatement(Statement prepStat)
    {
        try
        {
            if (prepStat != null)
                prepStat.close();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
    
    public static void closeResultSet(ResultSet reSet)
    {
        try
        {
            if (reSet != null)
                reSet.close();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
}