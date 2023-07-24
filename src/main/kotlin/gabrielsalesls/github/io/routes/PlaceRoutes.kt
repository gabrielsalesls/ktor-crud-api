package gabrielsalesls.github.io.routes

import gabrielsalesls.github.io.dto.PlaceRequest
import gabrielsalesls.github.io.dto.toModel
import gabrielsalesls.github.io.models.Place
import gabrielsalesls.github.io.models.toResponse
import gabrielsalesls.github.io.service.PlaceService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.placeRouting(service: PlaceService) {

    route("api/v1/places") {
        get {
            val allPlaces = service.getAll()

            return@get call.respond(
                status = HttpStatusCode.OK,
                message = allPlaces.map { it.toResponse() })
        }

        post {
            val placeRequest = call.receive<PlaceRequest>()
            val placeModel: Place = placeRequest.toModel()

            val result = service.save(placeModel)

            //TODO: Validar caso o resultRow esteja vazio

            return@post call.respond(
                status = HttpStatusCode.Created,
                message = result.map { it.toResponse() })
        }
    }
}
