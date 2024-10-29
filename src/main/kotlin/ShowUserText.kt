class ShowUserText {
    companion object {
        fun showMainMenu() {
            println(
                "Выберите действие:\n" +
                        "0. Создать архив\n" +
                        "1. Открыть архив\n" +
                        "2. Выйти из программы\n" +
                        "\n" +
                        "Введите цифру: "
            )
        }

        fun showArchiveMenu() {
            println(
                "Выберите действие с архивом:\n" +
                        "0. Создать заметку\n" +
                        "1. Открыть заметку\n" +
                        "2. Удалить архив\n" +
                        "3. Вернуться к выбору архива" +
                        "\n" +
                        "Введите цифру: "
            )
        }

        fun showNoteMenu() {
            println(
                "0. Редактироввать заметку\n" +
                        "1. Удалить заметку\n" +
                        "2. Вернуться к выбору заметок" +
                        "\n" +
                        "Введите цифру: "
            )
        }

    }


}