package com.example.harrypottergame

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Base64
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import java.io.FileOutputStream
import java.io.FileWriter


class FourFourActivity : AppCompatActivity() {
    private lateinit var image1 : ImageView
    private lateinit var image2 : ImageView
    private lateinit var image3 : ImageView
    private lateinit var image4 : ImageView
    private lateinit var image5 : ImageView
    private lateinit var image6 : ImageView
    private lateinit var image7 : ImageView
    private lateinit var image8 : ImageView
    private lateinit var image9 : ImageView
    private lateinit var image10 : ImageView
    private lateinit var image11 : ImageView
    private lateinit var image12 : ImageView
    private lateinit var image13 : ImageView
    private lateinit var image14 : ImageView
    private lateinit var image15 : ImageView
    private lateinit var image16 : ImageView

    private lateinit var  timeText : TextView
    private lateinit var  playerPointTextView : TextView
    var isOneCardFlipped :Boolean = false
    var isTwoCardsFlipped :Boolean = false
    var isInGame :Boolean = true
    private  var firstCard : ImageView? = null
    private  var secondCard : ImageView? = null
    private var score =0;
    private var remainingTime :Float =0F
    private var pastTime :Float =0F
    private var playerPoint :Long =0

    private lateinit var mediaPLayer : MediaPlayer
    private lateinit var mediaPlayer1 : MediaPlayer
    private lateinit var mediaPlayer2 : MediaPlayer
    private lateinit var mediaPlayer3 : MediaPlayer
    var email = String()

    var memoryCardDataListg = mutableListOf<MemoryCardData>()
    var memoryCardDataLists = mutableListOf<MemoryCardData>()
    var memoryCardDataListh = mutableListOf<MemoryCardData>()
    var memoryCardDataListr = mutableListOf<MemoryCardData>()

    var tempListg = mutableListOf<MemoryCardData>()
    var tempLists = mutableListOf<MemoryCardData>()
    var tempListh = mutableListOf<MemoryCardData>()
    var tempListr = mutableListOf<MemoryCardData>()

    var allTempList = mutableListOf<MemoryCardData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four_four)
        email = intent.getStringExtra("email")!!
        var hashMap:HashMap<ImageView,MemoryCardData> = HashMap<ImageView,MemoryCardData>()
        var imageViewList = mutableListOf<ImageView>()
