package de.stuebingerb

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class ProductRepositoryTest {

    private val persistenceMock: ProductPersistence = mockk()
    private val repository: ProductRepository = ProductRepository(persistenceMock)

    @Test
    fun test() {
        val expected = Product("foo")
        coEvery {
            persistenceMock.fetch(any())
        } returns expected
        runBlocking {
            assertEquals(expected, repository.load("foo"))
        }
    }
}
