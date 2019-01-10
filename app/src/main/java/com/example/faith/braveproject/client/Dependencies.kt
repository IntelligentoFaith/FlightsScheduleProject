package com.example.faith.braveproject.client

import android.util.Log
import com.example.faith.braveproject.BuildConfig

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.security.cert.CertificateException
import java.util.HashMap
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

abstract class Dependencies
{

    protected fun <S> provideRestApi(classService: Class<S>, baseUrl: String?): S {
        var baseUrl = baseUrl
        val okHttpClient = provideOkHttpClientDefault(provideHttpLoggingInterceptor())

        if (baseUrl == null)
            baseUrl = getBaseUrl()
        val builder = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create().asLenient().withNullSerialization())

        Log.d("asdfasd",builder.build().toString())
        return builder.build().create(classService)
    }

    protected fun provideOkHttpClientDefault(interceptor:HttpLoggingInterceptor): OkHttpClient {
        val okBuilder = OkHttpClient.Builder()
      //  okBuilder.addInterceptor(ConnectivityInterceptor())
        okBuilder.addInterceptor(interceptor)

        okBuilder.addInterceptor { chain ->

            var request = chain.request()
            val url = request.url().newBuilder().build()

            val builder = request.newBuilder().url(url)
            val headers = getHeaders()
            if (headers != null && headers.size > 0) {
                for ((key, value) in headers) {
                    builder.addHeader(key, value)
                    Log.e(key, value)
                }
            }
            chain.proceed(builder.build())
        }
        var timeout = getTimeOut()
        //------------------------------------------ Certificate code ---------------------------------------
        // Create a trust manager that does not validate certificate chains
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            @Throws(CertificateException::class)
            override fun checkClientTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {
            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {
            }

            override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                return arrayOf()
            }
        })

        // Install the all-trusting trust manager
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())
        // Create an ssl socket factory with our all-trusting manager
        val sslSocketFactory = sslContext.socketFactory
        okBuilder.sslSocketFactory(sslSocketFactory)
        okBuilder.hostnameVerifier { hostname, session -> true }

        //--------------------------------------------------------------------------------------------



        okBuilder.connectTimeout(timeout.toLong(), TimeUnit.SECONDS)
        okBuilder.readTimeout(timeout.toLong(), TimeUnit.SECONDS)
        okBuilder.writeTimeout(timeout.toLong(), TimeUnit.SECONDS)


        return okBuilder.build()
    }

    protected fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return interceptor
    }





    fun getTimeOut(): Int {
        return 30
    }

    fun getZeroTimeOut():Int {
        return 1
    }


    abstract fun getBaseUrl(): String

    abstract fun getHeaders(): HashMap<String, String>


}