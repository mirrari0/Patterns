package singleton

class CacheManager private constructor() {

    private val mCache: MutableMap<String, String> = mutableMapOf()


    init {
        ++myInstancesCount
    }


    companion object {
        var myInstancesCount = 0
        private val mInstance: CacheManager = CacheManager()

        @Synchronized
        fun getInstance(): CacheManager {
            return mInstance
        }
    }

    fun put(key: String, value: String) {
        when {
            !key.isEmpty() -> mCache.put(key, value)
            else -> throw IllegalArgumentException("Key cannot be empty")
        }
    }

    fun get(key: String): String? {
        return when {
            mCache.containsKey(key) -> mCache.get(key)
            else -> null
        }
    }

}

class FileResource {
    private val cacheManager: CacheManager = CacheManager.getInstance()
    fun doFileOperation() {
        println("Doing file operation")
        cacheManager.put("file", "this is some file operation")
        println("File operation completed with hashcode *${cacheManager.hashCode()}*")
    }
}

class NetworkResource {
    private val cacheManager: CacheManager = CacheManager.getInstance()
    fun doNetworkOperation() {
        println("Doing network operation")
        cacheManager.put("network", "this is some network operation")
        println("Network operation completed with hashcode *${cacheManager.hashCode()}*")
    }
}

fun main() {
    val cacheManager: CacheManager = CacheManager.getInstance()

    println("Initial CacheManager instance count is ${CacheManager.myInstancesCount}")

    println("")

    val networkRes = NetworkResource()
    networkRes.doNetworkOperation()
    println("CacheManager instance count is ${CacheManager.myInstancesCount} after network operation")

    println("")

    val fileRes = FileResource()
    fileRes.doFileOperation()
    println("CacheManager instance count is ${CacheManager.myInstancesCount} after file operation")

    println("")
    println("Main call cache manager hashcode *${cacheManager.hashCode()}*")

    println("File operation value: ${cacheManager.get("file")}")
    println("Network operation value: ${cacheManager.get("network")}")
    println("Main call cache manager hashcode after retrieving values *${cacheManager.hashCode()}*")

}


