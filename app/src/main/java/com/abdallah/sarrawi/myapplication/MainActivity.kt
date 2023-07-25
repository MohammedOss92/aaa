package com.abdallah.sarrawi.myapplication

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var spFont: Spinner
    lateinit var button: Button
    var theSelectedFontPosition = 0

    val font = arrayOf(
        "الخط الافتراضي",
        "الخط الاول",
        "الخط الثاني",
        "الخط الثالث",
        "الخط الرابع",
        "الخط الخامس",
        "الخط السادس"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var aFont = ArrayAdapter(this, android.R.layout.simple_list_item_1, font)
        spFont=findViewById(R.id.spinner)
        button=findViewById(R.id.textView)

        spFont.adapter=aFont;

        spFont.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?,
                position: Int, id: Long
            ) {
                theSelectedFontPosition = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // TODO Auto-generated method stub
            }
        }

        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        //SharedPreferences sp2=getSharedPreferences("MyPref", MODE_WORLD_WRITEABLE);
        sp.edit()

        with(sp.edit()) {
            putInt("font", theSelectedFontPosition)
            apply()
        }

        button.setOnClickListener {
            with(sp.edit()) {
                putInt("font", theSelectedFontPosition)
                apply()

            }
            val intent=Intent(this@MainActivity,MainActivity2::class.java)
            startActivity(intent)
        }
        Ffont();
    }

    fun Ffont() {
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        if (sp.getInt("font", 0) == 0) {
            spFont.setSelection(0)
        } else if (sp.getInt("font", 0) == 1) {
            spFont.setSelection(1)
        }
        if (sp.getInt("font", 0) == 2) {
            spFont.setSelection(2)
        } else if (sp.getInt("font", 0) == 3) {
            spFont.setSelection(3)
        }
        if (sp.getInt("font", 0) == 4) {
            spFont.setSelection(4)
        } else if (sp.getInt("font", 0) == 5) {
            spFont.setSelection(5)
        } else if (sp.getInt("font", 0) == 6) {
            spFont.setSelection(6)
        }
    }
}