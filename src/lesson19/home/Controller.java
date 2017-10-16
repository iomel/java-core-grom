package lesson19.home;

import java.io.IOException;
import java.util.Arrays;

public class Controller {

    public void put(Storage storage, File file) throws IOException
    {
        if (storage == null || file == null || file.isEmpty())
            return;

        String errorMessage = "";
        File[] files = storage.getFiles();
        boolean hasPlace = false;

        if (file.getSize() > storage.getStorageFreeSpace())
        {
            errorMessage = "Not enough space in storage:" + storage.getId() + " to put file:" + file.getId();
            System.out.println(errorMessage);
            throw new IOException(errorMessage);
        }

        if (!storage.checkFormat(file))
        {
            errorMessage = "Wrong file format! storage:" + storage.getId() + "    file:" + file.getId();
            System.out.println(errorMessage);
            throw new IOException(errorMessage);
        }

        if (storage.hasFile(file))
        {
            errorMessage = "There is such file in the storage already! storage:" + storage.getId() + "    file:" + file.getId();
            System.out.println(errorMessage);
            throw new IOException(errorMessage);
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
        } else
        {
            File[] newFiles = new File[files.length + 1];
            for (int i = 0; i < files.length; i++)
                newFiles[i] = files[i];
            newFiles[newFiles.length - 1] = file;
            storage.setFiles(newFiles);
        }

    }

    public void delete (Storage storage, File file) throws IOException
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
            throw new IOException(errorMessage);
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

    public void transferAll (Storage storageFrom, Storage storageTo) throws IOException
    {
        if (storageFrom == null || storageTo == null)
            return;

        for(File fFrom : storageFrom.getFiles())
        {
            this.put(storageTo, fFrom);
        }
    }

    public void transferFile (Storage storageFrom, Storage storageTo, long id) throws IOException
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
