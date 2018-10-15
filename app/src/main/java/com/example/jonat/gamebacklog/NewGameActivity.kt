package com.example.jonat.gamebacklog

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import java.text.SimpleDateFormat
import java.util.*

class NewGameActivity : AppCompatActivity() {

        private lateinit var editGameTitle: EditText
        private lateinit var editGamePlatform: EditText
        private lateinit var editGameNotes: EditText
        private var model: GameViewModel? = null
        private var mStatus: String? = null
        private lateinit var mSpinner: Spinner

        public override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_new_game)
            editGameTitle = findViewById(R.id.editTitle)
            editGamePlatform = findViewById(R.id.editPlatform)
            editGameNotes = findViewById(R.id.editNotes)
            mSpinner = findViewById(R.id.enumStatus)
            model = ViewModelProviders.of(this).get(GameViewModel::class.java)

            val dataAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Status.values())
            // Drop down layout style - list view with radio button
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // attaching data adapter to spinner
            mSpinner!!.adapter = dataAdapter
            val fab = findViewById<FloatingActionButton>(R.id.button_save)
            fab.setOnClickListener {
                val replyIntent = Intent()
                if (TextUtils.isEmpty(editGameTitle.text)) {
                    setResult(Activity.RESULT_CANCELED, replyIntent)
                } else {
                    val title = editGameTitle.text.toString()
                    val platform = editGamePlatform.text.toString()
                    val notes = editGameNotes.text.toString()
                    val status =  mSpinner.selectedItem.toString()
                    val date = SimpleDateFormat("dd/MM/yyyy", Locale.GERMANY).format(Date()).toString()
                    val game = Game(title, platform, notes, date, status)
                    model!!.insert(game)
                }
                finish()
            }
        }
    }