/*        var memoryCardDataListg = mutableListOf<MemoryCardData>()
        var memoryCardDataList1 = mutableListOf<MemoryCardData>()
        var memoryCardDataList2 = mutableListOf<MemoryCardData>()
        var memoryCardDataList3 = mutableListOf<MemoryCardData>()*/



        if(!this::mediaPLayer.isInitialized){
            mediaPLayer = MediaPlayer.create(this, R.raw.prologue)
            mediaPLayer.start()

        }
        if(!this::mediaPlayer1.isInitialized){
            mediaPlayer1 = MediaPlayer.create(this, R.raw.shocked)


        }
        if(!this::mediaPlayer2.isInitialized){
            mediaPlayer2 = MediaPlayer.create(this, R.raw.congratulations)


        }
        if(!this::mediaPlayer3.isInitialized){
            mediaPlayer3 = MediaPlayer.create(this, R.raw.dogrukart)


        }




        image1 = findViewById<ImageView>(R.id.imageView400)
        image2 = findViewById<ImageView>(R.id.imageView401)
        image3 = findViewById<ImageView>(R.id.imageView402)
        image4 = findViewById<ImageView>(R.id.imageView403)
        image5 = findViewById<ImageView>(R.id.imageView404)
        image6 = findViewById<ImageView>(R.id.imageView405)
        image7 = findViewById<ImageView>(R.id.imageView406)
        image8 = findViewById<ImageView>(R.id.imageView407)
        image9 = findViewById<ImageView>(R.id.imageView408)
        image10 = findViewById<ImageView>(R.id.imageView409)
        image11 = findViewById<ImageView>(R.id.imageView410)
        image12 = findViewById<ImageView>(R.id.imageView411)
        image13 = findViewById<ImageView>(R.id.imageView412)
        image14 = findViewById<ImageView>(R.id.imageView413)
        image15 = findViewById<ImageView>(R.id.imageView414)
        image16 = findViewById<ImageView>(R.id.imageView415)
        timeText = findViewById<TextView>(R.id.timeTextView4)
        playerPointTextView = findViewById<TextView>(R.id.playerPointTextView4)


        var MemoryCardData1 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData2 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData3 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData4 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData5 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData6 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData7 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData8 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData9 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData10 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData11 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData12 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData13 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData14 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData15 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData16 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData17 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData18 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData19 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData20 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData21 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData22 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData23 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData24 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData25 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData26 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData27 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData28 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData29 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData30 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData31 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData32 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData33 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData34 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData35 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData36 = MemoryCardData(null, null, null, null, null, null)
        var MemoryCardData37 = MemoryCardData(null, null, null, null, null, null)





        memoryCardDataListg.add(MemoryCardData1)
        memoryCardDataListg.add(MemoryCardData2)
        memoryCardDataListg.add(MemoryCardData3)
        memoryCardDataListg.add(MemoryCardData4)
        memoryCardDataListg.add(MemoryCardData5)
        memoryCardDataListg.add(MemoryCardData6)
        memoryCardDataListg.add(MemoryCardData7)
        memoryCardDataListg.add(MemoryCardData8)
        memoryCardDataListg.add(MemoryCardData9)
        memoryCardDataListg.add(MemoryCardData10)


        memoryCardDataLists.add(MemoryCardData11)
        memoryCardDataLists.add(MemoryCardData12)
        memoryCardDataLists.add(MemoryCardData13)
        memoryCardDataLists.add(MemoryCardData14)
        memoryCardDataLists.add(MemoryCardData15)
        memoryCardDataLists.add(MemoryCardData16)
        memoryCardDataLists.add(MemoryCardData17)
        memoryCardDataLists.add(MemoryCardData18)
        memoryCardDataLists.add(MemoryCardData19)
        memoryCardDataLists.add(MemoryCardData20)
        memoryCardDataLists.add(MemoryCardData21)



        memoryCardDataListh.add(MemoryCardData22)
        memoryCardDataListh.add(MemoryCardData23)
        memoryCardDataListh.add(MemoryCardData24)
        memoryCardDataListh.add(MemoryCardData25)
        memoryCardDataListh.add(MemoryCardData26)
        memoryCardDataListh.add(MemoryCardData27)
        memoryCardDataListh.add(MemoryCardData28)
        memoryCardDataListh.add(MemoryCardData29)
        memoryCardDataListh.add(MemoryCardData30)



        memoryCardDataListr.add(MemoryCardData31)
        memoryCardDataListr.add(MemoryCardData32)
        memoryCardDataListr.add(MemoryCardData33)
        memoryCardDataListr.add(MemoryCardData34)
        memoryCardDataListr.add(MemoryCardData35)
        memoryCardDataListr.add(MemoryCardData36)
        memoryCardDataListr.add(MemoryCardData37)






















        InitMemoryCard("gryffindor", "AlbusDumbledore",MemoryCardData1)
        InitMemoryCard("gryffindor", "ArthurWeasley", MemoryCardData2)
        InitMemoryCard("gryffindor", "HarryPotter", MemoryCardData3)
        InitMemoryCard("gryffindor", "HermioneGranger", MemoryCardData4)
        InitMemoryCard("gryffindor", "LilyPotter", MemoryCardData5)
        InitMemoryCard("gryffindor", "MinervaMcGonagall", MemoryCardData6)
        InitMemoryCard("gryffindor", "PeterPettigrew", MemoryCardData7)
        InitMemoryCard("gryffindor", "RemusLupin", MemoryCardData8)
        InitMemoryCard("gryffindor", "RubeusHagrid", MemoryCardData9)
        InitMemoryCard("gryffindor", "SiriusBlack", MemoryCardData10)




        InitMemoryCard("slytherin", "AndromedaTonks", MemoryCardData11)
        InitMemoryCard("slytherin", "BellatrixLestrange", MemoryCardData12)
        InitMemoryCard("slytherin", "DoloresUmbridge", MemoryCardData13)
        InitMemoryCard("slytherin", "DracoMalfoy", MemoryCardData14)
        InitMemoryCard("slytherin", "EvanRosier", MemoryCardData15)
        InitMemoryCard("slytherin", "HoraceSlughorn", MemoryCardData16)
        InitMemoryCard("slytherin", "LetaLestrange", MemoryCardData17)
        InitMemoryCard("slytherin", "LuciusMalfoy", MemoryCardData18)
        InitMemoryCard("slytherin", "NarcissaMalfoy", MemoryCardData19)
        InitMemoryCard("slytherin", "SeverusSnape", MemoryCardData20)
        InitMemoryCard("slytherin", "TomRiddle", MemoryCardData21)




        InitMemoryCard("hufflepuff", "CedricDiggory",MemoryCardData22)
        InitMemoryCard("hufflepuff", "ErnestMacmillan", MemoryCardData23)
        InitMemoryCard("hufflepuff", "FatFriar", MemoryCardData24)
        InitMemoryCard("hufflepuff", "HannahAbbott", MemoryCardData25)
        InitMemoryCard("hufflepuff", "HelgaHufflepuff", MemoryCardData26)
        InitMemoryCard("hufflepuff", "NymphadoraTonks", MemoryCardData27)
        InitMemoryCard("hufflepuff", "PomonaSprout", MemoryCardData28)
        InitMemoryCard("hufflepuff", "SilvanusKettleburn", MemoryCardData29)
        InitMemoryCard("hufflepuff", "TedLupin", MemoryCardData30)



        InitMemoryCard("ravenclaw", "FiliusFlitwick",MemoryCardData31)
        InitMemoryCard("ravenclaw", "GarrickOllivander", MemoryCardData32)
        InitMemoryCard("ravenclaw", "MarcusBelby", MemoryCardData33)
        InitMemoryCard("ravenclaw", "MyrtleWarren", MemoryCardData34)
        InitMemoryCard("ravenclaw", "PadmaPatil", MemoryCardData35)
        InitMemoryCard("ravenclaw", "QuirinusQuirrell", MemoryCardData36)
        InitMemoryCard("ravenclaw", "RowenaRavenclaw", MemoryCardData37)




        memoryCardDataListg.shuffle()
        memoryCardDataLists.shuffle()
        memoryCardDataListh.shuffle()
        memoryCardDataListr.shuffle()

        tempListg = memoryCardDataListg.take(2) as MutableList<MemoryCardData>
        tempLists = memoryCardDataLists.take(2) as MutableList<MemoryCardData>
        tempListh = memoryCardDataListh.take(2) as MutableList<MemoryCardData>
        tempListr = memoryCardDataListr.take(2) as MutableList<MemoryCardData>


        tempListg.addAll(tempListg)
        tempLists.addAll(tempLists)
        tempListh.addAll(tempListh)
        tempListr.addAll(tempListr)


        allTempList.addAll(tempLists)
        allTempList.addAll(tempListg)
        allTempList.addAll(tempListh)
        allTempList.addAll(tempListr)

        allTempList.shuffle()



        /*val filename ="deneme.txt"
        val myfile =File(filename)
        myfile.writeText(allTempList.toString())*/


     /*   var fo =FileWriter("C:\\Users\\Mehmet Ali\\Desktop\\deneme1.txt")
        fo.write(allTempList.toString())
        fo.close()*/

      /*  val FILENAME = "dosyadeneme"

        val fos: FileOutputStream = openFileOutput(FILENAME, MODE_PRIVATE)
        fos.write(allTempList.toString().toByteArray())
        fos.close()*/












        imageViewList.add(image1)
        imageViewList.add(image2)
        imageViewList.add(image3)
        imageViewList.add(image4)
        imageViewList.add(image5)
        imageViewList.add(image6)
        imageViewList.add(image7)
        imageViewList.add(image8)
        imageViewList.add(image9)
        imageViewList.add(image10)
        imageViewList.add(image11)
        imageViewList.add(image12)
        imageViewList.add(image13)
        imageViewList.add(image14)
        imageViewList.add(image15)
        imageViewList.add(image16)



        hashMap.put(image1,allTempList[0])
        hashMap.put(image2,allTempList[1])
        hashMap.put(image3,allTempList[2])
        hashMap.put(image4,allTempList[3])
        hashMap.put(image5,allTempList[4])
        hashMap.put(image6,allTempList[5])
        hashMap.put(image7,allTempList[6])
        hashMap.put(image8,allTempList[7])
        hashMap.put(image9,allTempList[8])
        hashMap.put(image10,allTempList[9])
        hashMap.put(image11,allTempList[10])
        hashMap.put(image12,allTempList[11])
        hashMap.put(image13,allTempList[12])
        hashMap.put(image14,allTempList[13])
        hashMap.put(image15,allTempList[14])
        hashMap.put(image16,allTempList[15])




        for (imageView in imageViewList) {

            imageView.setOnClickListener{

                if(isOneCardFlipped){

                    val valueOfElement = hashMap.getValue(imageView)
                    valueOfElement.isFlipped = true
                    isTwoCardsFlipped = true
                    imageView.setImageBitmap(ReturnBitmap(valueOfElement.photoStringBase64!!))
                    secondCard = imageView
                    var valueOfFirstCard = hashMap.getValue(firstCard!!)
                    var valueOfSecondCard = hashMap.getValue(secondCard!!)

                    if(valueOfFirstCard.photoStringBase64 == valueOfSecondCard.photoStringBase64){
                        mediaPlayer3.start()
                        //match olduysa

                        var addPoint = (2*valueOfFirstCard.wizardPoint!!*valueOfFirstCard.housePoint!!)*(remainingTime/10)
                        //Toast.makeText(applicationContext,remainingTime.toString(),Toast.LENGTH_LONG).show()
                        playerPoint += addPoint.toLong()
                        playerPointTextView.text = playerPoint.toString()



                        firstCard!!.setOnClickListener(null)
                        secondCard!!.setOnClickListener(null)
                        imageViewList.remove(firstCard)
                        imageViewList.remove(secondCard)
                        firstCard = null
                        secondCard = null
                        isOneCardFlipped = false
                        isTwoCardsFlipped= false
                        score +=1;
                        if(score ==8){
                            mediaPLayer.stop()
                            mediaPlayer2.start()
                            isInGame = false
                            Toast.makeText(this,""+playerPoint+ " Puan ile oyunu BİTİRDİNİZ!!!"  ,
                                Toast.LENGTH_LONG).show()
                            val intent = Intent(this, FeedActivity::class.java)
                            intent.putExtra("email",email)
                            startActivity(intent)
                        }


                    }else{
                        //DONT MATCH RESET THE GAME
                        //Delay ekle

                        if(valueOfFirstCard.houseName == valueOfSecondCard.houseName){

                            var totalPointsOfCards = valueOfFirstCard.wizardPoint!!+valueOfSecondCard.wizardPoint!!
                            var negativePoint = (totalPointsOfCards/valueOfFirstCard.housePoint!!) *(pastTime/10)
                            Log.i("time",pastTime.toString())

                            playerPoint -=negativePoint.toLong()
                            playerPointTextView.text = playerPoint.toString()

                        }else{

                            var averagePoint = (valueOfFirstCard.wizardPoint!!+valueOfSecondCard.wizardPoint!!)/2
                            var negativePoint = (averagePoint*valueOfFirstCard.housePoint!!*valueOfSecondCard.housePoint!!)*(pastTime/10)

                            Log.i("time",pastTime.toString())
                            playerPoint -=negativePoint.toLong()
                            playerPointTextView.text = playerPoint.toString()
                        }





                        val handler = Handler()
                        handler.postDelayed(
                            Runnable {  ResetGame(imageViewList)  },
                            500
                        )


                    }

                }else if ( !isOneCardFlipped && !isTwoCardsFlipped){
                    firstCard = imageView
                    val valueOfElement = hashMap.getValue(imageView)
                    valueOfElement.isFlipped = true
                    imageView.setImageBitmap(ReturnBitmap(valueOfElement.photoStringBase64!!))
                    isOneCardFlipped = true


                }

            }

        }

    }
    override fun onStart() {
        super.onStart()

        val timer = object: CountDownTimer(46000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                pastTime = 46000F/1000F - millisUntilFinished/1000F
                remainingTime = millisUntilFinished/1000F

                timeText.text = ""+  remainingTime




            }

            override fun onFinish() {

                /* val builder = AlertDialog.Builder(applicationContext)
                 builder.setMessage("You lose, time is up!")
                     .setPositiveButton("Go back",
                         DialogInterface.OnClickListener { dialog, id ->



                             val intent = Intent(applicationContext, FeedActivity::class.java)
                             startActivity(intent)

                         })

                 // Create the AlertDialog object and return it
                 builder.create()
                 builder.show()*/


                if(isInGame){
                    Toast.makeText(applicationContext,"Süre Bitti!",Toast.LENGTH_LONG).show()
                    val intent = Intent(applicationContext, FeedActivity::class.java)
                    intent.putExtra("email",email)
                    startActivity(intent)
                    mediaPlayer1.start()
                    finish()
                    mediaPLayer.stop()
                }

            }
        }
        timer.start()
    }

    override fun onResume() {
        super.onResume()
        isInGame=true

    }

    fun ResetGame(imageViewList : List<ImageView>){



        for(imageView in imageViewList){


            imageView.setImageResource(R.drawable.arkason)
            firstCard = null
            secondCard = null
            isTwoCardsFlipped = false
            isOneCardFlipped = false

        }
    }

    fun InitMemoryCard(houseName: String, wizardName: String, memoryCard: MemoryCardData) {


        val db = FirebaseFirestore.getInstance()
        val docRef = db.collection(houseName).document(wizardName)

        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {

                    if(document.data == null){
                        Log.e("bosbos","DATA IS NULLLLLLLLLLLLLL!!!!!!!!!!!!!")
                    }



                    val houseName = document.data!!["ev"].toString()
                    val wizardPoint = document.data!!["puan"] as Long
                    val housePoint = document.data!!["evpuanı"] as Long
                    val photoBase64 = document.data!!["foto"].toString()
                    memoryCard.isFlipped = false
                    memoryCard.isMatched = false
                    memoryCard.houseName = houseName
                    memoryCard.wizardPoint = wizardPoint
                    memoryCard.photoStringBase64 = photoBase64
                    memoryCard.housePoint = housePoint




                } else {
                    Log.d("TAG", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("TAG", "get failed with ", exception)
            }
    }

    fun ReturnBitmap(base64String: String): Bitmap {

        val imageBytes = Base64.decode(base64String, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
        return decodedImage
    }
}