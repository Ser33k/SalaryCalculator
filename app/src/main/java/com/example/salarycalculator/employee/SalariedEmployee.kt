package com.example.salarycalculator.employee

import com.example.salarycalculator.employee.Employee

class SalariedEmployee(id:Int, firstName: String, lastName: String, private val weeklySalary: Double) :
    Employee(id, firstName, lastName) {

    override fun getSalary(): Double {
        return weeklySalary * 4;
    }
}