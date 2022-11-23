package de.stuebingerb

abstract class AbstractPersistence<T, U> {

    open suspend fun fetch(identifier: U): T? = null
}

data class Product(val productId: String)

class ProductPersistence : AbstractPersistence<Product, String>()

class ProductRepository(private val productPersistence: ProductPersistence) {

    suspend fun load(productId: String) = productPersistence.fetch(productId)
}
