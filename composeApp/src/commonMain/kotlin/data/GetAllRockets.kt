package data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import screen.list.RocketList

suspend fun getAllRockets(client: HttpClient): RocketList {
    return client.get {
        url("https://api.spacexdata.com/v3/rockets")
    }.body()
}