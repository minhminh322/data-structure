package structures;

/**
 * Defines opertions for output-restricted double-ended queue.
 * 
 * @author minhphan
 * @version Winter 2019
 *
 * @param <E>
 */
public interface OutputRestrictedDequeADT<E> extends QueueADT<E> {
    
    /**
     * Adds the specified element to the 'head' of the queue.
     * 
     * @param theElement the element to add to the queue.
     */
    void enqueueAtFront(E theElement);
    

}
