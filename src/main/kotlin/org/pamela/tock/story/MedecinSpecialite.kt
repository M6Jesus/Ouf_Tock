package org.pamela.tock.story

import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import org.pamela.tock.apiclient.Client

val medecinspecialiteintent = story("medecinspecialiteintent"){
	var nomMed : String?= nomMedecin?.toString()
	
    logger.debug("**************medecinspecialiteintent de base, le nom passer est = " + nomMed)
	
	if(nomMed == null ){
		end("désolé je n'ai pas compris le nom du médecin qui vous intéresse")
	}else{
		var result = Client.specialite(nomMed)?.string().toString()
		send(result)
		end()
	}
}