package cat.shelter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CatBox implements Iterable<Cat> {

    private Cat[] arr;
    private int count;

    public CatBox() {
        arr = new Cat[16];
    }

    public void add(Cat p) {
        Objects.requireNonNull(p, "Error! Empty record is given");
        if (count == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[count++] = p;
    }

    @Override
    public Iterator<Cat> iterator() {
        return new Iterator<>() {
            int elemIndx = 0;

            @Override
            public boolean hasNext() {
                return elemIndx < count;
            }

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
