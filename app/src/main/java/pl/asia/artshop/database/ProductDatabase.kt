package pl.asia.artshop.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}

object ProductDb{
    private var db: ProductDatabase? = null

    fun getInstance(context: Context): ProductDatabase{
        if (db == null){
            db = Room.databaseBuilder(
                context,
                ProductDatabase::class.java,
                "product-database"
            )
                .createFromAsset(databaseFilePath = "database/product.db")
                .build()
        }
        return db!!
    }
}

