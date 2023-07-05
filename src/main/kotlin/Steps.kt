class Steps {

    private val menu = Menu()
    private val operate = ArcHiveOperations()
    fun run() {

        while (true) when (menu.arcHiveMenu()) {
            0 -> operate.createArcHive()
            1 -> {
                if (operate.showArcHives() == null) {
                } else if (operate.scan.hasNextInt()) {
                    val arcHive = operate.selectArcHive()
                    noteJump(arcHive)
                } else {
                    println()

                }
            }

            2 -> {
                println("Пока пока !")
                return
            }

            else -> menu.showError()
        }
    }

    private fun noteJump(arcHive: Archive) {
        while (true) {
            when (menu.notesMenu()) {
                0 -> operate.createNote(arcHive)
                1 -> {
                    if (operate.selectNote(arcHive) == null) {
                    } else if (operate.scan.hasNextInt()) {
                        val note = operate.showNotes(arcHive)
                        operate.showNoteDetails(note)
                    }
                }

                2 -> break
                else -> menu.showError()
            }
        }
    }
}