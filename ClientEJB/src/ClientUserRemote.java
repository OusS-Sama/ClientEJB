import java.util.Hashtable;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import metier.Smartphone.SmartphoneRemote;
import metier.User.UserRemote;
import metier.entities.Smartphone;
import metier.entities.User;

public class ClientUserRemote {
	

    @EJB

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
	        
	        UserRemote RemoteUser=(UserRemote)context.lookup("ejb:ControleEJBEAR/ControleEJB/CEJB!metier.User.UserRemote" );
		     SmartphoneRemote RemoteSmart = (SmartphoneRemote)context.lookup("ejb:ControleEJBEAR/ControleEJB/CEJB!metier.Smartphone.SmartphoneRemote" );

           
	        /*add user*/
		    Smartphone sm = new Smartphone();
	        User us= new User();
	        us.setNom("oussama");
	        us.setPrenom("elfenni");
	        us.setEmail("oussama@gmail.com");
	        us.setTelephone("054566556");
	        us.setDateNaissance(us.getDateNaissance()); 
	        
	        RemoteUser.addUser(us);
	        
		     
            
            
 	       /* delete user 
            
           
            RemoteUser.deleteUser(9);*/
        

            
            /* update user
            User use = RemoteUser.getUser(4);
            Smartphone sm = RemoteSmart.getSmartphone(1);
            use.setNom("elfenni");
            use.setPrenom("elfenni");
	        use.setEmail("oussama@gmail.com");
	        use.setTelephone("054566556");
            RemoteUser.updateUser(use); */
            
            
	        
			          
            
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
