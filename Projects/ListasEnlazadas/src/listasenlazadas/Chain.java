package listasenlazadas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Iterator;
import listasenlazadas.ChainNode;

/**
 *
 * @author Arles
 * @param <Item>
 */
public class Chain<Item> implements LinearList<Item> {//, Iterable<Item>{ 

    //data members
    protected ChainNode firstNode;
    protected int size;

    //Constructors
    public Chain(int initialCapacity) {

    }

    public Chain() {
        this(0);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @throws IndexOutOfBoundsException when index is not between 0 and size -
     * 1
     */
    void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index = " + index + " size = " + size);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Item get(int index) {
        checkIndex(index);
        ChainNode currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return (Item) currentNode.element;
    }

    @Override
    public int indexOf(Item theElement) {
        ChainNode currentNode = firstNode;
        int index = 0;
        while (currentNode != null
                && !currentNode.element.equals(theElement)) {
            currentNode = currentNode.next;
            index++;
        }
        if (currentNode == null) {
            return -1;
        } else {
            return index;
        }
    }

    @Override
    public Item remove(int index) {
        checkIndex(index);
        Item removedElement;
        if (index == 0) // remove first node
        {
            removedElement = (Item) firstNode.element;
            firstNode = firstNode.next;
        } else { // use q to get to predecessor of desired node
            ChainNode q = firstNode;
            for (int i = 0; i < index - 1; i++) {
                q = q.next;
            }
            removedElement = (Item) q.next.element;
            q.next = q.next.next; // remove desired node
   
        }
        size--;
        return removedElement;
    }

    @Override
    public void add(int index, Item theElement) {
        if (index < 0 || index > size) // invalid list position
        {
            throw new IndexOutOfBoundsException("index = " + index + "  size = " + size);
        }
        if (index == 0) // insert at front
        {
            firstNode = new ChainNode(theElement, firstNode);
        } else { // find predecessor of new element
            ChainNode p = firstNode;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            // insert after p
            p.next = new ChainNode(theElement, p.next);
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer("[");
        // put elements into the buffer
        ChainNode currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.element == null) {
                s.append("null, ");
            } else {
                s.append(currentNode.element.toString() + ", ");
            }
            currentNode = currentNode.next;
        }
        // remove last ", "
        if (size > 0) {
            s.delete(s.length() - 2, s.length());
        }
        s.append("]");
        // create equivalent String
        return new String(s);

    }

    // Big O: size 
    public int count(Item o) {

        ChainNode currentNode = firstNode;
        int total = 0;
        while (currentNode != null) {
            if (currentNode.element.equals(o)) {
                total++;
            }
            currentNode = currentNode.next;
        }
        return total;
    }

    // Big O: 1
    public Item peek() {

        if (size == 0) {
            return null;
        }
        return (Item)firstNode.element;
    }

    // Big O: 1
    public Item poll() {

        ChainNode remuevedNode = firstNode;
        firstNode = firstNode.next;
        size--;
        return (Item)remuevedNode.element;
    }

    // Big O: size
    public boolean contains(Item o) {

        ChainNode currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.element.equals(o)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    // Big O: size
    public void sortedInsert(Integer i) {

        ChainNode currentNode = firstNode;

        if (size == 0) {
            firstNode = new ChainNode(i);
        } else if (((int) firstNode.element) > i) {

            firstNode = new ChainNode(i, firstNode);
        } else {

            while (currentNode != null) {
                if (currentNode.next == null) {
                    currentNode.next = new ChainNode(i, currentNode.next);
                    break;

                } else if (((int) currentNode.element) >= i - 1) {
                    currentNode.next = new ChainNode(i, currentNode.next);
                    break;
                }
                currentNode = currentNode.next;
            }
        }
        size++;
    }

    // Big O: size
    public void append(Chain b) {

        if (firstNode == null) {
            firstNode = b.firstNode;
            size = b.size;
            b.firstNode = null;
            b.size = 0;
        } else {
            ChainNode currentNodeA = firstNode;
            ChainNode currentNodeB = b.firstNode;
            while (currentNodeB != null) {
                if (currentNodeA.next == null) {

                    currentNodeA.next = new ChainNode(currentNodeB.element);
                    currentNodeB = currentNodeB.next;
                    size++;
                }

                currentNodeA = currentNodeA.next;

            }
            b.firstNode = null;
            b.size = 0;
        }
    }

    // Big O: size^3
    public void removeDuplicate() {

        ArrayList<String> duplicados = new ArrayList();

        for (int i = 0; i < size; i++) {
            
            if (i == 0) {
                duplicados.add(get(i).toString());
            }else{
                for (int j = 0; j < duplicados.size(); j++) {
            
                    if (duplicados.get(j).equals(get(i).toString())) {
                        remove(i);
                        i--;
                        break;
                    }
                }
                duplicados.add(get(i).toString());
            }   
            
        }
        
//
//        String[] duplicados = new String[size];
//
//        int contador = 0;
//
//        for (int i = size - 1; i >= 0; i--) {
//
//            if (i == size - 1) {
//                duplicados[0] = get(i).toString();
//
//            } else {
//                for (int j = 0; j < duplicados.length; j++) {
//                    //System.out.println(contador++ + "  "+j);
//                    if (duplicados[0].equals(get(i).toString())) {
//                        remove(i);
//                        break;
//                    } else {
//                        duplicados[0] = get(i).toString();
//
//                        break;
//                    }
//                }
//
//            }
//
//        }

    }
    // Big O: size

    public int lastIndexOf(Item o) {
        ChainNode currentNode = firstNode;
        int index = 0;
        int index2 = -1;
        while (currentNode != null) {

            if (currentNode.element.equals(o)) {
                index2 = index;
            }
            index++;
            currentNode = currentNode.next;
        }

        return index2;
    }
//    
//    @Override
//    public Iterator<Item> iterator() {
//        return new Iterator<Item>() {
//            private int i = 0;
//
//            @Override
//            public boolean hasNext() {
//                return i < size;
//            }
//
//            @Override
//            public Item next() {
//                return element[i++];
//            }                        
//        };
//    }

}
