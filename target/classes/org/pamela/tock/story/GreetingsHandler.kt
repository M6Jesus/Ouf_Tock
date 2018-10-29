package org.pamela.tock.story

import fr.vsct.tock.bot.connector.ga.gaMessage
import fr.vsct.tock.bot.connector.ga.withGoogleAssistant
import fr.vsct.tock.bot.connector.messenger.buttonsTemplate
import fr.vsct.tock.bot.connector.messenger.postbackButton
import fr.vsct.tock.bot.connector.messenger.withMessenger
import fr.vsct.tock.bot.definition.story
import fr.vsct.tock.bot.definition.SimpleStoryStep
import fr.vsct.tock.bot.definition.*

import org.pamela.tock.story.logger


enum class MyStep : SimpleStoryStep { greetings, prenomIntent, nomIntent, codeSecretFirstIntent, codeSecretSecondIntent, codeSecretThirdIntent }

val story = storyWithSteps<MyStep>("stories") {
    if(step == welcome) {
        // ...
    } else if(step == prenomIntent) {
        // ...
    } else if(step == nomIntent) {
        // ...
    } else if(step == codeSecretFirstIntent) {
        // ...
    } else if(step == codeSecretSecondIntent) {
        // ...
    } else if(step == codeSecretThirdIntent) {
        // ...
    }else {
        //default case
    }
}
/**
 * The greetings handler.
 */
val welcome = story("greetings") {
	logger.debug("greetings")
    //cleanup state
    resetDialogState()

    send("Bonjour et bienvenue! ")
    send("Il s'agit d'un bot de test du framework Tock ")


    withGoogleAssistant {
       gaMessage(
            "Pour une connexion sécurisé, pourriez vous me donnez votre prénom s'il vous plait?"
        ) }
    end()
}
		 