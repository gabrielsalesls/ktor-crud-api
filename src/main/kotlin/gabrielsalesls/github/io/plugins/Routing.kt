package gabrielsalesls.github.io.plugins

import gabrielsalesls.github.io.respository.PlaceRepository
import gabrielsalesls.github.io.routes.placeRouting
import gabrielsalesls.github.io.service.PlaceService
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        placeRouting(PlaceService(PlaceRepository()))
    }
}
