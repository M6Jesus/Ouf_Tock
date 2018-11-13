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

val prenomintent: StoryDefinition by lazy {
	story("prenomintent", secondaryIntents = setOf(cancel, nomintent)) {
		
		
		if (isIntent(cancel)) {
			end("Ok aurevoir dans prenom_intent!!")
		} else {
			
			var prenomString: String? = prenom?.toString()
			logger.debug("******************** TESSSSTTTT   je suis dans prenomintent prenom = " + prenomString + "**********************************")
			when {
				prenomString == null -> {
											end(" **** dans prenomintent  ******  merci de me donner votre prénom pour une connexion sécurisé")
//											nextUserActionState = NextUserActionState(
//													prenomintent to 0.4,
//													cancel to 0.0
//											)
											switchStory(prenomintent)
										}
				else -> {
							end("vous avez dit " + prenomString + " merci de me donner votre nom svp!")
//							nextUserActionState = NextUserActionState(
//															nomintent to 0.4,
//															cancel to 0.0
//													)
							switchStory(nomintent)
						}

			}
		}
	}
}

		