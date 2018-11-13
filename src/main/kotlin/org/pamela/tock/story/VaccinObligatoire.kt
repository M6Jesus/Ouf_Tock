package org.pamela.tock.story

import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import org.pamela.tock.apiclient.Client


val vaccinobligatoireintent = story("vaccinobligatoireintent"){
	var nomVac : String?= nomVaccin?.toString()
    logger.debug("vaccinobligatoireintent de base, le vaccin passer est = " + nomVac)
   
	if(nomVac == null ){
		end("désolé je n'ai pas compris le nom du vaccin qui vous intéresse")
	}else{
		var result = Client.estObligatoire(nomVac)
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