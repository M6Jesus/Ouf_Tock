package org.pamela.tock.story

import fr.vsct.tock.bot.definition.StoryDefinition
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.bot.engine.dialog.NextUserActionState
import mu.KotlinLogging
import org.pamela.tock.SecondaryIntent.cancel


val logger = KotlinLogging.logger {}

//val codesecretfirstintent = story(
//        "codesecretfirstintent") {
//	
//	var codeSecretFirstInt : Int?= codeSecretFirst?.value?.toInt()
//    logger.debug("codesecretfirstintent de base le code rentrer est = " + codeSecretFirstInt)
//
//	if(codeSecretFirstInt == null ){
//		end("désolé merci de me donner votre code secret pour une connexion sécurisé")
//	}else{
//		
//		when(codeSecretFirstInt){
//			1234 -> send("vous avez dit " + codeSecretFirstInt + " la connexion viens d'etre établi avec l'application merci! " )
//			else -> send("vous avez dit " + codeSecretFirstInt + " ceci n'est malheureusement pas le bon code, il vous reste deux tentatives" )
//		}
//		
//		end()
//	}
//}


val codesecretfirstintent: StoryDefinition by lazy {
	story("codesecretfirstintent", secondaryIntents = setOf(cancel, codesecretsecondintent)) {


		if (isIntent(cancel)) {
			end("Ok aurevoir dans codesecretfirstintent!!")
		} else {

			var codeSecretFirstInt: Int? = codeSecretFirst?.value?.toInt()
			logger.debug("codesecretfirstintent de base le code rentrer est = " + codeSecretFirstInt)
			when {
				codeSecretFirstInt == null -> {
					end("désolé merci de me donner votre code secret pour une connexion sécurisé")
					nextUserActionState = NextUserActionState(
							codesecretfirstintent to 0.4,
							cancel to 0.0
					)
				}
				else -> when (codeSecretFirstInt) {
					1234 -> {
						end("vous avez dit " + codeSecretFirstInt + " la connexion viens d'etre établi avec l'application merci! ")
						end()
					}

					else -> {
						end("vous avez dit " + codeSecretFirstInt + " ceci n'est malheureusement pas le bon code")
						switchStory(codesecretsecondintent)
					}
				}

			}

		}
	}
}


//val codesecretfirstintent: StoryDefinition by lazy {
//	story("codesecretfirstintent", secondaryIntents = setOf(cancel)) {
//
//		logger.debug("********************je suis dans codesecretfirstintent **************")
//
//		if (isIntent(cancel)) {
//			end("Ok aurevoir dans code secret 1 hihiihihi!!")
//		} else {
//			var codeSecretFirstInt: Int? = codeSecretFirst?.value?.toInt()
//			logger.debug("codesecretfirstintent de base le code rentrer est = " + codeSecretFirstInt)
//			
//			//we have not detected entities - ok so we assume the whole test is the entity missing
//			if (!hasActionEntity(codeSecretEntityFirst) && !hasActionEntity(codeSecretEntitySecond)) {
//				if (codeSecretFirst != null && codeSecretSecond == null) {
//					
//					
//
//					when (codeSecretFirstInt) {
//						1234 -> send("vous avez dit " + codeSecretFirstInt + " la connexion viens d'etre établi avec l'application merci! ")
//						else -> send("vous avez dit " + codeSecretFirstInt + " ceci n'est malheureusement pas le bon code, il vous reste deux tentatives")
//					}
//
//					end()
//				}
//			} else {
//				end("désolé merci de me donner votre code secret pour une connexion sécurisé")
//			}
//		}
//
//	}

//
//	else -> {
//					var i = 0
//					loop@ while (i < 3) {
//
//						when (i) {
//							0 -> {
//								when (codeSecretFirstInt) {
//									1234 -> {
//										end("vous avez dit " + codeSecretFirstInt + " la connexion viens d'etre établi avec l'application merci! ")
//										end()
//										break@loop
//									}
//
//									else -> {
//										end("vous avez dit " + codeSecretFirstInt + " ceci n'est malheureusement pas le bon code, il vous reste deux tentatives")
//										
//									}
//								}
//
//
//							}
//							1 -> {
//								when (codeSecretFirstInt) {
//									1234 -> {
//										end("vous avez dit " + codeSecretFirstInt + " la connexion viens d'etre établi avec l'application merci! ")
//										end()
//										break@loop
//									}
//
//									else -> {
//										end("vous avez dit " + codeSecretFirstInt + " ceci n'est malheureusement pas le bon code, il vous reste une tentatives")
//									}
//								}
//
//
//							}
//							2 -> {
//								when (codeSecretFirstInt) {
//									1234 -> {
//										end("vous avez dit " + codeSecretFirstInt + " la connexion viens d'etre établi avec l'application merci! ")
//										end()
//										break@loop
//									}
//
//									else -> {
//										end("vous avez dit " + codeSecretFirstInt + " ceci n'est malheureusement pas le bon code")
//										switchStory(accesrefusee)
//									}
//								}
//
//
//							}
//						}
//
//
//						i++
//
//					}
//
//				}

