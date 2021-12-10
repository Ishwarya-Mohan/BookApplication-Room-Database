package com.example.bookapp_usingroom.data


    import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "author")

data class Author(@PrimaryKey(autoGenerate = true)
                  val author_id: Int,
                  val author: String,
                  val country: String)

