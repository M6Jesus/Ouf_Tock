package org.pamela.tock.story


import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import org.pamela.tock.apiclient.Client

val tousvaccinsintent = story("tousvaccinsintent") {
	logger.debug("*******************je suis dans l'intent touslesmedecins*****************")
	var reponse = Client.tousLesVacins().toString()
		send(reponse)
		end()
}