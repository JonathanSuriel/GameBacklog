package com.example.jonat.gamebacklog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

    class NewGameActivity : AppCompatActivity() {

        private lateinit var editWordView: EditText

        public override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_new_game)
            editWordView = findViewById(R.id.editTitle)

            val fab = findViewById<FloatingActionButton>(R.id.button_save)
            fab.setOnClickListener {
                val replyIntent = Intent()
                if (TextUtils.isEmpty(editWordView.text)) {
                    setResult(Activity.RESULT_CANCELED, replyIntent)
                } else {
                    val word = editWordView.text.toString()
                    replyIntent.putExtra(EXTRA_REPLY, word)
                    setResult(Activity.RESULT_OK, replyIntent)
                }
                finish()
            }
        }

        companion object {
            const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
        }
    }
