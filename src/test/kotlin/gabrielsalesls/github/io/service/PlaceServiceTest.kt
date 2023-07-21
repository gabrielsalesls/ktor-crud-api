package gabrielsalesls.github.io.service

import gabrielsalesls.github.io.models.Place
import gabrielsalesls.github.io.respository.PlaceRepository
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PlaceServiceTest {

    @InjectMockKs
    lateinit var service: PlaceService

    @MockK
    private lateinit var repository: PlaceRepository

    @Before
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `get all places`() {
        runBlocking {
            val expected = listOf(
                Place(1, "name", "slug", "city", "state", "created", "uptaded")
            )

            coEvery { repository.getAll() } returns expected

            val result = service.getAll()

            coVerify(exactly = 1) { repository.getAll() }
            Assert.assertEquals(1, result.size)
        }


    }





    @Test
    fun save() {
    }
}