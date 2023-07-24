package gabrielsalesls.github.io

import gabrielsalesls.github.io.dto.PlaceRequest
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ApplicationTest {

    @Test
    fun testApp() = testApplication {
        environment {
            config = ApplicationConfig("application-test.conf")
        }

        val client = createClient {
            install(ContentNegotiation) {
                gson()
            }
            followRedirects = false
        }

        val response = client.get("api/v1/places")
        assertEquals(HttpStatusCode.OK, response.status)

        client.post("api/v1/places") {
            contentType(ContentType.Application.Json)
            setBody(PlaceRequest("cidade", "slug", "city", "state"))
        }.let {
            println(it.bodyAsText())
            assertTrue { it.bodyAsText().contains("cidade") }
            assertEquals(HttpStatusCode.Created, it.status )

        }
    }
}
