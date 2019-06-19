package factory

interface Book {

    fun getInfo()
    fun order()
    fun rate()
}

enum class Genre {
    SCIENCE, LITERATURE
}

class BookFactory {

    companion object {
        fun createBook(genre: Genre) : Book = when (genre) {
            Genre.SCIENCE ->  object: Book {
                private val title = "Theory of Relativity"
                override fun getInfo() = println("$title ...")
                override fun order() = println("Order $title")
                override fun rate() = println("Rate for $title")
            }
            Genre.LITERATURE -> object: Book {
                private val title = "The Greatest of Gatsby's"
                override fun getInfo() = println("$title ...")
                override fun order() = println("Order $title")
                override fun rate() = println("Rate for $title")
            }
        }
    }
}


fun main() {
    var book = BookFactory.createBook(Genre.SCIENCE)

    book.getInfo()
    book.order()
    book.rate()

    book = BookFactory.createBook(Genre.SCIENCE)

    book.getInfo()
    book.order()
    book.rate()
}