public class LinearNode <Data>{
    private Data data;
    private LinearNode<Data> next;
    public LinearNode(Data data){
        this(data,null);
    }
    public LinearNode(Data data, LinearNode<Data> next){
        this.data = data;
        this.next = next;
    }
    public Data getData(){
        return data;
    }
    public LinearNode<Data> getNext(){
        return next;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setNext(LinearNode<Data> next) {
        this.next = next;
    }
}
