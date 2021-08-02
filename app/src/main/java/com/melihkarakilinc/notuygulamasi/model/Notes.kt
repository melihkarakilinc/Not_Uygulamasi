package com.melihkarakilinc.notuygulamasi.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "note_table")
@Parcelize
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "baslik")
    var baslik: String,

    @ColumnInfo(name = "icerik")
    var icerik: String,
) : Parcelable{}
