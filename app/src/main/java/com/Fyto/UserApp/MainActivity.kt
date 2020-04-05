package com.Fyto.UserApp

import android.app.*
import android.content.Intent
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RemoteViews
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.homepage.*
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private var mFirebaseDatabase: FirebaseDatabase? = null
    private var myRef: DatabaseReference? = null

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder : Notification.Builder
    private val channelId = "com.Fyto.UserApp"
    private val description = "Water Reservoir Low"

    companion object {
        private const val TAG = "MyActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myRef = FirebaseDatabase.getInstance().reference

        val imgView = ImageView(this)
        val bmFytoImg = BitmapFactory.decodeFile("C:\\Users\\harri\\AndroidStudioProjects\\MyApplication\\app\\src\\main\\res\\drawable\\fytologo.png")
        imgView.setImageBitmap(bmFytoImg)

        setContentView(R.layout.homepage)
        creatorButton.setOnClickListener {
            // This is where we'll dynamically create our new view!!!
            var newView: ImageView
            newView = ImageView(this)

            myLayout.addView(newView)

            newView.layoutParams.height = 200
            newView.layoutParams.width = 200
            newView.x = 300F
            newView.y = 500F
            newView.setBackgroundColor(Color.MAGENTA)
        }

        //setSupportActionBar(toolbar)
        /*called when the user presses button for plant 1*/
        /* fun sendMessage(view: View) {
        }*/


        //if firebase value is below minimum, run

        myRef!!.addValueEventListener(object : ValueEventListener {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onDataChange(dataSnapshot:DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated

                val rHomepageDataLux: HomepageData? = dataSnapshot.child("Light").child("L0").getValue(HomepageData::class.java)
                findViewById<TextView>(R.id.lightVal).text = rHomepageDataLux?.luxReading

                val rHomepageDataSH0: HomepageData? = dataSnapshot.child("SoilHumidity").child("SH0").getValue(HomepageData::class.java)
                findViewById<TextView>(R.id.Humidity1).text = rHomepageDataSH0?.humidityReading

                val rHomepageDataSH1: HomepageData? = dataSnapshot.child("SoilHumidity").child("SH1").getValue(HomepageData::class.java)
                findViewById<TextView>(R.id.Humidity2).text = rHomepageDataSH1?.humidityReading

                val rHomepageDataWL: HomepageData? = dataSnapshot.child("WateringSystem").getValue(HomepageData::class.java)

                notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

                if(rHomepageDataWL?.waterLevel!! > 100) {

                    findViewById<TextView>(R.id.WaterLevel).text = "Low Water! Please fill me up"
                    //val intent = Intent(this@MainActivity, LauncherActivity::class.java)
                    val intent = Intent(this@MainActivity, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }

                    val pendingIntent = PendingIntent.getActivity(this@MainActivity, 0, intent, 0)

                    val contentView = RemoteViews(packageName, R.layout.notification_layout)
                    contentView.setTextViewText(R.id.noti_title, "I'm Thirsty!")
                    contentView.setTextViewText(R.id.noti_content, "Please fill up your fyto reservoir")

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                        notificationChannel.enableLights(true)
                        notificationChannel.lightColor = Color.GREEN
                        notificationChannel.enableVibration(true)
                        notificationManager.createNotificationChannel(notificationChannel)

                        builder = Notification.Builder(this@MainActivity, channelId)
                            .setContent(contentView)
                            .setSmallIcon(R.drawable.fytologo)
                            .setLargeIcon(BitmapFactory.decodeResource(this@MainActivity.resources, R.drawable.fytologo))
                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true)
                    } else {
                        builder = Notification.Builder(this@MainActivity)
                            .setContent(contentView)
                            .setSmallIcon(R.drawable.fytologo)
                            .setLargeIcon(BitmapFactory.decodeResource(this@MainActivity.resources, R.drawable.fytologo))
                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true)
                    }
                    notificationManager.notify(1234, builder.build())
                }


            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }

            /*override fun onCancelled(p0: DatabaseError) {
                // Failed to read value

                Log.w("MyActivity", "Failed to read value.")
            }

            override fun onDataChange(p0: DataSnapshot) {

                for (h in p0!!.children) {
                    val rHomepageDataSH0 = h.child("SoilHumidity").child("SH0").getValue(HomepageData::class.java)

                }

            }*/
        })

        plant_1.setOnClickListener {
            val plant1 = Intent(this@MainActivity, PlantSelectionActivity::class.java)
            plant1.putExtra("plant num",1);
            startActivity(plant1);
        }

        plant_2.setOnClickListener {
            val plant2 = Intent(this@MainActivity, PlantSelectionActivity::class.java)
            plant2.putExtra("plant num",2);
            startActivity(plant2);
        }

        plant_3.setOnClickListener {
            val plant3 = Intent(this@MainActivity, PlantSelectionActivity::class.java)
            plant3.putExtra("plant num",3);
            startActivity(plant3);
        }

        plant_4.setOnClickListener {
            val plant4 = Intent(this@MainActivity, PlantSelectionActivity::class.java)
            plant4.putExtra("plant num",4);
            startActivity(plant4);
        }

        plant_5.setOnClickListener {
            val plant5 = Intent(this@MainActivity, PlantSelectionActivity::class.java)
            plant5.putExtra("plant num",5);
            startActivity(plant5);
        }

    }

}