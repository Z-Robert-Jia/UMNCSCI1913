public class GenericStack <Elem>{
    /**
     * size is always <= data.length
     * size is the number of in-use elements
     * Order of data equals to order of the pushes
     */
    private Elem[] data;
    private int size;
    public GenericStack(int size){
        data = (Elem[]) new Object[size];
        size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * If the data array is currently full, this function should double
     * the size of the array using the procedure outlined above. Then it should add the input
     * element into the array and increment the size variable.
     * @param ele
     */
    public void push(Elem ele){
        // Expand if full
        if (size == data.length){
            Elem[] newdata = (Elem[]) new Object[size*2];
            for (int i = 0; i < data.length; i++){
                newdata[i] = data[i];
            }
            data = newdata;
        }
        data[size] = ele;
        size++;
    }

    /**
     * If the stack is empty, then the special value
     * null should be returned. Otherwise, the current top of the stack should be returned.
     * @return
     */
    public Elem peek(){
        if (size == 0){
            return null;
        }
        else{
            return data[size-1];
        }
    }

    /**
     *If the stack is empty, then the special value null should be returned and nothing should be changed.
     * Otherwise, the top of the stack should be removed from the stack
     * @return
     */
    public Elem pop(){
        if (size == 0){
            return null;
        }
        Elem ret = data[size-1];
        size--;
        return ret;
    }

    /**
     * toString method
     * @return
     */
    @Override
    public String toString() {
        String ret = "";
        for (Elem ele : data){
            ret += ele.toString();
        }
        return ret;
    }

    /**
     * equals method
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (obj == this){
            return true;
        }
        if (obj instanceof GenericStack){
            GenericStack other = (GenericStack) obj;
            return other.size == this.size && other.data.equals(this.data);
        }
        return false;
    }
}
