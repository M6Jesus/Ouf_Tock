package org.pamela.tock.story

import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import org.pamela.tock.apiclient.Client

val vaccinparpaysintent = story("vaccinparpaysintent") {

	var nomP: String? = pays?.toString()
	logger.debug("**************nomparhopital de base, le nom du pays passer est = " + nomP)

	if (nomP == null) {
		end("désolé je n'ai pas compris le nom du vaccin qui vous intéresse")
	} else {
	
		var reponse = Client.vaccinParPays(nomP).toString()
		send(reponse)
		end()
	}
	
}