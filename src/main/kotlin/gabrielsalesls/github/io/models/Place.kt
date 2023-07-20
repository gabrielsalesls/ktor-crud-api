package gabrielsalesls.github.io.models

import gabrielsalesls.github.io.dto.PlaceResponse

data class Place(
    var id: Long? = null,
    var name: String,
    val slug: String,
    val city: String,
    val state: String,
    val createdAt: String,
    val updatedAt: String
)
fun Place.toResponse(): PlaceResponse {
    return PlaceResponse(
        this.id!!,
        this.name,
        this.slug,
        this.city,
        this.state,
        this.createdAt,
        this.updatedAt
    )
}
