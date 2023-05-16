package com.example.harrypottergame

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FeedActivity : AppCompatActivity() {


    private lateinit var levelRadioGroup: RadioGroup
    private lateinit var playerRadioGroup: RadioGroup
    private lateinit var sPRadioButton: RadioButton
    private lateinit var mPRadioButton: RadioButton
    private lateinit var twoRadioButton: RadioButton
    private lateinit var fourRadioButton: RadioButton
    private lateinit var sixRadioButton: RadioButton
    private lateinit var startButton: Button
    lateinit var text: TextView
    lateinit var usernameText: TextView
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_feed)
        var playerCount = 0
        var difficulty = 0
        playerRadioGroup = findViewById(R.id.playerCheckRadioGroup)
        levelRadioGroup = findViewById(R.id.levelRadioGroupCheck)
        sPRadioButton = findViewById(R.id.onePlayerRadioButton)
        mPRadioButton = findViewById(R.id.twoPlayerRadioButton)
        twoRadioButton = findViewById(R.id.twoByTwoRadioButton)
        fourRadioButton = findViewById(R.id.fourByFourRadioButton)
        sixRadioButton = findViewById(R.id.sixBySixRadioButton)
        startButton = findViewById(R.id.startGameButton)
        text = findViewById(R.id.textView)
        usernameText = findViewById(R.id.textusername1)



        val extras = intent.extras

        val email = intent.getStringExtra("email")
        //The key argument here must match that used in the other activity

       database = FirebaseDatabase.getInstance("https://harrypottermemorycardgame-default-rtdb.europe-west1.firebasedatabase.app").reference


        var username = database.child("Users").child(email!!).get()
            .addOnSuccessListener {
                  it.value.toString()
               usernameText.setText(it.child("username").value.toString())

                }





                sPRadioButton.setOnClickListener {
                    levelRadioGroup.visibility = View.VISIBLE
                    text.visibility = View.VISIBLE


                    playerCount = 1
                }

                mPRadioButton.setOnClickListener() {
                    levelRadioGroup.visibility = View.VISIBLE
                    text.visibility = View.VISIBLE
                    playerCount = 2
                }

                twoRadioButton.setOnClickListener {
                    startButton.visibility = View.VISIBLE
                    difficulty = 1
                }

                fourRadioButton.setOnClickListener {
                    startButton.visibility = View.VISIBLE
                    difficulty = 2
                }

                sixRadioButton.setOnClickListener {
                    startButton.visibility = View.VISIBLE
                    difficulty = 3
                }

                startButton.setOnClickListener {


                    if (playerCount == 1 && difficulty == 1) {
                        val intent = Intent(this, TwoTwoActivity::class.java)
                        intent.putExtra("email",email)
                        startActivity(intent)
                        finish()

                    } else if (playerCount == 1 && difficulty == 2) {

                        val intent = Intent(this, FourFourActivity::class.java)
                        intent.putExtra("email",email)
                        startActivity(intent)
                        finish()

                    } else if (playerCount == 1 && difficulty == 3) {

                        val intent = Intent(this, SixSixActivity::class.java)
                        intent.putExtra("email",email)
                        startActivity(intent)
                        finish()

                    } else if (playerCount == 2 && difficulty == 1) {

                        val intent = Intent(this, TwoTwo_2Activity::class.java)
                        intent.putExtra("email",email)
                        startActivity(intent)
                        finish()

                    } else if (playerCount == 2 && difficulty == 2) {

                        val intent = Intent(this, FourFour_2Activity::class.java)
                        intent.putExtra("email",email)
                        startActivity(intent)
                        finish()

                    } else if (playerCount == 2 && difficulty == 3) {

                        val intent = Intent(this, SixSix_2Activity::class.java)
                        intent.putExtra("email",email)
                        startActivity(intent)
                        finish()

                    }


                }




    }





    }






