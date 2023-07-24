package gabrielsalesls.github.io.service

import gabrielsalesls.github.io.models.Place
import gabrielsalesls.github.io.respository.PlaceRepository


class PlaceService(val repository: PlaceRepository) {
    suspend fun getAll(): List<Place> {
        return repository.getAll()
    }

    suspend fun save(place: Place): List<Place> {
        return repository.save(place)
    }
}