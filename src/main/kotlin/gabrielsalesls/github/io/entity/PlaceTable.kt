package gabrielsalesls.github.io.entity

import gabrielsalesls.github.io.models.Place
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object PlaceTable : Table() {
    private val id = long("id").autoIncrement()

    val name: Column<String> = varchar("name", 50)
    val slug: Column<String> = varchar("slug", 50)
    val city: Column<String> = varchar("city", 50)
    val state: Column<String> = varchar("state", 50)

    val createdAt: Column<String> = varchar("created_at", 100)
    val updatedAt: Column<String> = varchar("updated_at", 100)

    override val primaryKey = PrimaryKey(id)

    fun toPlace(row: ResultRow): Place = Place(
        id = row[id],
        name = row[name],
        slug = row[slug],
        city = row[city],
        state = row[state],
        createdAt = row[createdAt],
        updatedAt = row[updatedAt]
    )
}

