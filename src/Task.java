import java.io.Serializable;

public class Task implements Serializable {

    private int mPriority;
    private String mName, mDuedate, mDeadline;

    public Task(String name, String dueDate, String deadLine, int priority) {
        mName = name;
        mDuedate = dueDate;
        mDeadline = deadLine;
        mPriority = priority;
    }
    public Task(Task otherTask) {
        mName = otherTask.mName;
        mDuedate = otherTask.mDuedate;
        mDeadline = otherTask.mDeadline;
        mPriority = otherTask.mPriority;
    }


    public String getDuedate() {
        return mDuedate;
    }

    public void setDuedate(String duedate) {
        mDuedate = duedate;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int priority) {
        mPriority = priority;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDeadline() {
        return mDeadline;
    }

    public void setDeadline(String deadline) {
        mDeadline = deadline;
    }

    @Override
    public String toString() {
        String priority = "";
        switch(mPriority)
        {
            case 1:
                priority = "High";
                break;
            case 2:
                priority = "Medium";
                break;
            case 3:
                priority = "Low";
                break;
        }
        return "Task[" + "name=" + mName +
                ", dueDate=" + mDuedate +
                ", deadline=" + mDeadline +
                ", priority=" + priority +
                ']';
    }
}
