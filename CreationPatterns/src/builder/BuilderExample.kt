package builder

class Burger (
        var bun: Bun,
        var meat: Meat,
        var bacon: Boolean,
        var lettuce: Boolean,
        var tomato: Boolean,
        var onion: Boolean,
        var ketchup: Boolean,
        var mustard: Boolean) {

    data class Builder(
            var bun: Bun = Bun.WHITE,
            var meat: Meat = Meat.BEEF,
            var bacon: Boolean = false,
            var lettuce: Boolean = true,
            var tomato: Boolean = true,
            var onion: Boolean = true,
            var ketchup: Boolean = true,
            var mustard: Boolean = true

    ) {
        fun bun(bun: Bun) = apply { this.bun = bun }
        fun meat(meat: Meat) = apply { this.meat = meat}
        fun bacon(bacon: Boolean) = apply { this.bacon = bacon }
        fun lettuce(lettuce: Boolean) = apply { this.lettuce = lettuce }
        fun tomato(tomato: Boolean) = apply { this.tomato = tomato }
        fun onion(onion: Boolean) = apply { this.onion = onion }
        fun ketchup(ketchup: Boolean) = apply { this.ketchup = ketchup }
        fun mustard(mustard: Boolean) = apply { this.mustard = mustard }
        fun build() = Burger(bun, meat, bacon, lettuce, tomato, onion, ketchup, mustard)
    }

    enum class Bun {
        WHITE,WHEAT,PROTEIN_STYLE,ONION,GLUTEN_FREE
    }

    enum class Meat {
        BEEF,TURKEY,PORK,CHICKEN,IMPOSSIBLE,MUSHROOM
    }

    override fun toString() : String {
        return "ORDER: ${meat.name} Burger " +
                "\n\t - ${bun.name} BUN"+
                "\n\t - " + baconString() +
                "\n\t - " + lettuceString() +
                "\n\t - " + tomatoString() +
                "\n\t - " + onionString() +
                "\n\t - " + ketchupString() +
                "\n\t - " + mustardString()
    }

    private fun baconString() : String {
        return if(bacon) "bacon" else "No bacon"
    }
    private fun lettuceString() : String {
        return if(lettuce) "lettuce" else "No lettuce"
    }
    private fun tomatoString() : String {
        return if(tomato) "tomato" else "No tomato"
    }
    private fun onionString() : String {
        return if(onion) "onion" else "No onion"
    }
    private fun ketchupString() : String {
        return if(ketchup) "ketchup" else "No ketchup"
    }
    private fun mustardString() : String {
        return if(mustard) "mustard" else "No mustard"
    }
}

fun main() {
    val burger = Burger.Builder().build()
    val burger2 = Burger.Builder().bacon(true).meat(Burger.Meat.TURKEY).bun(Burger.Bun.ONION).onion(false).ketchup(false).mustard(false).lettuce(true).tomato(false).build()

    println(burger.toString())
    println()
    println(burger2.toString())

}