package org.pamela.tock

import fr.vsct.tock.bot.definition.IntentDef
import fr.vsct.tock.bot.definition.bot
import org.pamela.tock.story.codeSecretFirst
import org.pamela.tock.story.codeSecretSecond
import org.pamela.tock.story.codeSecretThird
import org.pamela.tock.story.nom
import org.pamela.tock.story.prenom
import org.pamela.tock.story.greetings
import mu.KotlinLogging

/**
 * The bot definition.
 */
val openBot = bot(
		"tockgoogle",
		stories =
		listOf(
				greetings,
				nom,
				prenom,
				codeSecretFirst,
				codeSecretSecond,
				codeSecretThird
		),
		hello = greetings
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