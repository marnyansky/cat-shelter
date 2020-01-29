import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Allows not to show explicitly the way Cat instances data is stored (by using custom Iterator)
 */
public class CatBox implements Iterable<Cat> {

    /**
     * arr - array of Cat instances
     * count - current number of valid Cat instances
     */
    private Cat[] arr;
    private int count;

    public CatBox() {
        arr = new Cat[16];
    }

    /**
     * Method adds pre-validated instance of Cat to Cat[] array, null instances is not allowed.
     * Also method "expands" Cat[] array (by 2) using CopyOf method of class Arrays
     *
     * @throws NullPointerException - thrown in runtime if instance of Cat is null
     */
    public void add(Cat cat) {
        Objects.requireNonNull(cat, "Error! Empty record is given");
        if (count == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[count++] = cat;
    }

    /**
     * iterates over Cat[] array from 0 to count-1
     *
     * @return instance of custom Iterator typified by Cat
     */
    @Override
    public Iterator<Cat> iterator() {
        return new Iterator<>() {
            int elemIndx = 0;

            @Override
            public boolean hasNext() {
                return elemIndx < count;
            }

            /**
             * @throws NoSuchElementException - thrown in runtime
             *                                  if next() method cannot return next element of Cat[] array
             */
            @Override
            public Cat next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return arr[elemIndx++];
            }
        };
    }

}
