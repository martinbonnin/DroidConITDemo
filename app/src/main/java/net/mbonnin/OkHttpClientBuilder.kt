package net.mbonnin

import android.content.Context
import okhttp3.OkHttpClient

fun newOkhttpClient(context: Context): OkHttpClient {
    val token = context.resources.openRawResource(R.raw.token).reader().readText()
    return OkHttpClient.Builder()
        .addInterceptor {chain ->
            chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
                .let {request ->
                    chain.proceed(request = request)
                }
        }
        .build()
}
