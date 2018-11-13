package org.pamela.tock.story


import fr.vsct.tock.bot.definition.StoryDefinition
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.bot.engine.BotBus
import fr.vsct.tock.bot.engine.dialog.NextUserActionState
import org.pamela.tock.SecondaryIntent.cancel
import org.pamela.tock.nomEntity
import org.pamela.tock.prenomEntity


val testintent: StoryDefinition by lazy {
	story("testintent", secondaryIntents = setOf(cancel)) {


		//cleanup state
		resetDialogState()


		if (isIntent(cancel)) {
			end("Ok aurevoir hihiihihi!!")
		} else {
			var prenomString: String? = prenom?.toString()
			logger.debug("******************** TESSSSTTTT   je suis dans testintent prenom = " + prenomString + "**********************************")
			when {
				prenomString == null -> {
											end("dans testintent  ******  merci de me donner votre prenom pour une connexion sécurisé")
											nextUserActionState = NextUserActionState(
													testintent to 0.4,
													cancel to 0.0
											)

										}
				else -> {
							end("vous avez dit " + prenomString + " merci de me donner votre nom svp!")
							nextUserActionState = NextUserActionState(
															nomintent to 0.4,
															cancel to 0.0
													)
						}

			}
			//nom = userText


		}
	}
}

		