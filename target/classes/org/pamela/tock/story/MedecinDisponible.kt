package org.pamela.tock.story

import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import org.pamela.tock.apiclient.Client

val medecindisponibleintent = story("medecindisponibleintent"){
	var nomMed : String?= nomMedecin?.toString()
    logger.debug("medecindisponibleintent de base, le nom passer est = " + nomMed)
 
	if(nomMed == null ){
		end("désolé je n'ai pas compris le nom du médecin qui vous intéresse")
	}else{
		var result = Client.estDisponible(nomMed)
		lateinit var reponse: String
		if(result == true){
			reponse = "oui effectivement"
		}else{
			reponse = "non pas du tout"
		}
		send(reponse)
		end()
	}
}