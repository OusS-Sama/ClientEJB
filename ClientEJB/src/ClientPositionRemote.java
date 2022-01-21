import java.util.Hashtable;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import metier.Position.PositionRemote;
import metier.Smartphone.SmartphoneRemote;
import metier.entities.Position;
import metier.entities.Smartphone;



public class ClientPositionRemote {


    @EJB

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			PositionRemote RemotePosition=(PositionRemote)context.lookup("ejb:ControleEJBEAR/ControleEJB/CEJB!metier.Position.PositionRemote" );
		    SmartphoneRemote RemoteSmart = (SmartphoneRemote)context.lookup("ejb:ControleEJBEAR/ControleEJB/CEJB!metier.Smartphone.SmartphoneRemote" );

			  /*add position*/
		    Smartphone sm = RemoteSmart.getSmartphone(1);
	        Position po= new Position();
	        po.setSmartphone(sm);
	        RemotePosition.addPosition(po);
		
            
            
            
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
