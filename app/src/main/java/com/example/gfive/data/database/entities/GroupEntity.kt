package com.example.gfive.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.Date


@Entity(tableName = "tbl_group")
data class GroupEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val groupName: String,
    val createDate: Date = Date(),
)