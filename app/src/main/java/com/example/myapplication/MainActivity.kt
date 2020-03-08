package com.example.myapplication

import android.app.PendingIntent.getActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlinx.android.synthetic.main.plant_chosen.*

class MainActivity : AppCompatActivity() {

/*    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.light_schedule, menu)
        return super.onCreateOptionsMenu(menu)
    }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        /*
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
         */

        /*
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.action_cut -> {
                to_del.text = "Cut"
                return true
            }
            R.id.action_copy -> {
                to_del.text = "Copy"
                return true
            }
            R.id.action_paste -> {
                to_del.text = "Paste"
                return true
            }
            R.id.action_new -> {
                to_del.text = "New"
                return true
            }
        }*/
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        actionBar!!.title = "Plant Settings"

        // Set action bar elevation
        actionBar.elevation = 4.0F

        // Display the app icon in action bar/toolbar
        actionBar.setDisplayShowHomeEnabled(true)
        android.app.ActionBar.DISPLAY_SHOW_TITLE
        actionBar.setLogo(R.drawable.home_icon_foreground)
        actionBar.setDisplayUseLogoEnabled(true)

    }



    /*fun getValues(view: View) {
        Toast.makeText(this, "Spinner 1 " + spinner1.selectedItem.toString() +
                "\nSpinner 2 " + spinner2.selectedItem.toString(), Toast.LENGTH_LONG).show()
    }
*/
}