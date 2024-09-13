import java.util.ArrayList;
import java.util.Arrays;

public class Epic extends Task{
    public ArrayList<SubTask> subTasksList;
    public Epic(String task, String description) {
        super(task, description);
        subTasksList = new ArrayList<>();
    }
    public Epic(String task, Status status, String description) {
        super(task, status, description);
        subTasksList = new ArrayList<>();
    }
    public Epic(Integer id, String task, String description, Status status) {
        super(id, task, description, status);
        subTasksList = new ArrayList<>();
    }
    public void setSubTasksList(ArrayList<SubTask> subTasksList) {
        this.subTasksList = subTasksList;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "name ='" + getName() +
                ", description ='" + getDescription() +
                ", id =" + getId() +
                ", status =" + getStatus() +
                ", subTasksList ='" + Arrays.toString(new ArrayList[]{subTasksList}) + '\'' +
                '}';
    }


}
