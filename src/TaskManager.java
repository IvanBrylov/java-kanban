import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TaskManager {
    private HashMap<Integer, Task> tasks;
    private Map<Integer, Epic> epics = new HashMap<>();
    private Map<Integer, SubTask> subTasks = new HashMap<>();
    private static int id;

    public static int idGeneration() {
        return ++id;
    }
    public TaskManager() {
        this.tasks = new HashMap<>();
    }
    public Task get (int id){
        return tasks.get(id);
    }
    public Task createTask (Task task){
        task.setId(idGeneration());
        tasks.put(task.getId(), task);
        return task;
    }
    public Task updateTask(Task task){
        Integer taskId = task.getId();
        if (taskId == null || !tasks.containsKey(taskId)){
            return null;
        }
        tasks.put(taskId, task);
        return task;
    }
    public ArrayList<Task> showMeAllTasks() {
        ArrayList<Task> TasksForOutput = new ArrayList<>();

        for (Task x : tasks.values()) {
            if (x.getClass() == Task.class) {
                TasksForOutput.add(x);
            }
        }
        return TasksForOutput;
    }
    public boolean deleteTask(int taskId) {
        return tasks.remove(taskId) != null;
    }
    public void deleteAllTasks(){
        tasks.clear();
    }
    public SubTask createSubTask (SubTask subTask){
        subTask.setId(idGeneration());
        subTasks.put(subTask.getId(), subTask);
        Epic epic = epics.get(subTask.getEpicId());
        subTask.setEpicId(epic.getId());
        epic.subTasksList.add(subTask);
        checkEpicStatus(epic);
        return subTask;
    }
    public void updateSubTask(SubTask subTask) {

        Epic epic = epics.get(subTask.getEpicId());
        for (SubTask i : epic.subTasksList) {
            if (i.getId() == subTask.getId()) {
                i.setName(subTask.getName());
                i.setDescription(subTask.getDescription());
                i.setStatus(subTask.getStatus());
            }
        }
        checkEpicStatus(epic);
    }
    public ArrayList<SubTask> showMeAllSubtaskInEpic(Epic epic) {
        return epic.subTasksList;
    }
    public boolean deleteSubTask(int id) {
        return subTasks.remove(id) != null;
    }
    public void deleteAllSubTasks(){

        subTasks.clear();

    }

    public Epic createEpic(Epic epic){
        Epic epic1 = new Epic(epic.getName(), epic.getDescription());
        epic1.setId(idGeneration());
        epics.put(epic1.getId(), epic1);
        return epic1;
    }
    public void updateEpic(Epic epic){
        Epic saved = epics.get(epic.getId());
        if (saved == null){
            return;
        }
        saved.setName(epic.getName());
        saved.setDescription(epic.getDescription());
        checkEpicStatus(epic);
    }
    public ArrayList<Task> showMeAllEpics() {
        ArrayList<Task> TasksForOut = new ArrayList<>();
        for (Task i : tasks.values()) {
            if (i.getClass() == Epic.class) {
                TasksForOut.add(i);
            }
        }
        return TasksForOut;
    }
    public void deleteEpic(Epic epic){
        for (SubTask i : epic.subTasksList) {
            if (i.getEpicId() == epic.getId()) {
                deleteSubTask(i.getId());
            }
            epics.remove(epic.getId());
        }
    }

    public void deleteAllEpics(){
        epics.clear();
    }

    public void printAllEpics() {
        for (Epic epic : epics.values()){
            System.out.println("Эпик: " + epic + "\nСодержит задачи:");
            for (SubTask subTask : subTasks.values()) {
                if (epics.containsKey(epic.getId()) == subTasks.containsKey(subTask.getId())) {
                    System.out.println(subTask);
                }
            }
        }
    }
    public void printEpicFromId(int id) {
        for (Epic epic : epics.values()){
            System.out.println("Эпик: " + epic.getName() + ", со статусом: " + epic.getStatus() + "\nСодержит задачи:");
            System.out.println(epic.subTasksList);
        }
    }
    protected Status checkEpicStatus(Epic epic) {
        int checkNew = 0;
        int checkDone = 0;

        if (epic.subTasksList.isEmpty()) {
            epic.setStatus(Status.NEW);
        } else {
            for (SubTask y : epic.subTasksList) {
                if (y.getStatus() == (Status.NEW)) {
                    checkNew++;
                } else if (y.getStatus() == (Status.DONE)) {
                    checkDone++;
                }
            }
            if (checkDone == epic.subTasksList.size()) {
                epic.setStatus(Status.DONE);
            } else if (checkNew == epic.subTasksList.size()) {
                epic.setStatus(Status.NEW);
            } else {
                epic.setStatus(Status.IN_PROGRESS);
            }
        }return epic.getStatus();
    }
}
