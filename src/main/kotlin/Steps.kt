class Steps {

    fun run() {
        val menu = Menu()
        val operate = ArcHiveOperations()

        while (true) when (menu.arcHiveMenu()) {
            0 -> operate.createArcHive()
            1 -> {
                if (operate.showArcHives() == null) {
                   // menu.showError()
                } else {
                    val arcHive = operate.selectArcHive()
                    while (true) {
                        when (menu.notesMenu()) {
                            0 -> operate.createNote(arcHive)
                            1 -> {
                                if (operate.selectNote(arcHive) == null) {
                                   // menu.showError()
                                } else {
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

            2 -> {
                println("Bye")
                return
            }

            else -> menu.showError()
        }
    }
}