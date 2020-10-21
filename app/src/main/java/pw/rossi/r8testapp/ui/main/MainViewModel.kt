package pw.rossi.r8testapp.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(
    delegate: DelegateInterface
) : ViewModel(), DelegateInterface by delegate {
    override fun onCleared() {
        super.onCleared()
        try {
            // This will throw `null` if minified. The debug print inside clear() implementation
            // won't be output.
            clear()
        } catch (e: NullPointerException) {
            Log.d("MainViewModel", "Caught NullPointerException", e)
        }
    }
}

interface DelegateInterface {
    fun clear()
}

class DelegateImpl : DelegateInterface, ViewModel() {
    init {
        Log.d("DelegateImpl", "init")
    }

    // Note that the interface has a `clear()` method and `ViewModel` has a final `clear()` method.
    override fun clear() {
        // Will never be called when minified
        Log.d("DelegateImpl", "clear() called")
    }
}
