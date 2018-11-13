package org.pamela.tock.story


import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import org.pamela.tock.apiclient.Client


val nomparhopitalintent = story("nomparhopitalintent") {

	var hopital: String? ="hopital " + hopital?.toString() 

	logger.debug("**************nomparhopital de base, l'hopital passer est = " + hopital)
	if (hopital == null) {
		end("désolé je n'ai pas compris le nom de l'hopital qui vous intéresse")
	} else {
		resetDialogState()
		var reponse = Client.nomParHopital(hopital).toString()
		send(reponse)
		end()
	}
}