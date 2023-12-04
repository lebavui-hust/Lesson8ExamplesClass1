package vn.edu.hust.lesson8examples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import vn.edu.hust.lesson8examples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var count = 0
    val viewModel: MainViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.count = count

        binding.buttonAdd1.setOnClickListener {
            count++
            // binding.textCount1.text = "$count"
        }

        // Ap dung view model
        binding.buttonAdd2.setOnClickListener {
            viewModel.increaseCount()
        }

    }
}