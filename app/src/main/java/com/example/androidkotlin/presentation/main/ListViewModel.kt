package com.example.androidkotlin.presentation.main


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidkotlin.data.remote.*
import com.example.androidkotlin.presentation.status.*
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListViewModel(
): ViewModel() {
    val apiLiveData: MutableLiveData<APIStatus> = MutableLiveData()
    private val BASE_URL = "https://raw.githubusercontent.com/Aqualio/TD3_list/master/"

    fun makeAPICall() {
    //    viewModelScope.launch(Dispatchers.IO) {

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            val skyrimapi = retrofit.create(Skyrimapi::class.java)

            val bruh: Call<RestSkyrimResponse>? = skyrimapi?.skyrimResponse

            if(bruh != null) {

                bruh.enqueue(object : Callback<RestSkyrimResponse?> {

                    override fun onResponse(
                        bruh: Call<RestSkyrimResponse?>?,
                        response: Response<RestSkyrimResponse?>
                    ) {
                        if (response.isSuccessful && response.body() != null) {
                            val charaList = response.body()!!.Liste
                            apiLiveData.value = APISuccess(charaList)
                        }
                    }

                    override fun onFailure(bruh: Call<RestSkyrimResponse?>?, t: Throwable?) {
                        apiLiveData.value = APIError
                    }
                })
            }

        }
   // }
}