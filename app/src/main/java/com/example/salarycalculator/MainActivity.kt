package com.example.salarycalculator

import android.app.Dialog
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.salarycalculator.adapter.EmployeeAdapter
import com.example.salarycalculator.employee.Employee
import com.example.salarycalculator.employee.HourlyEmployee
import com.example.salarycalculator.employee.SalariedEmployee
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class MainActivity : AppCompatActivity() {

    val employeeList = mutableListOf<Employee>()
    public lateinit var employeeAdapter: EmployeeAdapter
    private lateinit var showDialogBtn: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showDialogBtn = findViewById(R.id.floatingActionButton2)
        showDialogBtn.setOnClickListener {
               DialogFragmentX().show(supportFragmentManager, DialogFragmentX.TAG)

        }

        val he = HourlyEmployee(1,"Mik", "Kie", 20.0, 30)
        val se = SalariedEmployee(2, "Kie", "Mik", 500.0)



        employeeList.add(he)
        employeeList.add(se)

        title = "Recycler View"
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        employeeAdapter = EmployeeAdapter(employeeList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = employeeAdapter


    }


//    private fun prepareItems() {
//        itemsList.add("Item 1")
//        itemsList.add("Item 2")
//        itemsList.add("Item 3")
//        itemsList.add("Item 4")
//        itemsList.add("Item 5")
//        itemsList.add("Item 6")
//        itemsList.add("Item 7")
//        itemsList.add("Item 8")
//        itemsList.add("Item 9")
//        itemsList.add("Item 10")
//        itemsList.add("Item 11")
//        itemsList.add("Item 12")
//        itemsList.add("Item 13")
//        employeeAdapter.notifyDataSetChanged()
//    }
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}