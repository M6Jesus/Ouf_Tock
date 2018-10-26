package org.pamela.tock.story

import fr.vsct.tock.bot.connector.ga.gaMessage
import fr.vsct.tock.bot.connector.ga.withGoogleAssistant
import fr.vsct.tock.bot.connector.messenger.buttonsTemplate
import fr.vsct.tock.bot.connector.messenger.postbackButton
import fr.vsct.tock.bot.connector.messenger.withMessenger
import fr.vsct.tock.bot.definition.story
import org.pamela.tock.story.logger

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
        )
    }

    end()
}