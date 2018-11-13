package org.pamela.tock.story

import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import org.pamela.tock.apiclient.Client

val tousmedecinsintent =  story ("tousmedecinsintent"){
	
	logger.debug("*******************je suis dans l'intent touslesmedecins*****************")
	var reponse = Client.tousLesMedecins().toString()
	send(reponse)
	end()
}