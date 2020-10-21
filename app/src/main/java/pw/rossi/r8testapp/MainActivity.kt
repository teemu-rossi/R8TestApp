package pw.rossi.r8testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.core.os.postDelayed
import pw.rossi.r8testapp.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }

        handler.postDelayed(100) {
            Log.d("MainActivity", "Removing fragment after delay")
            supportFragmentManager.findFragmentById(R.id.container)?.let {
                supportFragmentManager.beginTransaction()
                    .remove(it)
                    .commitNow()
            }
        }
    }
}
