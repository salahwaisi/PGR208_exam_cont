package no.hik.todoapp.helpers

import android.content.Context
import com.beust.klaxon.Klaxon
import no.hik.todoapp.models.DecisionMakerResult
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.*
import no.hik.todoapp.models.DecisionMakerHttpResponse


class DecisionMakerHelper {
    companion object {
        suspend fun getDecision(text: String): String {
            val client = HttpClient()

            val url = "https://8ball.delegator.com/magic/JSON/$text";

            val response = client.get(url)
            return response.bodyAsText()
        }

        fun getDecision(text: String, context: Context): DecisionMakerResult {
            var result = DecisionMakerResult.Neutral;

            runBlocking {
                launch {
                    var response = Klaxon().parse<DecisionMakerHttpResponse>(getDecision(text))

                    result = if (response != null) DecisionMakerResult.valueOf(response?.magic?.type) else DecisionMakerResult.Neutral;
                }
            }

            return result;
        }
    }
}