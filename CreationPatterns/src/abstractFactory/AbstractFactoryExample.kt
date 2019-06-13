package abstractFactory

/**
 * Our factories are going to produce objects of type Cook
 */
interface Cook {
    val name : String
    fun cook()
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

    }

    private class Tina : BurgerCook {
        override val name: String
            get() = "Tina"

        override fun cook() {
            println("Tina dropped the burger on the floor while cooking it")
        }

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

    }

    private class JimmyJr : PizzaCook {

        override val name: String
            get() = "Jimmy Junior"

        override fun cook() {
            println("Jimmy Junior started dancing rather than cooking a pizza")
        }
    }
}

fun makeCook(factory: CookFactory, name : String) : Cook {
    return factory.getInstance(name)
}

fun main(args : Array<String>){
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