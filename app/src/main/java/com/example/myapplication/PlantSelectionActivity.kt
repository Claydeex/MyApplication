package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.database.*
//import com.google.firebase.ktx.Firebase

class PlantSelectionActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MyActivity"
    }

/*    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {

        R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item);
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val TAG = "MyActivity"
        var plantNumber: Int? = null
        val extras = intent.extras
        if (extras != null) {
            plantNumber = extras.getInt("plant num")

            Log.v(TAG, "plant #$plantNumber");
            //The plant # argument here must match the one used in the other activity
        }

        /*setContentView(R.layout.sign_in)
        // Create an ArrayAdapter
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.GeneralSettings, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinner2.adapter = adapter*/

        setContentView(R.layout.plant_chosen)

        val toolbar: Toolbar = findViewById<Toolbar>(R.id.plant_chosen_toolbar)
        setSupportActionBar(toolbar)

        //toolbar.setNavigationIcon(R.drawable.ic_)
        toolbar.title = "Plant $plantNumber Settings"
        toolbar.subtitle = "Your Plant Name"
        toolbar.setLogo(R.drawable.ic_fytologo)
        toolbar.titleMarginBottom = 5

        /*// Now get the support action bar
        val actionBar = supportActionBar

        // Set Home Button in Action Bar
        actionBar.setDisplayHomeAsUpEnabled(true)

        // Set action bar elevation
        actionBar.elevation = 4.0F

        // Display the app icon in action bar/toolbar
        actionBar.setDisplayShowHomeEnabled(true)
        android.app.ActionBar.DISPLAY_SHOW_TITLE*/

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
        //return super.onSupportNavigateUp()
    }

    // Firebase communication
    fun basicReadWrite() {

        // Writing to Firebase
        val myRef = FirebaseDatabase.getInstance().getReference("Light")
        //myRef.setValue("Hello, World!")

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(h in dataSnapshot.children) {
                    //val input = h.getValue(Light::class.java)
                }
                val value = dataSnapshot.value
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

    }

}

/*
open class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current time as the default values for the picker
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        return TimePickerDialog(activity, this, hour, minute, DateFormat.is24HourFormat(activity))
    }
    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        // Do something with the time chosen by the user
    }
    fun showTimePickerDialog(v: View) {
        val fm: FragmentManager = getSupportFragmentManager()
        TimePickerFragment().show(supportFragmentManager, "timePicker")
    }
}
*/