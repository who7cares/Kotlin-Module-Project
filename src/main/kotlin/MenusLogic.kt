import java.util.Scanner

class MenusLogic {
    companion object {
        private val scanner = Scanner(System.`in`)

        fun <T> makeNewObj(obj: MutableList<T>, elem: T): MutableList<T> {
            obj.add(elem)
            return obj
        }

        fun <T> removeObj(obj: MutableList<T>, elem: T) {
            obj.remove(elem)

        }

        fun chekUserAnswer(options: IntRange, menuScreen: Int): Int {
            while (true) {
                // три экрана меню: 0 - Главный; 1 - Архивы; 2 - Заметки.
                when(menuScreen){
                    0 -> ShowUserText.showMainMenu()
                    1 -> ShowUserText.showArchiveMenu()
                    2 -> ShowUserText.showNoteMenu()
                    3 -> println("Выберите номер архива:")
                    4 -> println("Выберите номер заметки:")
                }

                if (scanner.hasNextInt()) {
                    val chek = scanner.nextInt()

                    if (chek in options) {
                        return chek
                    } else {
                        println("Ошибка!!! Число вне диапазона\n")
                    }
                } else {
                    println("Ошибка!!! Введено не число\n")
                    scanner.next()
                }
            }
        }
    }
}