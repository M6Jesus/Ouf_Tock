package org.pamela.tock.story

import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.nlp.entity.StringValue
import fr.vsct.tock.bot.engine.BotBus

val prenom = story(
        "prenom") {

    logger.debug("prenom")
    resetDialogState()
 
	
	if(prenomValue == null ){
		end("désolé merci de me donner votre prenom pour une connexion sécurisé")
	}else{
		send("vous avez dit " + prenomValue + " merci de me donner votre nom svp " )
		end()
	}
   
}