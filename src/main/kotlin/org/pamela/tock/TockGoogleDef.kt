package org.pamela.tock

import fr.vsct.tock.bot.definition.IntentDef
import fr.vsct.tock.bot.definition.bot
import org.pamela.tock.story.codeSecretFirstIntent
import org.pamela.tock.story.codeSecretSecondIntent
import org.pamela.tock.story.codeSecretThirdIntent
import org.pamela.tock.story.nomIntent
import org.pamela.tock.story.prenomIntent
import org.pamela.tock.story.welcome
import mu.KotlinLogging

/**
 * The bot definition.
 */
val openBot = bot(
		"tockgoogle",
		stories =
		listOf(
				welcome,
				nomIntent,
				prenomIntent,
				codeSecretFirstIntent,
				codeSecretSecondIntent,
				codeSecretThirdIntent
		),
		hello = welcome
)

/**
 * The shared entities (used in more than one story).
 */
val prenomEntity = openBot.entity("prenom", "prenom")
val nomEntity = openBot.entity("nom", "nom")
val codeSecretEntityFirst = openBot.entity("codeSecretFirst", "codeSecretFirst")
val codeSecretEntitySecond = openBot.entity("codeSecretSecond", "codeSecretSecond")
val codeSecretEntityThird = openBot.entity("codeSecretThird", "codeSecretThird")
val nomVaccinEntity = openBot.entity("nomVaccin", "nomVaccin")
val nomMedecinEntity = openBot.entity("nomMedecin", "nomMedecin")