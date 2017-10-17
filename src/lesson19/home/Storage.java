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

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    public boolean canAddCheck (File file) throws Exception
    {
        return (checkFormat(file) && checkSpaceToAdd(file) && !duplicatedFilesCheck(file)) ? true : false;
    }

    public boolean contains (File file)
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

    public boolean hasPlaceToAdd() {
        for(File f : files)
            if (f == null)
                return true;
        return false;
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

        if (contains(file)) {
            String errorMessage = "There is such file in the storage already! storage:" + id + "    file:" + file.getId();
            System.out.println(errorMessage);
            throw new Exception(errorMessage);
        }
        return false;
    }

}
