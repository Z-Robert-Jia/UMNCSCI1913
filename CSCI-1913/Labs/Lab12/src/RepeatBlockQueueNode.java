public class RepeatBlockQueueNode <T>{
    private T data;
    private RepeatBlockQueueNode<T> next;
    private int count;

    public RepeatBlockQueueNode(T data, RepeatBlockQueueNode<T> next){
        this.data = data;
        this.next = next;
        count = 1;
    }

    public T getData(){
        return data;
    }

    public RepeatBlockQueueNode<T> getNext() {
        return next;
    }

    public int getCount() {
        return count;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(RepeatBlockQueueNode<T> next) {
        this.next = next;
    }

    public void setCount(int count) {
        this.count = count;
    }



}
