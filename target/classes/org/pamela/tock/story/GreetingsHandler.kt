package org.pamela.tock.story

import fr.vsct.tock.bot.connector.ga.gaMessage
import fr.vsct.tock.bot.connector.ga.withGoogleAssistant
import fr.vsct.tock.bot.connector.messenger.buttonsTemplate
import fr.vsct.tock.bot.connector.messenger.postbackButton
import fr.vsct.tock.bot.connector.messenger.withMessenger
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.bot.definition.SimpleStoryStep
import fr.vsct.tock.bot.definition.*
import org.pamela.tock.story.logger
import fr.vsct.tock.bot.engine.dialog.NextUserActionState


enum class GreetingsQuestionSteps : SimpleStoryStep { greetings, prenomintent, nomintent, codesecretfirstintent,
													codesecretsecondintent, codesecretthirdintent, tousmedecinsintent,
													tousvaccinsintent, medecindisponibleintent,
													medecinspecialiteintent}

val greetingss = storyWithSteps<GreetingsQuestionSteps>("greetingss") {
	logger.debug("********************je suis dans greetingss**********************************")
	//cleanup state
	resetDialogState()

	send("Bonjour et bienvenue! ")
	send("Il s'agit d'un bot de test du framework Tock ")
	withGoogleAssistant {
		gaMessage(
				"Pour une connexion sécurisé, pourriez vous me donnez votre prénom s'il vous plait?"
		)
	}
	end()
	if (step == tousmedecinsintent) {
		logger.debug("********************************************je passe au moins ici tousmedecinsintent *******************************")
	}
	else if (step == prenomintent) {
		logger.debug("********************************************je passe au moins ici prenomintent *******************************")

		
		
	} else if (step == nomintent) {
		logger.debug("********************************************je passe au moins ici nomintent *******************************")
		
	} else if (step == codesecretfirstintent) {
		logger.debug("********************************************je passe au moins ici codesecretfirstintent *******************************")
		
	} else if (step == codesecretsecondintent) {
		logger.debug("********************************************je passe au moins ici codesecretsecondintent *******************************")

		
	} else if (step == codesecretthirdintent) {
		logger.debug("********************************************je passe au moins ici codesecretthirdintent *******************************")
	
	}else if (step == tousmedecinsintent) {
		logger.debug("********************************************je passe au moins ici tousmedecinsintent *******************************")
	
	}else if (step == tousvaccinsintent) {
		logger.debug("********************************************je passe au moins ici tousvaccinsintent *******************************")
	} else if (step == medecindisponibleintent) {
		logger.debug("********************************************je passe au moins ici medecindisponibleintent *******************************")
	}else if (step == medecinspecialiteintent) {
		logger.debug("********************************************je passe au moins ici medecinspecialiteintent *******************************")
	}else {
		send("je suis perdu lol!")
	}
}

//val cancel = story("cancel"){
//	logger.debug("je suis dans l'intent cancel")
//	resetDialogState()
//	withGoogleAssistant {
//      gaMessage(
//            "vous n'avez pas rentrer les bonnes informations voulez vous reprendre?"
//       )	
//	}
//	end()
//}
/**
 * The greetings handler.
 */

//val greetings = story("greetings") {
//	logger.debug("greetings")
////    //cleanup state
//   resetDialogState()
//
//   send("Bonjour et bienvenue! ")
//    send("Il s'agit d'un bot de test du framework Tock ")
//
//
//    withGoogleAssistant {
//       gaMessage(
//            "Pour une connexion sécurisé, pourriez vous me donnez votre prénom s'il vous plait?"
//        )	
//	}
//
//    end()
//	
//}
		 