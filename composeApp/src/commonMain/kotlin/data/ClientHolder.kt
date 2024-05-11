package data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object ClientHolder {

    val httpClient by lazy {
        val engine = createHttpEngine()
        HttpClient(engine) {
            install(ContentNegotiation) {
                val config = Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }
                json(config)
            }
        }
    }
}