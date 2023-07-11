package pl.asia.artshop.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert
    suspend fun addProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Update
    suspend fun updateProduct(product: Product)

    @Query("SELECT * FROM product")
    fun getProducts(): Flow<List<Product>>

    @Query("SELECT * FROM product WHERE id=(:id)")
    suspend fun getProduct(id: Int): Product
}