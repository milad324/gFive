package com.example.gfive.ui.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.gfive.ui.data.database.entities.DeckEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GFiveDao {
    @Insert
    suspend fun createGroup(groupEntity: DeckEntity)

    @Update
    suspend fun updateGroup(groupEntity: DeckEntity)

    @Delete
    suspend fun deleteGroup(groupEntity: DeckEntity)

    @Query("SELECT * FROM tbl_group")
    fun getAllGroups(): Flow<List<DeckEntity>>
}