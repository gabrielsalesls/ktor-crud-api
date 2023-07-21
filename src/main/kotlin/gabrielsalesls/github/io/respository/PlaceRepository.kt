package gabrielsalesls.github.io.respository

import gabrielsalesls.github.io.entity.PlaceTable
import gabrielsalesls.github.io.entity.PlaceTable.toPlace
import gabrielsalesls.github.io.entity.dbQuery
import gabrielsalesls.github.io.models.Place
import org.jetbrains.exposed.sql.selectAll

class PlaceRepository {
    suspend fun getAll(): List<Place> {
        val places: ArrayList<Place> = arrayListOf()

        dbQuery {
            PlaceTable
                .selectAll()
                .map {
                    places.add(it.toPlace()) }
        }
        return places
    }
}