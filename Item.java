public class Item<T> {
    private T data;
    private Item<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        if(data != null)
            this.data = data;
    }

    public Item<T> getNext() {
        return next;
    }

    public void setNext(Item<T> next) {
        this.next = next;
    }

    public Item(T data){
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}