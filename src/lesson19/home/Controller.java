package lesson19.home;


public class Controller {

    public File put(Storage storage, File file) throws Exception
    {
        nullAbsentCheck(storage, file);
        isEnoughSpace(storage, file);
        formatsAllowed(storage, file);
        hasPlace(storage, file);

        if(hasFile(storage, file))
            throw new Exception("There is such file in the storage: " + storage.getId() + "    file: " + file.getId());

        File[] files = storage.getFiles();
        for (int i = 0; i < files.length; i++)
            if (files[i] != null && !files[i].isEmpty())
                continue;
            else {
                files[i] = file;
                storage.setFiles(files);
                return file;
            }
        return null;
    }


    public void delete (Storage storage, File file) throws Exception
    {
        nullAbsentCheck(storage, file);

        if(!hasFile(storage, file))
            throw new Exception("There is no such file in the storage: " + storage.getId() + "    file: " + file.getId());

        File[] files = storage.getFiles();
        for (int i = 0; i < files.length; i++)
        {
            if ((files[i] != null || !files[i].isEmpty()) && files[i].getId() == file.getId() ){
                files[i] = null;
                break;
            }
        }
        storage.setFiles(files);
    }

    public void transferAll (Storage storageFrom, Storage storageTo) throws Exception
    {
    }

    public void transferFile (Storage storageFrom, Storage storageTo, long id) throws Exception
    {
    }

    private boolean nullAbsentCheck (Storage storage, File file) throws Exception
    {
        if (storage == null
                || storage.getFiles() == null
                || storage.getFormatsSupported() == null
                || file == null
                || file.isEmpty()
                || file.getFormat() == null)
            throw new Exception("Put operation break - some data is NULL. Storage id:" + storage.getId() + "    file: " + file.getId());
        return true;
    }

    private boolean formatsAllowed(Storage storage, File file) throws Exception
    {
        for (String format : storage.getFormatsSupported())
            if(format.equals(file.getFormat()))
                return true;

        throw new Exception("File format is not allowed in the storage: " + storage.getId() + "    file: " + file.getId());
    }

    private boolean isEnoughSpace(Storage storage, File file) throws Exception
    {
        long totalSize = storage.getStorageSize();
        for (File f : storage.getFiles())
            if(f != null)
                totalSize -= f.getSize();

        if (totalSize > file.getSize())
            return true;
        throw new Exception("Not enough free space in the storage: " + storage.getId() + "    file: " + file.getId());
    }

    public boolean hasFile (Storage storage, File file)
    {
        for (File f : storage.getFiles())
            if (f != null && f.getId() == file.getId())
                return true;

        return false;
    }

    private boolean hasPlace (Storage storage, File file) throws Exception
    {
        int count = 0;
        for (File f : storage.getFiles())
            if (f == null || f.isEmpty())
                count++;

        if (count > 0)
            return true;

        throw new Exception("There is no empty place in the storage: " + storage.getId() + "    file: " + file.getId());
    }

}



