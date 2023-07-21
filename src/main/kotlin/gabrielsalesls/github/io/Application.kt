package gabrielsalesls.github.io

import gabrielsalesls.github.io.dao.DatabaseFactory
import gabrielsalesls.github.io.plugins.configureKoin
import gabrielsalesls.github.io.plugins.configureRouting
import gabrielsalesls.github.io.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit =
    EngineMain.main(args)

fun Application.module() {
    DatabaseFactory.init(environment.config)
    configureKoin()
    configureSerialization()
    configureRouting()
}
