package com.example.searchgourmet.presentation.search_shops

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.searchgourmet.domain.use_case.SearchShopsUseCase
import com.example.searchgourmet.utils.Constants.API_KEY
import com.example.searchgourmet.utils.Constants.QUERY_API_KEY
import com.example.searchgourmet.utils.Constants.QUERY_FORMAT
import com.example.searchgourmet.utils.Constants.QUERY_KEYWORD
import com.example.searchgourmet.utils.NetWorkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchShopsViewModel @Inject constructor(
 private val searchShopsUseCase: SearchShopsUseCase
): ViewModel() {

    private var _state = mutableStateOf(SearchShopsState())
    val state: State<SearchShopsState> get() =  _state
    //TODO: 検索条件の要素を追加　＆　検索時クエリ作成メソッド追加

    //テスト用
    init {
        val queries: HashMap<String, String> = HashMap()
        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_KEYWORD] = "和食"
        queries[QUERY_FORMAT] = "json"
        searchShops(queries)
    }

    fun searchShops(queries: Map<String, String>) {
        searchShopsUseCase(queries).onEach { result ->
            when(result) {
                is NetWorkResponse.Failure -> {
                    _state.value = SearchShopsState(error = result.error)
                }
                is NetWorkResponse.Loading -> {
                    _state.value = SearchShopsState(isLoading = true)
                }
                is NetWorkResponse.Success -> {
                    _state.value = SearchShopsState(shops = result.data)
                }
            }
        }
    }
}