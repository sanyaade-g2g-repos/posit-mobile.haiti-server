package haiti.server.gui;

import haiti.server.datamodel.Beneficiary;
import java.sql.*;

public class TbsManager {
	public static final String RESULT_OK = "Ok";
	
	public TbsManager() {}
	

	/**
	 *  METHODE POUR FAIRE DES REQUETES
	 *  @param chaine is the connection to the Db
	 *  @param type of update
	 */
 	public String ExecuterRequete(String chaine,String type){
		// chargement du Driver
 		ResultSet result;
	  	Connection con;
 		try{
	 		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         	// etablir une connection
        	con = DriverManager.getConnection("jdbc:odbc:acdi_source", "sa1", "tiovas");
        	//Creation d'une instruction
			Statement requete = con.createStatement();

			//Instruction pour savoir le type de requete
			if((type=="Inserer")||(type=="Mise")||(type=="Effacer")){
				requete.executeUpdate(chaine);
    		}
    		if(type=="Affiche"){
				result=requete.executeQuery(chaine);
    		}
    	}	catch (ClassNotFoundException t) { System.out.println(t);}
	   	catch(SQLException f){
	   		//f.printStackTrace();
	   		return f.getMessage();
	   	//JOptionPane.showMessageDialog(null,f,"Attention",JOptionPane.WARNING_MESSAGE);
	   	}
	   	return RESULT_OK;
	}
  	//Fin Methode pour faire des requettes
	
	/**
	 * Receives a Beneficiary object from the GUI and uses its
	 * data to update TBS Db.
	 * @param beneficiary
	 * @return
	 */
	public String postNewBeneficiary(Beneficiary beneficiary) {
		// TODO: Write the necessary queries and return true
		//  if insert was successful
	  	////////////////////Partie Informations Generales
		
		String requete="Insert into Beneficiaire_sms " +
				"values('"+beneficiary.getRandomDossierNumber()+"','"
           +beneficiary.getLastName()+"','"
           +beneficiary.getFirstName()+"','"
           +beneficiary.getCommune()+"','"
           +beneficiary.getCommuneSection()+"','"
           +beneficiary.getAddress()+
           "')";
           
           //"','"
           
           
//           +dateSaisie+"','"
//          +naissance+"','"
//          +sexe.getSelectedItem()+"','"
//          +type_field_benefi.getSelectedItem()+"','"
//          +type_field_benefi1.getSelectedItem()+"','"
//          +Nbre_personne_T.getText()+"',"
//          +ch_centre_sante.getSelectedItem()+"','"
//          +ch_centre_dist.getSelectedItem()+"','"
//          +ch_code_centre.getSelectedItem()+"','"
//          +responsable_T.getText()+"','"
//          +representant_FE_T.getText()+"','"
//          +Nom_epoux_T.getText()+"','"
//          +Nom_pere_T.getText()+"','"
//          +Mere_leader_T.getSelectedItem()+"','"
//          +recu_visit.getSelectedItem()+"','"
//          +Volet_agr_T.getSelectedItem()+"','"
//          +Reponse_T.getText()+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"','"
//          +" "+"')";


		return ExecuterRequete(requete,"Inserer");		
	}

}