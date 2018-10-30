package org.pamela.tock.story

import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.nlp.entity.StringValue
import fr.vsct.tock.bot.engine.BotBus

val codesecretsecondintent = story(
        "codesecretsecondintent") {

    logger.debug("codeSecretSecond")
    resetDialogState()
 
	var codeSecretSecondInt : Int?= codeSecretSecond?.value?.toInt()
	if(codeSecretSecondInt == null ){
		end("désolé merci de me donner votre code secret pour une connexion sécurisé")
	}else{
		when(codeSecretSecondInt){
			1234 -> send("vous avez dit " + codeSecretSecond + " la connexion viens d'etre établi avec l'application merci! " )
			else -> send("vous avez dit " + codeSecretSecond + "ceci n'est malheureusement pas le bon code, il vous reste une tentatives" )
		}
		
		end()
	}
}