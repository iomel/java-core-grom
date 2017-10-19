package lesson19.home;


import java.awt.*;

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
        nullCheckStorages(storageFrom, storageTo);

        if (usedPlaces(storageFrom) > emptyPlaces(storageTo) || emptyPlaces(storageTo) == 0)
            throw new Exception("Transfer stopped - Not enough space. Source storage:" + storageFrom.getId()
                    + "Destination storage:" + storageTo.getId());

        includeFormats(storageFrom, storageTo);
        idDuplicate(storageFrom, storageTo);

        for (File fileToTransfer : storageFrom.getFiles()) {
            if (fileToTransfer == null || fileToTransfer.isEmpty())
                continue;
            put(storageTo, fileToTransfer);
            delete(storageFrom, fileToTransfer);
        }
    }

    public void transferFile (Storage storageFrom, Storage storageTo, long id) throws Exception
    {
        nullCheckStorages(storageFrom, storageTo);

        File fileToTransfer = getFileById(storageFrom, id);
        put(storageTo, fileToTransfer);
        delete(storageFrom, fileToTransfer);
    }

    private void nullCheckStorages (Storage storageFrom, Storage storageTo) throws Exception {
        if (storageFrom == null || storageFrom.getFiles() == null
                || storageTo == null || storageTo.getFiles() == null
                || storageFrom.getId() == storageTo.getId()
                || storageFrom.getFormatsSupported() == null
                || storageTo.getFormatsSupported() == null )
            throw new Exception("Transfer stopped - some data is NULL. Source storage:" + storageFrom.getId()
                    + "Destination storage:" + storageTo.getId());
    }

    private void nullAbsentCheck (Storage storage, File file) throws Exception
    {
        if (storage == null
                || storage.getFiles() == null
                || storage.getFormatsSupported() == null
                || file == null
                || file.isEmpty()
                || file.getFormat() == null)
            throw new Exception("Put operation break - some data is NULL. Storage id:" + storage.getId() + "    file: " + file.getId());
    }

    private void includeFormats (Storage storageFrom, Storage storageTo)throws Exception{
        int count = 0;
        for (String formatSource : storageFrom.getFormatsSupported() )
            for (String formatDest : storageTo.getFormatsSupported())
                if (formatSource.equals(formatDest)) {
                    count++;
                    break;
                }
        if (count != storageFrom.getFormatsSupported().length)
            throw new Exception("Formats mismatch. Storage1 id:" + storageFrom.getId() + "    Storage2 id: " + storageTo.getId());

    }

    private void hasSpaceForTransfer(Storage storageFrom, Storage storageTo) throws Exception {

    }

    private void idDuplicate (Storage storageFrom, Storage storageTo) throws Exception {
        for (File sourceFile : storageFrom.getFiles())
            for (File destinationFile : storageTo.getFiles())
                if (sourceFile.getId() == destinationFile.getId())
                    throw new Exception("Duplicate files. Storage1 id:" + storageFrom.getId() + "    Storage2 id: " + storageTo.getId());
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


    private int usedPlaces (Storage storage){
        int count = 0;
        for (File f : storage.getFiles())
            if (f != null && !f.isEmpty())
                count++;
        return count;
    }

    private int emptyPlaces (Storage storage){
        int count = 0;
        for (File f : storage.getFiles())
            if (f == null || f.isEmpty())
                count++;
        return count;
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

    private File getFileById (Storage storage, long id) throws Exception
    {
        for (File f : storage.getFiles())
            if (f.getId() == id)
                return f;

        throw new Exception("There is file in the storage: " + storage.getId() + "    file: " + id);
    }
}



