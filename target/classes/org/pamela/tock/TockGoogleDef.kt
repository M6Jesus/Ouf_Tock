package org.pamela.tock

import fr.vsct.tock.bot.definition.IntentDef
import fr.vsct.tock.bot.definition.bot
import org.pamela.tock.story.codesecretfirstintent
import org.pamela.tock.story.codesecretsecondintent
import org.pamela.tock.story.codesecretthirdintent
import org.pamela.tock.story.nomintent
import org.pamela.tock.story.prenomintent
import org.pamela.tock.story.greetingss
import org.pamela.tock.story.tousmedecinsintent
import org.pamela.tock.story.tousvaccinsintent
import org.pamela.tock.story.medecindisponibleintent
import org.pamela.tock.story.medecinspecialiteintent
import org.pamela.tock.story.medecinhopitalintent
import org.pamela.tock.story.nomparspecialiteintent
import org.pamela.tock.story.nomparhopitalintent
import org.pamela.tock.story.nompardisponibiliteintent
import org.pamela.tock.story.vaccinobligatoireintent
import org.pamela.tock.story.vaccinparpaysintent
import org.pamela.tock.story.testintent
import mu.KotlinLogging

/**
 * The bot definition.
 */
val openBot = bot(
		"tockgoogle",
		stories =
		listOf(
				greetingss,
				nomintent,
				prenomintent,
				codesecretfirstintent,
				codesecretsecondintent,
				codesecretthirdintent,
				tousmedecinsintent,
				tousvaccinsintent,
				medecindisponibleintent,
				medecinspecialiteintent,
				medecinhopitalintent,
				nomparspecialiteintent,
				nomparhopitalintent,
				nompardisponibiliteintent,
				vaccinobligatoireintent,
				vaccinparpaysintent,
				testintent
		),
		hello = prenomintent
)



enum class SecondaryIntent : IntentDef {

    /**
     * cancel intent.
     */
    cancel,
	nomintent,
	codesecretfirstintent
}



/**
 * The shared entities (used in more than one story).
 */
val prenomEntity = openBot.entity("prenom", "prenom")
val nomEntity = openBot.entity("nom", "nom")
val codeSecretEntityFirst = openBot.entity("duckling:number", "codesecretfirst")
val codeSecretEntitySecond = openBot.entity("duckling:number", "codesecretsecond ")
val codeSecretEntityThird = openBot.entity("duckling:number", "codesecretthird ")
val tousVaccinsEntity = openBot.entity("touslesvaccins", "touslesvaccins")
val tousMedecinsEntity = openBot.entity("touslesmedecins", "touslesmedecins")
val nomMedecinEntity = openBot.entity("nonmedecin", "nonmedecin")
val specialiteEntity = openBot.entity("specialite", "specialite")
val hopitalEntity = openBot.entity("hopital", "hopital")
val nomVaccinEntity = openBot.entity("vaccin", "vaccin")
val nomPaysEntity = openBot.entity("pays", "pays")



