package org.csuf.cpsc411.simplehttpclient

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import java.lang.reflect.Type

class PersonService (val ctx : CustomActivity){

    lateinit var claimList: MutableList<Person>
   inner class GetAllServiceRespHandler : AsyncHttpResponseHandler()
   {
       override fun onSuccess(
           statusCode: Int,
           headers: Array<out Header>?,
           responseBody: ByteArray?
       ) {
           if(responseBody !=null)
           {
               Log.d("Person Service", "The response JSON string is ${String(responseBody)}")
               val gson = Gson()
               val claimListType : Type = object : TypeToken<List<Person>>(){}.type
               claimList = gson.fromJson(String(responseBody),claimListType)
               Log.d("Claim Service", "The Person List: ${claimList}")
           }
       }

       override fun onFailure(
           statusCode: Int,
           headers: Array<out Header>?,
           responseBody: ByteArray?,
           error: Throwable?
       ) {

       }

   }

    inner class addServiceRespHandler : AsyncHttpResponseHandler()
    {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            // JSON string
            if (responseBody != null)
            {
                val respStr = String(responseBody)
                Log.d("Person Service", "The add service response: ${respStr}")
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            Log.d("Person Service", "Error from PersonService.Kt-> addClaim")
        }
    }

    //This is actually a claim but uses the
    fun addClaim(pObj : Person) {

        //1. make the client
        val client = AsyncHttpClient()
        //2.register IP
        val requestUrl = "http://192.168.1.84:8080/ClaimService/add"

        // 3. Convert the pObj into JSON string
        val claimJsonString= Gson().toJson(pObj)
        val entity = StringEntity(claimJsonString)

        // cxt is an Android Application Context object
        client.post(ctx, requestUrl, entity,"application/json", addServiceRespHandler())
    }

    fun getAll()
    {
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.1.84:8080/ClaimService/getAll"
        Log.d("Claim Service", "About sending the HTTP Request")
         client.get(requestUrl,GetAllServiceRespHandler())
    }

}