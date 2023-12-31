package gabrielsalesls.github.io.dao

import gabrielsalesls.github.io.entity.PlaceTable
import io.ktor.server.config.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init(config: ApplicationConfig) {
        val driverClassName = config.property("storage.driverClassName").getString()
        val url = config.property("storage.url").getString()
        val user = config.property("storage.user").getString()
        val password = config.property("storage.password").getString()

        val database = Database.connect(
            url = url,
            driver = driverClassName,
            user = user,
            password = password)
        transaction(database) {
            SchemaUtils.create(PlaceTable)
        }
    }
}
