import java.util.Scanner

class ArcHiveOperations {
    internal val scan = Scanner(System.`in`)
    private val arcHives: MutableList<Archive> = mutableListOf()


    fun createArcHive() {
        println("Введите название архива. Или \"-\" что бы вернуться.")
        val input = scan.nextLine()
        if (input.isEmpty()) {
            println("Вы не можете создать архив без заголовка")
        } else if (input.equals("-")) {
            return
        } else {
            val notes = mutableListOf<Note>()
            arcHives.add(Archive(input, notes))
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
            for ((index, archive) in arcHives.withIndex()) {
                println("${index + 1}. ${archive.name}")
            }
        }
        return println(
            "Для выбора архива введите любое число.\n" +
                    "Символ что бы вернуться"
        )
    }

    fun selectArcHive(): Archive {
        while (true) {
            println("Выберите номер архива")
            val input = scan.nextLine()
            if (scan.hasNextInt()) {
                try {
                    val index = input.toInt() - 1
                    if (index in arcHives.indices) {
                        return arcHives[index]
                    } else {
                        println("Введите номер архива от 1 до ${arcHives.size}")
                    }
                } catch (e: NumberFormatException) {
                    println("Неверный ввод. Пожалуйста, введите число.")
                }
            }
        }
    }


    fun createNote(ArcHive: Archive) {

        println("Введите название заметки. Или \"-\" что бы вернуться.")
        val title = Scanner(System.`in`).nextLine()
        while (true) {
            if (title.isEmpty()) {
                println("Вы не можете создать заметку без заголовка или пустую заметку")
            } else if (title.equals("-")) {
                return
            } else {
                break
            }
        }
        println("Введите текст заметки:")
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


    fun showNotes(ArcHive: Archive): Note {
        println("Выберите номер заметки")
        try {
                val i = arcHives.indexOfFirst { it.name == ArcHive.name }
                while (true) {
                    if (choice()) {
                        val c = scan.nextInt()
                        return arcHives[i].arcHivesList[c - 1]
                    } else {
                        println("Введите номер заметки от 1 до ${arcHives[i].arcHivesList.size}")

                    }
                }

        } catch (e: IndexOutOfBoundsException) {
            println("Такой нет. Попробуйте еще.")
        }
        return showNotes(ArcHive)
    }


    fun selectNote(ArcHive: Archive): Unit? {
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
        return println(
            "Для выбора заметки введите любое число.\n" +
                    "Символ что бы вернуться"
        )

    }

    fun showNoteDetails(notes: Note) {
        println("Заметка")
        println("Название:\n ${notes.name}")
        println("Текст:\n ${notes.notesList}")
        println("Введите любой символ для выхода в меню заметок")
        scan.next()
    }

    private fun choice(): Boolean {
        return Scanner(System.`in`).hasNextInt()
    }
}