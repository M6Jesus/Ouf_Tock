package org.pamela.tock.apiclient

import okhttp3.ResponseBody
import org.pamela.tock.model.Medecin
import org.pamela.tock.model.Vaccin
import org.pamela.tock.model.Vaccins
import org.pamela.tock.model.Medecins
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OufTockApi {
	
	/**
	 * 
	 * pour acceder à la liste de tous les medecins present dans la base de donnée
	 */
    @GET("tousLesMedecins")
   // fun tousLesMedecins(): Call<Medecins>
	fun tousLesMedecins(): Call<List<String>>
	/**
	 * 
	 * @param nomMedecin le nom du medecin
	 * pour acceder a la disponibilité du médecin
	 */
	@GET("estDisponible")
    //fun estDisponible(@Path("nomMedecin") nomMedecin: String): Call<Boolean>
	fun estDisponible(@Query("nomMedecin") query: String): Call<Boolean>
	/**
	 * 
	 * @param nomMedecin le nom du medecin
	 * pour acceder à la specialité du medecin
	 */
	@GET("specialite")
    fun specialite(@Query("nomMedecin") query: String): Call<ResponseBody>
	
	/**
	 * 
	 * @param nomMedecin le nom du medecin
	 * pour acceder au nom de l'hopital ou travaille le medecin 
	 */
	@GET("hopital")
    fun hopital(@Query("nomMedecin") query: String): Call<ResponseBody>
		
    /**
	 * 
	 * @param specialite: la sepcialité du medecin
	 * pour acceder aux noms des medecins ayant cette specialité
	 */
	@GET("nomParSpecialite")
    fun nomParSpecialite(@Query("specialite") query: String): Call<List<String>>
		
	/**
	 * 
	 * @param hopital nom e l'hopital
	 * pour acceder a la liste de nom des medecins travaillant dans cet hopital
	 */
	@GET("nomParHopital")
    fun nomParHopital(@Query("hopital") query: String):  Call<List<String>>
	
		
	/**
	 * 
	 * pour acceder a  tous les noms de tous les medecins qui sont disponible
	 */
	@GET("nomParDisponibilite")
    fun nomParDisponibilite():  Call<List<String>>	
	
	/**
	 * 
	 * pour acceder à la liste de tous les vaccins de la base de donnée
	 */
	@GET("tousLesVacins")
    fun tousLesVacins(): Call<List<String>>
	
	/**
	 * 
	 * @param nomVaccin le nom du vaccin 
	 * pous savoir si un vaccin est obligatoire ou pas
	 */
	@GET("estObligatoire")
    fun estObligatoire(@Query("nomVaccin") query: String): Call<Boolean>
	
	
	
	
	/**
	 * 
	 * @param Pays nom du pays
	 * pour acceder à la liste de tous les vaccins en fonction du pays
	 */
	@GET("vaccinParPays")
	fun vaccinParPays(@Query("Pays") query: String): Call<List<String>>
	
	
}
