package com.bignerdranch.android.application17_1

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {
    lateinit var login: EditText
    lateinit var password: EditText
    lateinit var pref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login = findViewById(R.id.log)
        password = findViewById(R.id.pass)
        findViewById<View>(R.id.loadbutton).setOnClickListener{
            AlertDialog.Builder(this)
                .setMessage("Загрузить данные?")
                .setPositiveButton("Да") { dialog, which ->
                    pref = getPreferences(MODE_PRIVATE)
                    login.setText(pref.getString("login",""))
                    password.setText(pref.getString("password",""))
                }
                .setNegativeButton("Нет") { dialog, which ->
                    dialog.dismiss()
                }
                .show()
        }


    }

    fun handler(view: View) {
        if (view.getId() == R.id.savebutton){
            pref = getPreferences(MODE_PRIVATE)
            var ed = pref.edit()
            ed.putString("login",login.getText().toString())
            ed.putString("password",password.getText().toString())
            ed.apply()
        }
    }


}