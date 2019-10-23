package nickson.inheritance

import java.lang.Integer.min

/*
 * Adapted from https://www.journaldev.com/19705/kotlin-inheritance
 */
open class Employee(open val name: String) {
    init {
        println("An employee")
    }

    var age = 24
    open fun printDetails() = println("Employee name: $name")
}

open class Developer(override val name: String, open var salary: Int): Employee(name) {
    init {
        println("A Developer")
    }

    override fun printDetails() = println("Developer: $name, Salary: $salary")
}

class AndroidDeveloper(name: String, income: Int): Developer(name, income) {
    override var name = "Name property value is $name".also(::println)
    override var salary: Int = 0
        get() = field
        set(value) {
            if (value >= 100_000) {
                field = min(50_000, value)
            }
        }

    init {
        println("An Android Developer. If Salary >= 100000. It's halved.")
        salary = income
    }

    fun works() = println("Builds Apps")

    override fun printDetails() {
        super.printDetails()
        println("This is an Android Developer")
    }
}

class JuniorDeveloper: Developer {
    var aName = "Name is $name".also(::println)

    init {
        println("A junior Developer")
    }

    var mySkill: String?

    override var salary: Int = 0
        get() = field
        set(value) {
            if (value > 50_000) {
                field = min(10_000, value)
            } else field = value
        }

    constructor(name: String, income: Int, skill: String): super(name, income) {
        mySkill = skill
        salary = income
    }

    override fun printDetails() {
        println("Junior Dev name: $name and salary: $salary, skill: $mySkill")
    }
}

fun main() {
    var employee = Employee("Nickson")
    employee.printDetails()

    println("----------------------------------")

    var developer = Developer("Mutwa", 10_000)
    developer.printDetails()
    println(developer.age)

    println("----------------------------------")
    employee = developer
    employee.printDetails()
    println(employee.name)
}