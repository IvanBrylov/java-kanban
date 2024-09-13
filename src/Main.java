import java.util.List;

public class Main {

    public static void main(String[] args) {
        testTask();



    }

    private static void testTask(){
        TaskManager taskManager = new TaskManager();

        System.out.println("1 тест: Пустой список");
        List<Task> tasks = taskManager.showMeAllTasks();
        System.out.println("Задачи пустые? -" + tasks.isEmpty() + "\n");

        System.out.println("2 тест: Создание задачи");
        Task task1 = new Task("Задача первая", Status.NEW, "описание первой задачи");
        Task task1Created = taskManager.createTask(task1);
        Task task2 = new Task("Задача вторая", Status.NEW, "описание второй задачи");
        Task task2Created = taskManager.createTask(task2);
        System.out.println("Айди у 1 задачи: " + task1Created.getId());
        System.out.println("Айди у 2 задачи: " + task2Created.getId());
        System.out.println("Список задач должен включать в себя нашу: " + taskManager.showMeAllTasks() + "\n");

        System.out.println("3 тест: Обновление задачи");
        Task task1Upd = new Task(task1Created.getId(), "Первая задача обновлённая", "описание обновлённой задачи", Status.IN_PROGRESS);
        Task task1Updated = taskManager.updateTask(task1Upd);
        Task task2Upd = new Task(task2Created.getId(), "Вторая задача обновлённая", "описание обновлённой задачи", Status.IN_PROGRESS);
        Task task2Updated = taskManager.updateTask(task2Upd);
        System.out.println("Обновлённая задачи с новыми полями: " + task1Updated + task2Updated + "\n");

        System.out.println("4 тест: Удаление задачи");
        boolean deleteResult = taskManager.deleteTask(task1Updated.getId());
        System.out.println("Удаление задачи должно пройти успешно: " + deleteResult);
        System.out.println("Список задач теперь стал таким: " + taskManager.showMeAllTasks());
        System.out.println("5 тест: Эпики и подзадачи");

        Epic epic1 = new Epic("Эпик 1", "Описание 1 эпика");
        Epic epic2 = new Epic("Эпик 2", "Описание 2 эпика");
        Epic epic1Created = taskManager.createEpic(epic1);
        Epic epic2Created = taskManager.createEpic(epic2);
        System.out.println("Список Эпиков: " + taskManager.showMeAllEpics() + "\n");
        SubTask subTask1 = new SubTask(epic1Created.getId(), "Подзадача 1-1", "Описание 1 подзадачи 1го эпика", Status.NEW);
        SubTask subTask2 = new SubTask(epic1Created.getId(), "Подзадача 1-2", "Описание 2 подзадачи 1го эпика", Status.NEW);
        SubTask subTask3 = new SubTask(epic2Created.getId(), "Подзадача 2-1", "Описание 1 подзадачи 2го эпика", Status.NEW);
        taskManager.createSubTask(subTask1);
        taskManager.createSubTask(subTask2);
        taskManager.createSubTask(subTask3);
        System.out.println("Список эпиков");
        taskManager.printAllEpics();
        System.out.println("-".repeat(50));
        taskManager.printEpicFromId(epic1Created.getId());
        System.out.println("-".repeat(50));
        subTask2.setStatus(Status.IN_PROGRESS);
        taskManager.updateSubTask(subTask2);

        System.out.println("Список эпиков");
        taskManager.printAllEpics();
        subTask1.setStatus(Status.DONE);
        subTask2.setStatus(Status.DONE);
        taskManager.updateSubTask(subTask1);
        taskManager.updateSubTask(subTask2);
        System.out.println("-".repeat(50));
        taskManager.printEpicFromId(epic1Created.getId());
        System.out.println("-".repeat(50));
        System.out.println(taskManager.showMeAllSubtaskInEpic(epic1Created));
        System.out.println("-".repeat(50));
        System.out.println("-".repeat(50));
        System.out.println("-".repeat(50));
        epic1Created.setDescription("Всё по новой");
        taskManager.updateEpic(epic1Created);
        taskManager.deleteAllTasks();
        System.out.println("Удалил таски" + taskManager.showMeAllTasks());
        taskManager.deleteAllSubTasks();
        System.out.println("Удалил сабтаски");
        taskManager.printAllEpics();
        taskManager.deleteAllEpics();
        System.out.println("Удалил эпики");
        taskManager.printAllEpics();



    }
}
