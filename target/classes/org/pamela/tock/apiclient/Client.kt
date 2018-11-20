package org.pamela.tock.apiclient

import com.fasterxml.jackson.databind.module.SimpleModule
import fr.vsct.tock.shared.addJacksonConverter
import fr.vsct.tock.shared.create
import fr.vsct.tock.shared.jackson.mapper
import fr.vsct.tock.shared.retrofitBuilderWithTimeoutAndLogger
import okhttp3.ResponseBody
import org.pamela.tock.story.logger


object Client {
//	private val api: OufTockApi  = Retrofit.Builder()
//			.baseUrl("https://bcaa58d0.ngrok.io/api/")
//			.build()
//			.create()

	private val api: OufTockApi =
			retrofitBuilderWithTimeoutAndLogger(
					30000,
					logger
			)
					.baseUrl("https://fec8f9a3.ngrok.io/api/")
					
					
					.addJacksonConverter(
							mapper.copy().registerModule(
									SimpleModule()

							)
					)					
					.build()
					.create()
	
	lateinit var erreurHandle : List<String>

	fun tousLesMedecins(): List<String> {
		erreurHandle = listOf("désolé un problème est survenu lors de l'accès a la liste des médecins. Merci de réessayer plus tard")
		return api
				.tousLesMedecins()
				.execute()
				.body()
				?: erreurHandle
	}

	fun tousLesVacins(): List<String> {
		erreurHandle = listOf("désolé une erreur est survenu lors de l'accès a la liste des vaccins. Merci de réessayer plus tard")
		return api.tousLesVacins()
				.execute()
				.body()
				?: erreurHandle
	}


	fun estDisponible(query: String): Boolean? {
		return api.estDisponible(query)
				.execute()
				.body()
	}

	fun specialite(query: String): ResponseBody?{
		return api.specialite(query)
				.execute()
				.body()
		

	}
	
	fun hopital(query: String): ResponseBody? {
		return api.hopital(query)
				.execute()
				.body()
		
				
			
	}
	
	fun nomparspecialite(query: String): List<String> {
		erreurHandle = listOf("désolé une erreur est survenu lors de l'accès au nom des médecins de cette spécialité. Merci de réessayer plus tard")
		return api
				.nomParSpecialite(query)
				.execute()
				.body()
				?: erreurHandle
	}
	
	fun nomParHopital(query: String): List<String>? {
		erreurHandle = listOf("désolé une erreur est survenu lors de l'accès au nom des médecins de cet hopital. Merci de réessayer plus tard")
		return api
				.nomParHopital(query)
				.execute()
				.body()
				//?: erreurHandle
	}
	
	fun nomParDisponibilite(): List<String> {
		erreurHandle = listOf("désolé une erreur est survenu lors de l'accès au nom des médecins disponible. Merci de réessayer plus tard")
		return api
				.nomParDisponibilite()
				.execute()
				.body()
				?: erreurHandle
	}
	
	fun estObligatoire(query: String): Boolean? {
		return api.estObligatoire(query)
				.execute()
				.body()
	}
	
	fun vaccinParPays(query :String) : List<String> {
		erreurHandle = listOf("désolé une erreur est survenu lors de l'accès à la liste des vaccins de ce pays. Merci de réessayer plus tard")
		return api.vaccinParPays(query)
				.execute()
				.body()
				?: erreurHandle
	}
}