package gabrielsalesls.github.io.plugins

import gabrielsalesls.github.io.di.myModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(myModule)
    }
}