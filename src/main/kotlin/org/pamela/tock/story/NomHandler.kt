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

val nomintent: StoryDefinition by lazy {
	story("nomintent", secondaryIntents = setOf(cancel, codesecretfirstintent )) {

		
		if (isIntent(cancel)) {
			end("Ok aurevoir dans le nom_intent !!")
		} else {
			var prenomString: String? = prenom?.toString()
			var nomString: String? = nom?.toString()
			logger.debug("******************** ENFINNNNN!!!   je suis dans nomintent et nom = " + nomString + "**********************************")
			when {
				nomString == null -> {
											end("ENFINNNNN  dans nomintent  ******  merci de me donner votre nom pour une connexion sécurisé")
											nextUserActionState = NextUserActionState(
													nomintent to 0.4,
													cancel to 0.0
											)

										}
				else -> {
							end("vous avez dit " + prenomString + " " + nomString + " merci de me donner votre code secret svp!")
//							nextUserActionState = NextUserActionState(
//															codesecretfirstintent to 0.4,
//															cancel to 0.0
//													)
											
							switchStory(codesecretfirstintent)
						}
			}
		}
	}
}