package org.pamela.tock.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Vaccin(
		//@JsonProperty("vaccinId")
		val vaccinId : Int,
		@get:JsonProperty("nomVaccin")
		val nomVaccin: String,
		//@JsonProperty("typeVaccin")
		val typeVaccin: String,
		//@JsonProperty("pays")
		val  pays: String,
		//@JsonProperty("estObligatoire")
		val  estObligatoire: Boolean){
	

}
	
