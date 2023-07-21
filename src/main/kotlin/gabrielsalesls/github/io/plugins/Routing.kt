package gabrielsalesls.github.io.plugins

import gabrielsalesls.github.io.routes.placeRouting
import gabrielsalesls.github.io.service.PlaceService
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    val service: PlaceService by inject()

    routing {
        placeRouting(service)
    }
}