package com.abdallah.sarrawi.myapplication

//import android.util.Log
import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Typeface
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity2 : AppCompatActivity() {

    private lateinit var recycler_msg: RecyclerView
    private lateinit var sharedPreferences: SharedPreferences

    private var font1: Typeface? = null
    private var font2: Typeface? = null
    private var font3: Typeface? = null
    private var font4: Typeface? = null
    private var font5: Typeface? = null
    private var font6: Typeface? = null
    private var font7: Typeface? = null
    private var Ffont: Typeface? = null
    private var msgAdapter: MsgAdapter? = null
    private var msg_list: List<Msg> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        initFonts()
        initRecyclerView()
        specifyFont()
    }

    private fun initFonts() {
        font1 = Typeface.createFromAsset(assets, "fonts/a.otf")
        font2 = Typeface.createFromAsset(assets, "fonts/ab.otf")
        font3 = Typeface.createFromAsset(assets, "fonts/ac.otf")
        font4 = Typeface.createFromAsset(assets, "fonts/ad.otf")
        font5 = Typeface.createFromAsset(assets, "fonts/ae.otf")
        font6 = Typeface.createFromAsset(assets, "fonts/af.otf")
        font7 = Typeface.createFromAsset(assets, "fonts/ag.otf")
    }

    private fun initRecyclerView() {
        (msg_list as ArrayList<Msg>).add(Msg(1,  "نونونتش"))
        (msg_list as ArrayList<Msg>).add(Msg(2,  "سسسس"))
        (msg_list as ArrayList<Msg>).add(Msg(3,  "بيسبسبسيب"))
        (msg_list as ArrayList<Msg>).add(Msg(4,  "بيسبيسبيسب"))
        (msg_list as ArrayList<Msg>).add(Msg(5,  "بيسبيسبيسيبسيس"))
        (msg_list as ArrayList<Msg>).add(Msg(6,  "aaaaa"))

        recycler_msg = findViewById(R.id.recycler_msg)
        recycler_msg.setHasFixedSize(true)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recycler_msg.layoutManager = mLayoutManager
        recycler_msg.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recycler_msg.itemAnimator = DefaultItemAnimator()

        msgAdapter = MsgAdapter(msg_list, this@MainActivity2, Ffont)
        recycler_msg.adapter = msgAdapter
        msgAdapter?.notifyDataSetChanged()
    }

    private fun specifyFont() {
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        val fontIndex = sp.getInt("font", 0) // استخراج رقم الخط المحدد

        Ffont = when (fontIndex) {
            0 -> font1
            1 -> font2
            2 -> font3
            3 -> font4
            4 -> font5
            5 -> font6
            6 -> font7
            else -> font1
        }

        msgAdapter?.setFont(Ffont)
        msgAdapter?.notifyDataSetChanged()
        val editor = sp.edit()
        editor.putInt("font", fontIndex)
        editor.apply()
    }

    private fun saveFontSettings(selectedFont: String) {
        val spEditor = sharedPreferences.edit()
        spEditor.putString("LIST_OF_FONTS", selectedFont)
        spEditor.apply()
    }
}


