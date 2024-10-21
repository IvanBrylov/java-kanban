import java.util.ArrayList;

public interface TaskManger {
    Task createTask(Task task);

    Task updateTask(Task task);

    ArrayList<Task> showMeAllTasks();

    boolean deleteTask(int taskId);

    void deleteAllTasks();

    void createSubTask(SubTask subTask);

    void updateSubTask(SubTask subTask);

    ArrayList<SubTask> showMeAllSubtaskInEpic(Epic epic);

    void deleteSubTask(int id);

    void deleteAllSubTasks();

    Epic createEpic(Epic epic);

    void updateEpic(Epic epic);

    ArrayList<Task> showMeAllEpics();

    void deleteEpic(Epic epic);

    void deleteAllEpics();

    void printAllEpics();

    void printEpicFromId();

    void checkEpicStatus(Epic epic);

}
