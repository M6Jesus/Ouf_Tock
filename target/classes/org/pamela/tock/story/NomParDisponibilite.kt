package org.pamela.tock.story

import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import org.pamela.tock.apiclient.Client


val nompardisponibiliteintent = story("nompardisponibiliteintent") {

	logger.debug("**************NomParDisponibiliteintent de base******")
		var reponse = Client.nomParDisponibilite().toString()
		send(reponse)
		end()
	
}