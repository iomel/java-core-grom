package lesson19.home;


import java.util.Arrays;

public class Controller {

    public File put(Storage storage, File file) throws Exception
    {
        if (!canPut(storage, file))
            return null;

        File[] files;
        hasPlaceToAdd(storage);
        switch (hasPlaceToAdd(storage)) {
            case 0:
                files = new File[]{file};
                storage.setFiles(files);
                break;
            case 1:
                files = storage.getFiles();
                for (File f : files) {
                    if (f == null || f.isEmpty()) {
                        f = file;
                        storage.setFiles(files);
                        break;
                    }
                }
                break;
            case 2:
                files = storage.getFiles();
                File[] newFiles = new File[files.length + 1];
                for (int i = 0; i < files.length; i++)
                    newFiles[i] = files[i];
                newFiles[newFiles.length - 1] = file;
                storage.setFiles(newFiles);
        }
        return file;

    }


    public void delete (Storage storage, File file) throws Exception
    {
        checkParametersForNull(storage, file);

        if (contains(storage, file))
        {
            File[] files = storage.getFiles();
            File[] newFiles = new File[files.length-1-emptyFilesCount(storage)];
            for(int i = 0, j=0; i < files.length; i++)
            {
                if(files[i] != null && !files[i].isEmpty() && files[i].getId() != file.getId()){
                    newFiles[j++] = files[i];
                }
            }
            storage.setFiles(newFiles);
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

    private boolean canPut (Storage storage, File file) throws Exception
    {
        if (checkParametersForNull(storage, file))
            return (checkSpaceToAdd(storage, file)
                    && checkFormat(storage, file)
                    && noDuplicatedFiles(storage, file)) ? true : false;
        return false;
    }

    private int emptyFilesCount (Storage storage)
    {
        int count = 0;
        for (File f : storage.getFiles())
            if (f == null || f.isEmpty())
                count++;
        return count;
    }

    private boolean checkParametersForNull (Storage storage, File file) throws Exception
    {
        if(file == null || file.isEmpty())
            throw new Exception("No such file or file is empty!");
        if (storage == null)
            throw new Exception("No such storage!");

        return true;
    }

    private boolean checkSpaceToAdd (Storage storage, File file) throws Exception {
        if (storage.getFiles() == null)
            return storage.getStorageSize() > file.getSize() ? true : false;

        long totalSize = 0;
        for (File f : storage.getFiles())
        {
            if(f == null || f.isEmpty())
                continue;
            totalSize += f.getSize();
        }

        if ((storage.getStorageSize() - totalSize) >= file.getSize())
        {
            return true;
        } else {
            String errorMessage = "Not enough space in storage:" + storage.getId() + " to put file:" + file.getId();
            System.out.println(errorMessage);
            throw new Exception(errorMessage);
        }
    }

    private boolean checkFormat (Storage storage, File file) throws Exception
    {
        if(file.getFormat() == null || file.getFormat().isEmpty())
            throw new Exception("File format is empty!");

        for (String format : storage.getFormatsSupported())
        {
            if (format.equals(file.getFormat()))
                return true;
        }

        String errorMessage = "Wrong file format! storage:" + storage.getId() + "    file:" + file.getId();
        System.out.println(errorMessage);
        throw new Exception(errorMessage);
    }

    private boolean noDuplicatedFiles (Storage storage, File file) throws Exception {

        if (contains(storage, file)) {
            String errorMessage = "There is such file in the storage already! storage:" + storage.getId() + "    file:" + file.getId();
            System.out.println(errorMessage);
            throw new Exception(errorMessage);
        }
        return true;
    }

    private boolean contains (Storage storage, File file)
    {
        if (storage.getFiles() == null)
            return false;

        for (File f : storage.getFiles())
        {
            if (f == null || f.isEmpty())
                continue;
            if (f.getId() == file.getId())
                return true;
        }
        return false;
    }

    private int hasPlaceToAdd(Storage storage) {

        if(storage.getFiles() == null)
            return 0;

        for(File f : storage.getFiles())
            if (f == null)
                return 1;
        return 2;
    }


}



