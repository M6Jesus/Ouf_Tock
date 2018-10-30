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

var BotBus.prenomValue: StringValue?
	get() = entityValue(prenomEntity)
	set(value) = changeEntityValue(prenomEntity, value)


var BotBus.nomValue: StringValue?
	get() = entityValue(nomEntity)
	set(value) = changeEntityValue(nomEntity, value)


var BotBus.codeSecretFirstValue: NumberValue?
	get() = entityValue(codeSecretEntityFirst)
	set(value) = changeEntityValue(codeSecretEntityFirst, value)

var BotBus.codeSecretSecondValue: StringValue?
	get() = entityValue(codeSecretEntitySecond)
	set(value) = changeEntityValue(codeSecretEntitySecond, value)

var BotBus.codeSecretThirdValue: StringValue?
	get() = entityValue(codeSecretEntityThird)
	set(value) = changeEntityValue(codeSecretEntityThird, value)

var BotBus.nomMedecinValue: StringValue?
	get() = entityValue(nomMedecinEntity)
	set(value) = changeEntityValue(nomMedecinEntity, value)

var BotBus.nomVaccinValue: StringValue?
	get() = entityValue(nomVaccinEntity)
	set(value) = changeEntityValue(nomVaccinEntity, value)