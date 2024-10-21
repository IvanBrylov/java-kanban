import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{
    private final List<Task> historyArray = new ArrayList<>();



    @Override
    public void add(Task task) {
        if(historyArray.size()>=10){
            historyArray.remove(historyArray.getFirst());
            historyArray.add(task);
        }else{
            historyArray.add(task);
        }
    }

    @Override
    public List<Task> getHistory(){
        return historyArray;

    }
}
