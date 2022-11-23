package de.stuebingerb

import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import kotlin.reflect.KProperty1

abstract class AbstractPersistence<T, U>(
    val idProperty: KProperty1<T, U>
) : KoinComponent {
    protected open suspend fun fromDocument(doc: U): T = doc as T

    suspend fun fetch(identifier: U): T? = fromDocument(identifier)
}

data class Product(val productId: String)

class ProductPersistence : AbstractPersistence<Product, String>(Product::productId)

class ProductRepository : KoinComponent {
    private val productPersistence: ProductPersistence = get()

    suspend fun load(productId: String) = productPersistence.fetch(productId)
}
