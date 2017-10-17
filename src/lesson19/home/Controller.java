package lesson19.home;


public class Controller {

    public File put(Storage storage, File file) throws Exception
    {
        fileIsAvailable(file);

        if (!storage.canAddCheck(file))
            throw new Exception("Can't put file id:" + file.getId() + " to storage id:" + storage.getId());

        File[] files = storage.getFiles();

        if (storage.hasPlaceToAdd()) {
            for (File f : files)
                if (f == null || f.isEmpty()) {
                    f = file;
                    storage.setFiles(files);
                    return f;
                }
        } else {
            File[] newFiles = new File[files.length + 1];
            for (int i = 0; i < files.length; i++)
                newFiles[i] = files[i];
            newFiles[newFiles.length - 1] = file;
            storage.setFiles(newFiles);
            return file;
        }
        return null;
    }

    public void delete (Storage storage, File file) throws Exception
    {
        fileIsAvailable(file);

        File[] files = storage.getFiles();
        if (storage.contains(file))
        {
            for (File f : files) {
                if (f == null || f.isEmpty())
                    continue;
                if (f.getId() == file.getId()) {
                    f = null;
                    storage.setFiles(files);
                    return;
                }
            }
        }
    }

    public void transferAll (Storage storageFrom, Storage storageTo) throws Exception
    {
        if (storageFrom == null || storageTo == null || storageFrom.getId() == storageTo.getId() || storageFrom.getFiles() == null)
            throw new Exception("Can't transfer file from storage:" + storageFrom.getId() + " source [destination] storage is empty or it's same storage!");

        for(File fileToTransfer : storageFrom.getFiles())
        {
            if (put(storageTo, fileToTransfer) == null) {
                transferErrorMessage(storageTo.getId(), fileToTransfer.getId());
            }
            delete(storageFrom,fileToTransfer);
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
                if (put(storageTo, fileToTransfer) == null) {
                    transferErrorMessage(storageTo.getId(), fileToTransfer.getId());
                }
                delete(storageFrom, fileToTransfer);
            }
            break;
        }
    }
    private void transferErrorMessage (long storageId, long fileId ) throws Exception {
        String errorMessage = "Can't transfer file! storage:" + storageId + "    file:" + fileId;
        System.out.println(errorMessage);
        throw new Exception(errorMessage);
    }


    private boolean fileIsAvailable(File file) throws Exception
    {
        if(file == null || file.isEmpty())
            throw new Exception("No such file or file is empty!");

        return true;
    }

}



