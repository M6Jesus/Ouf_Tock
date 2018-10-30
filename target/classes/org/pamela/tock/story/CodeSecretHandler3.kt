package org.pamela.tock.story

import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.nlp.entity.StringValue
import fr.vsct.tock.bot.engine.BotBus

val codeSecretThird = story(
        "codeSecretThird") {

    logger.debug("codeSecretThird")
    resetDialogState()
 
    var codeSecretThirdInt : Int?= codeSecretThirdValue?.value?.toInt()
	if(codeSecretThirdInt == null ){
		end("désolé merci de me donner votre code secret pour une connexion sécurisé")
	}else{
		when(codeSecretThirdInt){
			1234 -> send("vous avez dit " + codeSecretThirdValue + " la connexion viens d'etre établi avec l'application merci! " )
			else -> send("vous avez dit " + codeSecretThirdValue + "ceci n'est malheureusement pas le bon code, aurevoir" )
		}
		
		end()
	}
}