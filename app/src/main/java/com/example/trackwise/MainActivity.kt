package com.example.trackwise
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Call findViewById on the DrawerLayout
        drawerLayout = findViewById(R.id.my_drawer_layout)

        // Pass the ActionBarToggle action into the drawerListener
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)

        // Display the hamburger icon to launch the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Call syncState() on the action bar so it'll automatically change to the back button when the drawer layout is open
        actionBarToggle.syncState()

        navView = findViewById<NavigationView>(R.id.navDrawer)
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.weight -> {
                    val intent= Intent(this,weightActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Weight", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.periods -> {
                    val intent= Intent(this,periods::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Periods", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.food -> {
                    val intent= Intent(this,food::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Food", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.allergy -> {
                    val intent= Intent(this,allergy::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Allergy", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        drawerLayout.openDrawer(navView)
        return true
    }

    // override the onBackPressed() function to close the Drawer when the back button is clicked
    override fun onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
