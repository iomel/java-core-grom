package lesson25.home;

public class GeneralDAO <T> {
    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[10];

    public T save (T t) throws Exception {
        validate((T)t);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = t;
                return array[i];
            }
        }
        return null;
    }

    public T[] getAll(){
        return array;
    }

    private <T> void validate (T t) throws Exception {
        if (t == null)
            throw new Exception("Element for save is NULL. Can't be saved" );

        // check Space
        int  emptyPlaces = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] == null)
                emptyPlaces++;
        if (emptyPlaces == 0)
            throw new Exception("Not enough space to save transaction. Can't be saved" );
    }


}
