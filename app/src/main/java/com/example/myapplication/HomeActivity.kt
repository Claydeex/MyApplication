package com.example.myapplication
//import android.R
import android.R.attr
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.home.*

class HomeActivity : AppCompatActivity() {

/*    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.light_schedule, menu)
        return super.onCreateOptionsMenu(menu)
    }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return true
    }
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

    /*public fun goToPlantSelection(view: View) {
        setContentView(R.layout.activity_plant_selection)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.home) //744311701
        super.onCreate(savedInstanceState)

        test_button.setOnClickListener {
            val intent = Intent(this@HomeActivity, PlantSelectionActivity::class.java)
            startActivity(intent);
        }
    }

    /*fun getValues(view: View) {
        Toast.makeText(this, "Spinner 1 " + spinner1.selectedItem.toString() +
                "\nSpinner 2 " + spinner2.selectedItem.toString(), Toast.LENGTH_LONG).show()
        }
         */


}
