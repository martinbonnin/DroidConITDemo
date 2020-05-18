package net.mbonnin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.toDeferred
import com.apollographql.apollo.exception.ApolloException
import demo.droidcon.ViewerQuery
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        val okHttpClient = ApolloClient.builder()
            .serverUrl("https://api.github.com/graphql")
            .okHttpClient(newOkhttpClient(this))
            .build()

        lifecycleScope.launchWhenResumed {
            val response = try {
                okHttpClient.query(ViewerQuery()).toDeferred().await()
            } catch (e: Exception) {
                TODO("do some proper error handling")
            }

            val viewer = response.data?.viewer

            findViewById<TextView>(R.id.name).text = viewer?.name
            findViewById<TextView>(R.id.bio).text = viewer?.bio
            findViewById<TextView>(R.id.status).text = viewer?.status?.message

        }

    }
}
