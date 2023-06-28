import java.util.Scanner

class ArcHiveOperations {
    val scan = Scanner(System.`in`)
    private val arcHives: MutableList<ArcHive> = mutableListOf()


    fun createArcHive() {
        println("Введите название архива. Или \"-\" что бы вернуться.")
        val input = Scanner(System.`in`).nextLine()
        if (input.isEmpty()) {
            println("Вы не можете создать архив без заголовка")
            return
        } else if (input.equals("-")) {
            return
        } else {
            val notes = mutableListOf<Note>()
            arcHives.add(ArcHive(input, notes))
            println("Архив создан")
            return

        }
    }

    fun showArcHives(): Unit? {
        if (arcHives.isEmpty()) {
            println("\nСписок архивов пуст.\n")

            return null
        } else {
            println("\nСписок архивов:")
            for ((index, ArcHive) in arcHives.withIndex()) {
                println("${index + 1}. ${ArcHive.name}")
            }
        }
        return println(
            "Для выбора архива введите любое число.\n" +
                    "Символ что бы вернуться"
        )
    }

    fun selectArcHive(): ArcHive {
        println("Выберите номер архива")
        try {
            while (true) {
                if (scan.hasNextInt()) {
                    while (true) {
                        val c = scan.nextInt()
                        return arcHives[c - 1]
                    }
                } else {
                    println("Введите номер архива который хотите выбрать 1 до ${arcHives.size}")
                    scan.next()
                }
            }
        } catch (e: IndexOutOfBoundsException) {
            println("Такого нет. Попробуйте еще.")
        }
        return selectArcHive()
    }


    fun createNote(ArcHive: ArcHive) {

        println("Введите название заметки. Или \"-\" что бы вернуться.")
        val title = Scanner(System.`in`).nextLine()
        while (true) {
            if (title.isEmpty()) {
                println("Вы не можете создать заметку без заголовка или пустую заметку")
                return
            } else if (title.equals("-")) {
                return
            } else {
                break
            }
        }
        println("Ввведите текст заметки:")
        val text = Scanner(System.`in`).nextLine()
        while (true) {
            if (text.isEmpty()) {
                println("Вы не можете создать пустую заметку")
                return
            } else {
                break
            }
        }
        ArcHive.arcHivesList.add(Note(title, text))
        println("Заметка создана")
        return
    }


    fun showNotes(ArcHive: ArcHive): Note {
        println("Выберите номер заметки")
        try {
            val i = arcHives.indexOfFirst { it.name == ArcHive.name }


            while (true) {

                if (scan.hasNextInt()) {
                    val choice = scan.nextInt()
                    return arcHives[i].arcHivesList[choice - 1]
                } else {
                    println("Введите номер заметки от 1 до ${arcHives[i].arcHivesList.size}")
                    scan.next()
                }
            }
        } catch (e: IndexOutOfBoundsException) {
            println("Такой нет. Попробуйте еще.")
        }
        return showNotes(ArcHive)
    }


    fun selectNote(ArcHive: ArcHive): Unit? {
        val i = arcHives.indexOfFirst { it.name == ArcHive.toString() }

        if (arcHives[i].arcHivesList.isEmpty()) {
            println("\nСписок заметок пуст.\n")
            return null
        } else {
            println("\nСписок заметок:")
            for ((index) in arcHives[i].arcHivesList.withIndex()) {
                println("${index + 1}. ${arcHives[i].arcHivesList[index]}")

            }
        }
        return println("")

    }

    fun showNoteDetails(notes: Note) {
        println("Заметка")
        println("Название:\n ${notes.name}")
        println("Текст:\n ${notes.notesList}")
        println("Введите любой символ для выхода в меню заметок")
        scan.next()
    }
}