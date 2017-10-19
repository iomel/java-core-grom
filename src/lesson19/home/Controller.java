package lesson19.home;


public class Controller {

    public File put(Storage storage, File file) throws Exception
    {
        nullAbsentCheck(storage, file);
        isEnoughSpace(storage, file);
        formatsAllowed(storage, file);

        if(hasFile(storage, file))
            errorMessage("There is such file in the storage: ", storage.getId(), file.getId());

        File[] files = storage.getFiles();
        for (int i = 0; i < files.length; i++)
            if (files[i] == null){
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
            errorMessage("There is no such file in the storage: ", storage.getId(), file.getId());

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
            errorMessage("Put operation break - some data is NULL. Storage id:", storage.getId(), file.getId());

        return true;
    }

    private boolean formatsAllowed(Storage storage, File file) throws Exception
    {
        for (String format : storage.getFormatsSupported())
            if(format.equals(file.getFormat()))
                return true;

        errorMessage("File format is not allowed in the storage: ", storage.getId(), file.getId());
        return false;
    }

    private boolean isEnoughSpace(Storage storage, File file) throws Exception
    {
        long totalSize = storage.getStorageSize();
        for (File f : storage.getFiles())
            if(f != null)
                totalSize -= f.getSize();

        if (totalSize > file.getSize() && hasPlace(storage))
            return true;

        errorMessage("Not enough free space in the storage: ", storage.getId(), file.getId());
        return false;
    }

    public boolean hasFile (Storage storage, File file)
    {
        for (File f : storage.getFiles())
            if (f != null && f.getId() == file.getId())
                return true;

        return false;
    }

    private boolean hasPlace (Storage storage) throws Exception
    {
        int count = 0;
        for (File f : storage.getFiles())
            if (f == null || f.isEmpty())
                count++;

        return count > 0 ? true : false;
    }

    private void errorMessage (String text, long storageId, long fileId) throws Exception
    {
        System.out.println(text + storageId + "   file: " + fileId);
        throw new Exception(text + storageId + "   file: " + fileId);

    }

}



