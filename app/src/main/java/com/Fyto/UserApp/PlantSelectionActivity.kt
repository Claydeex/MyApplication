package com.Fyto.UserApp

import android.os.Bundle
import android.provider.Contacts.People
import android.provider.Settings.Global.getString
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.database.*
//import com.google.firebase.ktx.Firebase

class PlantSelectionActivity : AppCompatActivity() {

    private var mFirebaseDatabase: FirebaseDatabase? = null
    private var myRef: DatabaseReference? = null
    lateinit var mLightSpinner: Spinner

    companion object {
        private const val TAG = "MyActivity"
    }

    /* var lightMode = arrayOf(
         "Automated",
         "Custom"
     )
 */
    /*  override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item);
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plant_chosen)

        //mFirebaseDatabase = FirebaseDatabase.getInstance()
        myRef = FirebaseDatabase.getInstance().reference
        // Getting a reference to Spinner Widget containing modes

        /*mLightSpinner = findViewById<Spinner>(R.id.light_sched_spinner)
        // Array adapter to set data in Spinner Widget
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, lightMode)
        // Setting the array adapter containing mode list to the spinner widget
        mLightSpinner.adapter = adapter*/

        //val TAG = "MyActivity"
        var plantNumber: Int? = null
        val extras = intent.extras
        if (extras != null) {
            plantNumber = extras.getInt("plant num")

            Log.v(TAG, "plant #$plantNumber")
            //The plant # argument here must match the one used in the other activity
        }

        val toolbar: Toolbar = findViewById<Toolbar>(R.id.plant_chosen_toolbar)
        setSupportActionBar(toolbar)

        //toolbar.setNavigationIcon(R.drawable.ic_)
        toolbar.title = "Plant $plantNumber Settings"
        toolbar.subtitle = "   Your Plant Name" //pass name string that is inputted by user input on homepage_harrison?
        toolbar.setLogo(R.drawable.ic_fytologo)// or change to plant{#}.png and make if loop for plantNum

        toolbar.titleMarginBottom = 5

        myRef!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot:DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated

                val rPlantDataUno: ReadPlantData? = dataSnapshot.child("Light").child("L0").getValue(ReadPlantData::class.java)
                findViewById<TextView>(R.id.textView2).text = rPlantDataUno?.luxReading

                //for (ds in dataSnapshot.children) {

                /*val rPlantData = ReadPlantData()
                rPlantData.lightIsConnected = ds.child("Light").child("L0").getValue(ReadPlantData::class.java)?.lightIsConnected  //Check if light is connected
                rPlantData.luxReading = ds.child("Light").child("L0").getValue(ReadPlantData::class.java)?.luxReading  //Set the lux sensor reading
                rPlantData.luxReading = ds.child("Light").child("L0").getValue(ReadPlantData::class.java)?. luxReading
                Log.d(TAG, "answer is " + rPlantData.luxReading)
                findViewById<TextView>(R.id.textView2).text = rPlantDataUno!!.luxReading
            }   */
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        // Setting ItemClick Handler for Spinner Widget
        //mLightSpinner.onItemSelectedListener = modeSelectedListener

        val spinner = findViewById<Spinner>(R.id.light_sched_spinner)
        val adapter = ArrayAdapter.createFromResource(this, R.array.lightMode, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.prompt = "Select Lighting Mode!"

        spinner.adapter = NothingSelectedSpinnerAdapter(adapter, R.layout.contact_spinner_row_nothing_selected,
            R.layout.contact_spinner_nothing_selected_dropdown,
            this)

        val modeSelectedListener = object : AdapterView.OnItemSelectedListener {
            //spinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(spinner: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.w(TAG, "Light Spinner:" + spinner!!.adapter.getItem(1))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // TODO Auto-generated method stub
            }
        }


        /*setContentView(R.layout.sign_in)
        // Create an ArrayAdapter
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.GeneralSettings, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinner2.adapter = adapter*/

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

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.plant_chosen, menu)
        return true
    }*/

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
        //return super.onSupportNavigateUp()
    }

    /*
     * Decorator Adapter to allow a Spinner to show a 'Nothing Selected...' initially
     * displayed instead of the first choice in the Adapter.
     */

    /*// Firebase communication
    fun basicReadWrite() {
        // Writing to Firebase
        val myRef = FirebaseDatabase.getInstance().getReference("Light")
        //myRef.setValue("Hello, World!")
    }*/

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