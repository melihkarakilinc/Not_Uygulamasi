package com.melihkarakilinc.notuygulamasi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "baslik")
    var baslik: String,

    @ColumnInfo(name = "icerik")
    var icerik: String,
) {
}