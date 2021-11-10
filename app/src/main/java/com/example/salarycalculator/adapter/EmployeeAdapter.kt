package com.example.salarycalculator.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.salarycalculator.R
import com.example.salarycalculator.employee.Employee
import com.google.android.material.floatingactionbutton.FloatingActionButton

public class EmployeeAdapter(private var employeeList: MutableList<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var fnameTextView: TextView = view.findViewById(R.id.fnameTextView)
        var lnameTextView: TextView = view.findViewById(R.id.lnameTextView)
        var salaryTextView: TextView = view.findViewById(R.id.salaryTextView)
        var deleteButton: FloatingActionButton = view.findViewById(R.id.floatingActionButton)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = employeeList[position]
        holder.fnameTextView.text = item.firstName
        holder.lnameTextView.text = item.lastName
        holder.salaryTextView.text = item.getSalary().toString()

        holder.deleteButton.setOnClickListener{deleteItem(item.id)}
    }
    override fun getItemCount(): Int {
        return employeeList.size
    }

    private fun deleteItem(index: Int) {
        employeeList = employeeList.filter { it.id != index } as MutableList<Employee>
        notifyDataSetChanged()
    }
}