package abstractFactory

/**
 * Our factories are going to produce objects of type Cook
 */
interface Cook {
    val name : String
    fun cook()
    val restaurant: Restaurant
    fun workInfo() {
        println("$name works in a ${restaurant.type}")
        println("${restaurant.type} has a " + getEquipment())
    }
    private fun getEquipment() {
        var equipmentList = ""
        restaurant.equipment.forEach { equipmentList = " $equipmentList $it"  }
    }
}

interface Restaurant {
    val type: String
    val equipment: List<String>
}

/**
 * BurgerCook is made by the BurgerCookFactory
 */
interface BurgerCook : Cook

/**
 * PizzaCook is made by the PizzaCookFactory
 */
interface PizzaCook : Cook

/**
 * The CookFactory is the base interface for our Factory
 */
interface CookFactory {
    fun getInstance(name : String) : Cook
}

/**
 * BurgerCookFactory implements CookFactory and serves as a concrete class to
 * make Cooks that make burgers
 */
class BurgerCookFactory : CookFactory {
    override fun getInstance(name: String) : BurgerCook {
        return when (name){
            "Bob" -> Bob()
            "Tina" -> Tina()
            else -> throw IllegalArgumentException("No class available for $name")
        }
    }

    /**
     * Bob is one concrete class
     */
    private class Bob : BurgerCook {
        override val name: String
            get() = "Bob"

        override fun cook() {
            println("Bob cooked Poutine on the Ritz Burger")
            println("           (comes with Poutine Fries)")
        }

        override val restaurant: Restaurant
            get() = BurgerShop()


    }

    private class Tina : BurgerCook {
        override val name: String
            get() = "Tina"

        override fun cook() {
            println("Tina dropped the burger on the floor while cooking it")
        }

        override val restaurant: Restaurant
            get() = BurgerShop()

    }

    private class BurgerShop : Restaurant {
        override val type: String
            get() = "Burger Shop"

        override val equipment: List<String>
            get() = listOf("Grill", "Fryer", "Ice Cream Machine")
    }
}

/**
 * This factory is for PizzaCooks
 */
class PizzaCookFactory : CookFactory {
    override fun getInstance(name: String) : PizzaCook {
        return when (name){
            "Jimmy" -> Jimmy()
            "Jr" -> JimmyJr()
            else -> throw IllegalArgumentException("No class available for $name")
        }
    }

    private class Jimmy : PizzaCook {
        override val name: String
            get() = "Jimmy"

        override fun cook() {
            println("Jimmy is cooking a bacon cheeseburger pizza")
        }

        override val restaurant: Restaurant
            get() = Pizzaria()

    }

    private class JimmyJr : PizzaCook {

        override val name: String
            get() = "Jimmy Junior"

        override fun cook() {
            println("Jimmy Junior started dancing rather than cooking a pizza")
        }

        override val restaurant: Restaurant
            get() = Pizzaria()
    }

    private class Pizzaria: Restaurant {
        override val type: String
            get() = "Pizzaria"

        override val equipment: List<String>
            get() = listOf("Pizza Oven", "Salad Bar")
    }
}

fun makeCook(factory: CookFactory, name : String) : Cook {
    return factory.getInstance(name)
}

fun main() {
    val burgerFactory = BurgerCookFactory()
    val pizzaFactory = PizzaCookFactory()

    var cook = makeCook(burgerFactory, "Bob")
    cook.cook()

    println()
    cook = makeCook(burgerFactory, "Tina")
    cook.cook()

    println()
    cook = makeCook(pizzaFactory, "Jimmy")
    cook.cook()

    println()
    cook = makeCook(pizzaFactory, "Jr")
    cook.cook()
}