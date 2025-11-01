// File: app/src/main/java/com/example/lab_4/data/database/ChiuitDbStore.kt
package com.example.lab_4.data.database

import com.example.lab_4.domain.Chiuit
import com.example.lab_4.domain.ChiuitRepository

class ChiuitDbStore(private val appDatabase: AppDatabase) : ChiuitRepository {

    override fun getAll(): List<Chiuit> {
        return appDatabase.chiuitDao().getAll().map { it.toDomainModel() }
    }

    // TODO 2: Add the new chiuit by invoking the DAO; make sure to use the designated mapper.
    override fun addChiuit(chiuit: Chiuit) {
        appDatabase.chiuitDao().insert(chiuit.toDbModel())
    }

    // TODO 5: Remove the chiuit by invoking the DAO; make sure to use the designated mapper.
    override fun removeChiuit(chiuit: Chiuit) {
        appDatabase.chiuitDao().delete(chiuit.toDbModel())
    }

    private fun Chiuit.toDbModel() = ChiuitEntity(timestamp, description)

    private fun ChiuitEntity.toDomainModel() = Chiuit(timestamp, description)
}
