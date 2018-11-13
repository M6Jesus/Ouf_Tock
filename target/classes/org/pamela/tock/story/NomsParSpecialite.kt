package org.pamela.tock.story

import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import org.pamela.tock.apiclient.Client


val nomparspecialiteintent = story("nomparspecialiteintent") {

	var specialite: String? = specialite?.toString()

	logger.debug("**************nomparspecialiteintent de base, le nom passer est = " + specialite)
	
	if (specialite == null) {
		end("désolé je n'ai pas compris la spécialité du médecin qui vous intéresse")
	} else {
		resetDialogState()
		var reponse = Client.nomparspecialite(specialite).toString()
		send(reponse)
		end()
	}
}