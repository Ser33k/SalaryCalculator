package com.example.salarycalculator.employee

abstract class Employee(val id: Int, val firstName: String, val lastName: String) {
    abstract fun getSalary(): Double

}