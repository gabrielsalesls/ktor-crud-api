package gabrielsalesls.github.io.respository

import gabrielsalesls.github.io.entity.PlaceTable
import gabrielsalesls.github.io.entity.PlaceTable.toPlace
import gabrielsalesls.github.io.entity.dbQuery
import gabrielsalesls.github.io.models.Place
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class PlaceRepository {
    suspend fun getAll(): List<Place> {
        val places: ArrayList<Place> = arrayListOf()

        dbQuery {
            PlaceTable
                .selectAll()
                .map {
                    places.add(it.toPlace())
                }
        }
        return places
    }

    suspend fun save(place: Place): List<Place> {

        val placeSaved = dbQuery {
            PlaceTable.insert {
                it[name] = place.name
                it[slug] = place.slug
                it[city] = place.city
                it[state] = place.state
                it[createdAt] = place.createdAt
                it[updatedAt] = place.updatedAt
            }
        }

        return placeSaved.resultedValues?.map { it.toPlace() } ?: listOf()
    }
}