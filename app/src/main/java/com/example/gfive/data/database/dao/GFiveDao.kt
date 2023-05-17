package com.example.gfive.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.gfive.data.database.entities.GroupEntity
import kotlinx.coroutines.selects.select
import kotlinx.coroutines.flow.Flow

@Dao
interface GFiveDao {
    @Insert
    suspend fun createGroup(groupEntity: GroupEntity)

    @Update
    suspend fun updateGroup(groupEntity: GroupEntity)

    @Delete
    suspend fun deleteGroup(groupEntity: GroupEntity)

    @Query("SELECT * FROM tbl_group")
    suspend fun getAllGroups(): Flow<List<GroupEntity>>
}