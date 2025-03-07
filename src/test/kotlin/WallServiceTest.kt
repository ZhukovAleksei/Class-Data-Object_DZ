import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun idNoZerro() {
        val service = WallService
        service.add(Post())
        assertEquals(1, service.array[0].id)
    }

    @Test
    fun updateTrue() {
        val service = WallService
        service.add(Post())
        var result = service.update(Post(id = 1, likes = Likes(5)))
        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        val service = WallService
        service.add(Post())
        var result = service.update(Post(likes = Likes(5)))
        assertFalse(result)
    }
}