public class Managers {
    public static InMemoryTaskManager getDafault() {
        return new InMemoryTaskManager();
    }
    public static InMemoryHistoryManager getDefaultHistory(){
        return new InMemoryHistoryManager();
    }

}
