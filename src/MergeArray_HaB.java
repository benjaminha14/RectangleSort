/**
 * Created by benha on 10/26/16.
 */
public class MergeArray_HaB {
    public static void main(String[] args) {
        MergeArray array = new MergeArray();
    }
}

class MergeArray {
    int[] arrayOne;
    int[] arrayTwo;
    int[] array;
    public MergeArray() {
        arrayOne = generateArray();
        arrayTwo = generateArray();
        array = merge(arrayOne,arrayTwo);
        System.out.println("Array 1");
        for(int i : arrayOne) {
            System.out.print (i + " ");
        }
        System.out.println("");
        System.out.println("Arrary 2");
        for(int i : arrayTwo) {
            System.out.print (i + " ");
        }
        System.out.println("");
        System.out.println("Result");
        for(int i : array) {
            System.out.print (i + " ");
        }
    }

    public int[] generateArray() {
        int[] array = new int[(int)(Math.random()*(1100-900)+900)];
        int min = array[0];
        int max = (int)(Math.random()*10);
        for(int i = 0; i < array.length; i++) {
        //    array[i] = Math.random()
            int newNumber = (int)(Math.random()*(max-min)+min);
            array[i] = newNumber;
            min = newNumber;
            max = (int)(Math.random()*(min+10-min)+min+1);
        }
        return array;
    }

    public int[] merge(int[] arrayOne, int[] arrayTwo) {
        int[] newArray = new int[arrayOne.length+arrayTwo.length];
        int i = 0, j = 0, k = 0;
        while (i < arrayOne.length && j < arrayTwo.length)
        {
            if (arrayOne[i] < arrayTwo[j])
            {
                newArray[k] = arrayOne[i];
                i++;
            }
            else
            {
                newArray[k] = arrayTwo[j];
                j++;
            }
            k++;
        }

        while (i < arrayOne.length)
        {
            newArray[k] = arrayOne[i];
            i++;
            k++;
        }

        while (j < arrayTwo.length)
        {
            newArray[k] = arrayTwo[j];
            j++;
            k++;
        }
        return newArray;

    }
}
