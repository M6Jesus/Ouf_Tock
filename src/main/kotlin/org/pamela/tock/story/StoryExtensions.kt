package org.pamela.tock.story

import fr.vsct.tock.bot.engine.BotBus
import org.pamela.tock.codeSecretEntityFirst
import org.pamela.tock.codeSecretEntitySecond
import org.pamela.tock.codeSecretEntityThird
import org.pamela.tock.nomEntity
import org.pamela.tock.nomMedecinEntity
import org.pamela.tock.nomVaccinEntity
import org.pamela.tock.prenomEntity
import fr.vsct.tock.nlp.entity.NumberValue
import fr.vsct.tock.nlp.entity.StringValue

/**
 * entity values
 */

var BotBus.prenom: StringValue?
	get() = entityValue(prenomEntity)
	set(value) = changeEntityValue(prenomEntity, value)


var BotBus.nom: StringValue?
	get() = entityValue(nomEntity)
	set(value) = changeEntityValue(nomEntity, value)


var BotBus.codeSecretFirst: NumberValue?
	get() = entityValue(codeSecretEntityFirst)
	set(value) = changeEntityValue(codeSecretEntityFirst, value)

var BotBus.codeSecretSecond: StringValue?
	get() = entityValue(codeSecretEntitySecond)
	set(value) = changeEntityValue(codeSecretEntitySecond, value)

var BotBus.codeSecretThird: StringValue?
	get() = entityValue(codeSecretEntityThird)
	set(value) = changeEntityValue(codeSecretEntityThird, value)

var BotBus.nomMedecin: StringValue?
	get() = entityValue(nomMedecinEntity)
	set(value) = changeEntityValue(nomMedecinEntity, value)

var BotBus.nomVaccin: StringValue?
	get() = entityValue(nomVaccinEntity)
	set(value) = changeEntityValue(nomVaccinEntity, value)