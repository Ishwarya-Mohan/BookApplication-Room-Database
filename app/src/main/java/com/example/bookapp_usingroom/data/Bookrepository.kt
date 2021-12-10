package com.example.bookapp_usingroom.data

import androidx.lifecycle.LiveData

class Bookrepository(private val bookDao: BookDao) {
    val readAllBooks: LiveData<List<Books>> = bookDao.readAllBooks()

    fun getBooksByAuthor(author:String):LiveData<List<Books>>
    {
        return bookDao.readBooks(author)
    }

    fun addBook(book: Books)
    {
        bookDao.addBook(book)
    }

    fun addAuthor(author: Author)
    {
        bookDao.addAuthor(author)
    }

}