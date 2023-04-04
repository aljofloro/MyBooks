package pe.info.mybooks.network

import pe.info.mybooks.model.GoogleBookRespond
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

  @GET("?")
  suspend fun getBooksByTitle(@Query("q") searchTerm: String):GoogleBookRespond

  companion object{
    var apiService: ApiService? = null
    fun getInstance():ApiService{
      if(apiService == null){
        apiService = Retrofit.Builder()
          .baseUrl("https://www.googleapis.com/books/v1/volumes/")
          .addConverterFactory(GsonConverterFactory.create())
          .build().create(ApiService::class.java)
      }
      return apiService!!
    }
  }
}