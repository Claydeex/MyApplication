package com.example.myapplication

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.homepage.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        fun sendMessage(view: View) {

        }

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
