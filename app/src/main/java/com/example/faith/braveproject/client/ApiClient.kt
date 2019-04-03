package com.example.faith.braveproject.client

import com.example.faith.braveproject.util.Constant
import java.util.HashMap

class ApiClient:Dependencies() {

    /*
    static variable
    */

    companion object {
        private lateinit var serverAPI: ResponseListener
        val newApiClientInstance=ApiClient()
    }

    /*
        return server api instance
    */

    fun getServerAPI():ResponseListener{
        serverAPI = provideRestApi(ResponseListener::class.java, null)
        return serverAPI
    }

    /*
    Base URL Initialization
    */

    override fun getBaseUrl(): String {

        return Constant.BaseURL
    }

    /*
    Header Initialization
    */
    override fun getHeaders(): HashMap<String, String> {
        val params = HashMap<String, String>()
        params.put("Accept", "application/json")
        params.put("Authorization", "Bearer np6ttw4zdu83x34jcxg8enyc")
        params.put("X-Originating-IP", "105.160.197.97")
        return params
    }

}