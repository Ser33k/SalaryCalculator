package com.example.salarycalculator.employee

class HourlyEmployee(id:Int, firstName:String, lastName:String, private val hourlyWage:Double, private val hours:Int) : Employee(id, firstName, lastName){
    override fun getSalary(): Double {
        return hourlyWage * hours;
    }
}