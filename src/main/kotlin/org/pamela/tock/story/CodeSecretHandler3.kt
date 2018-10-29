package org.pamela.tock.story

import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.nlp.entity.StringValue
import fr.vsct.tock.bot.engine.BotBus

val codeSecretThirdIntent = story(
        "codeSecretThird") {

    logger.debug("codeSecretThird")
    resetDialogState()
 
    var codeSecretThirdInt : Int?= codeSecretThird?.value?.toInt()
	if(codeSecretThirdInt == null ){
		end("désolé merci de me donner votre code secret pour une connexion sécurisé")
	}else{
		when(codeSecretThirdInt){
			1234 -> send("vous avez dit " + codeSecretThird + " la connexion viens d'etre établi avec l'application merci! " )
			else -> send("vous avez dit " + codeSecretThird + "ceci n'est malheureusement pas le bon code, aurevoir" )
		}
		
		end()
	}
}