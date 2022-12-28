package routines;

public class Traitement_Salaire {

    public static String traitement_Salaire(Integer salaire, String ville) {
    	
    	String faible ="FAIBLE";
    	String moyen = "MOYEN";
    	String eleve ="ELEVE";
    	String coherent ="COHERENT";
    	String intermediaire="INTERMEDIAIRE";
    	String pasDeFourchette="PAS DE FOURCHETTE";
    	
        if (salaire !=null && !ville.isEmpty() ) {
      		
      		if (Enum_Ville.rennes.getCode().equals(ville)|| Enum_Ville.nantes.getCode().equals(ville) || Enum_Ville.leMans.getCode().equals(ville)) {
            	
            	if (salaire<35000) {
    				return faible;
    			}
            	else if (salaire>35000 && salaire<40000) {
    				return moyen;
    			}
            	else if (salaire>40000  && salaire <50000) {
    				return coherent;
    			}
            	else if (salaire>50000) {
    				return eleve;				
    			}else {
    				return intermediaire;
    			}  	
            }else if (Enum_Ville.bordeaux.getCode().equals(ville) || Enum_Ville.paris.getCode().equals(ville) || Enum_Ville.nice.getCode().equals(ville)) {
            	
            	if (salaire<35000) {
    				return faible;
    			}
            	else if (salaire>35000 && salaire<45000) {
    				return moyen;
    			}
            	else if (salaire>45000  && salaire <55000) {
    				return coherent;
    			}
            	else if (salaire>55000) {
    				return eleve;				
    			}else {
    				return intermediaire;
    			}	
    		}	
		}
			return pasDeFourchette;
    }
}
