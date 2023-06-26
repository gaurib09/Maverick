package org.nlt.services;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.nlt.model.Users;

public class UserServices 
{
    public boolean addUser(Users user,Session ses)
    {
        Users userByEmailObject = getUserByEmail(user.getEmail(),ses);
        if (userByEmailObject==null)//if not email exist
        {
            ses.beginTransaction();
            ses.save(user);
            ses.getTransaction().commit();
            return true;
        } 
        else
        {
            return false;
        }
    }
    public Users getUserByEmail(String email,Session ses)
    {
        ses.beginTransaction();
        Query query = ses.createQuery("from users where status=1 and email='"+email+"'");
        List<Users> userList = query.list();
        ses.getTransaction().commit();
        if (userList.isEmpty())
        {
            return null;
        } 
        else
        {
            return userList.get(0);
        }
    }
    public Users getUserByEmailAndPassword(String email,String passwors,Session ses)
    {
        ses.beginTransaction();
        Query query=ses.createQuery("from users where status=1 and email='"+email+"' and password='"+passwors+"'");
        List<Users> userList = query.list();

        ses.getTransaction().commit();
        
        if (userList.isEmpty())
        {
            return  null;
        } 
        else
        {
            return userList.get(0);
        }
    }
    public Users updateuserByEmail(String email,Session ses)
    {
        ses.beginTransaction();
        int executeUdate = ses.createQuery("update users set status=2 where email='"+email+"'").executeUpdate();
        
        ses.getTransaction().commit();
        return null;
    }
}

