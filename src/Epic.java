import java.util.ArrayList;
import java.util.Arrays;

public class Epic extends Task{
    public ArrayList<SubTask> subTasksList;
    public Epic(String task, String description) {
        super(task, description);
        subTasksList = new ArrayList<>();
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
