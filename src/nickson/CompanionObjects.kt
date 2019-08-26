package nickson

/* Companion objects
 * - Kotlin doesn't have static members/member functions. They recommend you use package-level functions instead.
 * - Java static members/functions rule of thumb: ask yourself "does it make sense to call this method, even if no Obj
 * has been constructed yet? If so, it should definitely be static
 * */
class EventManager {
    companion object FireBaseManager {}
}

// companion object name is optional

class AnotherEventManager {
    companion object {}
}

// TODO: read the documentation on CLASSES AND OBJECTS sequentially.
fun main() {
    val firebaseManager = EventManager.FireBaseManager
    val anotherEventManager = AnotherEventManager.Companion
}