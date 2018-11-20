package org.pamela.tock.story

import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import org.pamela.tock.apiclient.Client

val medecinhopitalintent = story("medecinhopitalintent") {
	var nomMed: String? = nomMedecin?.toString()

	logger.debug("**************medecinhopitalintent de base, le nom passer est = " + nomMed)

	if (nomMed == null) {
		end("désolé je n'ai pas compris le nom du médecin qui vous intéresse")
	} else {
		var resultat = Client.hopital(nomMed)
		if (resultat == null) {
			send("désolé ce médecin ne figure pas dans notre repertoire. merci de consulter la liste de tous les médecins repertorié")
		} else {
			var result = Client.hopital(nomMed)?.string().toString()
			send(result)
		}
		end()
	}
}