package org.pamela.tock.story

import fr.vsct.tock.bot.definition.StoryDefinition
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.bot.engine.dialog.NextUserActionState
import mu.KotlinLogging
import org.pamela.tock.SecondaryIntent.cancel
import org.pamela.tock.codeSecretEntityFirst
import fr.vsct.tock.bot.definition.ParameterKey
import fr.vsct.tock.bot.engine.BotBus

val logger = KotlinLogging.logger {}
val codesecretfirstintent: StoryDefinition by lazy {
	story("codesecretfirstintent", secondaryIntents = setOf(cancel)) {
		if (isIntent(cancel)) {
			end("aurevoir")
		} else {
			var codeSecretFirstInt: Int? = codeSecretFirst?.value?.toInt()
			//we have not detected entities - ok so we assume the whole test is the entity missing
			if (!hasActionEntity(codeSecretEntityFirst)) {
				if (codeSecretFirstInt == null) {
					codeSecretFirstInt = userText?.toInt()
				}
			}
			when {
				codeSecretFirstInt == null -> end("quel est votre code secret pour une connexion sécurisée?")
				else -> {
					logger.debug("******le code secret viens d'etre rentrer est il est = " + codeSecretFirstInt)
					
//					var contextValue1Int: Int? = contextValue1
//					var contextValue2Int: Int? = contextValue2
//					var contextValue3Int: Int? = contextValue3
					val map = mapOf(medecindisponibleintent to 0.2,	tousmedecinsintent to 0.2,tousvaccinsintent to 0.2,	medecindisponibleintent to 0.2,	medecinspecialiteintent to 0.2, medecinhopitalintent to 0.2,nomparspecialiteintent to 0.2,nomparhopitalintent to 0.2,nompardisponibiliteintent to 0.2,vaccinobligatoireintent to 0.2,vaccinparpaysintent to 0.2,cancel to 0.0)
					if (contextValue1 == null && contextValue2 == null && contextValue3 == null) {
						// premier passage
						
						//contextValue1Int = codeSecretFirstInt
						contextValue1 = codeSecretFirstInt
						logger.debug("******je suis dans le premier passage et la valeur de contextValue1 = " + contextValue1 + " et le codeSecretFirstInt = " + codeSecretFirstInt)
						when (contextValue1) {
							1234 -> {
								end("vous avez dit " + contextValue1 + " la connexion viens d'etre établi avec l'application merci! ")
								nextUserActionState = NextUserActionState(
										map
								)
							}
							else -> {
								end("vous avez dit " + contextValue1 + " ceci n'est malheureusement pas le bon code, il vous reste deux tentatives")
								nextUserActionState = NextUserActionState(
										codesecretfirstintent to 0.4,
										cancel to 0.0
								)
							}
						}


					} else if (contextValue1 != null && contextValue2 == null && contextValue3 == null) {
						// deuxieme passage
						//contextValue2Int = codeSecretFirstInt
						contextValue2 = codeSecretFirstInt
						logger.debug("******je suis dans le deuxieme passage et la valeur de contextValue2Int = " + contextValue2 + " et le codeSecretFirstInt = " + codeSecretFirstInt)
						when (contextValue2) {
							1234 -> {
								end("vous avez dit " + contextValue2 + " la connexion viens d'etre établi avec l'application merci! ")
								nextUserActionState = NextUserActionState(
										map
								)
							}
							else -> {
								end("vous avez dit " + contextValue2 + " ceci n'est malheureusement pas le bon code, il vous reste une tentatives")
								nextUserActionState = NextUserActionState(
										codesecretfirstintent to 0.4,
										cancel to 0.0
								)
							}
						}
					} else if (contextValue1 != null && contextValue2 != null && contextValue3 == null) {
						// dernier passage
						//contextValue3Int = codeSecretFirstInt
						contextValue3 = codeSecretFirstInt
						logger.debug("******je suis dans le deuxieme passage et la valeur de contextValue3Int = " + contextValue3 + " et le codeSecretFirstInt = " + codeSecretFirstInt)
						when (contextValue3) {
							1234 -> {
								end("vous avez dit " + contextValue3 + " la connexion viens d'etre établi avec l'application merci! ")
								nextUserActionState = NextUserActionState(
										map
								)
							}
							else -> {
								end("vous avez dit " + contextValue3 + " ceci n'est malheureusement pas le bon code, vous n'avez pas accès a l'application")
								nextUserActionState = NextUserActionState(
										cancel to 0.4
								)
							}
						}
					}
				}
			}

			if (codeSecretFirstInt != null && nom != null && prenom != null) {
				resetDialogState()
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

