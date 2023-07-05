data class Archive(
    val name: String,
    var arcHivesList: MutableList<Note>
) {
    override fun toString() = name
}