package prototype

open class Bike : Cloneable {
    private var gears: Int = 0
    private var bikeType: String
    var model: String
        private set

    init {
        bikeType = "Standard"
        model = "Leopard"
        gears = 4
    }

    public override fun clone(): Bike {
        return Bike()
    }

    fun makeAdvanced() {
        bikeType = "Advanced"
        model = "Jaguar"
        gears = 6
    }
}

fun makeBike(): Bike {
    return Bike()
}

fun makeJaguar(basicBike: Bike): Bike {
    basicBike.makeAdvanced()
    return basicBike
}

fun main() {
    val bike = makeBike()
    println("Basic Bike: " + bike.model)
    val basicBike = bike.clone()
    println("Clone Bike: " + basicBike.model)
    val advancedBike = makeJaguar(basicBike)
    println("Advanced  : " + advancedBike.model)
}