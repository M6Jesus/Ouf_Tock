package org.pamela.tock.story

import fr.vsct.tock.bot.definition.StoryDefinition
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.bot.engine.dialog.NextUserActionState
import org.pamela.tock.SecondaryIntent.cancel
import fr.vsct.tock.bot.definition.*


//val codesecretsecondintent = story(
//		"codesecretsecondintent") {
//
//	var codeSecretSecondInt: Int? = codeSecretSecond?.value?.toInt()
//	logger.debug("codeSecretSecondintent  de base le code rentrer est = " + codeSecretSecondInt)
//
//	if (codeSecretSecondInt == null) {
//		end("désolé merci de me donner votre code secret pour une connexion sécurisé")
//	} else {
//		when (codeSecretSecondInt) {
//			1234 -> send("vous avez dit " + codeSecretSecondInt + " la connexion viens d'etre établi avec l'application merci! ")
//			else -> send("vous avez dit " + codeSecretSecondInt + "ceci n'est malheureusement pas le bon code, il vous reste une tentatives")
//		}
//
//		end()
//	}
//}

val codesecretsecondintent: StoryDefinition by lazy {
	story("codesecretsecondintent", secondaryIntents = setOf(cancel, codesecretthirdintent)) {


		if (isIntent(cancel)) {
			end("Ok aurevoir dans codesecretfirstintent!!")
		} else {

			var codeSecretSecondInt: Int? = codeSecretSecond?.value?.toInt()
			logger.debug("codeSecretSecondintent  de base le code rentrer est = " + codeSecretSecondInt)
			when {
				codeSecretSecondInt == null -> {
					end("désolé merci de me donner votre code secret pour une connexion sécurisé")
					nextUserActionState = NextUserActionState(
							codesecretfirstintent to 0.4,
							cancel to 0.0
					)
				}
				else -> {
					when (codeSecretSecondInt) {
						1234 -> {
							end("vous avez dit " + codeSecretSecondInt + " la connexion viens d'etre établi avec l'application merci! ")
							end()
						}

						else -> {
							end("vous avez dit " + codeSecretSecondInt + " ceci n'est malheureusement pas le bon code, il vous reste une tentative")
							switchStory(codesecretthirdintent)
						}
					}

				}

			}
		}
	}
}


//enum class dbConnectSteps : SimpleStoryStep {
//
//	firstnameRep,
//
//	lastnameRep,
//
//	passRep,
//
//}

//val dbconnect = storyWithSteps<dbConnectSteps>(
//		"dbConnect",
//		emptySet(),
//		setOf(SecondaryIntent.firstnameRep, SecondaryIntent.lastnameRep, SecondaryIntent.passRep)
//) {
//	if (step == null) {
//		step = dbConnectSteps.firstnameRep
//		end("Prénom ?")
//	} else if (step == dbConnectSteps.firstnameRep && intent == SecondaryIntent.firstname) {
//		step = dbConnectSteps.lastnameRep
//		end("Nom ?")
//	} else if (step == dbConnectSteps.lastnameRep && intent == SecondaryIntent.lastName) {
//		step = dbConnectSteps.passRep
//		end("Code ?")
//	} else if (step == dbConnectSteps.passRep && intent == SecondaryIntent.pass) {
//		step = dbConnectSteps.passRep
//		end("Bravo tu es connecté !")
//	} else {
//		end("Au revoir")
//	}
//}