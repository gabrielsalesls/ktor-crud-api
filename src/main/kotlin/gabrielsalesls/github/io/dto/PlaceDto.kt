package gabrielsalesls.github.io.dto

import gabrielsalesls.github.io.models.Place
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class PlaceRequest(
    var name: String,
    val slug: String,
    val city: String,
    val state: String,
)

fun PlaceRequest.toModel(): Place {
    return Place(
        name = this.name,
        slug = this.slug,
        city = this.city,
        state = this.state,
        createdAt = LocalDateTime.now().toString(),
        updatedAt = LocalDateTime.now().toString()
    )
}

@Serializable
data class PlaceResponse(
    val id: Long,
    val name: String,
    val slug: String,
    val city: String,
    val state: String,
    val createdAt: String,
    val updatedAt: String
)

