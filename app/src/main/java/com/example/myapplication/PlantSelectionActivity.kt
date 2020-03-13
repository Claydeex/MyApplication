package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class PlantSelectionActivity : AppCompatActivity() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {

        R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var plantNumber: Int? = null
        val extras = intent.extras
        if (extras != null) {
            plantNumber = extras.getInt("plant num")

            val TAG = "MyActivity"
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

        // Set the toolbar as support action bar
        setSupportActionBar(findViewById(R.id.plant_chosen_toolbar))

        // Now get the support action bar
        val actionBar = supportActionBar

        // Set toolbar title/app title
        actionBar!!.title = "Plant $plantNumber Settings"

        // Set Home Button in Action Bar
        actionBar.setDisplayHomeAsUpEnabled(true)

        // Set action bar elevation
        actionBar.elevation = 4.0F

        // Display the app icon in action bar/toolbar
        actionBar.setDisplayShowHomeEnabled(true)
        android.app.ActionBar.DISPLAY_SHOW_TITLE
        actionBar.setLogo(R.drawable.fytologo)
        actionBar.setDisplayUseLogoEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
        //return super.onSupportNavigateUp()
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