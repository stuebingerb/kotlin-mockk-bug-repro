package de.stuebingerb

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.inject
import org.koin.test.junit5.AutoCloseKoinTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class ProductRepositoryTest : AutoCloseKoinTest() {

    private val persistenceMock: ProductPersistence by inject()
    private val repository: ProductRepository by inject()

    @BeforeTest
    fun setup() {
        startKoin {
            modules(
                module {
                    single { ProductRepository() }
                    single { mockk<ProductPersistence>() }
                })
        }
    }

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
