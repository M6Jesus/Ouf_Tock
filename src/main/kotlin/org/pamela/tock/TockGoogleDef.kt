package org.pamela.tock

import fr.vsct.tock.bot.definition.IntentDef
import fr.vsct.tock.bot.definition.bot
import org.pamela.tock.story.codesecretfirstintent
import org.pamela.tock.story.codesecretsecondintent
import org.pamela.tock.story.codesecretthirdintent
import org.pamela.tock.story.nomintent
import org.pamela.tock.story.prenomintent
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
				nomintent,
				prenomintent,
				codesecretfirstintent,
				codesecretsecondintent,
				codesecretthirdintent
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

val codeSecret1 = openBot.entity("duckling:number", "number")