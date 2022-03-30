import java.util.*;
public class MyDeque<E>{
    private E[] data;
    private int size, start, end;
    public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        start = 0;
        end = -1;
        size = 0;
    }
    public MyDeque(int initialCapacity){
        if(initialCapacity<10){
            initialCapacity=10;
        }
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[initialCapacity];
        data = d;
        start = 0;
        end = -1;
        size = 0;
    }
    public int size(){
        return size;
    }
    public String toString(){
        if (size==0){
            return "[]";
        }
        String ans ="[";
        for(int i = 0; i < size-1; i++){
            if(start+i >= data.length){
                ans+= data[start+i-data.length].toString() + ", ";
            } else ans+= data[start+i].toString()+", ";
        }
        ans+= data[end].toString()+']';
        return ans;
    }
    public void addFirst(E element){
        if(element == null){
            throw new NullPointerException("no null");
        } 
        if(size == 0){
            end++;
            size++;
            data[start] = element;
        }
        else if(size == data.length){
            resize();
            size++;
            start = data.length-1;
            data[start] = element;
        }
        else if(start == 0){
            start = data.length-1;
            size++;
            data[start] = element;
        }
        else {
            size++;  
            start--;
            data[start] = element;
        }
    }
    public void addLast(E element){ 
        if(element == null){
            throw new NullPointerException("no null");
        }
        if(size == data.length){
            resize();
            size++;
            end++;
            data[end] = element;
        } 
        else if(end == data.length-1){
            end = 0;
            size++;
            data[end] = element;
        } 
        else {
            size++;
            end++;
            data[end] = element;
        }
    }

    public E removeFirst(){
        if(size == 0){
            throw new NoSuchElementException("size 0");
        }
        E temp = data[start];
        data[start] = null;
        size--;
        if(size == 0){
            start= 0;
            end = -1;
        } 
        else if(start+1 == data.length){
            start = 0;
        }
        else{
            start++;
        }
        return temp;
    }

    public E removeLast(){
        if(size == 0){
            throw new NoSuchElementException("size 0");
        }
        E temp = data[end];
        data[end] = null;
        size--;
        if(size == 0){
            start=0;
            end = -1;
        } 
        else if(end-1 < 0){
            end = data.length-1;
        }
        else{
            end--;
        }
        return temp;
    }

    public E getFirst () { 
        if(size == 0){
            throw new NoSuchElementException("size 0");
        }
        return data[start];
    }

    public E getLast() { 
        if(size == 0){
            throw new NoSuchElementException("size 0");
        }
        return data[end];
    }

    private void resize (){
        @SuppressWarnings("unchecked")
        E[] resize = (E[])new Object[data.length*2+1];
        for(int i = 0; i < size; i++){
            if(start+i >= data.length){
                resize[i] = data[start+i-data.length];
            } 
            else{
                resize[i] = data[start+i];
            }
        }
        start = 0;
        end = size-1;
        data = resize;
    }
}
