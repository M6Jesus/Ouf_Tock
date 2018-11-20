package org.pamela.tock.story

import fr.vsct.tock.bot.definition.StoryDefinition
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.bot.engine.dialog.NextUserActionState
import org.pamela.tock.SecondaryIntent.cancel
//val prenomintent = story(
//        "prenomintent") {
//		var prenomString : String?= prenom?.toString()
//		logger.debug("je suis dans prenomintent de base et prenom est  = " + prenomString)
//	
//	if(prenomString == null ){
//		end("désolé merci de me donner votre prenom pour une connexion sécurisé")
//
//	}else{
//		send("vous avez dit " + prenomString + " merci de me donner votre nom svp " )
//
//		end()
//	}
//   
//}


//// la derniere version OKI//
//val prenomintent: StoryDefinition by lazy {
//	story("prenomintent", secondaryIntents = setOf(cancel, nomintent)) {
//		
//		var prenomString: String? = prenom?.toString()	
//		if(prenomString == null ) {resetDialogState()}
//		
//		if (isIntent(cancel)) {
//			end("Ok aurevoir dans prenom_intent!!")
//		} else {
//			
//			
//			logger.debug("******************** TESSSSTTTT   je suis dans prenomintent prenom = " + prenomString + "**********************************")
//			when {
//				prenomString == null -> {
//											end(" **** dans prenomintent  ******  merci de me donner votre prénom pour une connexion sécurisé")
////											nextUserActionState = NextUserActionState(
////													prenomintent to 0.4,
////													cancel to 0.0
////											)
//											//switchStory(prenomintent)
//										}
//				else -> {
//							end(" votre prénom est " + prenomString + " merci de me donner votre nom svp!")
////							nextUserActionState = NextUserActionState(
////															nomintent to 0.4,
////															cancel to 0.0
////													)
//							switchStory(nomintent)
//						}
//
//			}
//		}
//	}
//}

val prenomintent: StoryDefinition by lazy {
	story("prenomintent", secondaryIntents = setOf(cancel)) {

		if (isIntent(cancel)) {
			end("Ok by")
		} else {
			
			var prenomString: String? = prenom?.toString()

			logger.debug("******************** ENFINNNNN!!!   je suis dans prenomintent et nom = " + prenomString + "**********************************")		
			//we have not detected entities - ok so we assume the whole test is the entity missing
//			if (!hasActionEntity(prenomEntity) && !hasActionEntity(nomEntity)) {
//				if (prenom != null && nom == null) {
//					nom = userText
//				} else {
//					prenom = userText
//				}
//			}
			if (prenomString == null) {
				//only ask_identity intent or cancel intent allowed for next request
				nextUserActionState = NextUserActionState(
						prenomintent to 0.4,
						cancel to 0.0
				)
			}
			if (prenomString != null) {
				nextUserActionState = NextUserActionState(
						nomintent to 0.4,
						cancel to 0.0
				)
			}
			when {
				prenomString == null -> end("ENFINNNNN  dans prenomintent  ******  merci de me donner votre prenom pour une connexion sécurisé")
				else -> end("votre prénom est  {0}. quel est votre nom svp?", prenomString)
			}
		}

	}
}

		