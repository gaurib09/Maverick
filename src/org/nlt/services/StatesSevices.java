package org.nlt.services;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.nlt.model.States;

public class StatesSevices 
{
    public List<States> getStates(Session ses)
    {
        ses.beginTransaction();
        Query query = ses.createQuery("from states where status=1");
        List<States> statesList = query.list();
        
        ses.getTransaction().commit();
        return statesList;
    }
}
