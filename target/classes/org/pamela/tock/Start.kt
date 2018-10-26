package org.pamela.tock

import fr.vsct.tock.bot.engine.BotRepository
import fr.vsct.tock.bot.importI18nDump
import fr.vsct.tock.bot.importNlpDump
import fr.vsct.tock.bot.registerAndInstallBot
import fr.vsct.tock.translator.Translator

fun main(args: Array<String>) {
    Start.start()
}

/**
 * This is the entry point of the bot.
 */
object Start {

    fun start() {
        //set default zone id, these are french trains, so...
        System.setProperty("tock_default_zone", "Europe/Paris")
        //enable i18n as two locales are supported
        Translator.enabled = true

        //add evaluation for [PlaceValue] after nlp response
        BotRepository.registerNlpListener(TockGoogleNlpListener)

        //register the bot
        registerAndInstallBot(openBot)

        //load NLP model and i18n labels
        importNlpDump("/tockgoogle.json")
        //importI18nDump("/labels.json")
    }
}