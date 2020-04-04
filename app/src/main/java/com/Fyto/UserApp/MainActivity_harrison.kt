package com.Fyto.UserApp

import android.app.*
import android.content.Intent
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.homepage_harrison.*
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    lateinit var myRef: DatabaseReference

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder : Notification.Builder
    private val channelId = "com.Fyto.UserApp"
    private val description = "Water Reservoir Low"

    override fun onCreate(savedInstanceState: Bundle?) {

        myRef = FirebaseDatabase.getInstance().getReference()
        super.onCreate(savedInstanceState)

        val imgView = ImageView(this)
        val bmFytoImg =
            BitmapFactory.decodeFile("C:\\Users\\harri\\AndroidStudioProjects\\MyApplication\\app\\src\\main\\res\\drawable\\fytologo.png")
        imgView.setImageBitmap(bmFytoImg)

        setContentView(R.layout.homepage_harrison)
        //setSupportActionBar(toolbar)
        /*called when the user presses button for plant 1*/
        /* fun sendMessage(view: View) {
        }*/

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //if firebase value is below minimum, run
        btn_notify.setOnClickListener {

            //val intent = Intent(this, LauncherActivity::class.java)
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }

            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

            val contentView = RemoteViews(packageName, R.layout.noitification_layout)
            contentView.setTextViewText(R.id.noti_title, "I'm Thirsty!")
            contentView.setTextViewText(R.id.noti_content, "Please fill up your fyto reservoir")

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.enableLights(true)
                notificationChannel.enableVibration(true)
                notificationManager.createNotificationChannel(notificationChannel)

                builder = Notification.Builder(this, channelId)
                    .setContent(contentView)
                    .setSmallIcon(R.drawable.fytologo)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.fytologo))
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
            } else {
                builder = Notification.Builder(this)
                    .setContent(contentView)
                    .setSmallIcon(R.drawable.fytologo)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.fytologo))
                    .setContentIntent(pendingIntent)
            }
            notificationManager.notify(1234, builder.build())
        }

        myRef.addValueEventListener(object : ValueEventListener {
            /*override fun onDataChange(dataSnapshot : DataSnapshot?) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated

                val rHomepageDataSH0: HomepageData? = dataSnapshot.child("SoilHumidity").child("SH0").getValue(HomepageData::class.java)
                findViewById<TextView>(R.id.Humidity1).text = rHomepageDataSH0?.humidityReading

                //val rHomepageDataSH1: HomepageData? = dataSnapshot.child("SoilHumidity").child("SH1").getValue(HomepageData::class.java)
                //findViewById<TextView>(R.id.Humidity2).text = rHomepageDataSH1?.humidityReading

                //val rHomepageDataWL: HomepageData? = dataSnapshot.child("WateringSystem").child("waterLevel").getValue(HomepageData::class.java)
               //findViewById<TextView>(R.id.WaterLevel).text = rHomepageDataWL?.waterLevel

            }*/

            override fun onCancelled(p0: DatabaseError) {
                // Failed to read value
                TODO("not implemented")
                Log.w("MyActivity", "Failed to read value.")
            }

            override fun onDataChange(p0: DataSnapshot) {

                for (h in p0!!.children) {
                    val rHomepageDataSH0 = h.child("SoilHumidity").child("SH0").getValue(HomepageData::class.java)

                }

            }
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
