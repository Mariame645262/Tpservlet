package mesCommandes;

import javax.servlet.http.*;
public class Identification {
	
	 static String chercheNom (javax.servlet.http.Cookie[] cookies) {
	 // cherche dans les cookies la valeur de celui qui se nomme "nom"
		  String name ="nom";
		 
		 for ( int i=0; i<cookies.length; i++) {
            
			 Cookie cookie = cookies[i];
		       
		       if (name.equals(cookie.getName())) {
		    	   
		    	  name=cookie.getValue();
		    	   }

		     }
		 return name;
	}


}
