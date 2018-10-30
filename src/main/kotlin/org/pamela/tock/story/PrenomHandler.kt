package org.pamela.tock.story

import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.nlp.entity.StringValue
import fr.vsct.tock.bot.engine.BotBus

val prenomintent = story(
        "prenomintent") {

    logger.debug("prenomintent de base le prenom est = " + prenom)
    resetDialogState()
 
	
	if(prenom == null ){
		end("désolé merci de me donner votre prenom pour une connexion sécurisé")
	}else{
		send("vous avez dit " + prenom + " merci de me donner votre nom svp " )
		end()
	}
   
}