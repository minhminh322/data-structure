
package tests;

import static org.junit.Assert.*;

import exceptions.EmptyCollectionException;
import org.junit.Before;
import org.junit.Test;
import structures.LinkedOutputRestrictedDeque;

/**
 * Unit tests of the LinkedOutputRestrictedDeque class.
 * 
 * @author minhphan
 * @version Winter 2019
 *
 */
public class OutputRestrictedDequeTest {

    /**
     * A GenericLinkedOutputRestrictedDeque to test.
     */
    private LinkedOutputRestrictedDeque<Integer> myQueue;
    

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() {
        myQueue = new LinkedOutputRestrictedDeque<>();
    }
    
    /**
     * Test method for {@link structures.LinkedOutputRestrictedDeque}.
     */
    @Test
    public void testLinkedQueue() {
        assertNotNull("myQueue was not instantiated!", myQueue);
        assertEquals("myQueue should be size zero!", 0, myQueue.size());
        assertTrue("myQueue should be empty!", myQueue.isEmpty());
    }
    
    /**
     * Test method for {@link structures.LinkedOutputRestrictedDeque}.
     */
    @Test
    public void testArrayStackOverloadedConstructor() {
        final LinkedOutputRestrictedDeque<Integer> queue2 = new 
                        LinkedOutputRestrictedDeque<>();
        assertNotNull("queue2 was not instantiated!", queue2);
        assertEquals("queue2 should be size zero!", 0, queue2.size());
        assertTrue("queue2 should be empty!", queue2.isEmpty());
    }
    
    /**
     * Test method for {@link structures.LinkedOutputRestrictedDeque#enqueue(Object)}.
     */
    @Test
    public void testEnqueue() {
        // using toString() in tests means that the format of toString() is
        // specified
        // OR it means we are doing white box testing
        // The advantage of using toString() is that we can test all contents in
        // one shot
        String test = "";
        for (int i = 0; i <= 10; i++) {
            test += i;
            myQueue.enqueue(i);
            assertEquals("enqueue() failed to update the contents of the Queue as expected!",
                         test, myQueue.toString());
            test += "\n";
            assertEquals("enqueue() failed to update the size of the Queue.", i + 1,
                         myQueue.size());

        }

    }
    
    /**
     * Test method for {@link structures.QRDT#EnqueueFront(java.lang.Object)}.
     */
    @Test
    public void testEnqueueFront() {
        // using toString() in tests means that the format of toString() is
        // specified
        // OR it means we are doing white box testing
        // The advantage of using toString() is that we can test all contents in
        // one shot
        String test = "";
        for (int i = 0; i <= 10; i++) {
            if (i == 0) {
                test = i + test;
                myQueue.enqueueAtFront(i);
            } else {
                test = i + "\n" + test;
                myQueue.enqueueAtFront(i);
            }
            

            assertEquals("enqueue() failed to update the contents of the Queue as expected!",
                         test, myQueue.toString());
            assertEquals("enqueue() failed to update the size of the Queue.", i + 1,
                         myQueue.size());

        }

    }
    
    
    /**
     * Test method for {@link structures.LinkedOutputRestrictedDeque#dequeue()}.
     */
    @Test
    public void testDequeue() {
        for (int i = 0; i <= 10; i++) {
            myQueue.enqueue(i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals("dequeue() returned an unexpected result!", i,
                         (int) myQueue.dequeue());
            assertEquals("dequeue() did not update the size of the stack as expected", 10 - i,
                         myQueue.size());
        }

        assertEquals("dequeue() returned an unexpected result!", 10, (int) myQueue.dequeue());
        assertEquals("dequeue() did not update the size of the stack as expected", 0,
                     myQueue.size());
        assertEquals("dequeue() failed to update the contents of the Stack as expected!",
                     "Empty Queue", myQueue.toString());
    }
    
    /**
     * Test method for {@link GenericSimpleinkedOutputRestrictedDeque#dequeue()}.
     */
    @Test(expected = EmptyCollectionException.class)
    public void testPopEmpty() {
        myQueue.dequeue();
    }
    
    /**
     * Test method for {@link structures.LinkedOutputRestrictedDeque#first()}.
     */
    @Test
    public void testFirst() {
        for (int i = 0; i <= 10; i++) {
            myQueue.enqueue(i);          
            assertEquals("First() returned an unexpected result!", 0, (int) myQueue.first());
        }
    }
    
    /**
     * Test method for {@link GenericSimpleinkedOutputRestrictedDeque#first()}.
     */
    @Test(expected = EmptyCollectionException.class)
    public void testPeekEmpty() {
        myQueue.first();
    }

}
