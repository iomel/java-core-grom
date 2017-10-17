package lesson19.home;


public class Controller {

    public File put(Storage storage, File file) throws Exception
    {
        if (storage != null)
            return storage.put(file);
        return null;
    }

    public void delete (Storage storage, File file) throws Exception
    {
        if (storage != null)
            storage.delete(file);
    }

    public void transferAll (Storage storageFrom, Storage storageTo) throws Exception
    {
        if (storageFrom == null || storageTo == null || storageFrom.getId() == storageTo.getId() || storageFrom.getFiles() == null)
            throw new Exception("Can't transfer file from storage:" + storageFrom.getId() + " source [destination] storage is empty or it's same storage!");

        for(File fileToTransfer : storageFrom.getFiles())
        {
            if (storageTo.put(fileToTransfer) == null) {
                transferErrorMessage(storageTo.getId(), fileToTransfer.getId());
            }
            storageFrom.delete(fileToTransfer);
        }
    }

    public void transferFile (Storage storageFrom, Storage storageTo, long id) throws Exception
    {
        if (storageFrom == null || storageTo == null || storageFrom.getId() == storageTo.getId() || storageFrom.getFiles() == null)
            throw new Exception("Can't transfer file from storage:" + storageFrom.getId() + " source [destination] storage is empty or it's same storage!");

        for(File fileToTransfer : storageFrom.getFiles())
        {
            if (fileToTransfer == null || fileToTransfer.isEmpty())
                continue;

            if (fileToTransfer.getId() == id)
            {
                if (storageTo.put(fileToTransfer) == null) {
                    transferErrorMessage(storageTo.getId(), fileToTransfer.getId());
                }
                storageFrom.delete(fileToTransfer);
            }
            break;
        }
    }
    private void transferErrorMessage (long storageId, long fileId ) throws Exception {
        String errorMessage = "Can't transfer file! storage:" + storageId + "    file:" + fileId;
        System.out.println(errorMessage);
        throw new Exception(errorMessage);
    }
}



