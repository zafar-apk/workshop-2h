package screen.list


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

typealias RocketList = List<Rocket>

@Serializable
data class Rocket(
    @SerialName("description")
    val description: String?,
    @SerialName("rocket_name")
    val rocketName: String?,
    @SerialName("flickr_images")
    val flickrImages: List<String>
) {
    fun getFirstImageOrNull(): String? = flickrImages.firstOrNull()
}