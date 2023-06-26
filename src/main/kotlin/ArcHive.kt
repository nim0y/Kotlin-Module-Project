data class ArcHive(
    val name: String,
    var arcHivesList: MutableList<Note>
) {
    override fun toString() = name
}