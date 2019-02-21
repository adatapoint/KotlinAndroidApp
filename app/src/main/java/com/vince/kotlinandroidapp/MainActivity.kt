package com.vince.kotlinandroidapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), TextWatcher, View.OnClickListener {


    private var editName: EditText? = null // ? cuando no lo pueda inicializar con otra cosa.
    private var editAge: EditText? = null
    private var textName: TextView? = null
    private var textAge: TextView? = null
    private var buttonExecute: Button? = null
    private var WHITE: String = "White"
    private var ORANGE: String = "Orange"
    private var buttonColor: String = ORANGE
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = findViewById<EditText>(R.id.editText_name)
        editAge = findViewById<EditText>(R.id.editText_age)
        textName = findViewById<TextView>(R.id.textView_name)
        textAge = findViewById<TextView>(R.id.textView_age)
        buttonExecute = findViewById<Button>(R.id.btn_execute)
        button = findViewById<Button>(R.id.btn)

        button!!.setOnClickListener (this)
        editName!!.addTextChangedListener(this) // !! asegura que no tenemos ningún null
        editAge!!.addTextChangedListener(this)
        buttonExecute?.setOnClickListener { changeButtonColor() }
        editName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS

    }

    override fun afterTextChanged(s: Editable?) {
        // Después de un dato
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        // Antes del dato (focus en campo de texto)
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        textName?.text = editName?.text
        if (editName?.equals("") ?: ("" === null)) {
            editName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
        } else {
            editName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_NORMAL
        }
        textAge?.text = editAge?.text
    }

    fun changeButtonColor(){
        if(buttonColor == ORANGE) {
            buttonColor = WHITE
            buttonExecute!!.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.colorWhite))
            buttonExecute!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorOrange))
        } else {
            buttonColor = ORANGE
            buttonExecute!!.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.colorOrange))
            buttonExecute!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorWhite))
        }
    }

    override fun onClick(v: View?) {
        if (editName?.text.toString().equals("")){
            editName!!.requestFocus()
        } else {
            textName?.text = editName?.text.toString()
            if (editAge?.text.toString().equals("")) {
                editAge!!.requestFocus()
            } else {
                textAge?.text = editAge?.text.toString()
            }
        }
    }

}
