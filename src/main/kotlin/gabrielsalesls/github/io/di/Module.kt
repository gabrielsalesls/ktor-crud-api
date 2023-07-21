package gabrielsalesls.github.io.di

import gabrielsalesls.github.io.respository.PlaceRepository
import gabrielsalesls.github.io.service.PlaceService
import org.koin.dsl.module

val myModule = module {
    single { PlaceService(get()) }
    single { PlaceRepository() }
}