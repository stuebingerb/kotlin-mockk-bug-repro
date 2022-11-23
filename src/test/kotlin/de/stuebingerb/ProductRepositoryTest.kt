package de.stuebingerb

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class ProductRepositoryTest {

    private val persistenceMock: ProductPersistence = mockk()
    private val repository: ProductRepository = ProductRepository(persistenceMock)

    @Test
    fun test() {
        coEvery {
            persistenceMock.fetch(any())
        } returns null
        runBlocking {
            repository.load("foo")
        }
    }
}
