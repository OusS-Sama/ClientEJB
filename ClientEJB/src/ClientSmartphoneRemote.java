import java.util.Hashtable;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import metier.Smartphone.SmartphoneRemote;
import metier.User.UserRemote;
import metier.entities.Smartphone;
import metier.entities.User;

public class ClientSmartphoneRemote {
	
        
    

    @EJB

	public static void main(String[] args) {
		try {
		 Context context = new InitialContext();
	     SmartphoneRemote RemoteSmart = (SmartphoneRemote)context.lookup("ejb:ControleEJBEAR/ControleEJB/CEJB!metier.Smartphone.SmartphoneRemote" );
	     UserRemote RemoteUser=(UserRemote)context.lookup("ejb:ControleEJBEAR/ControleEJB/CEJB!metier.User.UserRemote" );

	     /* add smart */
	     	User us = RemoteUser.getUser(4);
            Smartphone sm = new Smartphone();
            sm.setImei("564654");
            sm.setUser(us);
           
            RemoteSmart.addSmartphone(sm);
            
            
            RemoteSmart.deleteSmartphone(7);
            RemoteSmart.deleteSmartphone(8);
            RemoteSmart.deleteSmartphone(9);



            
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	

}
