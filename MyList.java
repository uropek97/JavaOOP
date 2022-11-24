import java.util.Iterator;

public class MyList<T> implements Iterable<T> {
    private Item<T> start;
    private Item<T> end;
    private int count;

    public Item<T> getStart() {
        return start;
    }

    public void setStart(Item<T> start) {
        this.start = start;
    }

    public Item<T> getEnd() {
        return end;
    }

    public void setEnd(Item<T> end) {
        this.end = end;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        count = count;
    }

    public MyList(){
        start = null;
        end = null;
        count = 0;
    }

    public MyList(T data){
        var item = new Item<T>(data);
        setStartAndEnd(item);
    }

    public void add(T data){
        var item = new Item<T>(data);
        if(end != null){
            end.setNext(item);
            end = item;
            count++;
        }
        else{
            setStartAndEnd(item);
        }
    }

    //тут нужно исключение если индекс+1 больше чем каунт,
    //но я пока корректно не знаю как это сделать. следующий курс как раз ислючения
    public Item<T> get(int index) {
        if(index == 0)
            return start;
        else{
            int i = 1;
            var item = start.getNext();
            while(i != index){
                item = item.getNext();
                i++;
            }
            return item;
        }
    }

    private void setStartAndEnd(Item<T> item){
        start = item;
        end = item;
        count = 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator<T>(this);
    }
}