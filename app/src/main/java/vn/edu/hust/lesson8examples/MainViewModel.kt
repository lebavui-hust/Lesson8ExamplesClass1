package vn.edu.hust.lesson8examples

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap

class MainViewModel: ViewModel() {
    var count = MutableLiveData<Int>(0)
    fun increaseCount() {
        count.postValue(count.value!! + 1)
    }

    var text1 = MutableLiveData<String>("")
    val textReverse: LiveData<String> = text1.map {
        it.reversed()
    }

    var textA = MutableLiveData<String>("")
    var textB = MutableLiveData<String>("")
    var AorB = MutableLiveData<Boolean>(true)

    val textSwitch: LiveData<String> = AorB.switchMap {
        if (it) textA else textB
    }
}