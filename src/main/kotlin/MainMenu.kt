import java.util.Scanner
class Menu {
    private val scanner = Scanner(System.`in`)
    fun arcHiveMenu(): Int {
        val mString =
            """ |Главное меню 
                |0. Создать архив 
                |1. Созданные архивы 
                |2. Выход 
                |Выберите пункт
                |
                """.trimMargin()
        print(mString)

        return Menu().repeat()

    }

    fun notesMenu(): Int {

        val mString =
            """ |Заметки 
                |0. Создать заметку 
                |1. Созданые заметки 
                |2. Выход в главное меню
                |Выберите пункт
                |
                """.trimMargin()
        print(mString)

        return Menu().repeat()

    }

    fun showError() {
        println("Выберите пункт")
    }

    private fun repeat(): Int {

        while (true) {

            if (scanner.hasNextInt()) {
                val scan = scanner.nextInt()
                if (scan in 0..2) {
                    return scan
                } else {
                    Menu().showError()
                    scanner.nextLine()
                }
            } else {
                Menu().showError()
                scanner.nextLine()
            }
        }
    }
}