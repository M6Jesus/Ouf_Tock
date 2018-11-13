package org.pamela.tock.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Medecin(
		//@JsonProperty("medecinID")
		val   medecinID: Int,
		@get:JsonProperty("nomMedecin")
		val  nomMedecin: String,
		//@JsonProperty("hopital")
		val  hopital: String,
		//@JsonProperty("specialite")
		val  specialite: String,
		//@JsonProperty("disponibilite")
		val  disponibilite: Boolean){
	
}
	
