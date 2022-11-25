import java.util.Iterator;

public class MyListIterator<T> implements Iterator<T>{
    private MyList<T> myList;
    private Item<T> current;

    public MyListIterator(MyList<T> myList){
        this.myList = myList;
        if(this.myList.getStart() != null)
            current = myList.getStart();
    }

    @Override
    public boolean hasNext() {
        return current.getNext() != null;
    }

    @Override
    public T next() {
        current = current.getNext();
        return current.getData();
    }
}