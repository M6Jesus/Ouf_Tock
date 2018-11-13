//package org.pamela.tock.story
//
//import org.pamela.tock.story.logger
//import fr.vsct.tock.bot.definition.story
//import org.pamela.tock.apiclient.Client
//
//
//
//val medecindisponibleintent = story("medecindisponibleintent"){
//	var nomMed : String?= nomMedecin?.toString()
//    logger.debug("medecindisponibleintent de base, le nom passer est = " + nomMed)
// 
//	if(nomMed == null ){
//		end("désolé je n'ai pas compris le nom du médecin qui vous intéresse")
//	}else{
//		var result = Client.estDisponible(nomMed)
//		lateinit var reponse: String
//		if(result == true){
//			reponse = "oui effectivement"
//		}else{
//			reponse = "non pas du tout"
//		}
//		send(reponse)
//		end()
//	}
//}
//
//
//val medecinhopitalintent = story("medecinhopitalintent"){
//var nomMed : String?= nomMedecin?.toString()
//	
//    logger.debug("**************medecinhopitalintent de base, le nom passer est = " + nomMed)
//  	
//	if(nomMed == null ){
//		end("désolé je n'ai pas compris le nom du médecin qui vous intéresse")
//	}else{
//		var result = Client.hopital(nomMed)?.string().toString()
//		send(result)
//		end()
//	}
//}
//
//val medecinspecialiteintent = story("medecinspecialiteintent"){
//	var nomMed : String?= nomMedecin?.toString()
//	
//    logger.debug("**************medecinspecialiteintent de base, le nom passer est = " + nomMed)
//	
//	if(nomMed == null ){
//		end("désolé je n'ai pas compris le nom du médecin qui vous intéresse")
//	}else{
//		var result = Client.specialite(nomMed)?.string().toString()
//		send(result)
//		end()
//	}
//}
//
//val nompardisponibiliteintent = story("nompardisponibiliteintent") {
//
//	logger.debug("**************NomParDisponibiliteintent de base******")
//		var reponse = Client.nomParDisponibilite().toString()
//		send(reponse)
//		end()
//	
//}
//
//val nomparhopitalintent = story("nomparhopitalintent") {
//
//	var hopital: String? ="hopital " + hopital?.toString() 
//
//	logger.debug("**************nomparhopital de base, l'hopital passer est = " + hopital)
//	if (hopital == null) {
//		end("désolé je n'ai pas compris le nom de l'hopital qui vous intéresse")
//	} else {
//		resetDialogState()
//		var reponse = Client.nomParHopital(hopital).toString()
//		send(reponse)
//		end()
//	}
//}
//
//
//val nomparspecialiteintent = story("nomparspecialiteintent") {
//
//	var specialite: String? = specialite?.toString()
//
//	logger.debug("**************nomparspecialiteintent de base, le nom passer est = " + specialite)
//	
//	if (specialite == null) {
//		end("désolé je n'ai pas compris la spécialité du médecin qui vous intéresse")
//	} else {
//		resetDialogState()
//		var reponse = Client.nomparspecialite(specialite).toString()
//		send(reponse)
//		end()
//	}
//}
//
//val tousmedecinsintent =  story ("tousmedecinsintent"){
//	
//	logger.debug("*******************je suis dans l'intent touslesmedecins*****************")
//	var reponse = Client.tousLesMedecins().toString()
//	send(reponse)
//	end()
//}
//
//val tousvaccinsintent = story("tousvaccinsintent") {
//	logger.debug("*******************je suis dans l'intent touslesmedecins*****************")
//	var reponse = Client.tousLesVacins().toString()
//		send(reponse)
//		end()
//}
//
//val vaccinobligatoireintent = story("vaccinobligatoireintent"){
//	var nomVac : String?= nomVaccin?.toString()
//    logger.debug("vaccinobligatoireintent de base, le vaccin passer est = " + nomVac)
//   
//	if(nomVac == null ){
//		end("désolé je n'ai pas compris le nom du vaccin qui vous intéresse")
//	}else{
//		var result = Client.estObligatoire(nomVac)
//		lateinit var reponse: String
//		if(result == true){
//			reponse = "oui effectivement"
//		}else{
//			reponse = "non pas du tout"
//		}
//		send(reponse)
//		end()
//	}
//}
//
//
//val vaccinparpaysintent = story("vaccinparpaysintent") {
//
//	var nomP: String? = pays?.toString()
//	logger.debug("**************nomparhopital de base, le nom du pays passer est = " + nomP)
//
//	if (nomP == null) {
//		end("désolé je n'ai pas compris le nom du vaccin qui vous intéresse")
//	} else {
//	
//		var reponse = Client.vaccinParPays(nomP).toString()
//		send(reponse)
//		end()
//	}
//	
//}