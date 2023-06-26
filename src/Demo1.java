
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nlt.model.Cities;
import org.nlt.model.Persons;
import org.nlt.model.States;
import org.nlt.model.Users;
import static org.nlt.view.ParentInterface1.loginFrame;
import static org.nlt.view.ParentInterface1.personsFrame;

public class Demo1 
{
    public static void main(String[] args) 
    {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session ses=sf.openSession();
        ses.beginTransaction();
        
        Users users=new Users();
        Persons persons=new Persons();
        Cities cities=new Cities();
        States states=new States();
        
        loginFrame.setVisible(true);
//      userFrame.setVisible(true);
//      statesFrame.setVisible(true);
//      citiesFrame.setVisible(true);
    //    personsFrame.setVisible(true);
                
        ses.getTransaction().commit();
        ses.close();
        sf.close();
    }
}
