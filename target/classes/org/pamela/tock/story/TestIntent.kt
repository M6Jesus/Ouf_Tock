package org.pamela.tock.story


import fr.vsct.tock.bot.definition.StoryDefinition
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.bot.engine.BotBus
import fr.vsct.tock.bot.engine.dialog.NextUserActionState
import org.pamela.tock.SecondaryIntent.cancel
import org.pamela.tock.nomEntity
import org.pamela.tock.prenomEntity


//val testintent: StoryDefinition by lazy {
//	story("testintent", secondaryIntents = setOf(cancel)) {
//
//
//		//cleanup state
//		resetDialogState()
//
//
//		if (isIntent(cancel)) {
//			end("Ok aurevoir hihiihihi!!")
//		} else {
//			var prenomString: String? = prenom?.toString()
//			logger.debug("******************** TESSSSTTTT   je suis dans testintent prenom = " + prenomString + "**********************************")
//			when {
//				prenomString == null -> {
//					end("dans testintent  ******  merci de me donner votre prenom pour une connexion sécurisé")
//					nextUserActionState = NextUserActionState(
//							testintent to 0.4,
//							cancel to 0.0
//					)
//
//				}
//				else -> {
//					end("vous avez dit " + prenomString + " merci de me donner votre nom svp!")
//					nextUserActionState = NextUserActionState(
//							nomintent to 0.4,
//							cancel to 0.0
//					)
//				}
//
//			}
//			//nom = userText
//
//
//		}
//	}
//}


val askIdentity: StoryDefinition by lazy {
	story("ask_identity", secondaryIntents = setOf(cancel)) {

		if (isIntent(cancel)) {
			end("Ok by")
		} else {
			//we have not detected entities - ok so we assume the whole test is the entity missing
			if (!hasActionEntity(prenomEntity) && !hasActionEntity(nomEntity)) {
				if (prenom != null && nom == null) {
					nom = userText
				} else {
					prenom = userText
				}
			}
			if (nom == null || prenom == null) {
				//only ask_identity intent or cancel intent allowed for next request
				nextUserActionState = NextUserActionState(
						askIdentity to 0.4,
						cancel to 0.0
				)
			}
			if (nom != null && prenom != null) {
				nextUserActionState = NextUserActionState(
						codesecretfirstintent to 0.4,
						cancel to 0.0
				)
			}
			when {
				prenom == null -> end("What is your first name?")
				nom == null -> end("Ok {0}, what is your last name?", prenom)
				else -> end("Your complete name is {0} {1}. what is your secret code for safe connexion", prenom, nom)
			}
		}

	}
}

		