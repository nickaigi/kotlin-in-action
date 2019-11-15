package nickson.java_interop

fun main() {
    val session = Session()
    val description = session.description
    // note: kotlin says the type of description is String! (platform type)
    // but after we added the @Nullable, now the type is String?
    println(description?.length) // after adding the @Nullable annotation, you must use safe access
}