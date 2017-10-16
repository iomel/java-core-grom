package lesson19.home;

import java.io.IOException;


public class Controller {

    public File put(Storage storage, File file) throws Exception
    {
        if (storage == null || file == null || file.isEmpty())
            return null;

        String errorMessage = "";
        File[] files = storage.getFiles();
        boolean hasPlace = false;

        if (file.getSize() > storage.getStorageFreeSpace())
        {
            errorMessage = "Not enough space in storage:" + storage.getId() + " to put file:" + file.getId();
            System.out.println(errorMessage);
            throw new Exception(errorMessage);
        }

        if (!storage.checkFormat(file))
        {
            errorMessage = "Wrong file format! storage:" + storage.getId() + "    file:" + file.getId();
            System.out.println(errorMessage);
            throw new Exception(errorMessage);
        }

        if (storage.hasFile(file))
        {
            errorMessage = "There is such file in the storage already! storage:" + storage.getId() + "    file:" + file.getId();
            System.out.println(errorMessage);
            throw new Exception(errorMessage);
        }

        for (File f : files)
            if(f == null)
                hasPlace = !hasPlace;

        if(hasPlace)
        {
            for (File f : files)
                if(f == null)
                {
                    f = file;
                    break;
                }
                storage.setFiles(files);
                return file;
        } else
        {
            File[] newFiles = new File[files.length + 1];
            for (int i = 0; i < files.length; i++)
                newFiles[i] = files[i];
            newFiles[newFiles.length - 1] = file;
            storage.setFiles(newFiles);
            return file;
        }

    }

    public void delete (Storage storage, File file) throws Exception
    {
        if (storage == null || file == null || file.isEmpty())
            return;

        String errorMessage = "";
        File[] files = storage.getFiles();
        File[] newFiles = new File[files.length-1];

        if (!storage.hasFile(file))
        {
            errorMessage = "There is no such file in the storage already! storage:" + storage.getId() + "    file:" + file.getId();
            System.out.println(errorMessage);
            throw new Exception(errorMessage);
        }

        for (int i = 0, j = 0; i < files.length; i++)
        {
            if (files[i].equals(file))
                continue;
            else
            {
                newFiles[j++] = files[i];
            }
        }
        storage.setFiles(newFiles);
    }

    public void transferAll (Storage storageFrom, Storage storageTo) throws Exception
    {
        if (storageFrom == null || storageTo == null)
            return;

        File[] emptyStorage = new File[0];
        for(File fFrom : storageFrom.getFiles())
        {
            this.put(storageTo, fFrom);
        }
        storageFrom.setFiles(emptyStorage);
    }

    public void transferFile (Storage storageFrom, Storage storageTo, long id) throws Exception
    {
        if (storageFrom == null || storageTo == null)
            return;

        for(File fFrom : storageFrom.getFiles())
        {
            if (fFrom.getId() == id)
            {
                this.put(storageTo, fFrom);
                break;
            }
        }

    }


}
