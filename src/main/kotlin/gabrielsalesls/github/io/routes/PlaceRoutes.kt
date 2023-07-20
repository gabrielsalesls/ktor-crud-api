package gabrielsalesls.github.io.routes

import gabrielsalesls.github.io.dto.PlaceRequest
import gabrielsalesls.github.io.dto.toModel
import gabrielsalesls.github.io.entity.PlaceTable
import gabrielsalesls.github.io.models.Place
import gabrielsalesls.github.io.models.toResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.placeRouting() {
    route("api/v1/places") {
        get {
            val allPlaces = transaction {
                PlaceTable
                    .selectAll()
                    .map { PlaceTable.toPlace(it) }
            }

            return@get call.respond(
                status = HttpStatusCode.OK,
                message = allPlaces.map { it.toResponse() })
        }

        post {
            val placeRequest = call.receive<PlaceRequest>()
            val placeModel: Place = placeRequest.toModel()

            //TODO: Envolver em um try-catch para validação
            //TODO: Remove from routing and add a service
            val result = transaction {
                PlaceTable.insert {
                    it[name] = placeModel.name
                    it[slug] = placeModel.slug
                    it[city] = placeModel.city
                    it[state] = placeModel.state
                    it[createdAt] = placeModel.createdAt
                    it[updatedAt] = placeModel.updatedAt
                }.resultedValues?.map { PlaceTable.toPlace(it) }
            }
            if (result != null) {
                return@post call.respond(
                    status = HttpStatusCode.Created,
                    message = result.map { it.toResponse() })
            }

        }
    }
}
