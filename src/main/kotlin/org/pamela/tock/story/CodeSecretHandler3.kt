package org.pamela.tock.story

import fr.vsct.tock.bot.definition.StoryDefinition
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.bot.engine.dialog.NextUserActionState
import org.pamela.tock.SecondaryIntent.cancel


//val codesecretthirdintent = story(
//		"codesecretthirdintent") {
//	var codeSecretThirdInt: Int? = codeSecretThird?.value?.toInt()
//	logger.debug("codesecretthirdintent  de base le code rentrer est = " + codeSecretThirdInt)
//
//	if (codeSecretThirdInt == null) {
//		end("désolé merci de me donner votre code secret pour une connexion sécurisé")
//	} else {
//		when (codeSecretThirdInt) {
//			1234 -> send("vous avez dit " + codeSecretThirdInt + " la connexion viens d'etre établi avec l'application merci! ")
//			else -> send("vous avez dit " + codeSecretThirdInt + "ceci n'est malheureusement pas le bon code, aurevoir")
//		}
//
//		end()
//	}
//}

val codesecretthirdintent: StoryDefinition by lazy {
	story("codesecretthirdintent", secondaryIntents = setOf(cancel, accesrefuse )) {


		if (isIntent(cancel)) {
			end("Ok aurevoir dans codesecretfirstintent!!")
		} else {

			var codeSecretThirdInt: Int? = codeSecretThird?.value?.toInt()
			logger.debug("codesecretthirdintent  de base le code rentrer est = " + codeSecretThirdInt)
			when {
				codeSecretThirdInt == null -> {
					end("désolé merci de me donner votre code secret pour une connexion sécurisé")
					nextUserActionState = NextUserActionState(
							codesecretfirstintent to 0.4,
							cancel to 0.0
					)
				}
				else -> {
					when (codeSecretThirdInt) {
						1234 -> {
							end("vous avez dit " + codeSecretThirdInt + " la connexion viens d'etre établi avec l'application merci! ")
							end()
						}

						else -> {
							end("vous avez dit " + codeSecretThirdInt + " vous n'avez pas trouver le le bon code")
							switchStory(accesrefuse)
						}
					}

				}

			}
		}
	}
}


val accesrefuse = story("accesrefuse") {end("desolé vous n'avez pas accès a l'application")}

