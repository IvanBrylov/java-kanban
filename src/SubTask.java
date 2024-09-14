public class SubTask extends Task{
    private Integer epicId;

    public SubTask(Integer id, String task, String description, Status status) {
        super(id, task, description, status);
        setEpicId(id);
    }
    public Integer getEpicId() {
        return epicId;
    }
    public void setEpicId(Integer epicId) {
        this.epicId = epicId;
    }
    @Override
    public String toString() {
        return "SubTask {" +
                "name ='" + getName() +
                ", status =" + getStatus() +
                ", id =" + getId() +
                ", epic_id =" + epicId +
                '}';
    }
}