//class MainActivity2 : AppCompatActivity() {
//    private lateinit var recycler_msg: RecyclerView // قم بتعيين نوع الـ recycler_msg هنا
//
//    var font1: Typeface? = null
//    var font2:Typeface? = null
//    var font3:Typeface? = null
//    var font4:Typeface? = null
//    var font5:Typeface? = null
//    var font6:Typeface? = null
//    var font7:Typeface? = null
//    var Ffont: Typeface? = null
//    var msgAdapter: MsgAdapter?=null
//    var msg_list: List<Msg> = ArrayList()
//    lateinit var sharedPreferences: SharedPreferences
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
//        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
//        (msg_list as ArrayList<Msg>).add(Msg(1,  "نونونتش"))
//        (msg_list as ArrayList<Msg>).add(Msg(2,  "سسسس"))
//        (msg_list as ArrayList<Msg>).add(Msg(3,  "بيسبسبسيب"))
//        (msg_list as ArrayList<Msg>).add(Msg(4,  "بيسبيسبيسب"))
//        (msg_list as ArrayList<Msg>).add(Msg(5,  "بيسبيسبيسيبسيس"))
//        (msg_list as ArrayList<Msg>).add(Msg(6,  "aaaaa"))
//
//        // تهيئة الخط (font)
//
//
//        recycler_msg = findViewById(R.id.recycler_msg) // قم بتعيين recycler_msg بالشكل المحدد هنا
//        recycler_msg.setHasFixedSize(true)
//        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
//        recycler_msg.setLayoutManager(mLayoutManager)
//        recycler_msg.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
//        recycler_msg.setItemAnimator(DefaultItemAnimator())
//
//        // تحديد القيمة الفعلية لـ recycler_msg بعد تهيئتها
//        msgAdapter = MsgAdapter(msg_list, this@MainActivity2, Ffont)
//        recycler_msg.setAdapter(msgAdapter)
//        msgAdapter!!.notifyDataSetChanged()
//        font1 = Typeface.createFromAsset(assets, "fonts/a.otf")
//        font2 = Typeface.createFromAsset(assets, "fonts/ab.otf")
//        font3 = Typeface.createFromAsset(assets, "fonts/ac.otf")
//        font4 = Typeface.createFromAsset(assets, "fonts/ad.otf")
//        font5 = Typeface.createFromAsset(assets, "fonts/ae.otf")
//        font6 = Typeface.createFromAsset(assets, "fonts/af.otf")
//        font7 = Typeface.createFromAsset(assets, "fonts/ag.otf")
//        specifyFont()
//    }
//
//
////    private fun specifyFont() {
////        // ...
////        val fontName: String = sharedPreferences.getString("LIST_OF_FONTS", "a.otf") ?: "a.otf"
////
////        // تحديد الخط المحدد من الـ SharedPreferences
////        when (fontName) {
////            "a.otf" -> font = font1
////
////            "ab.otf" -> font = font2
////            "ac.otf" -> font = font3
////            "ad.otf" -> font = font4
////            "ae.otf" -> font = font5
////            "af.otf" -> font = font6
////            "ag.otf" -> font = font7
////            else -> font = font1 // تعيين الخط الافتراضي هنا
////        }
////
////        // تحديث الخط المحدد في MsgAdapter
////        msgAdapter?.setFont(font)
////
////        // إعادة تحميل قائمة الرسائل بالخط الجديد
////        msgAdapter?.notifyDataSetChanged()
////    }
////    private fun specifyFont() {
//////        String fontName = preferences.getString("LIST_OF_FONTS", "Chunkfive.otf");
////        val sp = PreferenceManager.getDefaultSharedPreferences(this)
////        Log.d(TAG, "specifyFont: $sp")
////        if (sp.getInt("font", 0) == 0) {
////            font1 = Typeface.createFromAsset(this.assets, "fonts/a.otf")
////            Ffont = font1
////            //msgTypesAdapter = new MsgTypesAdapter(msgTypes_list, this, font1, textSize);
////            //mRecyclerView.setAdapter(msgTypesAdapter);
////        } else if (sp.getInt("font", 0) == 1) {
////            Log.d(TAG, "specifyFont: 2")
////            font2 = Typeface.createFromAsset(this.assets, "fonts/ab.otf")
////            Ffont = font2
////            //msgTypesAdapter = new MsgTypesAdapter(msgTypes_list, this, font2, textSize);
////            //mRecyclerView.setAdapter(msgTypesAdapter);
////        } else if (sp.getInt("font", 0) == 2) {
////            Log.d(TAG, "specifyFont: 3")
////            font3 = Typeface.createFromAsset(this.assets, "fonts/ac.otf")
////            Ffont = font3
////            //msgTypesAdapter = new MsgTypesAdapter(msgTypes_list, this, font3, textSize);
////            //mRecyclerView.setAdapter(msgTypesAdapter);
////        } else if (sp.getInt("font", 0) == 3) {
////            Log.d(TAG, "specifyFont: 4")
////            font4 = Typeface.createFromAsset(this.assets, "fonts/ad.otf")
////            Ffont = font4
////            //msgTypesAdapter = new MsgTypesAdapter(msgTypes_list, this, font4, textSize);
////            //mRecyclerView.setAdapter(msgTypesAdapter);
////        } else if (sp.getInt("font", 0) == 4) {
////            Log.d(TAG, "specifyFont: 5")
////            font5 = Typeface.createFromAsset(this.assets, "fonts/ae.otf")
////            Ffont = font5
////            //msgTypesAdapter = new MsgTypesAdapter(msgTypes_list, this, font5, textSize);
////            // mRecyclerView.setAdapter(msgTypesAdapter);
////        } else if (sp.getInt("font", 0) == 5) {
////            Log.d(TAG, "specifyFont: 6")
////            font6 = Typeface.createFromAsset(this.assets, "fonts/af.otf")
////            Ffont = font6
////            //msgTypesAdapter = new MsgTypesAdapter(msgTypes_list, this, font6, textSize);
////            //mRecyclerView.setAdapter(msgTypesAdapter);
////        } else if (sp.getInt("font", 0) == 6) {
////            Log.d(TAG, "specifyFont: 7")
////            font7 = Typeface.createFromAsset(this.assets, "fonts/ag.otf")
////            Ffont = font7
////            //msgTypesAdapter = new MsgTypesAdapter(msgTypes_list, this, font7, textSize);
////            //mRecyclerView.setAdapter(msgTypesAdapter);
////        }
////        //mRecyclerView.setAdapter(msgTypesAdapter);
////        msgAdapter!!.setFont(Ffont)
////        msgAdapter!!.notifyDataSetChanged()
////
////    }
//
//
//    private fun specifyFont() {
//        val sp = PreferenceManager.getDefaultSharedPreferences(this)
//        Log.d(TAG, "specifyFont: $sp")
//        var fontIndex = sp.getInt("font", 0) // استخراج رقم الخط المحدد
//
//        Ffont = when (fontIndex) {
//            0 -> font1
//            1 -> font2
//            2 -> font3
//            3 -> font4
//            4 -> font5
//            5 -> font6
//            6 -> font7
//            else -> font1
//        }
//
//        // حفظ رقم الخط المحدد بعد تغييره
////        sp.edit().putInt("font", fontIndex).apply()
//
//        msgAdapter?.setFont(Ffont)
//        msgAdapter?.notifyDataSetChanged()
//        val editor = sp.edit()
//        editor.putInt("font", fontIndex)
//        editor.apply()
//    }
//
//
//    override fun onResume() {
//        super.onResume()
//        specifyFont()
//    }
//
//    override fun onPause() {
//        super.onPause()
//        specifyFont()
//    }
//
//    override fun onStop() {
//        super.onStop()
//        specifyFont()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        specifyFont()
//
//    }
//    private fun saveFontSettings(selectedFont: String) {
//        val spEditor = sharedPreferences.edit()
//        spEditor.putString("LIST_OF_FONTS", selectedFont)
//        spEditor.apply()
//    }
//}

