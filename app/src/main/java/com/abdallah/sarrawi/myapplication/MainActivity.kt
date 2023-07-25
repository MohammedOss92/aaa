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
    // تعريف المتغيرات الخاصة بمكونات واجهة المستخدم
    lateinit var spFont: Spinner
    lateinit var button: Button
    var theSelectedFontPosition = 0

    // تعريف مصفوفة بخيارات الخط المتاحة
    val font = arrayOf(
        "الخط الافتراضي",
        "الخط الاول",
        "الخط الثاني"
    )

    // دالة onCreate تستدعى عند بدء تشغيل النشاط
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // تهيئة المكونات وربطها بمكونات واجهة المستخدم
        var aFont = ArrayAdapter(this, android.R.layout.simple_list_item_1, font)
        spFont=findViewById(R.id.spinner)
        button=findViewById(R.id.textView)

        spFont.adapter=aFont;

        // تعيين دالة استماع للـ Spinner لتحديد الموضع المختار
        spFont.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?,
                position: Int, id: Long
            ) {
                theSelectedFontPosition = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // دالة فارغة للتعامل مع حالة عدم تحديد شيء في الـ Spinner
            }
        }

        // الحصول على كائن SharedPreferences لإدارة الإعدادات
        val sp = PreferenceManager.getDefaultSharedPreferences(this)

        // حفظ الموضع المختار في الـ Spinner في SharedPreferences
        sp.edit().apply {
            putInt("font", theSelectedFontPosition)
            apply()
        }

        // إنشاء استجابة للنقر على الزر (Button)
        button.setOnClickListener {
            // حفظ الموضع المختار في الـ Spinner في SharedPreferences
            sp.edit().apply {
                putInt("font", theSelectedFontPosition)
                apply()
            }

            // إنشاء كائن Intent للانتقال إلى الشاشة الثانية (MainActivity2)
            val intent=Intent(this@MainActivity,MainActivity2::class.java)
            // بدء النشاط (MainActivity2)
            startActivity(intent)
        }

        // تحديث الخط المختار عند بدء تشغيل النشاط
        Ffont()
    }

    // دالة لتحديث الخط المختار في الـ Spinner
    fun Ffont() {
        // الحصول على كائن SharedPreferences للوصول إلى الإعدادات المحفوظة
        val sp = PreferenceManager.getDefaultSharedPreferences(this)

        // تحديد الموضع المختار للخط في الـ Spinner وفقًا للقيمة المحفوظة في SharedPreferences
        when (sp.getInt("font", 0)) {
            0 -> spFont.setSelection(0)
            1 -> spFont.setSelection(1)
            2 -> spFont.setSelection(2)
            3 -> spFont.setSelection(3)
            4 -> spFont.setSelection(4)
            5 -> spFont.setSelection(5)
            6 -> spFont.setSelection(6)
        }
    }

    // دالة onResume تستدعى عند استئناف النشاط بعد التوقف المؤقت
    override fun onResume() {
        super.onResume()
        // تحديث الخط المختار عند استئناف النشاط
        Ffont()
    }

    // دوال الحياة الدورية الأخرى (onStart و onPause و onDestroy و onRestart)
    // يمكن استدعاؤها بنفس الأسلوب لتحديث خيارات الخط عند تغييرها وعند حدوث أحداث الحياة الدورية الأخرى.
}


