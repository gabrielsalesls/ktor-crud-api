package gabrielsalesls.github.io.entity

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object PlaceTable: Table() {
    val id = long("id").autoIncrement()
    val name: Column<String> = varchar("name", 50)
    val slug: Column<String> = varchar("slug", 50)
    val city: Column<String> = varchar("city", 50)
    val state: Column<String> = varchar("state", 50)

    override val primaryKey = PrimaryKey(id)
}
