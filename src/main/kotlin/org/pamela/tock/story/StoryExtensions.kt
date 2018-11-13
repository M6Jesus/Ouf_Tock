package org.pamela.tock.story

import fr.vsct.tock.bot.engine.BotBus
import org.pamela.tock.codeSecretEntityFirst
import org.pamela.tock.codeSecretEntitySecond
import org.pamela.tock.codeSecretEntityThird
import org.pamela.tock.nomEntity
import org.pamela.tock.prenomEntity
import org.pamela.tock.nomMedecinEntity
import org.pamela.tock.specialiteEntity
import org.pamela.tock.hopitalEntity
import org.pamela.tock.nomVaccinEntity
import org.pamela.tock.nomPaysEntity
import fr.vsct.tock.nlp.entity.NumberValue
import fr.vsct.tock.nlp.entity.StringValue

/**
 * entity values
 */

var BotBus.prenom: String?
	get() = entityText(prenomEntity)
	set(a) { if(a ==null) removeEntityValue(prenomEntity) else changeEntityText(prenomEntity, a) }


var BotBus.nom: String?
	get() = entityText(nomEntity)
	set(a) { if(a ==null) removeEntityValue(nomEntity) else changeEntityText(nomEntity, a) }

var BotBus.codeSecretFirst: NumberValue?
	get() = entityValue(codeSecretEntityFirst)
	set(value) = changeEntityValue(codeSecretEntityFirst, value)

var BotBus.codeSecretSecond: NumberValue?
	get() = entityValue(codeSecretEntitySecond)
	set(value) = changeEntityValue(codeSecretEntitySecond, value)

var BotBus.codeSecretThird: NumberValue?
	get() = entityValue(codeSecretEntityThird)
	set(value) = changeEntityValue(codeSecretEntityThird, value)

var BotBus.nomMedecin : String?
	get() = entityText(nomMedecinEntity)
	set(a) { if(a ==null) removeEntityValue(nomMedecinEntity) else changeEntityText(nomMedecinEntity, a) }

var BotBus.specialite : String?
	get() = entityText(specialiteEntity)
	set(a) { if(a ==null) removeEntityValue(specialiteEntity) else changeEntityText(specialiteEntity, a) }

var BotBus.hopital : String?
	get() = entityText(hopitalEntity)
	set(a) { if(a ==null) removeEntityValue(hopitalEntity) else changeEntityText(hopitalEntity, a) }

var BotBus.nomVaccin : String?
	get() = entityText(nomVaccinEntity)
	set(a) { if(a ==null) removeEntityValue(nomVaccinEntity) else changeEntityText(nomVaccinEntity, a) }

var BotBus.pays : String?
	get() = entityText(nomPaysEntity)
	set(a) { if(a ==null) removeEntityValue(nomPaysEntity) else changeEntityText(nomPaysEntity, a) }


//var BotBus.nomMedecin: String?
//	get() = entityText(nomMedecinEntity)
//	set(a) { if(a ==null) removeEntityValue(nomMedecinEntity) else changeEntityText(nomMedecinEntity, a) }
//
//var BotBus.nomVaccin: String?
//	get() = entityText(nomVaccinEntity)
//	set(a) { if(a ==null) removeEntityValue(nomVaccinEntity) else changeEntityText(nomVaccinEntity, a) }

