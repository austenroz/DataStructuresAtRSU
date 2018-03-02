import java.util.*;

public class RemoveDuplicates
{
    public static <T extends Comparable<? super T>> void main(String[] args)
    {
        LinkedList<T> list = new LinkedList<T>();
        list.add((T) new Integer(12));
        list.add((T) new Integer(12));
        list.add((T) new Integer(12));
        list.add((T) new Integer(4));
        list.add((T) new Integer(2));
        list.add((T) new Integer(2));
        list.add((T) new Integer(2));
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
        System.out.println();
        System.out.println();
        System.out.println();
        deleteReps(list);
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
    
    public static <T extends Comparable<? super T>> void deleteReps(LinkedList<T> list)
    {
        LinkedList<T> noRepsList = new LinkedList<T>();
        Iterator<T> itr = list.iterator();
        while(itr.hasNext())
        {
            T currentTest = itr.next();
            if (!noRepsList.contains(currentTest))
                noRepsList.add(currentTest);
            else
                itr.remove();
        }
    }
}