package gabrielsalesls.github.io.service

import gabrielsalesls.github.io.entity.PlaceTable
import gabrielsalesls.github.io.entity.PlaceTable.toPlace
import gabrielsalesls.github.io.entity.dbQuery
import gabrielsalesls.github.io.models.Place
import gabrielsalesls.github.io.respository.PlaceRepository
import org.jetbrains.exposed.sql.insert


class PlaceService(val repository: PlaceRepository) {
    suspend fun getAll(): List<Place> {
        return repository.getAll()
    }

    suspend fun save(place: Place) = dbQuery {
        PlaceTable.insert {
            it[name] = place.name
            it[slug] = place.slug
            it[city] = place.city
            it[state] = place.state
            it[createdAt] = place.createdAt
            it[updatedAt] = place.updatedAt
        }.resultedValues?.map { it.toPlace() }
    }
}