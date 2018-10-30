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


enum class GreetingsQuestionSteps : SimpleStoryStep { greetings, prenomintent, nomintent, codesecretfirstintent, codesecretsecondintent, codesecretthirdintent }

val greetings = storyWithSteps<GreetingsQuestionSteps>("greetings") {
	logger.debug("greetings")
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

	if (step == prenomintent) {
		logger.debug("je suis dans prenomintent = "+ prenom)
		resetDialogState()


		if (prenom == null) {
			end("désolé merci de me donner votre prenom pour une connexion sécurisé")
		} else {
			send("vous avez dit " + prenom + " merci de me donner votre nom svp ")
			end()
		}
	} else if (step == nomintent) {
		logger.debug("je suis dans nom = "+ nom)
		resetDialogState()


		if (nom == null) {
			end("désolé merci de me donner votre nom pour une connexion sécurisé")
		} else {
			send("vous avez dit " + nom + " merci de me donner votre code secret svp vous avez 3 tentatives")
			end()
		}
	} else if (step == codesecretfirstintent) {
		logger.debug("je suis dans prenomValuecodeSecretFirst = " + codeSecretFirst)
		resetDialogState()

		var codeSecretFirstInt: Int? = codeSecretFirst?.value?.toInt()
		if (codeSecretFirstInt == null) {
			end("désolé merci de me donner votre code secret pour une connexion sécurisé")
		} else {

			when (codeSecretFirstInt) {
				1234 -> send("vous avez dit " + codeSecretFirstInt + " la connexion viens d'etre établi avec l'application merci! ")
				else -> send("vous avez dit " + codeSecretFirstInt + "ceci n'est malheureusement pas le bon code, il vous reste deux tentatives")
			}

			end()
		}
	} else if (step == codesecretsecondintent) {

		logger.debug("codeSecretSecond")
		resetDialogState()

		var codeSecretSecondInt: Int? = codeSecretSecond?.value?.toInt()
		if (codeSecretSecondInt == null) {
			end("désolé merci de me donner votre code secret pour une connexion sécurisé")
		} else {
			when (codeSecretSecondInt) {
				1234 -> send("vous avez dit " + codeSecretSecondInt + " la connexion viens d'etre établi avec l'application merci! ")
				else -> send("vous avez dit " + codeSecretSecondInt + "ceci n'est malheureusement pas le bon code, il vous reste une tentatives")
			}

			end()
		}
	} else if (step == codesecretthirdintent) {
		logger.debug("codeSecretThird")
		resetDialogState()

		var codeSecretThirdInt: Int? = codeSecretThird?.value?.toInt()
		if (codeSecretThirdInt == null) {
			end("désolé merci de me donner votre code secret pour une connexion sécurisé")
		} else {
			when (codeSecretThirdInt) {
				1234 -> send("vous avez dit " + codeSecretThirdInt + " la connexion viens d'etre établi avec l'application merci! ")
				else -> send("vous avez dit " + codeSecretThirdInt + "ceci n'est malheureusement pas le bon code, aurevoir")
			}

			end()
		}
	} else {
		send("je suis perdu lol!")
	}
}
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
		 