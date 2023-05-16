package com.example.harrypottergame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.harrypottergame.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var binding : ActivityMainBinding
    private lateinit var database : DatabaseReference
    private lateinit var email : String
    lateinit var usernameText: TextView








    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = Firebase.auth
       database = FirebaseDatabase.getInstance("https://harrypottermemorycardgame-default-rtdb.europe-west1.firebasedatabase.app" ).getReference("Users")



    }

    override fun onStart() {
        super.onStart()

    }

    fun cheatButtonClicked (view : View){
        val intent = Intent(this,FeedActivity::class.java)
        startActivity(intent)
        finish()
    }


     fun SignInClicked(view : View){
         email = binding.emailText.text.toString().trim()
         val password = binding.passwordText.text.toString().trim()
         val email3 = email.replace(".","")

         //var email2 = database.child(userName).child(email).key
         //Log.i("mail", "Got value $email2")
         //email2 = email2 + ".com"
         if(email.isEmpty() || password.isEmpty())
         {
             Toast.makeText(this,"Email ve şifre boş olamaz",Toast.LENGTH_LONG).show()
         }
         else
         {
             auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {


                 val intent = Intent(this,FeedActivity::class.java)
                 intent.putExtra("email",email3)
                 val intent2 = Intent(this,FourFourActivity::class.java)
                 intent.putExtra("email",email3)
                 startActivity(intent)
                 finish()

             }.addOnFailureListener{
                 Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
             }



         }







    }

    fun passforgotOnClick(view: View){
        binding.passwordText.visibility = View.INVISIBLE
        binding.loginButton.visibility = View.INVISIBLE
        binding.passwordRecovery.visibility = View.VISIBLE
        binding.dontHaveAccText.visibility = View.INVISIBLE
        binding.textView2.visibility = View.INVISIBLE
        binding.forgotPassText.visibility = View.INVISIBLE

    }

    fun recoveryClicked(view: View){
       val email = binding.emailText.text.toString().trim()
        if(email.isEmpty()){
            Toast.makeText(this,"Email giriniz!",Toast.LENGTH_LONG).show()
        }
        else{
            Firebase.auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("TAG", "Email sent.")
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
                    else{
                        Toast.makeText(this,"Email sistemde kayıtlı değil !",Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    fun dontHaveAccTextClicked (view: View){
        binding.loginButton.visibility = View.INVISIBLE
        binding.registerButton.visibility = View.VISIBLE
        binding.emailText.visibility = View.VISIBLE
        binding.dontHaveAccText.visibility = View.INVISIBLE
        binding.textView2.visibility = View.INVISIBLE
        binding.forgotPassText.visibility = View.INVISIBLE
        binding.userNameText.visibility = View.VISIBLE

    }



    fun RegisterClicked(view: View){

        email = binding.emailText.text.toString().trim()
        val password = binding.passwordText.text.toString().trim()
        val username = binding.userNameText.text.toString().trim()

        val user = User(username)

        val email2 = email.replace("." , "")


        database.child(email2).setValue(user)




        if(email.isEmpty() || password.isEmpty() )
        {
            Toast.makeText(this,"Tüm alanlar doldurulmalıdır!",Toast.LENGTH_LONG).show()
        }
        else
        {
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {


                val intent = Intent(this,FeedActivity::class.java)
                intent.putExtra("email",email2)
                startActivity(intent)
                finish()

            }.addOnFailureListener{
                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
            }

        }



    }

    }


