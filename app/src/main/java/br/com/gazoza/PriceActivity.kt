package br.com.gazoza

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class PriceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_price)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val Price = findViewById<TextInputEditText>(R.id.PriceImput)
        val Next = findViewById<AppCompatImageButton>(R.id.Next)
        Next.setOnClickListener {
            val PriceStr: String = Price.text.toString()
            if (PriceStr == "") {
                val snackbar = Snackbar.make(
                    Price,
                    "Digite quanto custa o litro do seu combustível.",
                    Snackbar.LENGTH_LONG
                )
                snackbar.show()
            } else {
                val RS = PriceStr.toFloat()
                val GoToNextActivity = Intent(this, Result::class.java)
                GoToNextActivity.putExtra(Key, RS)
                startActivity(GoToNextActivity)
                println(PriceStr)
            }
        }
    }
}