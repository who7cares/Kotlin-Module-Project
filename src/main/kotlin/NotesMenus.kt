import java.util.Scanner


open class NotesMenus {
    private val scanner = Scanner(System.`in`)
    private val archiveCatalog: MutableList<Archive> = mutableListOf()

    fun mainMenu() {
        while (true) {

            val userAnswer = MenusLogic.chekUserAnswer(0..2, 0)
            when (userAnswer) {
                0 -> {
                    MenusLogic.makeNewObj(archiveCatalog, Archive())
                    println("Архив создан\n")
                }

                1 -> {
                    if (archiveCatalog.size < 1) {
                        println("Ошибка!!! Список архивов пуст\n")
                        continue
                    } else {
                        archiveCatalog.forEachIndexed { index, archive -> println("Архив №${index + 1} содержит ${archive.notes.size} заметок") }
                        val archiveIndex = MenusLogic.chekUserAnswer(1..archiveCatalog.size, 3) - 1
                        // передаем выбранный архив в экран архивов
                        archiveMenu(archiveCatalog[archiveIndex])
                    }
                }

                2 -> {
                    println("Завершение программы")
                    break
                }
            }
        }
    }


    fun archiveMenu(archive: Archive) {

        while (true) {
            val userAnswer = MenusLogic.chekUserAnswer(0..3, 1)

            when (userAnswer){
                0 -> {
                    println("Введите текст заметки:")
                    MenusLogic.makeNewObj(archive.notes, scanner.nextLine())
                    println("Заметка создана\n")
                }

                1 -> {
                    if(archive.notes.size != 0){
                        archive.notes.forEachIndexed { index, it -> println("Заметка №${index + 1}: '$it'")  }
                        val note = archive.notes[MenusLogic.chekUserAnswer(1..archive.notes.size, 4) - 1]
                        noteMenu(note, archive)
                    } else {
                        println("Ошибка!!! В архиве нет заметок\n")
                    }
                }
                2 -> {
                    MenusLogic.removeObj(archiveCatalog, archive)
                    println("Архив удален\n")
                    break
                }

                3 -> break
            }
        }
    }

    fun noteMenu(note: String, archive: Archive){
        var notE = note

        while (true){
            println("\nВыбранная заметка №${(archive.notes.indexOf(notE) + 1)}: $notE")
            val userAnswer = MenusLogic.chekUserAnswer(0..2, 2)

            when (userAnswer) {
                0 -> {

                    println("Введите текст заметки:")
                    notE = scanner.nextLine()
                    archive.notes[archive.notes.indexOf(note)] = notE
                    println("Заметка изменена")
                }

                1 -> {
                    MenusLogic.removeObj(archive.notes, notE)
                    println("Заметка удалена")
                    break
                }

                2 -> break
            }
        }
    }
}

