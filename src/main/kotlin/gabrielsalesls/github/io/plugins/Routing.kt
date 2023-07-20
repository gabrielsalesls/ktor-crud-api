package gabrielsalesls.github.io.plugins

import gabrielsalesls.github.io.routes.placeRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        placeRouting()
    }
}
