package gabrielsalesls.github.io.entity

import gabrielsalesls.github.io.models.Place
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

object PlaceTable : Table() {
    private val id = long("id").autoIncrement()

    val name: Column<String> = varchar("name", 50)
    val slug: Column<String> = varchar("slug", 50)
    val city: Column<String> = varchar("city", 50)
    val state: Column<String> = varchar("state", 50)

    val createdAt: Column<String> = varchar("created_at", 100)
    val updatedAt: Column<String> = varchar("updated_at", 100)

    override val primaryKey = PrimaryKey(id)

    fun ResultRow.toPlace(): Place = Place(
        id = this[id],
        name = this[name],
        slug = this[slug],
        city = this[city],
        state = this[state],
        createdAt = this[createdAt],
        updatedAt = this[updatedAt]
    )
}

suspend fun <T> dbQuery(block: suspend () -> T): T =
    newSuspendedTransaction(Dispatchers.IO) { block() }