package data

object ClientHolder {
    val client by lazy {
        createHttpClient()
    }
}