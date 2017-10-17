package lesson19.home;

public class Storage {
    private long id;
    private File[] files;
    private String[] formatsSupported;
    private String storageCountry;
    private long storageSize;

    public Storage(long id, File[] files, String[] formatsSupported, String storageCountry, long storageSize) {
        this.id = id;
        this.files = files;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }


    public void printStorage()
    {
        System.out.println("Storage (id:" + id + ") contains: ");
        if(files == null) {
            System.out.println(" Nothing - is empty!");
            return;
        }
        for (File f : files)
            System.out.println(f.toString());
    }
    public File put (File file) throws Exception {

        fileIsAvailable(file);

        if (!canAddCheck(file))
            throw new Exception("Can't put file id:" + file.getId() + " to storage id:" + id);

        if (hasPlaceToAdd()) {
            for (File f : files)
                if (f == null || f.isEmpty()) {
                    f = file;
                    return f;
                }
        } else {
            File[] newFiles = new File[files.length + 1];
            for (int i = 0; i < files.length; i++)
                newFiles[i] = files[i];
            newFiles[newFiles.length - 1] = file;
            return file;
        }
        return null;
    }

    public void delete (File file) throws Exception
    {
        fileIsAvailable(file);
        if (fileInStorageCheck(file))
        {
            for (File f : files) {
                if (f == null || f.isEmpty())
                    continue;
                if (f.getId() == file.getId()) {
                    f = null;
                    return;
                }
            }
        }
    }

    private boolean canAddCheck (File file) throws Exception
    {
        return (checkFormat(file) && checkSpaceToAdd(file) && !duplicatedFilesCheck(file)) ? true : false;
    }

    private boolean checkSpaceToAdd (File file) throws Exception {

        long totalSize = 0;
        for (File f : files)
        {
            if(f == null || f.isEmpty())
                continue;
            totalSize += f.getSize();
        }
        if ((storageSize - totalSize) >= file.getSize())
        {
            return true;
        } else {
            String errorMessage = "Not enough space in storage:" + id + " to put file:" + file.getId();
            System.out.println(errorMessage);
            throw new Exception(errorMessage);
        }
    }

    private boolean checkFormat (File file) throws Exception
    {
        if(file.getFormat() == null)
            throw new Exception("File format is empty!");

        for (String format : formatsSupported)
        {
            if (format.equals(file.getFormat()))
                return true;
        }

        String errorMessage = "Wrong file format! storage:" + id + "    file:" + file.getId();
        System.out.println(errorMessage);
        throw new Exception(errorMessage);
    }

    private boolean duplicatedFilesCheck (File file) throws Exception {

        if (fileInStorageCheck(file)) {
            String errorMessage = "There is such file in the storage already! storage:" + id + "    file:" + file.getId();
            System.out.println(errorMessage);
            throw new Exception(errorMessage);
        }
        return false;
    }

    private boolean fileInStorageCheck (File file)
    {
        if (files == null)
            return false;

        for (File f : files)
        {
            if (f == null || f.isEmpty())
                continue;
            if (f.getId() == file.getId())
                return true;
        }
        return false;
    }

    private boolean hasPlaceToAdd() {
        for(File f : files)
            if (f == null)
                return true;
        return false;
    }

    public long getId() {
        return id;
    }


    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    private boolean fileIsAvailable(File file) throws Exception
    {
        if(file == null || file.isEmpty())
            throw new Exception("No such file or file is empty!");

        return true;
    }
}
