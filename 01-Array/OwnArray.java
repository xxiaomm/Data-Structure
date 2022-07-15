
public class OwnArray<T> {

    private T[] data;
    private int size;   // size is the real size of array

    // Constructor: capacity is the maximum size of array
    public OwnArray(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public OwnArray(){
        this(10); // default size
    }

    // get capacity
    public int getCapacity(){
        return data.length;
    }

    // get real size
    public int getSize(){
        return size;
    }

    // judge empty
    public boolean isEmpty(){
        return size == 0;
    }

    // judge whether the array contains the element
    public boolean contain(T val) {
        for (int i = 0; i < size; i++) {
            if (data[i] == val) return true;
        }
        return false;
    }

    // return the index of the element
    public int find(T val) {
        for (int i = 0; i < size; i++) {
            if (data[i] == val)
                return i;
        }
        return -1;
    }

    /** get element */
    public T get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed, index is illegal.");
        return data[index];
    }

    /** change value of specific index */
    public void set(int index, T val) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed, index is illegal.");
        data[index] = val;
    }

    /** add elemnt */
    public void add(int index, T val) {
        // if (size == data.length)
        //     throw new IllegalArgumentException("Add failed, Arrya is full.");
        
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        /** dynamic array */
        if(size == data.length)
            resize(2 * data.length);

        for(int i = size - 1; i >= index ; i --)
            data[i + 1] = data[i];

        data[index] = val;
        size ++;
    }

    public void addFirst(T val) {
        add(0, val);
    }

    public void addLast(T val) {
//        if(size == data.length)
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//        data[size] = e;
//        size ++;
        add(size, val);
    }

    /** remove element */
    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed, illegal index.");
        T val = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        size--;
        return val;
    }

    public int removeFirst() {
        remove(0);
    }

    public int removeLast() {
        remove(size-1);
    }

    public void remove(T val) {
        int index = find(val);
        if (index != -1)
            remove(index);
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    /** dynamic array */
    private void resize(int newCapacity){
        T[] newData = (T[])new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++)
            newData[i] = data[i];
        data = newData;
    }
}