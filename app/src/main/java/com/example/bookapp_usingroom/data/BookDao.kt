package com.example.bookapp_usingroom.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDao {
    //Author
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAuthor(author: Author)

    //Books
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addBook(book: Books)

    @Query("SELECT * FROM books")
    fun readAllBooks(): LiveData<List<Books>>

    @Query("SELECT * FROM books WHERE author=:author LIMIT 3")
    fun readBooks(author: String): LiveData<List<Books>>
}