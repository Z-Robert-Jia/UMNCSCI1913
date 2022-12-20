public class RepeatBlockQueue <T>{
    private RepeatBlockQueueNode<T> front;
    private RepeatBlockQueueNode<T> rear;
    private int size;

    public RepeatBlockQueue(){
        //set fron and rear to null
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * returns the current front of the queue without re- moving it. If the queue is empty return null
     * @return
     */
    public T front() {
        if(isEmpty()){
            return null;
        }
        return front.getData();
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * adds an element to the queue.
     * @param data
     */
    //TODO Remember to increase size!!
    public void enqueue(T data){
        size++;
        RepeatBlockQueueNode<T> newNode = new RepeatBlockQueueNode<>(data,null);
        //Empty
        if (front==null){
            front = newNode;
            rear = front;
        }
        else{
            // Change only the end node
            // Check if the same
            if(data.equals(rear.getData())){
                rear.setCount(rear.getCount()+1);
            }
            else{
                //Add to the end
                rear.setNext(newNode);
                rear = newNode;
            }
        }
    }

    /**
     * returns the current front of the queue without re- moving it. If the queue is empty return null
     * @return
     */
    public T dequeue(){
        //null
        if (isEmpty()){
            return null;
        } else if (size==1) {
            T ret = front.getData();
            front = front.getNext();
            rear = null;
            size = 0;
            return ret;
        } else {
            size--;
            if (front.getCount()==1){
                //change front
                T ret = front.getData();
                front = front.getNext();
                return ret;
            }
            else {front.setCount(front.getCount()-1);
                return front.getData();
            }
        }
        //size
    }

    /**
     * returns the size of the repeat block at the front of the queue.
     * @return
     */
    public int frontOfLineRepeatCount(){
        if (isEmpty()){
            return 0;
        }
        return front.getCount();
    }

    /**
     * toString method!!
     * @return
     */
    @Override
    public String toString() {
        if (isEmpty()){
            return "";
        }
        RepeatBlockQueueNode<T> currNode = front;
        String str = currNode.getData().toString() + ":" + currNode.getCount();
        while (currNode.getNext()!=null){
            str += ", ";
            currNode = currNode.getNext();
            str += currNode.getData().toString() + ":" + currNode.getCount();
        }
        return str;
    }
}
