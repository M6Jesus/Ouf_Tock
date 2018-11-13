package org.pamela.tock.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Vaccins (
		@JsonProperty("lesVaccins")
		val lesVaccins : List<Vaccin>) {
}