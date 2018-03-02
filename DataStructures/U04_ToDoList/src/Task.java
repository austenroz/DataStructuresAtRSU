
import java.io.Serializable;

public class Task implements Comparable<Task>, Serializable {
   /** counter used to assign unique ids to tasks */
   static int taskCount=0;
   /** user assigned importance of the task */
   int priority;
   /** unique id for the task */
   int id;
   /** the task to be done */
   String name;
    
   /**
    * 
    * @param name (string) description for the new task
    * @param priority (int) importance of the new task
    */
   public Task(String name, int priority) {
       this.name=name;
       this.priority=priority;
       id=taskCount++;
   }
    
    /**
     *   @returns -1 if second task is more important than the first one.  0 if the two tasks
     *   have the same priority and 1 if the current task is more important than the second task
     */
    @Override
    public int compareTo(Task otherTask) {
        if (priority>otherTask.priority) 
            return 1;        
        else if (priority<otherTask.priority)
            return -1;
        else
               return 0;
    }
    
    public String getName() {return name + "        Priority: " + priority;}
    public int getId() {return id;}
    public int getPriority() {return priority;}
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(id);
        sb.append(':');
        sb.append(priority);
        sb.append(':');
        sb.append(name);
        return sb.toString();
    }
}