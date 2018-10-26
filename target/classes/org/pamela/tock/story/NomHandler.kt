package org.pamela.tock.story

import org.pamela.tock.story.logger
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.nlp.entity.StringValue
import fr.vsct.tock.bot.engine.BotBus

val nomIntent = story("nom") {

    logger.debug("prenom")
    resetDialogState()
 
	
	if(nom == null ){
		end("désolé merci de me donner votre nom pour une connexion sécurisé")
	}else{
		send("vous avez dit " + nom + " merci de me donner votre code secret svp vous avez 3 tentatives" )
		end()
	}
}