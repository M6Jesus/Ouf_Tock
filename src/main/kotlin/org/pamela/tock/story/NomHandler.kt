package org.pamela.tock.story

import fr.vsct.tock.bot.definition.story
import org.pamela.tock.apiclient.Client
import fr.vsct.tock.bot.definition.StoryDefinition
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.bot.engine.BotBus
import fr.vsct.tock.bot.engine.dialog.NextUserActionState
import org.pamela.tock.SecondaryIntent.cancel

//val nomintent = story("nomintent") {
//	
//	var nomString : String?= nom?.toString()
//    logger.debug("nomintent de base, le nom passer est = " + nomString +  "test :"+  Client.tousLesMedecins().toString())
//	
//	if(nomString == null ){
//		end("désolé merci de me donner votre nom pour une connexion sécurisé")
//	}else{
//		send("vous avez dit " + nomString + " merci de me donner votre code secret svp vous avez 3 tentatives" )
//		end()
//	}
//}

//val nomintent: StoryDefinition by lazy {
//	story("nomintent", secondaryIntents = setOf(cancel, codesecretfirstintent)) {
//
//		var prenomString: String? = prenom?.toString()
//		var nomString: String? = nom?.toString()
//
//		if (prenomString == null && nomString == null) {
//			resetDialogState()
//		}
//
//		if (isIntent(cancel)) {
//			end("Ok aurevoir dans le nom_intent !!")
//		} else {
//
//			logger.debug("******************** ENFINNNNN!!!   je suis dans nomintent et nom = " + nomString + "**********************************")
//			when {
//				nomString == null -> {
//					end("ENFINNNNN  dans nomintent  ******  merci de me donner votre nom pour une connexion sécurisé")
//					nextUserActionState = NextUserActionState(
//							nomintent to 0.4,
//							cancel to 0.0
//					)
//
//				}
//				else -> {
//					end("vous avez dit " + prenomString + " " + nomString + " merci de me donner votre code secret svp!")
////							nextUserActionState = NextUserActionState(
////															codesecretfirstintent to 0.4,
////															cancel to 0.0
////													)
//
//					switchStory(codesecretfirstintent)
//				}
//			}
//		}
//	}
//}


val nomintent: StoryDefinition by lazy {
	story("nomintent", secondaryIntents = setOf(cancel)) {

		if (isIntent(cancel)) {
			end("Ok by")
		} else {

			var prenomString: String? = prenom?.toString()
			var nomString: String? = nom?.toString()
			logger.debug("******************** ENFINNNNN!!!   je suis dans nomintent et nom = " + nomString + "**********************************")
			//we have not detected entities - ok so we assume the whole test is the entity missing
//			if (!hasActionEntity(prenomEntity) && !hasActionEntity(nomEntity)) {
//				if (prenom != null && nom == null) {
//					nom = userText
//				} else {
//					prenom = userText
//				}
//			}
			if (nomString == null) {
				//only ask_identity intent or cancel intent allowed for next request
				nextUserActionState = NextUserActionState(
						nomintent to 0.4,
						cancel to 0.0
				)
			}
			if (nomString != null) {
				nextUserActionState = NextUserActionState(
						codesecretfirstintent to 0.4,
						cancel to 0.0
				)
			}
			when {
				nomString == null -> end("quel est votre nom svp?")
				else -> {
					logger.debug("***************je suis dans nomIntent, le prenom = "+ prenomString + "et le nom est = " + nomString)
					end("votre nom complet est {0} {1}. quel est votre code secret pour une connexion sécurisée?", prenomString, nomString)
				}
			}
		}

	}
}