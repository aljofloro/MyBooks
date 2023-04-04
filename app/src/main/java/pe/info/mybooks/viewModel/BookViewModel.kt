package pe.info.mybooks.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.info.mybooks.model.Item
import pe.info.mybooks.network.ApiService

class BookViewModel: ViewModel() {

  var bookListResponse: List<Item> by mutableStateOf(listOf())
  var errorMessage: String by mutableStateOf("")
  var searchField: String by mutableStateOf("")

  fun getBookList(parametro: String){
    viewModelScope.launch {
      val apiService = ApiService.getInstance()
      try{
        val bookList = apiService.getBooksByTitle(parametro)
        bookListResponse = bookList.items
      }catch (e:Exception){
        errorMessage = e.message.toString()
      }
    }
  }
}