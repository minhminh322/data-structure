package structures;

/**
 * An output-restricted double-ended queue supports insertions from both ends,
 * but accesses and deletions only from the front.
 * 
 * @author minhphan
 * @version Winter 2019
 *
 * @param <E>
 */
public class LinkedOutputRestrictedDeque<E> extends LinkedQueue<E>
                implements OutputRestrictedDequeADT<E> {

    @Override
    public void enqueueAtFront(final E theElement) {
        final Node<E> node = new Node<E>(theElement);
        if (mySize == 0) {
            myFront = node;
            myRear = myFront;
        } else {
            node.myNext = myFront;
            myFront = node;

        }
        mySize++;
    }
    /**
     * The returned String lists each element in the queue and includes a label for
     * the front of the queue.
     * 
     * <p>The format of the returned String is:
     * 0
     * 1
     * 2
     * 3
     * 4
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (mySize > 0) {
            Node<E> temp = myFront;
            for (int i = 0; i < mySize - 1; i++) {
                sb.append(temp.myData);
                sb.append('\n');
                temp = temp.myNext;
            }
            sb.append(temp.myData);
        } else if (isEmpty()) {
            sb.append("Empty Queue");
        }
        return sb.toString();
    }
    
    

}
