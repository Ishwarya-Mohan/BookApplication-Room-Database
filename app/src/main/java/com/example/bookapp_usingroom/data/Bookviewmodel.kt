package com.example.bookapp_usingroom.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application): AndroidViewModel(application) {

    private val repository:Bookrepository
    val readAllBooks:LiveData<List<Books>>
    init {
        val bookDao = BookDatabase.getDatabase(application).bookDao()
        repository= Bookrepository(bookDao)
        readAllBooks=bookDao.readAllBooks()
    }

    fun getBooksByAuthor(author:String):LiveData<List<Books>>
    {
        return repository.getBooksByAuthor(author)
    }

    fun addBook(book: Books)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBook(book)
        }
    }
    fun addAuthor(author: Author)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAuthor(author)
        }
    }
}