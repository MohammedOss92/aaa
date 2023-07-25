package com.abdallah.sarrawi.myapplication

//import android.util.Log
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    private lateinit var recycler_msg: RecyclerView

    var font: Typeface? = null

    var msgAdapter: MsgAdapter? = null
    var msg_list: List<Msg> = ArrayList()
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        (msg_list as ArrayList<Msg>).add(Msg(1,  "نونونتش"))
        (msg_list as ArrayList<Msg>).add(Msg(2,  "سسسس"))
        (msg_list as ArrayList<Msg>).add(Msg(3,  "بيسبسبسيب"))
        (msg_list as ArrayList<Msg>).add(Msg(4,  "بيسبيسبيسب"))
        (msg_list as ArrayList<Msg>).add(Msg(5,  "بيسبيسبيسيبسيس"))
        (msg_list as ArrayList<Msg>).add(Msg(6,  "aaaaa"))


        recycler_msg = findViewById(R.id.recycler_msg)
        recycler_msg.setHasFixedSize(true)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recycler_msg.setLayoutManager(mLayoutManager)
        recycler_msg.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recycler_msg.setItemAnimator(DefaultItemAnimator())

        // Initialize the MsgAdapter with a default font
        font = Typeface.createFromAsset(assets, "fonts/a.otf")
        msgAdapter = MsgAdapter(msg_list, this@MainActivity2, font)
        recycler_msg.setAdapter(msgAdapter)
        msgAdapter?.notifyDataSetChanged()

        specifyFont()
    }

    private fun specifyFont() {
        val fontName: String = sharedPreferences.getString("LIST_OF_FONTS", "a.otf") ?: "a.otf"

        font = when (fontName) {
            "a.otf" -> Typeface.createFromAsset(assets, "fonts/a.otf")
            "ab.otf" -> Typeface.createFromAsset(assets, "fonts/ab.otf")
            // Add more font options as needed
            else -> Typeface.createFromAsset(assets, "fonts/a.otf") // Default font
        }

        // Update the font in the existing MsgAdapter and notify the RecyclerView
        msgAdapter?.setFont(font!!)
        msgAdapter?.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        specifyFont()
    }

    override fun onPause() {
        super.onPause()
    }
}
