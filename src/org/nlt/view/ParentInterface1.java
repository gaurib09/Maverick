//dcpemyapmxoekdgy
package org.nlt.view;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nlt.model.Users;
import org.nlt.services.StatesSevices;
import org.nlt.services.UserServices;

/**
 *
 * @author Gauri Bhamkar
 */
public interface ParentInterface1 
{
public  static  SessionFactory factory=getDatabaseSessionFactory();
    public  static  Session ses=factory.openSession();
    
    public static UserFrame userFrame=new UserFrame();
    public static StatesFrame statesFrame=new StatesFrame();
    public static CitiesFrame citiesFrame=new CitiesFrame();
    public static PersonsFrame personsFrame=new PersonsFrame();
    public static LoginFrame loginFrame=new LoginFrame();
    public static UserServices userService=new UserServices();
    public static StatesSevices statesService=new StatesSevices();
    
    
   public static Users loginUser=new Users();
   
   public  static  SessionFactory getDatabaseSessionFactory()
   {
       SessionFactory sf=new Configuration().configure().buildSessionFactory();
       return sf;
   }    
}
