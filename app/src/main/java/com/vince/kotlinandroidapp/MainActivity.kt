package com.vince.kotlinandroidapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

//    private var editName: EditText? = null // ? cuando no lo pueda inicializar con otra cosa.
//    private var editAge: EditText? = null
//    private var textName: TextView? = null
//    private var textAge: TextView? = null
//    private var buttonExecute: Button? = null
    private var WHITE: String = "White"
    private var ORANGE: String = "Orange"
    private var buttonColor: String = ORANGE
//    private var button: Button? = null
//    private var radioButtonMan: RadioButton? = null
//    private var radioButtonWoman: RadioButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        editName = findViewById<EditText>(R.id.editText_name)
//        editAge = findViewById<EditText>(R.id.editText_age)
//        textName = findViewById<TextView>(R.id.textView_name)
//        textAge = findViewById<TextView>(R.id.textView_age)
//        buttonExecute = findViewById<Button>(R.id.btn_execute)
//        button = findViewById<Button>(R.id.btn)
//        radioButtonMan = findViewById<RadioButton>(R.id.radioButton_M)
//        radioButtonWoman = findViewById<RadioButton>(R.id.radioButton_W)


        btn!!.setOnClickListener (this)
        editTextName!!.addTextChangedListener(this) // !! asegura que no tenemos ningún null
        editTextAge!!.addTextChangedListener(this)
        btnExecute?.setOnClickListener { changeButtonColor() }
        editTextName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS

        radioButtonMan!!.setOnCheckedChangeListener(this)
        radioButtonWoman!!.setOnCheckedChangeListener(this)

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
        textViewName?.text = editTextName?.text
        if (editTextName!!.text.equals("")) {
            editTextName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
        } else {
            editTextName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_NORMAL
        }
        editTextAge?.text = editTextAge?.text
    }

    fun changeButtonColor(){
        if(buttonColor == ORANGE) {
            buttonColor = WHITE
            btnExecute!!.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.colorWhite))
            btnExecute!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorOrange))
        } else {
            buttonColor = ORANGE
            btnExecute!!.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.colorOrange))
            btnExecute!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorWhite))
        }
    }

    override fun onClick(v: View?) {
        if (editTextName?.text.toString().equals("")){
            editTextName!!.requestFocus()
        } else {
            textViewName?.text = editTextName?.text.toString()
            if (editTextAge?.text.toString().equals("")) {
                editTextAge!!.requestFocus()
            } else {
                textViewAge?.text = editTextAge?.text.toString()
            }
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView!!.id) {
            R.id.radioButtonMan -> Toast.makeText(this, "Ha seleccionado Hombre", Toast.LENGTH_SHORT).show()
            R.id.radioButtonWoman -> Toast.makeText(this, "Ha seleccionado Mujer", Toast.LENGTH_SHORT).show()
        }
    }

}
